// Generated from C:/Users/javie/IdeaProjects/DLP/src/parser\Pmm.g4 by ANTLR 4.9.1
package parser;

import ast.*;
import ast.expressions.*;
import ast.expressions.literals.*;
import ast.statements.*;
import ast.types.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, TRASH=37, INT_CONSTANT=38, 
		TYPE=39, REAL_CONSTANT=40, ID=41, CHAR_CONSTANT=42;
	public static final int
		RULE_program = 0, RULE_definition = 1, RULE_expression = 2, RULE_statement = 3, 
		RULE_block = 4, RULE_function_invocation = 5, RULE_variable_definition = 6, 
		RULE_multiple_ids_definitions = 7, RULE_function_definition = 8, RULE_type = 9, 
		RULE_terminal_types = 10, RULE_record_field = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "definition", "expression", "statement", "block", "function_invocation", 
			"variable_definition", "multiple_ids_definitions", "function_definition", 
			"type", "terminal_types", "record_field"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'.'", "'-'", "'!'", "'*'", "'/'", 
			"'%'", "'+'", "'>'", "'<'", "'>='", "'<='", "'!='", "'=='", "'&&'", "'||'", 
			"'='", "';'", "'while'", "':'", "'if'", "'else'", "'return'", "'input'", 
			"','", "'print'", "'{'", "'}'", "'def'", "'struct'", "'int'", "'double'", 
			"'char'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "TRASH", "INT_CONSTANT", "TYPE", "REAL_CONSTANT", "ID", "CHAR_CONSTANT"
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
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public List<Definition> definitions = new ArrayList<Definition>();
		public DefinitionContext def;
		public TerminalNode EOF() { return getToken(PmmParser.EOF, 0); }
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__31 || _la==ID) {
				{
				{
				setState(24);
				((ProgramContext)_localctx).def = definition();
				 _localctx.definitions.addAll(((ProgramContext)_localctx).def.ast); 
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 ((ProgramContext)_localctx).ast =  new Program(0 ,0 , _localctx.definitions); 
			setState(33);
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

	public static class DefinitionContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public Function_definitionContext fun;
		public Variable_definitionContext var;
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public Variable_definitionContext variable_definition() {
			return getRuleContext(Variable_definitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				((DefinitionContext)_localctx).fun = function_definition();
				 _localctx.ast.add(((DefinitionContext)_localctx).fun.ast); 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				((DefinitionContext)_localctx).var = variable_definition();
				 _localctx.ast.addAll(((DefinitionContext)_localctx).var.ast); 
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

	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext exp1;
		public ExpressionContext exp;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token ID;
		public TypeContext typ;
		public Function_invocationContext fu;
		public Token OP;
		public ExpressionContext exp2;
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(PmmParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(PmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Function_invocationContext function_invocation() {
			return getRuleContext(Function_invocationContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(44);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).INT_CONSTANT.getLine(), ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null))); 
				}
				break;
			case 2:
				{
				setState(46);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new RealLiteral(((ExpressionContext)_localctx).REAL_CONSTANT.getLine(), ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine() + 1 , LexerHelper.lexemeToReal((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null))); 
				}
				break;
			case 3:
				{
				setState(48);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(), ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine() + 1 , LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null))); 
				}
				break;
			case 4:
				{
				setState(50);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1 ,(((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			case 5:
				{
				setState(52);
				match(T__0);
				setState(53);
				((ExpressionContext)_localctx).exp = expression(0);
				setState(54);
				match(T__1);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).exp.ast; 
				}
				break;
			case 6:
				{
				setState(57);
				match(T__2);
				setState(58);
				((ExpressionContext)_localctx).exp = expression(0);
				setState(59);
				match(T__3);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).exp.ast; 
				}
				break;
			case 7:
				{
				setState(62);
				match(T__0);
				setState(63);
				((ExpressionContext)_localctx).typ = type();
				setState(64);
				match(T__1);
				setState(65);
				((ExpressionContext)_localctx).exp = expression(8);
				 ((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(), ((ExpressionContext)_localctx).typ.ast, ((ExpressionContext)_localctx).exp.ast); 
				}
				break;
			case 8:
				{
				setState(68);
				match(T__5);
				setState(69);
				((ExpressionContext)_localctx).exp = expression(7);
				 ((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(), ((ExpressionContext)_localctx).exp.ast); 
				}
				break;
			case 9:
				{
				setState(72);
				match(T__6);
				setState(73);
				((ExpressionContext)_localctx).exp = expression(6);
				 ((ExpressionContext)_localctx).ast =  new UnaryNot(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(), ((ExpressionContext)_localctx).exp.ast); 
				}
				break;
			case 10:
				{
				setState(76);
				((ExpressionContext)_localctx).fu = function_invocation();
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).fu.ast; 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(111);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(81);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(82);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(83);
						((ExpressionContext)_localctx).exp2 = expression(6);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).exp2.ast); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(86);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(87);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__10) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(88);
						((ExpressionContext)_localctx).exp2 = expression(5);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).exp2.ast); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(91);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(92);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(93);
						((ExpressionContext)_localctx).exp2 = expression(4);
						 ((ExpressionContext)_localctx).ast =  new Comparison(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).exp2.ast); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(96);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(97);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__18) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(98);
						((ExpressionContext)_localctx).exp2 = expression(3);
						 ((ExpressionContext)_localctx).ast =  new LogicalOperation(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).exp2.ast); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(101);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(102);
						match(T__2);
						setState(103);
						((ExpressionContext)_localctx).exp2 = expression(0);
						setState(104);
						match(T__3);
						 ((ExpressionContext)_localctx).ast =  new ArrayIndexing(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, ((ExpressionContext)_localctx).exp2.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp = _prevctx;
						_localctx.exp = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(107);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(108);
						match(T__4);
						setState(109);
						((ExpressionContext)_localctx).ID = match(ID);
						 ((ExpressionContext)_localctx).ast =  new FieldAccess(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(), ((ExpressionContext)_localctx).exp.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
						}
						break;
					}
					} 
				}
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class StatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public List<Statement> statementsElse = new ArrayList<Statement>();
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public ExpressionContext exp;
		public BlockContext bl;
		public BlockContext bl1;
		public BlockContext bl2;
		public Function_invocationContext fu;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public Function_invocationContext function_invocation() {
			return getRuleContext(Function_invocationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				((StatementContext)_localctx).exp1 = expression(0);
				setState(117);
				match(T__19);
				setState(118);
				((StatementContext)_localctx).exp2 = expression(0);
				setState(119);
				match(T__20);
				 _localctx.ast.add(new Assignment(((StatementContext)_localctx).exp1.ast.getLine(), ((StatementContext)_localctx).exp1.ast.getColumn(), ((StatementContext)_localctx).exp1.ast, ((StatementContext)_localctx).exp2.ast)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				match(T__21);
				setState(123);
				((StatementContext)_localctx).exp = expression(0);
				setState(124);
				match(T__22);
				setState(125);
				((StatementContext)_localctx).bl = block();
				 _localctx.ast.add(new While(((StatementContext)_localctx).exp.ast.getLine(), ((StatementContext)_localctx).exp.ast.getColumn(), ((StatementContext)_localctx).exp.ast, ((StatementContext)_localctx).bl.ast)); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				match(T__23);
				setState(129);
				((StatementContext)_localctx).exp = expression(0);
				setState(130);
				match(T__22);
				setState(131);
				((StatementContext)_localctx).bl1 = block();
				setState(136);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(132);
					match(T__24);
					setState(133);
					((StatementContext)_localctx).bl2 = block();
					 ((StatementContext)_localctx).statementsElse =  ((StatementContext)_localctx).bl2.ast; 
					}
					break;
				}
				 _localctx.ast.add(new If(((StatementContext)_localctx).exp.ast.getLine(), ((StatementContext)_localctx).exp.ast.getColumn(), ((StatementContext)_localctx).exp.ast, ((StatementContext)_localctx).bl1.ast, _localctx.statementsElse)); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(140);
				((StatementContext)_localctx).fu = function_invocation();
				setState(141);
				match(T__20);
				 _localctx.ast.add(((StatementContext)_localctx).fu.ast); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(144);
				match(T__25);
				setState(145);
				((StatementContext)_localctx).exp = expression(0);
				setState(146);
				match(T__20);
				 _localctx.ast.add(new Return(((StatementContext)_localctx).exp.ast.getLine(), ((StatementContext)_localctx).exp.ast.getColumn(), ((StatementContext)_localctx).exp.ast)); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(149);
				match(T__26);
				setState(150);
				((StatementContext)_localctx).exp1 = expression(0);
				 _localctx.ast.add(new Input(((StatementContext)_localctx).exp1.ast.getLine(), ((StatementContext)_localctx).exp1.ast.getColumn(), ((StatementContext)_localctx).exp1.ast)); 
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__27) {
					{
					{
					setState(152);
					match(T__27);
					setState(153);
					((StatementContext)_localctx).exp2 = expression(0);
					 _localctx.ast.add(new Input(((StatementContext)_localctx).exp2.ast.getLine(), ((StatementContext)_localctx).exp2.ast.getColumn(), ((StatementContext)_localctx).exp2.ast)); 
					}
					}
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(161);
				match(T__20);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(163);
				match(T__28);
				setState(164);
				((StatementContext)_localctx).exp1 = expression(0);
				 _localctx.ast.add(new Print(((StatementContext)_localctx).exp1.ast.getLine(), ((StatementContext)_localctx).exp1.ast.getColumn(), ((StatementContext)_localctx).exp1.ast)); 
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__27) {
					{
					{
					setState(166);
					match(T__27);
					setState(167);
					((StatementContext)_localctx).exp2 = expression(0);
					 _localctx.ast.add(new Print(((StatementContext)_localctx).exp2.ast.getLine(), ((StatementContext)_localctx).exp2.ast.getColumn(), ((StatementContext)_localctx).exp2.ast)); 
					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(175);
				match(T__20);
				}
				break;
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

	public static class BlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext st1;
		public StatementContext st2;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__2:
			case T__5:
			case T__6:
			case T__21:
			case T__23:
			case T__25:
			case T__26:
			case T__28:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case ID:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(179);
				((BlockContext)_localctx).st1 = statement();
				 _localctx.ast.addAll(((BlockContext)_localctx).st1.ast); 
				}
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				match(T__29);
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__6) | (1L << T__21) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__28) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << ID) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(183);
					((BlockContext)_localctx).st2 = statement();
					 _localctx.ast.addAll(((BlockContext)_localctx).st2.ast); 
					}
					}
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(191);
				match(T__30);
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

	public static class Function_invocationContext extends ParserRuleContext {
		public FunctionInvocation ast;
		public List<Expression> expressions = new ArrayList<Expression>();
		public Token id;
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Function_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterFunction_invocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitFunction_invocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitFunction_invocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_invocationContext function_invocation() throws RecognitionException {
		Function_invocationContext _localctx = new Function_invocationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			((Function_invocationContext)_localctx).id = match(ID);
			setState(195);
			match(T__0);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__6) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << ID) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				setState(196);
				((Function_invocationContext)_localctx).exp1 = expression(0);
				 _localctx.expressions.add(((Function_invocationContext)_localctx).exp1.ast); 
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__27) {
					{
					{
					setState(198);
					match(T__27);
					setState(199);
					((Function_invocationContext)_localctx).exp2 = expression(0);
					 _localctx.expressions.add(((Function_invocationContext)_localctx).exp2.ast); 
					}
					}
					setState(206);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(209);
			match(T__1);
			 ((Function_invocationContext)_localctx).ast =  new FunctionInvocation(((Function_invocationContext)_localctx).id.getLine(), ((Function_invocationContext)_localctx).id.getCharPositionInLine() + 1, new Variable(((Function_invocationContext)_localctx).id.getLine(), ((Function_invocationContext)_localctx).id.getCharPositionInLine() + 1 ,(((Function_invocationContext)_localctx).id!=null?((Function_invocationContext)_localctx).id.getText():null)), _localctx.expressions); 
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

	public static class Variable_definitionContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<VariableDefinition>();
		public Multiple_ids_definitionsContext identifiers;
		public TypeContext ty;
		public TypeContext type;
		public Multiple_ids_definitionsContext multiple_ids_definitions() {
			return getRuleContext(Multiple_ids_definitionsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Variable_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterVariable_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitVariable_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitVariable_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_definitionContext variable_definition() throws RecognitionException {
		Variable_definitionContext _localctx = new Variable_definitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variable_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(212);
			((Variable_definitionContext)_localctx).identifiers = multiple_ids_definitions();
			setState(213);
			match(T__22);
			setState(214);
			((Variable_definitionContext)_localctx).ty = ((Variable_definitionContext)_localctx).type = type();
			setState(215);
			match(T__20);
			 for (String identifier : ((Variable_definitionContext)_localctx).identifiers.ast) { _localctx.ast.add(new VariableDefinition((((Variable_definitionContext)_localctx).identifiers!=null?(((Variable_definitionContext)_localctx).identifiers.start):null).getLine(), (((Variable_definitionContext)_localctx).identifiers!=null?(((Variable_definitionContext)_localctx).identifiers.start):null).getCharPositionInLine(), identifier, ((Variable_definitionContext)_localctx).type.ast)); } 
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

	public static class Multiple_ids_definitionsContext extends ParserRuleContext {
		public List<String> ast = new ArrayList<String>();
		public Token id1;
		public Token id2;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public Multiple_ids_definitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_ids_definitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterMultiple_ids_definitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitMultiple_ids_definitions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitMultiple_ids_definitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_ids_definitionsContext multiple_ids_definitions() throws RecognitionException {
		Multiple_ids_definitionsContext _localctx = new Multiple_ids_definitionsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_multiple_ids_definitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			((Multiple_ids_definitionsContext)_localctx).id1 = match(ID);
			 _localctx.ast.add((((Multiple_ids_definitionsContext)_localctx).id1!=null?((Multiple_ids_definitionsContext)_localctx).id1.getText():null)); 
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__27) {
				{
				{
				setState(220);
				match(T__27);
				setState(221);
				((Multiple_ids_definitionsContext)_localctx).id2 = match(ID);

					   if (!_localctx.ast.contains((((Multiple_ids_definitionsContext)_localctx).id2!=null?((Multiple_ids_definitionsContext)_localctx).id2.getText():null))) {
					        _localctx.ast.add((((Multiple_ids_definitionsContext)_localctx).id2!=null?((Multiple_ids_definitionsContext)_localctx).id2.getText():null));
					   } else {
						    ErrorType et = new ErrorType(((Multiple_ids_definitionsContext)_localctx).id2.getLine(), ((Multiple_ids_definitionsContext)_localctx).id2.getCharPositionInLine() + 1, "ID with text " + (((Multiple_ids_definitionsContext)_localctx).id2!=null?((Multiple_ids_definitionsContext)_localctx).id2.getText():null) + " has already been defined.");
					   }
					   
				}
				}
				setState(227);
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

	public static class Function_definitionContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public List<VariableDefinition> parametersp = new ArrayList<VariableDefinition>();
		public Type return_typep = new VoidType();
		public List<VariableDefinition> variablesp = new ArrayList<VariableDefinition>();
		public List<Statement> statementsp = new ArrayList<Statement>();
		public Token id;
		public Token id1;
		public TypeContext typ1;
		public Token id2;
		public TypeContext typ2;
		public TypeContext return_type;
		public Variable_definitionContext var;
		public StatementContext st;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<Variable_definitionContext> variable_definition() {
			return getRuleContexts(Variable_definitionContext.class);
		}
		public Variable_definitionContext variable_definition(int i) {
			return getRuleContext(Variable_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterFunction_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitFunction_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitFunction_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_function_definition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(T__31);
			setState(229);
			((Function_definitionContext)_localctx).id = match(ID);
			setState(230);
			match(T__0);
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(231);
				((Function_definitionContext)_localctx).id1 = match(ID);
				setState(232);
				match(T__22);
				setState(233);
				((Function_definitionContext)_localctx).typ1 = type();
				 _localctx.parametersp.add(new VariableDefinition(((Function_definitionContext)_localctx).id1.getLine(), ((Function_definitionContext)_localctx).id1.getCharPositionInLine(), (((Function_definitionContext)_localctx).id1!=null?((Function_definitionContext)_localctx).id1.getText():null), ((Function_definitionContext)_localctx).typ1.ast)); 
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__27) {
					{
					{
					setState(235);
					match(T__27);
					setState(236);
					((Function_definitionContext)_localctx).id2 = match(ID);
					setState(237);
					match(T__22);
					setState(238);
					((Function_definitionContext)_localctx).typ2 = type();
					 _localctx.parametersp.add(new VariableDefinition(((Function_definitionContext)_localctx).id2.getLine(), ((Function_definitionContext)_localctx).id2.getCharPositionInLine(), (((Function_definitionContext)_localctx).id2!=null?((Function_definitionContext)_localctx).id2.getText():null), ((Function_definitionContext)_localctx).typ2.ast)); 
					}
					}
					setState(245);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(248);
			match(T__1);
			setState(249);
			match(T__22);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) {
				{
				setState(250);
				((Function_definitionContext)_localctx).return_type = type();
				((Function_definitionContext)_localctx).return_typep =  ((Function_definitionContext)_localctx).return_type.ast;
				}
			}

			setState(255);
			match(T__29);
			setState(261);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(256);
					((Function_definitionContext)_localctx).var = variable_definition();
					 _localctx.variablesp.addAll(((Function_definitionContext)_localctx).var.ast); 
					}
					} 
				}
				setState(263);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__6) | (1L << T__21) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__28) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << ID) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				{
				setState(264);
				((Function_definitionContext)_localctx).st = statement();
				 _localctx.statementsp.addAll(((Function_definitionContext)_localctx).st.ast); 
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(272);
			match(T__30);
			 ((Function_definitionContext)_localctx).ast =  new FunctionDefinition(((Function_definitionContext)_localctx).id.getLine(), ((Function_definitionContext)_localctx).id.getCharPositionInLine() + 1 ,(((Function_definitionContext)_localctx).id!=null?((Function_definitionContext)_localctx).id.getText():null), new FunctionType(_localctx.parametersp, _localctx.return_typep), _localctx.variablesp, _localctx.statementsp); 
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

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public Terminal_typesContext terminal;
		public Token struct_start;
		public Record_fieldContext record;
		public Token i_c;
		public TypeContext type;
		public Terminal_typesContext terminal_types() {
			return getRuleContext(Terminal_typesContext.class,0);
		}
		public Record_fieldContext record_field() {
			return getRuleContext(Record_fieldContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		try {
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				((TypeContext)_localctx).terminal = terminal_types();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).terminal.ast; 
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(278);
				((TypeContext)_localctx).struct_start = match(T__32);
				setState(279);
				match(T__29);
				setState(280);
				((TypeContext)_localctx).record = record_field();
				setState(281);
				match(T__30);
				}
				 ((TypeContext)_localctx).ast =  new StructType(((TypeContext)_localctx).struct_start.getLine(), ((TypeContext)_localctx).struct_start.getCharPositionInLine()+1, ((TypeContext)_localctx).record.ast); 
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(285);
				match(T__2);
				setState(286);
				((TypeContext)_localctx).i_c = match(INT_CONSTANT);
				setState(287);
				match(T__3);
				}
				setState(289);
				((TypeContext)_localctx).type = type();
				 ((TypeContext)_localctx).ast =  new ArrayType( ((TypeContext)_localctx).i_c.getLine(), ((TypeContext)_localctx).i_c.getCharPositionInLine() + 1, LexerHelper.lexemeToInt((((TypeContext)_localctx).i_c!=null?((TypeContext)_localctx).i_c.getText():null)), ((TypeContext)_localctx).type.ast); 
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

	public static class Terminal_typesContext extends ParserRuleContext {
		public Type ast;
		public Token int_type;
		public Token real_type;
		public Token char_type;
		public Terminal_typesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminal_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterTerminal_types(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitTerminal_types(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitTerminal_types(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Terminal_typesContext terminal_types() throws RecognitionException {
		Terminal_typesContext _localctx = new Terminal_typesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_terminal_types);
		try {
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				((Terminal_typesContext)_localctx).int_type = match(T__33);
				 ((Terminal_typesContext)_localctx).ast =  IntType.getTypeInt(); 
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
				((Terminal_typesContext)_localctx).real_type = match(T__34);
				 ((Terminal_typesContext)_localctx).ast =  RealType.getTypeReal(); 
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(298);
				((Terminal_typesContext)_localctx).char_type = match(T__35);
				 ((Terminal_typesContext)_localctx).ast =  CharType.getTypeChar(); 
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

	public static class Record_fieldContext extends ParserRuleContext {
		public List<RecordField> ast = new ArrayList<RecordField>();
		public RecordField rf = new RecordField();
		public Multiple_ids_definitionsContext identifiers;
		public Terminal_typesContext terminal;
		public List<Multiple_ids_definitionsContext> multiple_ids_definitions() {
			return getRuleContexts(Multiple_ids_definitionsContext.class);
		}
		public Multiple_ids_definitionsContext multiple_ids_definitions(int i) {
			return getRuleContext(Multiple_ids_definitionsContext.class,i);
		}
		public List<Terminal_typesContext> terminal_types() {
			return getRuleContexts(Terminal_typesContext.class);
		}
		public Terminal_typesContext terminal_types(int i) {
			return getRuleContext(Terminal_typesContext.class,i);
		}
		public Record_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_record_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterRecord_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitRecord_field(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitRecord_field(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Record_fieldContext record_field() throws RecognitionException {
		Record_fieldContext _localctx = new Record_fieldContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_record_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(302);
				((Record_fieldContext)_localctx).identifiers = multiple_ids_definitions();
				setState(303);
				match(T__22);
				setState(304);
				((Record_fieldContext)_localctx).terminal = terminal_types();
				setState(305);
				match(T__20);

				    for (String identifier : ((Record_fieldContext)_localctx).identifiers.ast) {
				        ((Record_fieldContext)_localctx).rf =  new RecordField((((Record_fieldContext)_localctx).identifiers!=null?(((Record_fieldContext)_localctx).identifiers.start):null).getLine(), (((Record_fieldContext)_localctx).identifiers!=null?(((Record_fieldContext)_localctx).identifiers.start):null).getCharPositionInLine(), identifier, ((Record_fieldContext)_localctx).terminal.ast);
				        boolean isInTheList = false;
				        for (RecordField aux : _localctx.ast) {
				        	if (aux.getName().equals(_localctx.rf.getName())) {
				        		isInTheList = true;
				        	}
				        }
				        if (isInTheList) {
				        	ErrorType et = new ErrorType(_localctx.rf.getLine(), _localctx.rf.getColumn(), "Record field with name " + _localctx.rf.getName() + " has already been defined in this struct.");
				        } else {
				        	_localctx.ast.add(_localctx.rf);
				        }
				    }
				    
				}
				}
				setState(312);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u013c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3,\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4R\n\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4r\n\4\f\4\16\4u\13\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u008b"+
		"\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\7\5\u009f\n\5\f\5\16\5\u00a2\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\7\5\u00ad\n\5\f\5\16\5\u00b0\13\5\3\5\3\5\5\5\u00b4\n\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\7\6\u00bd\n\6\f\6\16\6\u00c0\13\6\3\6\5\6\u00c3\n"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00cd\n\7\f\7\16\7\u00d0\13\7\5"+
		"\7\u00d2\n\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7"+
		"\t\u00e2\n\t\f\t\16\t\u00e5\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\7\n\u00f4\n\n\f\n\16\n\u00f7\13\n\5\n\u00f9\n\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u0100\n\n\3\n\3\n\3\n\3\n\7\n\u0106\n\n\f\n\16\n\u0109"+
		"\13\n\3\n\3\n\3\n\7\n\u010e\n\n\f\n\16\n\u0111\13\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u0127\n\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u012f\n\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\7\r\u0137\n\r\f\r\16\r\u013a\13\r\3\r\2\3\6\16\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\2\6\3\2\n\f\4\2\b\b\r\r\3\2\16\23\3\2\24\25\2"+
		"\u0158\2\37\3\2\2\2\4+\3\2\2\2\6Q\3\2\2\2\b\u00b3\3\2\2\2\n\u00c2\3\2"+
		"\2\2\f\u00c4\3\2\2\2\16\u00d6\3\2\2\2\20\u00dc\3\2\2\2\22\u00e6\3\2\2"+
		"\2\24\u0126\3\2\2\2\26\u012e\3\2\2\2\30\u0138\3\2\2\2\32\33\5\4\3\2\33"+
		"\34\b\2\1\2\34\36\3\2\2\2\35\32\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 "+
		"\3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"#\b\2\1\2#$\7\2\2\3$\3\3\2\2\2%&\5\22"+
		"\n\2&\'\b\3\1\2\',\3\2\2\2()\5\16\b\2)*\b\3\1\2*,\3\2\2\2+%\3\2\2\2+("+
		"\3\2\2\2,\5\3\2\2\2-.\b\4\1\2./\7(\2\2/R\b\4\1\2\60\61\7*\2\2\61R\b\4"+
		"\1\2\62\63\7,\2\2\63R\b\4\1\2\64\65\7+\2\2\65R\b\4\1\2\66\67\7\3\2\2\67"+
		"8\5\6\4\289\7\4\2\29:\b\4\1\2:R\3\2\2\2;<\7\5\2\2<=\5\6\4\2=>\7\6\2\2"+
		">?\b\4\1\2?R\3\2\2\2@A\7\3\2\2AB\5\24\13\2BC\7\4\2\2CD\5\6\4\nDE\b\4\1"+
		"\2ER\3\2\2\2FG\7\b\2\2GH\5\6\4\tHI\b\4\1\2IR\3\2\2\2JK\7\t\2\2KL\5\6\4"+
		"\bLM\b\4\1\2MR\3\2\2\2NO\5\f\7\2OP\b\4\1\2PR\3\2\2\2Q-\3\2\2\2Q\60\3\2"+
		"\2\2Q\62\3\2\2\2Q\64\3\2\2\2Q\66\3\2\2\2Q;\3\2\2\2Q@\3\2\2\2QF\3\2\2\2"+
		"QJ\3\2\2\2QN\3\2\2\2Rs\3\2\2\2ST\f\7\2\2TU\t\2\2\2UV\5\6\4\bVW\b\4\1\2"+
		"Wr\3\2\2\2XY\f\6\2\2YZ\t\3\2\2Z[\5\6\4\7[\\\b\4\1\2\\r\3\2\2\2]^\f\5\2"+
		"\2^_\t\4\2\2_`\5\6\4\6`a\b\4\1\2ar\3\2\2\2bc\f\4\2\2cd\t\5\2\2de\5\6\4"+
		"\5ef\b\4\1\2fr\3\2\2\2gh\f\f\2\2hi\7\5\2\2ij\5\6\4\2jk\7\6\2\2kl\b\4\1"+
		"\2lr\3\2\2\2mn\f\13\2\2no\7\7\2\2op\7+\2\2pr\b\4\1\2qS\3\2\2\2qX\3\2\2"+
		"\2q]\3\2\2\2qb\3\2\2\2qg\3\2\2\2qm\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2"+
		"\2t\7\3\2\2\2us\3\2\2\2vw\5\6\4\2wx\7\26\2\2xy\5\6\4\2yz\7\27\2\2z{\b"+
		"\5\1\2{\u00b4\3\2\2\2|}\7\30\2\2}~\5\6\4\2~\177\7\31\2\2\177\u0080\5\n"+
		"\6\2\u0080\u0081\b\5\1\2\u0081\u00b4\3\2\2\2\u0082\u0083\7\32\2\2\u0083"+
		"\u0084\5\6\4\2\u0084\u0085\7\31\2\2\u0085\u008a\5\n\6\2\u0086\u0087\7"+
		"\33\2\2\u0087\u0088\5\n\6\2\u0088\u0089\b\5\1\2\u0089\u008b\3\2\2\2\u008a"+
		"\u0086\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\b\5"+
		"\1\2\u008d\u00b4\3\2\2\2\u008e\u008f\5\f\7\2\u008f\u0090\7\27\2\2\u0090"+
		"\u0091\b\5\1\2\u0091\u00b4\3\2\2\2\u0092\u0093\7\34\2\2\u0093\u0094\5"+
		"\6\4\2\u0094\u0095\7\27\2\2\u0095\u0096\b\5\1\2\u0096\u00b4\3\2\2\2\u0097"+
		"\u0098\7\35\2\2\u0098\u0099\5\6\4\2\u0099\u00a0\b\5\1\2\u009a\u009b\7"+
		"\36\2\2\u009b\u009c\5\6\4\2\u009c\u009d\b\5\1\2\u009d\u009f\3\2\2\2\u009e"+
		"\u009a\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\7\27\2\2\u00a4"+
		"\u00b4\3\2\2\2\u00a5\u00a6\7\37\2\2\u00a6\u00a7\5\6\4\2\u00a7\u00ae\b"+
		"\5\1\2\u00a8\u00a9\7\36\2\2\u00a9\u00aa\5\6\4\2\u00aa\u00ab\b\5\1\2\u00ab"+
		"\u00ad\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2"+
		"\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1"+
		"\u00b2\7\27\2\2\u00b2\u00b4\3\2\2\2\u00b3v\3\2\2\2\u00b3|\3\2\2\2\u00b3"+
		"\u0082\3\2\2\2\u00b3\u008e\3\2\2\2\u00b3\u0092\3\2\2\2\u00b3\u0097\3\2"+
		"\2\2\u00b3\u00a5\3\2\2\2\u00b4\t\3\2\2\2\u00b5\u00b6\5\b\5\2\u00b6\u00b7"+
		"\b\6\1\2\u00b7\u00c3\3\2\2\2\u00b8\u00be\7 \2\2\u00b9\u00ba\5\b\5\2\u00ba"+
		"\u00bb\b\6\1\2\u00bb\u00bd\3\2\2\2\u00bc\u00b9\3\2\2\2\u00bd\u00c0\3\2"+
		"\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c1\u00c3\7!\2\2\u00c2\u00b5\3\2\2\2\u00c2\u00b8\3\2"+
		"\2\2\u00c3\13\3\2\2\2\u00c4\u00c5\7+\2\2\u00c5\u00d1\7\3\2\2\u00c6\u00c7"+
		"\5\6\4\2\u00c7\u00ce\b\7\1\2\u00c8\u00c9\7\36\2\2\u00c9\u00ca\5\6\4\2"+
		"\u00ca\u00cb\b\7\1\2\u00cb\u00cd\3\2\2\2\u00cc\u00c8\3\2\2\2\u00cd\u00d0"+
		"\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d1\u00c6\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2"+
		"\2\2\u00d3\u00d4\7\4\2\2\u00d4\u00d5\b\7\1\2\u00d5\r\3\2\2\2\u00d6\u00d7"+
		"\5\20\t\2\u00d7\u00d8\7\31\2\2\u00d8\u00d9\5\24\13\2\u00d9\u00da\7\27"+
		"\2\2\u00da\u00db\b\b\1\2\u00db\17\3\2\2\2\u00dc\u00dd\7+\2\2\u00dd\u00e3"+
		"\b\t\1\2\u00de\u00df\7\36\2\2\u00df\u00e0\7+\2\2\u00e0\u00e2\b\t\1\2\u00e1"+
		"\u00de\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2"+
		"\2\2\u00e4\21\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e7\7\"\2\2\u00e7\u00e8"+
		"\7+\2\2\u00e8\u00f8\7\3\2\2\u00e9\u00ea\7+\2\2\u00ea\u00eb\7\31\2\2\u00eb"+
		"\u00ec\5\24\13\2\u00ec\u00f5\b\n\1\2\u00ed\u00ee\7\36\2\2\u00ee\u00ef"+
		"\7+\2\2\u00ef\u00f0\7\31\2\2\u00f0\u00f1\5\24\13\2\u00f1\u00f2\b\n\1\2"+
		"\u00f2\u00f4\3\2\2\2\u00f3\u00ed\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3"+
		"\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8"+
		"\u00e9\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\7\4"+
		"\2\2\u00fb\u00ff\7\31\2\2\u00fc\u00fd\5\24\13\2\u00fd\u00fe\b\n\1\2\u00fe"+
		"\u0100\3\2\2\2\u00ff\u00fc\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\3\2"+
		"\2\2\u0101\u0107\7 \2\2\u0102\u0103\5\16\b\2\u0103\u0104\b\n\1\2\u0104"+
		"\u0106\3\2\2\2\u0105\u0102\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2"+
		"\2\2\u0107\u0108\3\2\2\2\u0108\u010f\3\2\2\2\u0109\u0107\3\2\2\2\u010a"+
		"\u010b\5\b\5\2\u010b\u010c\b\n\1\2\u010c\u010e\3\2\2\2\u010d\u010a\3\2"+
		"\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\7!\2\2\u0113\u0114\b\n"+
		"\1\2\u0114\23\3\2\2\2\u0115\u0116\5\26\f\2\u0116\u0117\b\13\1\2\u0117"+
		"\u0127\3\2\2\2\u0118\u0119\7#\2\2\u0119\u011a\7 \2\2\u011a\u011b\5\30"+
		"\r\2\u011b\u011c\7!\2\2\u011c\u011d\3\2\2\2\u011d\u011e\b\13\1\2\u011e"+
		"\u0127\3\2\2\2\u011f\u0120\7\5\2\2\u0120\u0121\7(\2\2\u0121\u0122\7\6"+
		"\2\2\u0122\u0123\3\2\2\2\u0123\u0124\5\24\13\2\u0124\u0125\b\13\1\2\u0125"+
		"\u0127\3\2\2\2\u0126\u0115\3\2\2\2\u0126\u0118\3\2\2\2\u0126\u011f\3\2"+
		"\2\2\u0127\25\3\2\2\2\u0128\u0129\7$\2\2\u0129\u012f\b\f\1\2\u012a\u012b"+
		"\7%\2\2\u012b\u012f\b\f\1\2\u012c\u012d\7&\2\2\u012d\u012f\b\f\1\2\u012e"+
		"\u0128\3\2\2\2\u012e\u012a\3\2\2\2\u012e\u012c\3\2\2\2\u012f\27\3\2\2"+
		"\2\u0130\u0131\5\20\t\2\u0131\u0132\7\31\2\2\u0132\u0133\5\26\f\2\u0133"+
		"\u0134\7\27\2\2\u0134\u0135\b\r\1\2\u0135\u0137\3\2\2\2\u0136\u0130\3"+
		"\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\31\3\2\2\2\u013a\u0138\3\2\2\2\30\37+Qqs\u008a\u00a0\u00ae\u00b3\u00be"+
		"\u00c2\u00ce\u00d1\u00e3\u00f5\u00f8\u00ff\u0107\u010f\u0126\u012e\u0138";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}