package SQLParseModule.ParsePack;

import DatabaseModule.Operations.Condition.Condition;
import DatabaseModule.Operations.Condition.MultiCondition;
import DatabaseModule.Operations.Condition.OperatorType;
import DatabaseModule.Operations.Condition.SingleCondition;
import DatabaseModule.Operations.FieldType.Type;
import DatabaseModule.Operations.Functions.FuncReplace;
import DatabaseModule.Operations.Node;
import DatabaseModule.Operations.ValAssign.ValAssign;
import SQLParseModule.Utils.CastUtils;
import SQLParseModule.Statements.*;
import SQLParseModule.gen.BasicSqlBaseVisitor;
import SQLParseModule.gen.BasicSqlParser;

import java.util.ArrayList;
import java.util.List;

public class NodeVisitor extends BasicSqlBaseVisitor<Node> {

    @Override
    public Node visitParagraphs(BasicSqlParser.ParagraphsContext ctx) {
        StatementList ans = new StatementList();
        for (var statement : ctx.singleStatement()) {
            ans.statements.add(visitSingleStatement(statement));
        }
        return ans;
    }

    @Override
    public Statement visitSingleStatement(BasicSqlParser.SingleStatementContext ctx) {
        var s = ctx.statement();
        if (s instanceof BasicSqlParser.CreateTableContext) {
            return visitCreateTable((BasicSqlParser.CreateTableContext) s);
        } else if (s instanceof BasicSqlParser.InsertTableContext) {
            return visitInsertTable((BasicSqlParser.InsertTableContext) s);
        } else if (s instanceof BasicSqlParser.DropTableContext) {
            return visitDropTable((BasicSqlParser.DropTableContext) s);
        } else if (s instanceof BasicSqlParser.UpdateTableContext) {
            return visitUpdateTable((BasicSqlParser.UpdateTableContext) s);
        } else if (s instanceof BasicSqlParser.SelectTableContext) {
            return visitSelectTable((BasicSqlParser.SelectTableContext) s);
        } else throw new RuntimeException("Unknown type of " + s.getClass());
    }

    @Override
    public CreateNode visitCreateTable(BasicSqlParser.CreateTableContext ctx) {
        CreateNode ans = new CreateNode();
        ans.table = ctx.table().getText();
        for (var col : ctx.columns.colType()) {
            ans.list.add(CastUtils.toTypeObj((TypeObjectNode) visitColType(col)));
        }
        return ans;
    }

    //TODO 这段代码可能需要扩展
    @Override
    public InsertNode visitInsertTable(BasicSqlParser.InsertTableContext ctx) {
        InsertNode node = new InsertNode();
        node.tableName = ctx.table().getText();
        for (var v : ctx.vals(0).valType()) {
            ValNode n = visitValType(v);
            node.assigns.add(new ValAssign(null, n));
        }
        node.assigns.get(0).setAllAssign(true);
        return node;
    }

    @Override
    public DropNode visitDropTable(BasicSqlParser.DropTableContext ctx) {
        DropNode node = new DropNode();
        node.tableName = ctx.table().getText();
        return node;
    }

    @Override
    public UpdateNode visitUpdateTable(BasicSqlParser.UpdateTableContext ctx) {
        UpdateNode node = new UpdateNode();
        node.tableName = ctx.table().getText();
        node.assigns = visitValAssignTypeList(ctx.valAssignTypeList());
        if (ctx.boolExpression() == null) {
            MultiCondition cond = new MultiCondition();
            cond.operator = OperatorType.All;
            node.cond = cond;
        } else {
            node.cond = visitBoolExpression(ctx.boolExpression());
        }
        return node;
    }

    @Override
    public SelectNode visitSelectTable(BasicSqlParser.SelectTableContext ctx) {
        //Select field可以处理
        SelectNode node = new SelectNode();
        node.table = ctx.table().getText();
        if (ctx.boolExpression() == null) {
            MultiCondition cond = new MultiCondition();
            cond.operator = OperatorType.All;
            node.cond = cond;
        } else {
            node.cond = visitBoolExpression(ctx.boolExpression());
        }
        return node;
    }

    @Override
    public Node visitSelectField(BasicSqlParser.SelectFieldContext ctx) {
        return null;
    }

    @Override
    public Condition visitBoolExpression(BasicSqlParser.BoolExpressionContext ctx) {
        //TODO ckd
        var b = ctx.boolExpression();
        if (ctx.operator == null) {
            return visitBoolExpression(b.get(0));
        }
        int type = ctx.operator.getType();
        MultiCondition cond = new MultiCondition();
        switch (type) {
            case BasicSqlParser.AND, BasicSqlParser.OR, BasicSqlParser.NOT -> {
                cond.operator = switch (type) {
                    case BasicSqlParser.AND -> OperatorType.And;
                    case BasicSqlParser.OR -> OperatorType.Or;
                    case BasicSqlParser.NOT -> OperatorType.Not;
                    default -> throw new IllegalStateException("Unexpected value: " + type);
                };
                cond.items = b.stream().map(this::visitBoolExpression).toArray(Condition[]::new);
            }
            case BasicSqlParser.LIKE -> {
                Condition[] to = new Condition[2];
                String regex = fieldStrEdit(ctx.regex.getText());
                cond.operator = likeHandler(regex);
                regex = switch (cond.operator) {
                    case GeneralLike -> regex.substring(1, regex.length() - 1);
                    case LeftLike -> regex.substring(0, regex.length() - 1);
                    case RightLike -> regex.substring(1);
                    default -> throw new IllegalStateException("Unexpected value: " + cond.operator);
                };
                to[0] = new SingleCondition(true, ctx.fieldName.getText());
                to[1] = new SingleCondition(false, regex);

                cond.items = to;
            }
            case BasicSqlParser.GREATER, BasicSqlParser.LESS, BasicSqlParser.EQUALS, BasicSqlParser.DOUBLEEQUALS,
                    BasicSqlParser.GREATEREQUAS, BasicSqlParser.LESSEQUALS -> {
                Condition[] to = new Condition[2];
                to[0] = visitValExpression(ctx.left);
                to[1] = visitValExpression(ctx.right);
                cond.items = to;
                cond.operator = switch (type) {
                    case BasicSqlParser.GREATER -> OperatorType.Greater;
                    case BasicSqlParser.LESS -> OperatorType.Less;
                    case BasicSqlParser.EQUALS, BasicSqlParser.DOUBLEEQUALS -> OperatorType.Equals;
                    case BasicSqlParser.GREATEREQUAS -> OperatorType.GreaterEquals;
                    case BasicSqlParser.LESSEQUALS -> OperatorType.LessEquals;
                    default -> throw new IllegalStateException("Unexpected value: " + type);
                };
            }
            default -> throw new RuntimeException("Unknown type:" + ctx.operator.getType());
        }
        return cond;
    }


    @Override
    public Condition visitValExpression(BasicSqlParser.ValExpressionContext ctx) {
        //TODO ckd
        if (ctx.primaryValExpression() != null) {
            return visitPrimaryValExpression(ctx.primaryValExpression());
        }
        var v = ctx.valExpression();
        if (v.size() == 1) {
            return visitValExpression(v.get(0));
        }
        MultiCondition cond = new MultiCondition();
        cond.operator = switch (ctx.operator.getType()) {
            case BasicSqlParser.ADD -> OperatorType.Add;
            case BasicSqlParser.SUBTRACT -> OperatorType.Subtract;
            case BasicSqlParser.STAR -> OperatorType.Multiply;
            case BasicSqlParser.DIVIDED -> OperatorType.Divided;
            default -> throw new RuntimeException("Unknown type:" + ctx.operator.getType());
        };
        cond.items = v.stream().map(this::visitValExpression).toArray(Condition[]::new);
        return cond;
    }

    public OperatorType likeHandler(String str) {
        //TODO ckd
        if (!str.startsWith("%")) return OperatorType.LeftLike;
        if (!str.endsWith("%")) return OperatorType.RightLike;
        if (str.startsWith("%") && str.endsWith("%")) return OperatorType.GeneralLike;
        throw new RuntimeException("Unknown string:" + str);
    }

    @Override
    public Condition visitPrimaryValExpression(BasicSqlParser.PrimaryValExpressionContext ctx) {
        //TODO ckd
        SingleCondition cond = new SingleCondition();
        if (ctx.ID() != null) {
            cond.fieldName = true;
            cond.val = ctx.ID().getText();
            return cond;
        }
        cond.fieldName = false;
        cond.val = String.valueOf(visitValType(ctx.valType()).val);
        return cond;
    }

    @Override
    public ValAssignsNode visitValAssignTypeList(BasicSqlParser.ValAssignTypeListContext ctx) {
        ValAssignsNode node = new ValAssignsNode();
        List<ValAssign> list = new ArrayList<>();
        for (var v : ctx.valAssignType()) {
            list.add(visitValAssignType(v));
        }
        node.assigns = list.toArray(new ValAssign[0]);
        return node;
    }

    @Override
    public ValAssign visitValAssignType(BasicSqlParser.ValAssignTypeContext ctx) {
        String fieldName = ctx.ID().getText();
        return new ValAssign(fieldName, visitValType(ctx.valType()));
    }

    @Override
    public Node visitVals(BasicSqlParser.ValsContext ctx) {
        return null;
    }

    public String fieldStrEdit(String basic) {//去掉'',"",将转义符合并为一个
        return basic.substring(1, basic.length() - 1)
                .replaceAll("''", "'").replaceAll("\"\"", "\"");
    }

    @Override
    public ValNode visitValType(BasicSqlParser.ValTypeContext ctx) {
        if (ctx.numberType() != null) {
            return visitNumberType(ctx.numberType());
        } else if (ctx.VALSTRING() != null) {
            ValNode valNode = new ValNode(Type.String);
            valNode.val = fieldStrEdit(ctx.VALSTRING().getText());
            return valNode;
        } else if (ctx.NULL() != null) {
            return new ValNode(Type.Null);
        } else if (ctx.functions() != null) {
            return functionHandler(ctx.functions());
        } else throw new RuntimeException("Unknown node type:" + ctx);
    }

    private ValNode functionHandler(BasicSqlParser.FunctionsContext functions) {
        if (functions instanceof BasicSqlParser.ReplaceFunctionContext) {
            return visitReplaceFunction((BasicSqlParser.ReplaceFunctionContext) functions);
        } else
            throw new RuntimeException("Unknown function type:" + functions.getClass() + "msg:" + functions.getText());
    }

    @Override
    public ValNode visitReplaceFunction(BasicSqlParser.ReplaceFunctionContext ctx) {
        ValNode v = new ValNode(Type.String);
        String field = ctx.field.getText();
        String origin = fieldStrEdit(ctx.origin.getText());
        String new_ = fieldStrEdit(ctx.new_.getText());
        v.val = new FuncReplace(field, origin, new_);
        return v;
    }

    @Override
    public ValNode visitNumberType(BasicSqlParser.NumberTypeContext ctx) {//处理一下负号
        var v = visitUnsignednumbType(ctx.unsignednumbType());
        if (ctx.op != null && ctx.op.getText().equals("-")) {
            switch (v.type) {
                case Integer -> v.val = -((Integer) v.val);
                case Double -> v.val = -((Double) v.val);
                default -> throw new RuntimeException("Unsupported type:" + v.type);
            }
        }
        return v;
    }

    @Override
    public ValNode visitUnsignednumbType(BasicSqlParser.UnsignednumbTypeContext ctx) {
        if (ctx.VALINT() != null) {
            ValNode v = new ValNode(Type.Integer);
            v.val = Integer.valueOf(ctx.VALINT().getText());
            return v;
        } else if (ctx.VALDOUBLE() != null) {
            ValNode v = new ValNode(Type.Double);
            v.val = Double.valueOf(ctx.VALDOUBLE().getText());
            return v;
        } else throw new RuntimeException("Unknown type:" + ctx.getText());
    }

    @Override
    public Node visitColTypeList(BasicSqlParser.ColTypeListContext ctx) {
        return null;
    }

    @Override
    public Node visitColList(BasicSqlParser.ColListContext ctx) {
        return null;
    }

    @Override
    public Node visitColType(BasicSqlParser.ColTypeContext ctx) {
        TypeObjectNode node = new TypeObjectNode();
        node.name = ctx.ID().getText();
        node.primaryKey = ctx.PRIMARY_KEY() != null;
        if (ctx.dataType().INTTYPE() != null) {
            node.type = Type.Integer;
        } else if (ctx.dataType().DOUBLETYPE() != null) {
            node.type = Type.Double;
        } else if (ctx.dataType().STRINGTYPE() != null) {
            node.type = Type.String;
        } else throw new RuntimeException("Unknown dataType" + ctx.dataType().toString());
        return node;
    }

    @Override
    public Node visitDataType(BasicSqlParser.DataTypeContext ctx) {
        return null;
    }
}