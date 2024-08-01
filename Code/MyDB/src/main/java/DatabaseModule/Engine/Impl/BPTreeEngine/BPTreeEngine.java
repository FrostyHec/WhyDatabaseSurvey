package DatabaseModule.Engine.Impl.BPTreeEngine;

import DatabaseModule.Engine.Engine;
import DatabaseModule.Exception.IllegalAssign;
import DatabaseModule.Exception.TableExistException;
import DatabaseModule.Exception.WhereParamException;
import DatabaseModule.Operations.Condition.Condition;
import DatabaseModule.Operations.FieldType.TypeObject;
import DatabaseModule.Operations.Select.SelectResult;
import DatabaseModule.Operations.ValAssign.ValAssign;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.Map;

public class BPTreeEngine implements Engine {
    Map<String,Cache> rowMap;
    @Override
    public boolean create(String tableName, TypeObject[] arr) throws TableExistException, IOException {
        return false;
    }

    @Override
    public SelectResult select(String tableName, Condition cond) throws WhereParamException, IOException, CsvException {
        return null;
    }

    @Override
    public int insert(String tableName, ValAssign[] sets) throws IOException, IllegalAssign {
        return 0;
    }

    @Override
    public int update(String tableName, ValAssign[] sets, Condition cond) {
        return 0;
    }

    @Override
    public int delete(String tableName, Condition cond) throws IOException, CsvException, WhereParamException {
        return 0;
    }

    @Override
    public void drop(String tableName) throws IOException {

    }
}
