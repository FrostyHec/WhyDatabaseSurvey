package SQLParseModule.Statements;

import DatabaseModule.Engine.Engine;
import DatabaseModule.LogType;
import DatabaseModule.Operations.Condition.Condition;
import DatabaseModule.Operations.FieldType.TypeObject;
import DatabaseModule.Settings;

public class UpdateNode extends Statement {
    public String tableName;
    public ValAssignsNode assigns;
    public Condition cond;

    public String log(int affectedRows) {
        if (Settings.logType() != LogType.Details) return "";
        return "Rows affected: " + affectedRows;
    }

    @Override
    public String next() throws Exception {
        Engine e = super.getEngine();
        int affect = e.update(tableName, assigns.assigns, cond);
        return log(affect);
    }
}
