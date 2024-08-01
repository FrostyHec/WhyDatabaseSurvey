import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoadSQL {
    public static void main(String[] args) throws IOException {
        long t1=System.currentTimeMillis();
        String filePath = "filmdb2.sql";
        parseSQLFile(filePath);
        long t2=System.currentTimeMillis();
        System.out.println("总计耗时："+(t2-t1)+"毫秒");
    }

    private static void parseSQLFile(String filePath) throws IOException {
        String sqlContent = Utils.readFile(filePath);
        // CREATE TABLE pattern
        Pattern createTablePattern = Pattern.compile("CREATE TABLE (\\w+)\\(([^;]+);", Pattern.CASE_INSENSITIVE);
        Matcher createTableMatcher = createTablePattern.matcher(sqlContent);
        while (createTableMatcher.find()) {
            String tableName = createTableMatcher.group(1);
            String fields = createTableMatcher.group(2);
            String[][] field = getField(fields);
            CSVHandler.create(tableName, field);
        }

        // INSERT INTO pattern
        Pattern insertIntoPattern = Pattern.compile("INSERT INTO (\\w+) VALUES\\(([^\\)]+)\\);", Pattern.CASE_INSENSITIVE);
        Matcher insertIntoMatcher = insertIntoPattern.matcher(sqlContent);
        while (insertIntoMatcher.find()) {
            String tableName = insertIntoMatcher.group(1);
            String valueS = insertIntoMatcher.group(2);
            String[] temp = valueS.split(",");
            List<String> strs = new ArrayList<>();
            for (int i = 0; i < temp.length; i++) {
                String s = temp[i];
                if (Utils.isInt(s) || Utils.isDouble(s)||Utils.isNull(s)) {//数字、NULL不需要处理
                    strs.add(s);
                    continue;
                }
                //字符处理
                StringBuilder sb = new StringBuilder(s);
                while (sb.charAt(sb.length() - 1) != '\'') {//被逗号斩断了
                    if(i==temp.length-1){
                        int stop=1;
                    }
                    sb.append(',');
                    sb.append(temp[++i]);
                }
                strs.add(sb.toString().replaceAll("''", "'"));//\'换成'
            }
            String[] vals = strs.toArray(new String[0]);
            CSVHandler.insert(tableName, vals);
        }
    }

    private static String[][] getField(String s) {
        StringBuilder fieldsb = new StringBuilder(s);
        fieldsb.replace(fieldsb.length() - 1, fieldsb.length(), "");
        String[] fieldArray = fieldsb.toString().trim().split(",\\s*");
        List<String> fieldNames = new ArrayList<>();
        List<String> fieldType = new ArrayList<>();
        for (String field : fieldArray) {
            String[] arr = field.split("\\s+");
            fieldNames.add(arr[0]);
            fieldType.add(arr[1]);
        }

        String[][] ans = new String[2][];
        ans[0] = fieldNames.toArray(new String[0]);
        ans[1] = fieldType.toArray(new String[0]);
        return ans;
    }
}
