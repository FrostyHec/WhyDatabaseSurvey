package SQLParseModule.gen;// Generated from D:/ComputerScience/Projects/MyDB/src/main/resources/BasicSql.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BasicSqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BasicSqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#paragraphs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParagraphs(BasicSqlParser.ParagraphsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#singleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStatement(BasicSqlParser.SingleStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createTable}
	 * labeled alternative in {@link BasicSqlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTable(BasicSqlParser.CreateTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insertTable}
	 * labeled alternative in {@link BasicSqlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertTable(BasicSqlParser.InsertTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dropTable}
	 * labeled alternative in {@link BasicSqlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTable(BasicSqlParser.DropTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code updateTable}
	 * labeled alternative in {@link BasicSqlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateTable(BasicSqlParser.UpdateTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selectTable}
	 * labeled alternative in {@link BasicSqlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectTable(BasicSqlParser.SelectTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#selectField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectField(BasicSqlParser.SelectFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(BasicSqlParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#boolExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(BasicSqlParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#valExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValExpression(BasicSqlParser.ValExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#primaryValExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryValExpression(BasicSqlParser.PrimaryValExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#valAssignTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValAssignTypeList(BasicSqlParser.ValAssignTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#valAssignType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValAssignType(BasicSqlParser.ValAssignTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#vals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVals(BasicSqlParser.ValsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#valType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValType(BasicSqlParser.ValTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code replaceFunction}
	 * labeled alternative in {@link BasicSqlParser#functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceFunction(BasicSqlParser.ReplaceFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#numberType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberType(BasicSqlParser.NumberTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#unsignednumbType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignednumbType(BasicSqlParser.UnsignednumbTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#colTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColTypeList(BasicSqlParser.ColTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#colList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColList(BasicSqlParser.ColListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#colType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColType(BasicSqlParser.ColTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicSqlParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(BasicSqlParser.DataTypeContext ctx);
}