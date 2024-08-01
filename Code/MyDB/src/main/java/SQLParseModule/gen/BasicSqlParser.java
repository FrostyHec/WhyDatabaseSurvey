package SQLParseModule.gen;// Generated from D:/ComputerScience/Projects/MyDB/src/main/resources/BasicSql.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BasicSqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, CREATE=6, TABLE=7, INSERT=8, INTO=9, 
		VALUES=10, DROP=11, SET=12, UPDATE=13, WHERE=14, FROM=15, SELECT=16, PRIMARY_KEY=17, 
		INTTYPE=18, DOUBLETYPE=19, STRINGTYPE=20, NOT=21, AND=22, OR=23, ADD=24, 
		SUBTRACT=25, DIVIDED=26, GREATER=27, LESS=28, EQUALS=29, DOUBLEEQUALS=30, 
		LIKE=31, STAR=32, GREATEREQUAS=33, LESSEQUALS=34, NULL=35, ID=36, VALINT=37, 
		VALDOUBLE=38, VALSTRING=39, WS=40, COMMENT=41;
	public static final int
		RULE_paragraphs = 0, RULE_singleStatement = 1, RULE_statement = 2, RULE_selectField = 3, 
		RULE_table = 4, RULE_boolExpression = 5, RULE_valExpression = 6, RULE_primaryValExpression = 7, 
		RULE_valAssignTypeList = 8, RULE_valAssignType = 9, RULE_vals = 10, RULE_valType = 11, 
		RULE_functions = 12, RULE_numberType = 13, RULE_unsignednumbType = 14, 
		RULE_colTypeList = 15, RULE_colList = 16, RULE_colType = 17, RULE_dataType = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"paragraphs", "singleStatement", "statement", "selectField", "table", 
			"boolExpression", "valExpression", "primaryValExpression", "valAssignTypeList", 
			"valAssignType", "vals", "valType", "functions", "numberType", "unsignednumbType", 
			"colTypeList", "colList", "colType", "dataType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "')'", "','", "'replace('", null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "'+'", "'-'", "'/'", "'>'", "'<'", "'='", "'=='", null, "'*'", 
			"'>='", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "CREATE", "TABLE", "INSERT", "INTO", 
			"VALUES", "DROP", "SET", "UPDATE", "WHERE", "FROM", "SELECT", "PRIMARY_KEY", 
			"INTTYPE", "DOUBLETYPE", "STRINGTYPE", "NOT", "AND", "OR", "ADD", "SUBTRACT", 
			"DIVIDED", "GREATER", "LESS", "EQUALS", "DOUBLEEQUALS", "LIKE", "STAR", 
			"GREATEREQUAS", "LESSEQUALS", "NULL", "ID", "VALINT", "VALDOUBLE", "VALSTRING", 
			"WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "BasicSql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BasicSqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParagraphsContext extends ParserRuleContext {
		public List<SingleStatementContext> singleStatement() {
			return getRuleContexts(SingleStatementContext.class);
		}
		public SingleStatementContext singleStatement(int i) {
			return getRuleContext(SingleStatementContext.class,i);
		}
		public TerminalNode EOF() { return getToken(BasicSqlParser.EOF, 0); }
		public ParagraphsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paragraphs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterParagraphs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitParagraphs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitParagraphs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParagraphsContext paragraphs() throws RecognitionException {
		ParagraphsContext _localctx = new ParagraphsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_paragraphs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			singleStatement();
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(39);
				match(T__0);
				setState(40);
				singleStatement();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SingleStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_singleStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			statement();
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(49);
				match(T__0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelectTableContext extends StatementContext {
		public TerminalNode SELECT() { return getToken(BasicSqlParser.SELECT, 0); }
		public SelectFieldContext selectField() {
			return getRuleContext(SelectFieldContext.class,0);
		}
		public TerminalNode FROM() { return getToken(BasicSqlParser.FROM, 0); }
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(BasicSqlParser.WHERE, 0); }
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public SelectTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterSelectTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitSelectTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitSelectTable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CreateTableContext extends StatementContext {
		public ColTypeListContext columns;
		public TerminalNode CREATE() { return getToken(BasicSqlParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(BasicSqlParser.TABLE, 0); }
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public List<ColTypeListContext> colTypeList() {
			return getRuleContexts(ColTypeListContext.class);
		}
		public ColTypeListContext colTypeList(int i) {
			return getRuleContext(ColTypeListContext.class,i);
		}
		public CreateTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterCreateTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitCreateTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitCreateTable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InsertTableContext extends StatementContext {
		public ColListContext columns;
		public TerminalNode INSERT() { return getToken(BasicSqlParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(BasicSqlParser.INTO, 0); }
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public TerminalNode VALUES() { return getToken(BasicSqlParser.VALUES, 0); }
		public List<ValsContext> vals() {
			return getRuleContexts(ValsContext.class);
		}
		public ValsContext vals(int i) {
			return getRuleContext(ValsContext.class,i);
		}
		public List<ColListContext> colList() {
			return getRuleContexts(ColListContext.class);
		}
		public ColListContext colList(int i) {
			return getRuleContext(ColListContext.class,i);
		}
		public InsertTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterInsertTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitInsertTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitInsertTable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UpdateTableContext extends StatementContext {
		public TerminalNode UPDATE() { return getToken(BasicSqlParser.UPDATE, 0); }
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public TerminalNode SET() { return getToken(BasicSqlParser.SET, 0); }
		public ValAssignTypeListContext valAssignTypeList() {
			return getRuleContext(ValAssignTypeListContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(BasicSqlParser.WHERE, 0); }
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public UpdateTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterUpdateTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitUpdateTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitUpdateTable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DropTableContext extends StatementContext {
		public TerminalNode DROP() { return getToken(BasicSqlParser.DROP, 0); }
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public DropTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterDropTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitDropTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitDropTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CREATE:
				_localctx = new CreateTableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(CREATE);
				setState(53);
				match(TABLE);
				setState(54);
				table();
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(55);
					match(T__1);
					}
					}
					setState(58); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 );
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(60);
					((CreateTableContext)_localctx).columns = colTypeList();
					}
					}
					setState(63); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(65);
				match(T__2);
				}
				break;
			case INSERT:
				_localctx = new InsertTableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(INSERT);
				setState(68);
				match(INTO);
				setState(69);
				table();
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(71); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(70);
						match(T__1);
						}
						}
						setState(73); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==T__1 );
					setState(76); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(75);
						((InsertTableContext)_localctx).columns = colList();
						}
						}
						setState(78); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==ID );
					setState(80);
					match(T__2);
					}
				}

				setState(84);
				match(VALUES);
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(85);
					match(T__1);
					}
					}
					setState(88); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 );
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(90);
					vals();
					}
					}
					setState(93); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 996482744352L) != 0) );
				setState(95);
				match(T__2);
				}
				break;
			case DROP:
				_localctx = new DropTableContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(DROP);
				setState(98);
				table();
				}
				break;
			case UPDATE:
				_localctx = new UpdateTableContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(99);
				match(UPDATE);
				setState(100);
				table();
				setState(101);
				match(SET);
				setState(102);
				valAssignTypeList();
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(103);
					match(WHERE);
					setState(104);
					boolExpression(0);
					}
				}

				}
				break;
			case SELECT:
				_localctx = new SelectTableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(107);
				match(SELECT);
				setState(108);
				selectField();
				setState(109);
				match(FROM);
				setState(110);
				table();
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(111);
					match(WHERE);
					setState(112);
					boolExpression(0);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectFieldContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(BasicSqlParser.STAR, 0); }
		public SelectFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterSelectField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitSelectField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitSelectField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectFieldContext selectField() throws RecognitionException {
		SelectFieldContext _localctx = new SelectFieldContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_selectField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(STAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BasicSqlParser.ID, 0); }
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolExpressionContext extends ParserRuleContext {
		public BoolExpressionContext bool1Expr;
		public Token operator;
		public Token fieldName;
		public Token regex;
		public ValExpressionContext left;
		public ValExpressionContext right;
		public BoolExpressionContext bool2Expr;
		public List<BoolExpressionContext> boolExpression() {
			return getRuleContexts(BoolExpressionContext.class);
		}
		public BoolExpressionContext boolExpression(int i) {
			return getRuleContext(BoolExpressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(BasicSqlParser.NOT, 0); }
		public TerminalNode ID() { return getToken(BasicSqlParser.ID, 0); }
		public TerminalNode LIKE() { return getToken(BasicSqlParser.LIKE, 0); }
		public TerminalNode VALSTRING() { return getToken(BasicSqlParser.VALSTRING, 0); }
		public List<ValExpressionContext> valExpression() {
			return getRuleContexts(ValExpressionContext.class);
		}
		public ValExpressionContext valExpression(int i) {
			return getRuleContext(ValExpressionContext.class,i);
		}
		public TerminalNode GREATER() { return getToken(BasicSqlParser.GREATER, 0); }
		public TerminalNode LESS() { return getToken(BasicSqlParser.LESS, 0); }
		public TerminalNode EQUALS() { return getToken(BasicSqlParser.EQUALS, 0); }
		public TerminalNode DOUBLEEQUALS() { return getToken(BasicSqlParser.DOUBLEEQUALS, 0); }
		public TerminalNode GREATEREQUAS() { return getToken(BasicSqlParser.GREATEREQUAS, 0); }
		public TerminalNode LESSEQUALS() { return getToken(BasicSqlParser.LESSEQUALS, 0); }
		public List<TerminalNode> AND() { return getTokens(BasicSqlParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(BasicSqlParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(BasicSqlParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(BasicSqlParser.OR, i);
		}
		public BoolExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterBoolExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitBoolExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitBoolExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolExpressionContext boolExpression() throws RecognitionException {
		return boolExpression(0);
	}

	private BoolExpressionContext boolExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BoolExpressionContext _localctx = new BoolExpressionContext(_ctx, _parentState);
		BoolExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_boolExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(122);
				match(T__1);
				setState(123);
				boolExpression(0);
				setState(124);
				match(T__2);
				}
				break;
			case 2:
				{
				setState(126);
				((BoolExpressionContext)_localctx).operator = match(NOT);
				setState(127);
				((BoolExpressionContext)_localctx).bool1Expr = boolExpression(4);
				}
				break;
			case 3:
				{
				setState(128);
				((BoolExpressionContext)_localctx).fieldName = match(ID);
				setState(129);
				((BoolExpressionContext)_localctx).operator = match(LIKE);
				setState(130);
				((BoolExpressionContext)_localctx).regex = match(VALSTRING);
				}
				break;
			case 4:
				{
				setState(131);
				((BoolExpressionContext)_localctx).left = valExpression(0);
				setState(132);
				((BoolExpressionContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 27783069696L) != 0)) ) {
					((BoolExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(133);
				((BoolExpressionContext)_localctx).right = valExpression(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BoolExpressionContext(_parentctx, _parentState);
					_localctx.bool1Expr = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_boolExpression);
					setState(137);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(140); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(138);
							((BoolExpressionContext)_localctx).operator = _input.LT(1);
							_la = _input.LA(1);
							if ( !(_la==AND || _la==OR) ) {
								((BoolExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							setState(139);
							((BoolExpressionContext)_localctx).bool2Expr = boolExpression(0);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(142); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
					} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
					}
					} 
				}
				setState(148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValExpressionContext extends ParserRuleContext {
		public ValExpressionContext left;
		public Token operator;
		public ValExpressionContext right;
		public List<ValExpressionContext> valExpression() {
			return getRuleContexts(ValExpressionContext.class);
		}
		public ValExpressionContext valExpression(int i) {
			return getRuleContext(ValExpressionContext.class,i);
		}
		public PrimaryValExpressionContext primaryValExpression() {
			return getRuleContext(PrimaryValExpressionContext.class,0);
		}
		public TerminalNode STAR() { return getToken(BasicSqlParser.STAR, 0); }
		public TerminalNode DIVIDED() { return getToken(BasicSqlParser.DIVIDED, 0); }
		public TerminalNode ADD() { return getToken(BasicSqlParser.ADD, 0); }
		public TerminalNode SUBTRACT() { return getToken(BasicSqlParser.SUBTRACT, 0); }
		public ValExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterValExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitValExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitValExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValExpressionContext valExpression() throws RecognitionException {
		return valExpression(0);
	}

	private ValExpressionContext valExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValExpressionContext _localctx = new ValExpressionContext(_ctx, _parentState);
		ValExpressionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_valExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(150);
				match(T__1);
				setState(151);
				valExpression(0);
				setState(152);
				match(T__2);
				}
				break;
			case T__4:
			case ADD:
			case SUBTRACT:
			case NULL:
			case ID:
			case VALINT:
			case VALDOUBLE:
			case VALSTRING:
				{
				setState(154);
				primaryValExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(165);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(163);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ValExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valExpression);
						setState(157);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(158);
						((ValExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==DIVIDED || _la==STAR) ) {
							((ValExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(159);
						((ValExpressionContext)_localctx).right = valExpression(3);
						}
						break;
					case 2:
						{
						_localctx = new ValExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valExpression);
						setState(160);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(161);
						((ValExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUBTRACT) ) {
							((ValExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(162);
						((ValExpressionContext)_localctx).right = valExpression(2);
						}
						break;
					}
					} 
				}
				setState(167);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryValExpressionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BasicSqlParser.ID, 0); }
		public ValTypeContext valType() {
			return getRuleContext(ValTypeContext.class,0);
		}
		public PrimaryValExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryValExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterPrimaryValExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitPrimaryValExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitPrimaryValExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryValExpressionContext primaryValExpression() throws RecognitionException {
		PrimaryValExpressionContext _localctx = new PrimaryValExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_primaryValExpression);
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				match(ID);
				}
				break;
			case T__4:
			case ADD:
			case SUBTRACT:
			case NULL:
			case VALINT:
			case VALDOUBLE:
			case VALSTRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				valType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValAssignTypeListContext extends ParserRuleContext {
		public List<ValAssignTypeContext> valAssignType() {
			return getRuleContexts(ValAssignTypeContext.class);
		}
		public ValAssignTypeContext valAssignType(int i) {
			return getRuleContext(ValAssignTypeContext.class,i);
		}
		public ValAssignTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valAssignTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterValAssignTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitValAssignTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitValAssignTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValAssignTypeListContext valAssignTypeList() throws RecognitionException {
		ValAssignTypeListContext _localctx = new ValAssignTypeListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_valAssignTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			valAssignType();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(173);
				match(T__3);
				setState(174);
				valAssignType();
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValAssignTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BasicSqlParser.ID, 0); }
		public TerminalNode EQUALS() { return getToken(BasicSqlParser.EQUALS, 0); }
		public ValTypeContext valType() {
			return getRuleContext(ValTypeContext.class,0);
		}
		public ValAssignTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valAssignType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterValAssignType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitValAssignType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitValAssignType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValAssignTypeContext valAssignType() throws RecognitionException {
		ValAssignTypeContext _localctx = new ValAssignTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_valAssignType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(ID);
			setState(181);
			match(EQUALS);
			setState(182);
			valType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValsContext extends ParserRuleContext {
		public List<ValTypeContext> valType() {
			return getRuleContexts(ValTypeContext.class);
		}
		public ValTypeContext valType(int i) {
			return getRuleContext(ValTypeContext.class,i);
		}
		public ValsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterVals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitVals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitVals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValsContext vals() throws RecognitionException {
		ValsContext _localctx = new ValsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_vals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			valType();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(185);
				match(T__3);
				setState(186);
				valType();
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValTypeContext extends ParserRuleContext {
		public NumberTypeContext numberType() {
			return getRuleContext(NumberTypeContext.class,0);
		}
		public TerminalNode VALSTRING() { return getToken(BasicSqlParser.VALSTRING, 0); }
		public TerminalNode NULL() { return getToken(BasicSqlParser.NULL, 0); }
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public ValTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterValType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitValType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitValType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValTypeContext valType() throws RecognitionException {
		ValTypeContext _localctx = new ValTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_valType);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
			case SUBTRACT:
			case VALINT:
			case VALDOUBLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				numberType();
				}
				break;
			case VALSTRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				match(VALSTRING);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(194);
				match(NULL);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(195);
				functions();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionsContext extends ParserRuleContext {
		public FunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions; }
	 
		public FunctionsContext() { }
		public void copyFrom(FunctionsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReplaceFunctionContext extends FunctionsContext {
		public Token field;
		public Token origin;
		public Token new_;
		public TerminalNode ID() { return getToken(BasicSqlParser.ID, 0); }
		public List<TerminalNode> VALSTRING() { return getTokens(BasicSqlParser.VALSTRING); }
		public TerminalNode VALSTRING(int i) {
			return getToken(BasicSqlParser.VALSTRING, i);
		}
		public ReplaceFunctionContext(FunctionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterReplaceFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitReplaceFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitReplaceFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functions);
		try {
			_localctx = new ReplaceFunctionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__4);
			setState(199);
			((ReplaceFunctionContext)_localctx).field = match(ID);
			setState(200);
			match(T__3);
			setState(201);
			((ReplaceFunctionContext)_localctx).origin = match(VALSTRING);
			setState(202);
			match(T__3);
			setState(203);
			((ReplaceFunctionContext)_localctx).new_ = match(VALSTRING);
			setState(204);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberTypeContext extends ParserRuleContext {
		public Token op;
		public UnsignednumbTypeContext unsignednumbType() {
			return getRuleContext(UnsignednumbTypeContext.class,0);
		}
		public TerminalNode ADD() { return getToken(BasicSqlParser.ADD, 0); }
		public TerminalNode SUBTRACT() { return getToken(BasicSqlParser.SUBTRACT, 0); }
		public NumberTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterNumberType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitNumberType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitNumberType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberTypeContext numberType() throws RecognitionException {
		NumberTypeContext _localctx = new NumberTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_numberType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADD || _la==SUBTRACT) {
				{
				setState(206);
				((NumberTypeContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUBTRACT) ) {
					((NumberTypeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(209);
			unsignednumbType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnsignednumbTypeContext extends ParserRuleContext {
		public TerminalNode VALINT() { return getToken(BasicSqlParser.VALINT, 0); }
		public TerminalNode VALDOUBLE() { return getToken(BasicSqlParser.VALDOUBLE, 0); }
		public UnsignednumbTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsignednumbType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterUnsignednumbType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitUnsignednumbType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitUnsignednumbType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsignednumbTypeContext unsignednumbType() throws RecognitionException {
		UnsignednumbTypeContext _localctx = new UnsignednumbTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unsignednumbType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_la = _input.LA(1);
			if ( !(_la==VALINT || _la==VALDOUBLE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColTypeListContext extends ParserRuleContext {
		public List<ColTypeContext> colType() {
			return getRuleContexts(ColTypeContext.class);
		}
		public ColTypeContext colType(int i) {
			return getRuleContext(ColTypeContext.class,i);
		}
		public ColTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterColTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitColTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitColTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColTypeListContext colTypeList() throws RecognitionException {
		ColTypeListContext _localctx = new ColTypeListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_colTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			colType();
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(214);
				match(T__3);
				setState(215);
				colType();
				}
				}
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(BasicSqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(BasicSqlParser.ID, i);
		}
		public ColListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterColList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitColList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitColList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColListContext colList() throws RecognitionException {
		ColListContext _localctx = new ColListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_colList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(ID);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(222);
				match(T__3);
				setState(223);
				match(ID);
				}
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColTypeContext extends ParserRuleContext {
		public DataTypeContext type;
		public TerminalNode ID() { return getToken(BasicSqlParser.ID, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode PRIMARY_KEY() { return getToken(BasicSqlParser.PRIMARY_KEY, 0); }
		public ColTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterColType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitColType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitColType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColTypeContext colType() throws RecognitionException {
		ColTypeContext _localctx = new ColTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_colType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(ID);
			setState(230);
			((ColTypeContext)_localctx).type = dataType();
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PRIMARY_KEY) {
				{
				setState(231);
				match(PRIMARY_KEY);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataTypeContext extends ParserRuleContext {
		public TerminalNode INTTYPE() { return getToken(BasicSqlParser.INTTYPE, 0); }
		public TerminalNode DOUBLETYPE() { return getToken(BasicSqlParser.DOUBLETYPE, 0); }
		public TerminalNode STRINGTYPE() { return getToken(BasicSqlParser.STRINGTYPE, 0); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSqlListener ) ((BasicSqlListener)listener).exitDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicSqlVisitor ) return ((BasicSqlVisitor<? extends T>)visitor).visitDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_dataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1835008L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return boolExpression_sempred((BoolExpressionContext)_localctx, predIndex);
		case 6:
			return valExpression_sempred((ValExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean boolExpression_sempred(BoolExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean valExpression_sempred(ValExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001)\u00ed\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000*\b\u0000\n\u0000\f\u0000"+
		"-\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001"+
		"3\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002"+
		"9\b\u0002\u000b\u0002\f\u0002:\u0001\u0002\u0004\u0002>\b\u0002\u000b"+
		"\u0002\f\u0002?\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0004\u0002H\b\u0002\u000b\u0002\f\u0002I\u0001\u0002"+
		"\u0004\u0002M\b\u0002\u000b\u0002\f\u0002N\u0001\u0002\u0001\u0002\u0003"+
		"\u0002S\b\u0002\u0001\u0002\u0001\u0002\u0004\u0002W\b\u0002\u000b\u0002"+
		"\f\u0002X\u0001\u0002\u0004\u0002\\\b\u0002\u000b\u0002\f\u0002]\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002j\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002r\b\u0002\u0003\u0002t\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0088\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0004\u0005\u008d\b\u0005\u000b\u0005\f\u0005"+
		"\u008e\u0005\u0005\u0091\b\u0005\n\u0005\f\u0005\u0094\t\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u009c\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u00a4\b\u0006\n\u0006\f\u0006\u00a7\t\u0006\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u00ab\b\u0007\u0001\b\u0001\b\u0001\b\u0005"+
		"\b\u00b0\b\b\n\b\f\b\u00b3\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\n\u0005\n\u00bc\b\n\n\n\f\n\u00bf\t\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00c5\b\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0003\r\u00d0"+
		"\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u00d9\b\u000f\n\u000f\f\u000f\u00dc\t\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u00e1\b\u0010\n\u0010\f\u0010\u00e4"+
		"\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00e9\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0000\u0002\n\f\u0013\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$\u0000\u0006\u0002\u0000\u001b\u001e!\"\u0001\u0000\u0016\u0017\u0002"+
		"\u0000\u001a\u001a  \u0001\u0000\u0018\u0019\u0001\u0000%&\u0001\u0000"+
		"\u0012\u0014\u00fa\u0000&\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000"+
		"\u0000\u0004s\u0001\u0000\u0000\u0000\u0006u\u0001\u0000\u0000\u0000\b"+
		"w\u0001\u0000\u0000\u0000\n\u0087\u0001\u0000\u0000\u0000\f\u009b\u0001"+
		"\u0000\u0000\u0000\u000e\u00aa\u0001\u0000\u0000\u0000\u0010\u00ac\u0001"+
		"\u0000\u0000\u0000\u0012\u00b4\u0001\u0000\u0000\u0000\u0014\u00b8\u0001"+
		"\u0000\u0000\u0000\u0016\u00c4\u0001\u0000\u0000\u0000\u0018\u00c6\u0001"+
		"\u0000\u0000\u0000\u001a\u00cf\u0001\u0000\u0000\u0000\u001c\u00d3\u0001"+
		"\u0000\u0000\u0000\u001e\u00d5\u0001\u0000\u0000\u0000 \u00dd\u0001\u0000"+
		"\u0000\u0000\"\u00e5\u0001\u0000\u0000\u0000$\u00ea\u0001\u0000\u0000"+
		"\u0000&+\u0003\u0002\u0001\u0000\'(\u0005\u0001\u0000\u0000(*\u0003\u0002"+
		"\u0001\u0000)\'\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+)\u0001"+
		"\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001\u0000\u0000\u0000"+
		"-+\u0001\u0000\u0000\u0000./\u0005\u0000\u0000\u0001/\u0001\u0001\u0000"+
		"\u0000\u000002\u0003\u0004\u0002\u000013\u0005\u0001\u0000\u000021\u0001"+
		"\u0000\u0000\u000023\u0001\u0000\u0000\u00003\u0003\u0001\u0000\u0000"+
		"\u000045\u0005\u0006\u0000\u000056\u0005\u0007\u0000\u000068\u0003\b\u0004"+
		"\u000079\u0005\u0002\u0000\u000087\u0001\u0000\u0000\u00009:\u0001\u0000"+
		"\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;=\u0001"+
		"\u0000\u0000\u0000<>\u0003\u001e\u000f\u0000=<\u0001\u0000\u0000\u0000"+
		">?\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000"+
		"\u0000@A\u0001\u0000\u0000\u0000AB\u0005\u0003\u0000\u0000Bt\u0001\u0000"+
		"\u0000\u0000CD\u0005\b\u0000\u0000DE\u0005\t\u0000\u0000ER\u0003\b\u0004"+
		"\u0000FH\u0005\u0002\u0000\u0000GF\u0001\u0000\u0000\u0000HI\u0001\u0000"+
		"\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JL\u0001"+
		"\u0000\u0000\u0000KM\u0003 \u0010\u0000LK\u0001\u0000\u0000\u0000MN\u0001"+
		"\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000PQ\u0005\u0003\u0000\u0000QS\u0001\u0000\u0000"+
		"\u0000RG\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0001\u0000"+
		"\u0000\u0000TV\u0005\n\u0000\u0000UW\u0005\u0002\u0000\u0000VU\u0001\u0000"+
		"\u0000\u0000WX\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001"+
		"\u0000\u0000\u0000Y[\u0001\u0000\u0000\u0000Z\\\u0003\u0014\n\u0000[Z"+
		"\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000][\u0001\u0000\u0000"+
		"\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0005\u0003"+
		"\u0000\u0000`t\u0001\u0000\u0000\u0000ab\u0005\u000b\u0000\u0000bt\u0003"+
		"\b\u0004\u0000cd\u0005\r\u0000\u0000de\u0003\b\u0004\u0000ef\u0005\f\u0000"+
		"\u0000fi\u0003\u0010\b\u0000gh\u0005\u000e\u0000\u0000hj\u0003\n\u0005"+
		"\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jt\u0001\u0000"+
		"\u0000\u0000kl\u0005\u0010\u0000\u0000lm\u0003\u0006\u0003\u0000mn\u0005"+
		"\u000f\u0000\u0000nq\u0003\b\u0004\u0000op\u0005\u000e\u0000\u0000pr\u0003"+
		"\n\u0005\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rt\u0001"+
		"\u0000\u0000\u0000s4\u0001\u0000\u0000\u0000sC\u0001\u0000\u0000\u0000"+
		"sa\u0001\u0000\u0000\u0000sc\u0001\u0000\u0000\u0000sk\u0001\u0000\u0000"+
		"\u0000t\u0005\u0001\u0000\u0000\u0000uv\u0005 \u0000\u0000v\u0007\u0001"+
		"\u0000\u0000\u0000wx\u0005$\u0000\u0000x\t\u0001\u0000\u0000\u0000yz\u0006"+
		"\u0005\uffff\uffff\u0000z{\u0005\u0002\u0000\u0000{|\u0003\n\u0005\u0000"+
		"|}\u0005\u0003\u0000\u0000}\u0088\u0001\u0000\u0000\u0000~\u007f\u0005"+
		"\u0015\u0000\u0000\u007f\u0088\u0003\n\u0005\u0004\u0080\u0081\u0005$"+
		"\u0000\u0000\u0081\u0082\u0005\u001f\u0000\u0000\u0082\u0088\u0005\'\u0000"+
		"\u0000\u0083\u0084\u0003\f\u0006\u0000\u0084\u0085\u0007\u0000\u0000\u0000"+
		"\u0085\u0086\u0003\f\u0006\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087"+
		"y\u0001\u0000\u0000\u0000\u0087~\u0001\u0000\u0000\u0000\u0087\u0080\u0001"+
		"\u0000\u0000\u0000\u0087\u0083\u0001\u0000\u0000\u0000\u0088\u0092\u0001"+
		"\u0000\u0000\u0000\u0089\u008c\n\u0003\u0000\u0000\u008a\u008b\u0007\u0001"+
		"\u0000\u0000\u008b\u008d\u0003\n\u0005\u0000\u008c\u008a\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0091\u0001\u0000\u0000"+
		"\u0000\u0090\u0089\u0001\u0000\u0000\u0000\u0091\u0094\u0001\u0000\u0000"+
		"\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000"+
		"\u0000\u0093\u000b\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0006\u0006\uffff\uffff\u0000\u0096\u0097\u0005\u0002"+
		"\u0000\u0000\u0097\u0098\u0003\f\u0006\u0000\u0098\u0099\u0005\u0003\u0000"+
		"\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u009c\u0003\u000e\u0007"+
		"\u0000\u009b\u0095\u0001\u0000\u0000\u0000\u009b\u009a\u0001\u0000\u0000"+
		"\u0000\u009c\u00a5\u0001\u0000\u0000\u0000\u009d\u009e\n\u0002\u0000\u0000"+
		"\u009e\u009f\u0007\u0002\u0000\u0000\u009f\u00a4\u0003\f\u0006\u0003\u00a0"+
		"\u00a1\n\u0001\u0000\u0000\u00a1\u00a2\u0007\u0003\u0000\u0000\u00a2\u00a4"+
		"\u0003\f\u0006\u0002\u00a3\u009d\u0001\u0000\u0000\u0000\u00a3\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\r\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00ab\u0005$\u0000"+
		"\u0000\u00a9\u00ab\u0003\u0016\u000b\u0000\u00aa\u00a8\u0001\u0000\u0000"+
		"\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab\u000f\u0001\u0000\u0000"+
		"\u0000\u00ac\u00b1\u0003\u0012\t\u0000\u00ad\u00ae\u0005\u0004\u0000\u0000"+
		"\u00ae\u00b0\u0003\u0012\t\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b2\u0011\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005$\u0000\u0000\u00b5\u00b6"+
		"\u0005\u001d\u0000\u0000\u00b6\u00b7\u0003\u0016\u000b\u0000\u00b7\u0013"+
		"\u0001\u0000\u0000\u0000\u00b8\u00bd\u0003\u0016\u000b\u0000\u00b9\u00ba"+
		"\u0005\u0004\u0000\u0000\u00ba\u00bc\u0003\u0016\u000b\u0000\u00bb\u00b9"+
		"\u0001\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb"+
		"\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u0015"+
		"\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c5"+
		"\u0003\u001a\r\u0000\u00c1\u00c5\u0005\'\u0000\u0000\u00c2\u00c5\u0005"+
		"#\u0000\u0000\u00c3\u00c5\u0003\u0018\f\u0000\u00c4\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5\u0017\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c7\u0005\u0005\u0000\u0000\u00c7\u00c8\u0005$\u0000"+
		"\u0000\u00c8\u00c9\u0005\u0004\u0000\u0000\u00c9\u00ca\u0005\'\u0000\u0000"+
		"\u00ca\u00cb\u0005\u0004\u0000\u0000\u00cb\u00cc\u0005\'\u0000\u0000\u00cc"+
		"\u00cd\u0005\u0003\u0000\u0000\u00cd\u0019\u0001\u0000\u0000\u0000\u00ce"+
		"\u00d0\u0007\u0003\u0000\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d2\u0003\u001c\u000e\u0000\u00d2\u001b\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d4\u0007\u0004\u0000\u0000\u00d4\u001d\u0001\u0000\u0000\u0000\u00d5"+
		"\u00da\u0003\"\u0011\u0000\u00d6\u00d7\u0005\u0004\u0000\u0000\u00d7\u00d9"+
		"\u0003\"\u0011\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9\u00dc\u0001"+
		"\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db\u0001"+
		"\u0000\u0000\u0000\u00db\u001f\u0001\u0000\u0000\u0000\u00dc\u00da\u0001"+
		"\u0000\u0000\u0000\u00dd\u00e2\u0005$\u0000\u0000\u00de\u00df\u0005\u0004"+
		"\u0000\u0000\u00df\u00e1\u0005$\u0000\u0000\u00e0\u00de\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e4\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3!\u0001\u0000\u0000\u0000"+
		"\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005$\u0000\u0000\u00e6"+
		"\u00e8\u0003$\u0012\u0000\u00e7\u00e9\u0005\u0011\u0000\u0000\u00e8\u00e7"+
		"\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9#\u0001"+
		"\u0000\u0000\u0000\u00ea\u00eb\u0007\u0005\u0000\u0000\u00eb%\u0001\u0000"+
		"\u0000\u0000\u001a+2:?INRX]iqs\u0087\u008e\u0092\u009b\u00a3\u00a5\u00aa"+
		"\u00b1\u00bd\u00c4\u00cf\u00da\u00e2\u00e8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}