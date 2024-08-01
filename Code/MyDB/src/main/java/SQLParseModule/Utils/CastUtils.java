package SQLParseModule.Utils;

import DatabaseModule.Operations.FieldType.TypeObject;
import SQLParseModule.Statements.TypeObjectNode;

public class CastUtils {
    public static TypeObject toTypeObj(TypeObjectNode node){
        String name=node.name;
        Class<?> type=node.type.getTypeClass();
        boolean isPrimaryKey= node.primaryKey;
        return new TypeObject(type,name,null,isPrimaryKey);
    }
}
