package SQLParseModule.ParsePack;

import DatabaseModule.LogType;
import DatabaseModule.Settings;
import DatabaseModule.Operations.Node;
import SQLParseModule.Statements.StatementList;
import SQLParseModule.gen.BasicSqlLexer;
import SQLParseModule.gen.BasicSqlParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class SQLConsole {
    public static void execute(String sql) throws Exception {
        BasicSqlLexer lexer = new BasicSqlLexer(CharStreams.fromString(sql));//TODO 英文要判断如果包含在"",''
        CommonTokenStream st = new CommonTokenStream(lexer);
        BasicSqlParser parser = new BasicSqlParser(st);
        BasicSqlParser.ParagraphsContext tree = parser.paragraphs();
        NodeVisitor visitor = new NodeVisitor();
        Node n = visitor.visit(tree);
        for (var v : ((StatementList) n).statements) {
            if (Settings.logType() == LogType.Details) {
                System.out.println("Executing sql command: " + sql);
            }
            String log = v.next();
            if(Settings.logType()==LogType.None) continue;
            if (!log.equals("")) System.out.println(log);
        }
    }
}
