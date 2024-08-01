package DatabaseModule.Engine.Impl.CSVEngine;

import DatabaseModule.Engine.Engine;
import DatabaseModule.Engine.HeadFile;
import DatabaseModule.Exception.IllegalAssign;
import DatabaseModule.Exception.TableExistException;
import DatabaseModule.Exception.WhereParamException;
import DatabaseModule.Operations.Condition.Condition;
import DatabaseModule.Operations.Condition.MultiCondition;
import DatabaseModule.Operations.Condition.SingleCondition;
import DatabaseModule.Operations.FieldType.Type;
import DatabaseModule.Operations.FieldType.TypeObject;
import DatabaseModule.Operations.Functions.Functions;
import DatabaseModule.Operations.Row;
import DatabaseModule.Operations.Select.SelectResult;
import DatabaseModule.Operations.ValAssign.ValAssign;
import DatabaseModule.Settings;
import DatabaseModule.Utils.JSON;
import SQLParseModule.Statements.ValNode;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.lang3.ObjectUtils;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CSVEngine implements Engine {
    public static final String name = "CSVEngine";

    private void resetColumnIndex(TypeObject[] arr) {
        for (int i = 0; i < arr.length; i++) {
            var o = arr[i];
            o.setColumn(i);
        }
    }

    private void illegalAssignCheck(TypeObject fields, Class<?> toAssign) throws IllegalAssign {
        //如果赋入null，或field为string（所有类型都可以自动转型为string，则不检查
        if (toAssign.equals(ObjectUtils.Null.class)||fields.getType().equals(Type.String.getTypeClass())) return;
        if (!fields.getType().equals(toAssign))
            throw new IllegalAssign("Assigning type invalid,target column:" + fields.getType() + "input type:" + toAssign);
    }

    @Override
    public boolean create(String tableName, TypeObject[] fields) throws TableExistException, IOException {

        String strFolderPath = Settings.getDataPath() + "/" + tableName;
        Path folderPath = Paths.get(strFolderPath);
        String strHeadFilePath = strFolderPath + "/headFile.json";
        Path headFilePath = Paths.get(strHeadFilePath);
        String strDataFilePath = strFolderPath + "/data.csv";
        Path dataFilePath = Paths.get(strDataFilePath);
        //创建文件夹
        if (Files.exists(folderPath)) throw new TableExistException();
        try {//在这一部分如果出现了异常就删除创建的文件夹
            Files.createDirectories(folderPath);
            //创建头信息文件
            resetColumnIndex(fields);
            String content = JSON.serialize(new HeadFile(tableName, name, fields));
            Files.createFile(headFilePath);
            Files.write(headFilePath, content.getBytes(), StandardOpenOption.WRITE);
            //创建数据文件
            Files.createFile(dataFilePath);
            return true;
        } catch (Exception e) {
            //出现异常后，删除整个文件夹
            drop(tableName);
            throw e;
        }
    }

    @Override
    public SelectResult select(String tableName, Condition _cond) throws WhereParamException, IOException, CsvException {
        if (_cond instanceof SingleCondition) throw new WhereParamException("invalid condition input");
        MultiCondition cond = (MultiCondition) _cond;
        //打开文件
        String strFolderPath = Settings.getDataPath() + "/" + tableName;
        Path folderPath = Paths.get(strFolderPath);
        String strHeadFilePath = strFolderPath + "/headFile.json";
        Path headFilePath = Paths.get(strHeadFilePath);
        String strDataFilePath = strFolderPath + "/data.csv";
        Path dataFilePath = Paths.get(strDataFilePath);
        HeadFile file = JSON.deserialize(new String(Files.readAllBytes(headFilePath)), HeadFile.class);
        TypeObject[] fields = file.getFields();
        Map<String, TypeObject> fieldMap = Arrays.stream(fields).collect(Collectors.toMap(TypeObject::getName, Function.identity()));
        String[] fieldList = Arrays.stream(fields).map(TypeObject::getName).toArray(String[]::new);

        CSVReader csvReader = new CSVReader(new FileReader(strDataFilePath));
        List<String[]> data = csvReader.readAll();
        List<Row> ans = new ArrayList<>();
        for (String[] _row : data) {
            CSVRow row = new CSVRow(fieldList, _row);
            Object _res = cond.operator.calculate(cond.items, row);
            if (!(_res instanceof Boolean res)) throw new WhereParamException("where sql error");
            if (res) {
                ans.add(row);
            }
        }
        csvReader.close();
        SelectResult res = new SelectResult();
        res.valSeq = Arrays.stream(fields).map(TypeObject::getName).collect(Collectors.toList());
        res.data = ans;
        return res;
    }

    @Override
    public int insert(String tableName, ValAssign[] sets) throws IOException, IllegalAssign {
        String strFolderPath = Settings.getDataPath() + "/" + tableName;
        Path folderPath = Paths.get(strFolderPath);
        String strHeadFilePath = strFolderPath + "/headFile.json";
        Path headFilePath = Paths.get(strHeadFilePath);
        String strDataFilePath = strFolderPath + "/data.csv";
        Path dataFilePath = Paths.get(strDataFilePath);
        HeadFile file = JSON.deserialize(new String(Files.readAllBytes(headFilePath)), HeadFile.class);
        TypeObject[] fields = file.getFields();
        String[] toSave = new String[fields.length];
        if (sets[0].isAllAssign()) {//全赋值
            if (sets.length != fields.length)//检查是不是全赋值
                throw new IllegalAssign("Assigning val number invalid,target require vals:" + fields.length + " input vals:" + sets.length);
            for (int i = 0; i < fields.length; i++) {
                ValAssign set = sets[i];
                illegalAssignCheck(fields[i], set.getValNode().type.getTypeClass());
                toSave[i] = String.valueOf(set.getValNode().val);
            }
        } else {
            Map<String, TypeObject> fieldMap = Arrays.stream(fields).collect(Collectors.toMap(TypeObject::getName, Function.identity()));
            for (ValAssign v : sets) {
                String fieldName = v.getFieldName();
                ValNode valNode = v.getValNode();
                TypeObject type = fieldMap.get(fieldName);
                int col = type.getColumn();
                illegalAssignCheck(type, valNode.type.getTypeClass());
                toSave[col] = String.valueOf(valNode.val);
            }
        }
        CSVWriter csvWriter = new CSVWriter(new FileWriter(strDataFilePath, true));
        csvWriter.writeNext(toSave);
        csvWriter.close();
        return 1;
    }

    @Override
    public int update(String tableName, ValAssign[] sets, Condition _cond) throws IOException, CsvException, WhereParamException, IllegalAssign {
        if (_cond instanceof SingleCondition) throw new WhereParamException("invalid condition input");
        MultiCondition cond = (MultiCondition) _cond;
        //打开文件
        String strFolderPath = Settings.getDataPath() + "/" + tableName;
        Path folderPath = Paths.get(strFolderPath);
        String strHeadFilePath = strFolderPath + "/headFile.json";
        Path headFilePath = Paths.get(strHeadFilePath);
        String strDataFilePath = strFolderPath + "/data.csv";
        Path dataFilePath = Paths.get(strDataFilePath);
        HeadFile file = JSON.deserialize(new String(Files.readAllBytes(headFilePath)), HeadFile.class);
        TypeObject[] fields = file.getFields();
        Map<String, TypeObject> fieldMap = Arrays.stream(fields).collect(Collectors.toMap(TypeObject::getName, Function.identity()));
        String[] fieldList = Arrays.stream(fields).map(TypeObject::getName).toArray(String[]::new);
        //读取数据
        CSVReader csvReader = new CSVReader(new FileReader(strDataFilePath));
        List<String[]> data = csvReader.readAll();
        csvReader.close();

        Files.delete(dataFilePath);
        Files.createFile(dataFilePath);

        int count = 0;
        CSVWriter csvWriter = new CSVWriter(new FileWriter(strDataFilePath, true));
        for (String[] _row : data) {
            CSVRow row = new CSVRow(fieldList, _row);
            Object _res = cond.operator.calculate(cond.items, row);
            if (!(_res instanceof Boolean res)) throw new WhereParamException("where sql error");
            if (res) {
                //修改字段值
                for (ValAssign v : sets) {
                    String fieldName = v.getFieldName();
                    ValNode valNode = v.getValNode();
                    TypeObject type = fieldMap.get(fieldName);
                    int col = type.getColumn();
                    illegalAssignCheck(type, valNode.type.getTypeClass());
                    if (valNode.val instanceof Functions func) {
                        _row[col]=func.handle(row);
                    } else {
                        _row[col] = String.valueOf(valNode.val);
                    }
                }
                count++;
            }
            csvWriter.writeNext(_row);
        }
        csvWriter.close();
        return count;

    }

    @Override
    public int delete(String tableName, Condition _cond) throws IOException, CsvException, WhereParamException {
        if (_cond instanceof SingleCondition) throw new WhereParamException("invalid condition input");
        MultiCondition cond = (MultiCondition) _cond;
        //打开文件
        String strFolderPath = Settings.getDataPath() + "/" + tableName;
        Path folderPath = Paths.get(strFolderPath);
        String strHeadFilePath = strFolderPath + "/headFile.json";
        Path headFilePath = Paths.get(strHeadFilePath);
        String strDataFilePath = strFolderPath + "/data.csv";
        Path dataFilePath = Paths.get(strDataFilePath);
        HeadFile file = JSON.deserialize(new String(Files.readAllBytes(headFilePath)), HeadFile.class);
        TypeObject[] fields = file.getFields();
        Map<String, TypeObject> fieldMap = Arrays.stream(fields).collect(Collectors.toMap(TypeObject::getName, Function.identity()));
        String[] fieldList = Arrays.stream(fields).map(TypeObject::getName).toArray(String[]::new);


        CSVReader csvReader = new CSVReader(new FileReader(strDataFilePath));
        List<String[]> data = csvReader.readAll();//读取数据
        csvReader.close();
        Files.delete(dataFilePath);
        Files.createFile(dataFilePath);
        int count = 0;
        CSVWriter csvWriter = new CSVWriter(new FileWriter(strDataFilePath, true));
        for (String[] _row : data) {
            CSVRow row = new CSVRow(fieldList, _row);
            Object _res = cond.operator.calculate(cond.items, row);
            if (!(_res instanceof Boolean res)) throw new WhereParamException("where sql error");
            if (!res) {
                csvWriter.writeNext(_row);
                count++;
            }
        }
        csvWriter.close();
        return data.size() - count;
    }

    @Override
    public void drop(String tableName) throws IOException {
        String strFolderPath = Settings.getDataPath() + "/" + tableName;
        Path folderPath = Paths.get(strFolderPath);
        Files.walkFileTree(folderPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                if (!dir.equals(folderPath)) {
                    Files.delete(dir);
                }
                return FileVisitResult.CONTINUE;
            }
        });
        Files.delete(folderPath);
    }

}
