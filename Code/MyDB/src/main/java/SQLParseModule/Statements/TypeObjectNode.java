package SQLParseModule.Statements;


import DatabaseModule.Operations.FieldType.Type;
import DatabaseModule.Operations.Node;

public class TypeObjectNode implements Node {
    public String name;
    public Type type;
    public boolean primaryKey;
}
