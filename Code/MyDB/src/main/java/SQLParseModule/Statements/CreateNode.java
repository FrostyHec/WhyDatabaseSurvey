package SQLParseModule.Statements;

import DatabaseModule.Engine.Engine;
import DatabaseModule.LogType;
import DatabaseModule.Operations.FieldType.Type;
import DatabaseModule.Operations.FieldType.TypeObject;
import DatabaseModule.Settings;

import java.util.ArrayList;
import java.util.List;

public class CreateNode extends Statement {
    public String table;
    public final List<TypeObject> list = new ArrayList<>();

    public String log() {
        if (!(Settings.logType() == LogType.Details)) return "";
        StringBuilder s = new StringBuilder("Successfully created table:" + table + "\n");
        s.append("Column details:\n");
        boolean warn = false;
        for (int i = 0; i < list.size(); i++) {
            TypeObject o = list.get(i);
            s.append("Col ").append(i).append("  \t").
                    append("| name:").append(o.getName()).append("  \t").
                    append("type:").append(Type.getType(o.getType()).name()).append("  \t");
            if (o.isPrimaryKey()) {
                s.append("primary key").append("  \t");
                warn = true;
            }
            s.append("\t\n");
        }
        if (warn) {
            s.append("Warning! Not all store engine support primary-key check\n");
        }
        return s.toString();
    }

    @Override
    public String next() throws Exception {
        Engine e = super.getEngine();
        e.create(table, (list.toArray(new TypeObject[0])));
        return log();
    }
}
