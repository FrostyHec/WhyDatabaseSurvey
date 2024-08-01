package DatabaseModule.Operations;

import DatabaseModule.Operations.Condition.Condition;
import DatabaseModule.Operations.FieldType.TypeObject;
import DatabaseModule.Operations.Select.SelectResult;
import DatabaseModule.Operations.ValAssign.ValAssign;

import java.util.List;

public interface BasicOperations {
    boolean create(String tableName, TypeObject[] arr) throws Exception;
    SelectResult select(String tableName, Condition cond) throws Exception;
    int insert(String tableName, ValAssign[] sets) throws Exception;
    int update(String tableName, ValAssign[] sets, Condition cond) throws Exception;
    int delete(String tableName,  Condition cond) throws Exception;
    void drop(String tableName) throws Exception;
}
