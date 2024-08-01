package SQLParseModule.Statements;

import DatabaseModule.LogType;
import DatabaseModule.Operations.Condition.Condition;
import DatabaseModule.Operations.Row;
import DatabaseModule.Operations.Select.SelectResult;
import DatabaseModule.Settings;

import java.util.stream.Collectors;

public class SelectNode extends Statement {
    public String table;
    public Condition cond;

    public String log(SelectResult res) {
        StringBuilder total = new StringBuilder(String.join("   \t", res.valSeq) + "\n");//加入表头
        for (Row row : res.data) {
            total.append(res.valSeq.stream()
                    .map(fieldName -> row.getVal(fieldName).toString())
                    .collect(Collectors.joining("   \t", "", "\n")));
        }
        return total.toString();
    }

    @Override
    public String next() throws Exception {
        var res = getEngine().select(table, cond);
        return log(res);
    }
}
