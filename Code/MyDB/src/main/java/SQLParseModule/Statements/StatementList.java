package SQLParseModule.Statements;

import DatabaseModule.Operations.Node;

import java.util.ArrayList;
import java.util.List;

public class StatementList implements Node {
    public final List<Statement> statements=new ArrayList<>();
}
