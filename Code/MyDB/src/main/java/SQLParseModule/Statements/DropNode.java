package SQLParseModule.Statements;

import DatabaseModule.Engine.Engine;
import DatabaseModule.LogType;
import DatabaseModule.Settings;

public class DropNode extends Statement {
    public String tableName;
    public String log(){
        if(!(Settings.logType()== LogType.Details)) return "";
        return "Successfully dropped table:" + tableName;
    }
    @Override
    public String next() throws Exception {
        Engine e = getEngine();
        e.drop(tableName);
        return log();
    }


}
