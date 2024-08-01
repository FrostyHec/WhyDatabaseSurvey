package SQLParseModule.gen;// Generated from D:/ComputerScience/Projects/MyDB/src/main/resources/BasicSql.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BasicSqlParser}.
 */
public interface BasicSqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#paragraphs}.
	 * @param ctx the parse tree
	 */
	void enterParagraphs(BasicSqlParser.ParagraphsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#paragraphs}.
	 * @param ctx the parse tree
	 */
	void exitParagraphs(BasicSqlParser.ParagraphsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSingleStatement(BasicSqlParser.SingleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSingleStatement(BasicSqlParser.SingleStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createTable}
	 * labeled alternative in {@link BasicSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCreateTable(BasicSqlParser.CreateTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createTable}
	 * labeled alternative in {@link BasicSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCreateTable(BasicSqlParser.CreateTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insertTable}
	 * labeled alternative in {@link BasicSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterInsertTable(BasicSqlParser.InsertTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insertTable}
	 * labeled alternative in {@link BasicSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitInsertTable(BasicSqlParser.InsertTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dropTable}
	 * labeled alternative in {@link BasicSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDropTable(BasicSqlParser.DropTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dropTable}
	 * labeled alternative in {@link BasicSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDropTable(BasicSqlParser.DropTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code updateTable}
	 * labeled alternative in {@link BasicSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterUpdateTable(BasicSqlParser.UpdateTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code updateTable}
	 * labeled alternative in {@link BasicSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitUpdateTable(BasicSqlParser.UpdateTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectTable}
	 * labeled alternative in {@link BasicSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSelectTable(BasicSqlParser.SelectTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectTable}
	 * labeled alternative in {@link BasicSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSelectTable(BasicSqlParser.SelectTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#selectField}.
	 * @param ctx the parse tree
	 */
	void enterSelectField(BasicSqlParser.SelectFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#selectField}.
	 * @param ctx the parse tree
	 */
	void exitSelectField(BasicSqlParser.SelectFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(BasicSqlParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(BasicSqlParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#boolExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(BasicSqlParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#boolExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(BasicSqlParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#valExpression}.
	 * @param ctx the parse tree
	 */
	void enterValExpression(BasicSqlParser.ValExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#valExpression}.
	 * @param ctx the parse tree
	 */
	void exitValExpression(BasicSqlParser.ValExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#primaryValExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryValExpression(BasicSqlParser.PrimaryValExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#primaryValExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryValExpression(BasicSqlParser.PrimaryValExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#valAssignTypeList}.
	 * @param ctx the parse tree
	 */
	void enterValAssignTypeList(BasicSqlParser.ValAssignTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#valAssignTypeList}.
	 * @param ctx the parse tree
	 */
	void exitValAssignTypeList(BasicSqlParser.ValAssignTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#valAssignType}.
	 * @param ctx the parse tree
	 */
	void enterValAssignType(BasicSqlParser.ValAssignTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#valAssignType}.
	 * @param ctx the parse tree
	 */
	void exitValAssignType(BasicSqlParser.ValAssignTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#vals}.
	 * @param ctx the parse tree
	 */
	void enterVals(BasicSqlParser.ValsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#vals}.
	 * @param ctx the parse tree
	 */
	void exitVals(BasicSqlParser.ValsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#valType}.
	 * @param ctx the parse tree
	 */
	void enterValType(BasicSqlParser.ValTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#valType}.
	 * @param ctx the parse tree
	 */
	void exitValType(BasicSqlParser.ValTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code replaceFunction}
	 * labeled alternative in {@link BasicSqlParser#functions}.
	 * @param ctx the parse tree
	 */
	void enterReplaceFunction(BasicSqlParser.ReplaceFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code replaceFunction}
	 * labeled alternative in {@link BasicSqlParser#functions}.
	 * @param ctx the parse tree
	 */
	void exitReplaceFunction(BasicSqlParser.ReplaceFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#numberType}.
	 * @param ctx the parse tree
	 */
	void enterNumberType(BasicSqlParser.NumberTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#numberType}.
	 * @param ctx the parse tree
	 */
	void exitNumberType(BasicSqlParser.NumberTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#unsignednumbType}.
	 * @param ctx the parse tree
	 */
	void enterUnsignednumbType(BasicSqlParser.UnsignednumbTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#unsignednumbType}.
	 * @param ctx the parse tree
	 */
	void exitUnsignednumbType(BasicSqlParser.UnsignednumbTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#colTypeList}.
	 * @param ctx the parse tree
	 */
	void enterColTypeList(BasicSqlParser.ColTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#colTypeList}.
	 * @param ctx the parse tree
	 */
	void exitColTypeList(BasicSqlParser.ColTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#colList}.
	 * @param ctx the parse tree
	 */
	void enterColList(BasicSqlParser.ColListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#colList}.
	 * @param ctx the parse tree
	 */
	void exitColList(BasicSqlParser.ColListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#colType}.
	 * @param ctx the parse tree
	 */
	void enterColType(BasicSqlParser.ColTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#colType}.
	 * @param ctx the parse tree
	 */
	void exitColType(BasicSqlParser.ColTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(BasicSqlParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(BasicSqlParser.DataTypeContext ctx);
}