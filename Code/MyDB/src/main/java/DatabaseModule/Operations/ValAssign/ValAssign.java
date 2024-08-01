package DatabaseModule.Operations.ValAssign;

import DatabaseModule.Operations.Node;
import SQLParseModule.Statements.ValNode;
import lombok.Data;

@Data
public class ValAssign implements Node {
    private boolean allAssign;
    private String fieldName;
    private ValNode valNode;
    public ValAssign(String fieldName,ValNode valNode){
        this.fieldName=fieldName;
        this.valNode = valNode;
    }
}
