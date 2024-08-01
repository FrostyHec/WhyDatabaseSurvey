package SQLParseModule.Statements;

import DatabaseModule.Operations.FieldType.Type;
import DatabaseModule.Operations.Node;

public class  ValNode implements Node {
    public Type type;
    public Object val;
    public ValNode(Type type){
        this.type=type;
    }
}
