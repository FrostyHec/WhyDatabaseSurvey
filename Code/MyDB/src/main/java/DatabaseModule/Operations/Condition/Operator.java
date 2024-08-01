package DatabaseModule.Operations.Condition;

import DatabaseModule.Exception.WhereParamException;
import DatabaseModule.Operations.Row;

public interface Operator {
    Object calculate(Condition[] items, Row row) throws WhereParamException;

}
