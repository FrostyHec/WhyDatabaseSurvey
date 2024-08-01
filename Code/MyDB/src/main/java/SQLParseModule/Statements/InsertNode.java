package SQLParseModule.Statements;

import DatabaseModule.Engine.Engine;
import DatabaseModule.LogType;
import DatabaseModule.Operations.ValAssign.ValAssign;
import DatabaseModule.Settings;

import java.util.ArrayList;
import java.util.List;

public class InsertNode extends Statement {
    public String tableName;
    public List<ValAssign> assigns = new ArrayList<>();

    private String log() {
        if(Settings.logType()!= LogType.Details) return "";
        StringBuilder sb = new StringBuilder("Insertion complete. Table:" + tableName + "\n");
        if (assigns.get(0).isAllAssign()) {
            sb.append("AssignField: All ");
            for (var v : assigns) {
                sb.append(v.getValNode().val).append(",");
            }
            sb.delete(sb.length()-1,sb.length());
        }
        return sb.toString();
    }

    @Override
    public String next() throws Exception {
        Engine e = getEngine();
        e.insert(tableName, assigns.toArray(new ValAssign[0]));
        return log();
    }
}
