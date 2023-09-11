// Generated from C:\Users\fry\processing4\java/src/processing/mode/java/preproc/Processing.g4 by ANTLR 4.7.2
package processing.mode.java.preproc;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ProcessingParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, HexColorLiteral=2, WS=3, COMMENT=4, LINE_COMMENT=5, CHAR_LITERAL=6, 
		ABSTRACT=7, ASSERT=8, BOOLEAN=9, BREAK=10, BYTE=11, CASE=12, CATCH=13, 
		CHAR=14, CLASS=15, CONST=16, CONTINUE=17, DEFAULT=18, DO=19, DOUBLE=20, 
		ELSE=21, ENUM=22, EXTENDS=23, FINAL=24, FINALLY=25, FLOAT=26, FOR=27, 
		IF=28, GOTO=29, IMPLEMENTS=30, IMPORT=31, INSTANCEOF=32, INT=33, INTERFACE=34, 
		LONG=35, NATIVE=36, NEW=37, PACKAGE=38, PRIVATE=39, PROTECTED=40, PUBLIC=41, 
		RETURN=42, SHORT=43, STATIC=44, STRICTFP=45, SUPER=46, SWITCH=47, SYNCHRONIZED=48, 
		THIS=49, THROW=50, THROWS=51, TRANSIENT=52, TRY=53, VAR=54, VOID=55, VOLATILE=56, 
		WHILE=57, DECIMAL_LITERAL=58, HEX_LITERAL=59, OCT_LITERAL=60, BINARY_LITERAL=61, 
		FLOAT_LITERAL=62, HEX_FLOAT_LITERAL=63, BOOL_LITERAL=64, STRING_LITERAL=65, 
		NULL_LITERAL=66, LPAREN=67, RPAREN=68, LBRACE=69, RBRACE=70, LBRACK=71, 
		RBRACK=72, SEMI=73, COMMA=74, DOT=75, ASSIGN=76, GT=77, LT=78, BANG=79, 
		TILDE=80, QUESTION=81, COLON=82, EQUAL=83, LE=84, GE=85, NOTEQUAL=86, 
		AND=87, OR=88, INC=89, DEC=90, ADD=91, SUB=92, MUL=93, DIV=94, BITAND=95, 
		BITOR=96, CARET=97, MOD=98, ADD_ASSIGN=99, SUB_ASSIGN=100, MUL_ASSIGN=101, 
		DIV_ASSIGN=102, AND_ASSIGN=103, OR_ASSIGN=104, XOR_ASSIGN=105, MOD_ASSIGN=106, 
		LSHIFT_ASSIGN=107, RSHIFT_ASSIGN=108, URSHIFT_ASSIGN=109, ARROW=110, COLONCOLON=111, 
		AT=112, ELLIPSIS=113, IDENTIFIER=114;
	public static final int
		RULE_processingSketch = 0, RULE_javaProcessingSketch = 1, RULE_staticProcessingSketch = 2, 
		RULE_activeProcessingSketch = 3, RULE_variableDeclaratorId = 4, RULE_warnTypeAsVariableName = 5, 
		RULE_methodCall = 6, RULE_functionWithPrimitiveTypeName = 7, RULE_primitiveType = 8, 
		RULE_colorPrimitiveType = 9, RULE_qualifiedName = 10, RULE_literal = 11, 
		RULE_hexColorLiteral = 12, RULE_compilationUnit = 13, RULE_packageDeclaration = 14, 
		RULE_importDeclaration = 15, RULE_typeDeclaration = 16, RULE_modifier = 17, 
		RULE_classOrInterfaceModifier = 18, RULE_variableModifier = 19, RULE_classDeclaration = 20, 
		RULE_typeParameters = 21, RULE_typeParameter = 22, RULE_typeBound = 23, 
		RULE_enumDeclaration = 24, RULE_enumConstants = 25, RULE_enumConstant = 26, 
		RULE_enumBodyDeclarations = 27, RULE_interfaceDeclaration = 28, RULE_classBody = 29, 
		RULE_interfaceBody = 30, RULE_classBodyDeclaration = 31, RULE_memberDeclaration = 32, 
		RULE_methodDeclaration = 33, RULE_methodBody = 34, RULE_typeTypeOrVoid = 35, 
		RULE_genericMethodDeclaration = 36, RULE_genericConstructorDeclaration = 37, 
		RULE_constructorDeclaration = 38, RULE_fieldDeclaration = 39, RULE_interfaceBodyDeclaration = 40, 
		RULE_interfaceMemberDeclaration = 41, RULE_constDeclaration = 42, RULE_constantDeclarator = 43, 
		RULE_interfaceMethodDeclaration = 44, RULE_interfaceMethodModifier = 45, 
		RULE_genericInterfaceMethodDeclaration = 46, RULE_variableDeclarators = 47, 
		RULE_variableDeclarator = 48, RULE_variableInitializer = 49, RULE_arrayInitializer = 50, 
		RULE_classOrInterfaceType = 51, RULE_typeArgument = 52, RULE_qualifiedNameList = 53, 
		RULE_formalParameters = 54, RULE_formalParameterList = 55, RULE_formalParameter = 56, 
		RULE_lastFormalParameter = 57, RULE_integerLiteral = 58, RULE_floatLiteral = 59, 
		RULE_annotation = 60, RULE_elementValuePairs = 61, RULE_elementValuePair = 62, 
		RULE_elementValue = 63, RULE_elementValueArrayInitializer = 64, RULE_annotationTypeDeclaration = 65, 
		RULE_annotationTypeBody = 66, RULE_annotationTypeElementDeclaration = 67, 
		RULE_annotationTypeElementRest = 68, RULE_annotationMethodOrConstantRest = 69, 
		RULE_annotationMethodRest = 70, RULE_annotationConstantRest = 71, RULE_defaultValue = 72, 
		RULE_block = 73, RULE_blockStatement = 74, RULE_localVariableDeclaration = 75, 
		RULE_localTypeDeclaration = 76, RULE_statement = 77, RULE_catchClause = 78, 
		RULE_catchType = 79, RULE_finallyBlock = 80, RULE_resourceSpecification = 81, 
		RULE_resources = 82, RULE_resource = 83, RULE_switchBlockStatementGroup = 84, 
		RULE_switchLabel = 85, RULE_forControl = 86, RULE_forInit = 87, RULE_enhancedForControl = 88, 
		RULE_parExpression = 89, RULE_expressionList = 90, RULE_expression = 91, 
		RULE_lambdaExpression = 92, RULE_lambdaParameters = 93, RULE_lambdaBody = 94, 
		RULE_primary = 95, RULE_classType = 96, RULE_creator = 97, RULE_createdName = 98, 
		RULE_innerCreator = 99, RULE_arrayCreatorRest = 100, RULE_classCreatorRest = 101, 
		RULE_explicitGenericInvocation = 102, RULE_typeArgumentsOrDiamond = 103, 
		RULE_nonWildcardTypeArgumentsOrDiamond = 104, RULE_nonWildcardTypeArguments = 105, 
		RULE_typeList = 106, RULE_typeType = 107, RULE_typeArguments = 108, RULE_superSuffix = 109, 
		RULE_explicitGenericInvocationSuffix = 110, RULE_arguments = 111;
	private static String[] makeRuleNames() {
		return new String[] {
			"processingSketch", "javaProcessingSketch", "staticProcessingSketch", 
			"activeProcessingSketch", "variableDeclaratorId", "warnTypeAsVariableName", 
			"methodCall", "functionWithPrimitiveTypeName", "primitiveType", "colorPrimitiveType", 
			"qualifiedName", "literal", "hexColorLiteral", "compilationUnit", "packageDeclaration", 
			"importDeclaration", "typeDeclaration", "modifier", "classOrInterfaceModifier", 
			"variableModifier", "classDeclaration", "typeParameters", "typeParameter", 
			"typeBound", "enumDeclaration", "enumConstants", "enumConstant", "enumBodyDeclarations", 
			"interfaceDeclaration", "classBody", "interfaceBody", "classBodyDeclaration", 
			"memberDeclaration", "methodDeclaration", "methodBody", "typeTypeOrVoid", 
			"genericMethodDeclaration", "genericConstructorDeclaration", "constructorDeclaration", 
			"fieldDeclaration", "interfaceBodyDeclaration", "interfaceMemberDeclaration", 
			"constDeclaration", "constantDeclarator", "interfaceMethodDeclaration", 
			"interfaceMethodModifier", "genericInterfaceMethodDeclaration", "variableDeclarators", 
			"variableDeclarator", "variableInitializer", "arrayInitializer", "classOrInterfaceType", 
			"typeArgument", "qualifiedNameList", "formalParameters", "formalParameterList", 
			"formalParameter", "lastFormalParameter", "integerLiteral", "floatLiteral", 
			"annotation", "elementValuePairs", "elementValuePair", "elementValue", 
			"elementValueArrayInitializer", "annotationTypeDeclaration", "annotationTypeBody", 
			"annotationTypeElementDeclaration", "annotationTypeElementRest", "annotationMethodOrConstantRest", 
			"annotationMethodRest", "annotationConstantRest", "defaultValue", "block", 
			"blockStatement", "localVariableDeclaration", "localTypeDeclaration", 
			"statement", "catchClause", "catchType", "finallyBlock", "resourceSpecification", 
			"resources", "resource", "switchBlockStatementGroup", "switchLabel", 
			"forControl", "forInit", "enhancedForControl", "parExpression", "expressionList", 
			"expression", "lambdaExpression", "lambdaParameters", "lambdaBody", "primary", 
			"classType", "creator", "createdName", "innerCreator", "arrayCreatorRest", 
			"classCreatorRest", "explicitGenericInvocation", "typeArgumentsOrDiamond", 
			"nonWildcardTypeArgumentsOrDiamond", "nonWildcardTypeArguments", "typeList", 
			"typeType", "typeArguments", "superSuffix", "explicitGenericInvocationSuffix", 
			"arguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'color'", null, null, null, null, null, "'abstract'", "'assert'", 
			"'boolean'", "'break'", "'byte'", "'case'", "'catch'", "'char'", "'class'", 
			"'const'", "'continue'", "'default'", "'do'", "'double'", "'else'", "'enum'", 
			"'extends'", "'final'", "'finally'", "'float'", "'for'", "'if'", "'goto'", 
			"'implements'", "'import'", "'instanceof'", "'int'", "'interface'", "'long'", 
			"'native'", "'new'", "'package'", "'private'", "'protected'", "'public'", 
			"'return'", "'short'", "'static'", "'strictfp'", "'super'", "'switch'", 
			"'synchronized'", "'this'", "'throw'", "'throws'", "'transient'", "'try'", 
			"'var'", "'void'", "'volatile'", "'while'", null, null, null, null, null, 
			null, null, null, "'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", 
			"';'", "','", "'.'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", 
			"'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", 
			"'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", "'+='", "'-='", "'*='", 
			"'/='", "'&='", "'|='", "'^='", "'%='", "'<<='", "'>>='", "'>>>='", "'->'", 
			"'::'", "'@'", "'...'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "HexColorLiteral", "WS", "COMMENT", "LINE_COMMENT", "CHAR_LITERAL", 
			"ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", "CHAR", 
			"CLASS", "CONST", "CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM", 
			"EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "GOTO", "IMPLEMENTS", 
			"IMPORT", "INSTANCEOF", "INT", "INTERFACE", "LONG", "NATIVE", "NEW", 
			"PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", "STATIC", 
			"STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", "THROWS", 
			"TRANSIENT", "TRY", "VAR", "VOID", "VOLATILE", "WHILE", "DECIMAL_LITERAL", 
			"HEX_LITERAL", "OCT_LITERAL", "BINARY_LITERAL", "FLOAT_LITERAL", "HEX_FLOAT_LITERAL", 
			"BOOL_LITERAL", "STRING_LITERAL", "NULL_LITERAL", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", 
			"GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", "LE", "GE", 
			"NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", 
			"BITOR", "CARET", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
			"AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", "LSHIFT_ASSIGN", 
			"RSHIFT_ASSIGN", "URSHIFT_ASSIGN", "ARROW", "COLONCOLON", "AT", "ELLIPSIS", 
			"IDENTIFIER"
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
	public String getGrammarFileName() { return "Processing.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ProcessingParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProcessingSketchContext extends ParserRuleContext {
		public JavaProcessingSketchContext javaProcessingSketch() {
			return getRuleContext(JavaProcessingSketchContext.class,0);
		}
		public StaticProcessingSketchContext staticProcessingSketch() {
			return getRuleContext(StaticProcessingSketchContext.class,0);
		}
		public ActiveProcessingSketchContext activeProcessingSketch() {
			return getRuleContext(ActiveProcessingSketchContext.class,0);
		}
		public ProcessingSketchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_processingSketch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterProcessingSketch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitProcessingSketch(this);
		}
	}

	public final ProcessingSketchContext processingSketch() throws RecognitionException {
		ProcessingSketchContext _localctx = new ProcessingSketchContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_processingSketch);
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				javaProcessingSketch();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				staticProcessingSketch();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
				activeProcessingSketch();
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

	public static class JavaProcessingSketchContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ProcessingParser.EOF, 0); }
		public PackageDeclarationContext packageDeclaration() {
			return getRuleContext(PackageDeclarationContext.class,0);
		}
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public JavaProcessingSketchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_javaProcessingSketch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterJavaProcessingSketch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitJavaProcessingSketch(this);
		}
	}

	public final JavaProcessingSketchContext javaProcessingSketch() throws RecognitionException {
		JavaProcessingSketchContext _localctx = new JavaProcessingSketchContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_javaProcessingSketch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(229);
				packageDeclaration();
				}
				break;
			}
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(232);
				importDeclaration();
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(239); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(238);
				typeDeclaration();
				}
				}
				setState(241); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << CLASS) | (1L << ENUM) | (1L << FINAL) | (1L << INTERFACE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==SEMI || _la==AT );
			setState(243);
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

	public static class StaticProcessingSketchContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ProcessingParser.EOF, 0); }
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public StaticProcessingSketchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticProcessingSketch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterStaticProcessingSketch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitStaticProcessingSketch(this);
		}
	}

	public final StaticProcessingSketchContext staticProcessingSketch() throws RecognitionException {
		StaticProcessingSketchContext _localctx = new StaticProcessingSketchContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_staticProcessingSketch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << HexColorLiteral) | (1L << CHAR_LITERAL) | (1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << IMPORT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SUPER) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VAR) | (1L << VOID) | (1L << WHILE) | (1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << OCT_LITERAL) | (1L << BINARY_LITERAL) | (1L << FLOAT_LITERAL) | (1L << HEX_FLOAT_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BOOL_LITERAL - 64)) | (1L << (STRING_LITERAL - 64)) | (1L << (NULL_LITERAL - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (AT - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
				{
				setState(247);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IMPORT:
					{
					setState(245);
					importDeclaration();
					}
					break;
				case T__0:
				case HexColorLiteral:
				case CHAR_LITERAL:
				case ABSTRACT:
				case ASSERT:
				case BOOLEAN:
				case BREAK:
				case BYTE:
				case CHAR:
				case CLASS:
				case CONTINUE:
				case DO:
				case DOUBLE:
				case FINAL:
				case FLOAT:
				case FOR:
				case IF:
				case INT:
				case INTERFACE:
				case LONG:
				case NEW:
				case PRIVATE:
				case PROTECTED:
				case PUBLIC:
				case RETURN:
				case SHORT:
				case STATIC:
				case STRICTFP:
				case SUPER:
				case SWITCH:
				case SYNCHRONIZED:
				case THIS:
				case THROW:
				case TRY:
				case VAR:
				case VOID:
				case WHILE:
				case DECIMAL_LITERAL:
				case HEX_LITERAL:
				case OCT_LITERAL:
				case BINARY_LITERAL:
				case FLOAT_LITERAL:
				case HEX_FLOAT_LITERAL:
				case BOOL_LITERAL:
				case STRING_LITERAL:
				case NULL_LITERAL:
				case LPAREN:
				case LBRACE:
				case SEMI:
				case LT:
				case BANG:
				case TILDE:
				case INC:
				case DEC:
				case ADD:
				case SUB:
				case AT:
				case IDENTIFIER:
					{
					setState(246);
					blockStatement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(252);
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

	public static class ActiveProcessingSketchContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ProcessingParser.EOF, 0); }
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ActiveProcessingSketchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_activeProcessingSketch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterActiveProcessingSketch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitActiveProcessingSketch(this);
		}
	}

	public final ActiveProcessingSketchContext activeProcessingSketch() throws RecognitionException {
		ActiveProcessingSketchContext _localctx = new ActiveProcessingSketchContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_activeProcessingSketch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << IMPORT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VAR) | (1L << VOID) | (1L << VOLATILE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (LBRACE - 69)) | (1L << (SEMI - 69)) | (1L << (LT - 69)) | (1L << (AT - 69)) | (1L << (IDENTIFIER - 69)))) != 0)) {
				{
				setState(256);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(254);
					importDeclaration();
					}
					break;
				case 2:
					{
					setState(255);
					classBodyDeclaration();
					}
					break;
				}
				}
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(261);
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

	public static class VariableDeclaratorIdContext extends ParserRuleContext {
		public WarnTypeAsVariableNameContext warnTypeAsVariableName() {
			return getRuleContext(WarnTypeAsVariableNameContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public List<TerminalNode> LBRACK() { return getTokens(ProcessingParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(ProcessingParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(ProcessingParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(ProcessingParser.RBRACK, i);
		}
		public VariableDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterVariableDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitVariableDeclaratorId(this);
		}
	}

	public final VariableDeclaratorIdContext variableDeclaratorId() throws RecognitionException {
		VariableDeclaratorIdContext _localctx = new VariableDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableDeclaratorId);
		int _la;
		try {
			setState(272);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				warnTypeAsVariableName();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				match(IDENTIFIER);
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(265);
					match(LBRACK);
					setState(266);
					match(RBRACK);
					}
					}
					setState(271);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class WarnTypeAsVariableNameContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType;
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(ProcessingParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(ProcessingParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(ProcessingParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(ProcessingParser.RBRACK, i);
		}
		public WarnTypeAsVariableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_warnTypeAsVariableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterWarnTypeAsVariableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitWarnTypeAsVariableName(this);
		}
	}

	public final WarnTypeAsVariableNameContext warnTypeAsVariableName() throws RecognitionException {
		WarnTypeAsVariableNameContext _localctx = new WarnTypeAsVariableNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_warnTypeAsVariableName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			((WarnTypeAsVariableNameContext)_localctx).primitiveType = primitiveType();
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(275);
				match(LBRACK);
				setState(276);
				match(RBRACK);
				}
				}
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			            notifyErrorListeners("Type names are not allowed as variable names: "+(((WarnTypeAsVariableNameContext)_localctx).primitiveType!=null?_input.getText(((WarnTypeAsVariableNameContext)_localctx).primitiveType.start,((WarnTypeAsVariableNameContext)_localctx).primitiveType.stop):null));
			        
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

	public static class MethodCallContext extends ParserRuleContext {
		public FunctionWithPrimitiveTypeNameContext functionWithPrimitiveTypeName() {
			return getRuleContext(FunctionWithPrimitiveTypeNameContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(ProcessingParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ProcessingParser.RPAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode THIS() { return getToken(ProcessingParser.THIS, 0); }
		public TerminalNode SUPER() { return getToken(ProcessingParser.SUPER, 0); }
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitMethodCall(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodCall);
		int _la;
		try {
			setState(303);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case FLOAT:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				functionWithPrimitiveTypeName();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				match(IDENTIFIER);
				setState(286);
				match(LPAREN);
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << HexColorLiteral) | (1L << CHAR_LITERAL) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VAR) | (1L << VOID) | (1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << OCT_LITERAL) | (1L << BINARY_LITERAL) | (1L << FLOAT_LITERAL) | (1L << HEX_FLOAT_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BOOL_LITERAL - 64)) | (1L << (STRING_LITERAL - 64)) | (1L << (NULL_LITERAL - 64)) | (1L << (LPAREN - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (AT - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
					{
					setState(287);
					expressionList();
					}
				}

				setState(290);
				match(RPAREN);
				}
				break;
			case THIS:
				enterOuterAlt(_localctx, 3);
				{
				setState(291);
				match(THIS);
				setState(292);
				match(LPAREN);
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << HexColorLiteral) | (1L << CHAR_LITERAL) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VAR) | (1L << VOID) | (1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << OCT_LITERAL) | (1L << BINARY_LITERAL) | (1L << FLOAT_LITERAL) | (1L << HEX_FLOAT_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BOOL_LITERAL - 64)) | (1L << (STRING_LITERAL - 64)) | (1L << (NULL_LITERAL - 64)) | (1L << (LPAREN - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (AT - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
					{
					setState(293);
					expressionList();
					}
				}

				setState(296);
				match(RPAREN);
				}
				break;
			case SUPER:
				enterOuterAlt(_localctx, 4);
				{
				setState(297);
				match(SUPER);
				setState(298);
				match(LPAREN);
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << HexColorLiteral) | (1L << CHAR_LITERAL) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VAR) | (1L << VOID) | (1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << OCT_LITERAL) | (1L << BINARY_LITERAL) | (1L << FLOAT_LITERAL) | (1L << HEX_FLOAT_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BOOL_LITERAL - 64)) | (1L << (STRING_LITERAL - 64)) | (1L << (NULL_LITERAL - 64)) | (1L << (LPAREN - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (AT - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
					{
					setState(299);
					expressionList();
					}
				}

				setState(302);
				match(RPAREN);
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

	public static class FunctionWithPrimitiveTypeNameContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ProcessingParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ProcessingParser.RPAREN, 0); }
		public TerminalNode BOOLEAN() { return getToken(ProcessingParser.BOOLEAN, 0); }
		public TerminalNode BYTE() { return getToken(ProcessingParser.BYTE, 0); }
		public TerminalNode CHAR() { return getToken(ProcessingParser.CHAR, 0); }
		public TerminalNode FLOAT() { return getToken(ProcessingParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(ProcessingParser.INT, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public FunctionWithPrimitiveTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionWithPrimitiveTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterFunctionWithPrimitiveTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitFunctionWithPrimitiveTypeName(this);
		}
	}

	public final FunctionWithPrimitiveTypeNameContext functionWithPrimitiveTypeName() throws RecognitionException {
		FunctionWithPrimitiveTypeNameContext _localctx = new FunctionWithPrimitiveTypeNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionWithPrimitiveTypeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << FLOAT) | (1L << INT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(306);
			match(LPAREN);
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << HexColorLiteral) | (1L << CHAR_LITERAL) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VAR) | (1L << VOID) | (1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << OCT_LITERAL) | (1L << BINARY_LITERAL) | (1L << FLOAT_LITERAL) | (1L << HEX_FLOAT_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BOOL_LITERAL - 64)) | (1L << (STRING_LITERAL - 64)) | (1L << (NULL_LITERAL - 64)) | (1L << (LPAREN - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (AT - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
				{
				setState(307);
				expressionList();
				}
			}

			setState(310);
			match(RPAREN);
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(ProcessingParser.BOOLEAN, 0); }
		public TerminalNode CHAR() { return getToken(ProcessingParser.CHAR, 0); }
		public TerminalNode BYTE() { return getToken(ProcessingParser.BYTE, 0); }
		public TerminalNode SHORT() { return getToken(ProcessingParser.SHORT, 0); }
		public TerminalNode INT() { return getToken(ProcessingParser.INT, 0); }
		public TerminalNode LONG() { return getToken(ProcessingParser.LONG, 0); }
		public TerminalNode FLOAT() { return getToken(ProcessingParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(ProcessingParser.DOUBLE, 0); }
		public ColorPrimitiveTypeContext colorPrimitiveType() {
			return getRuleContext(ColorPrimitiveTypeContext.class,0);
		}
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitPrimitiveType(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_primitiveType);
		try {
			setState(321);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				match(BOOLEAN);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
				match(CHAR);
				}
				break;
			case BYTE:
				enterOuterAlt(_localctx, 3);
				{
				setState(314);
				match(BYTE);
				}
				break;
			case SHORT:
				enterOuterAlt(_localctx, 4);
				{
				setState(315);
				match(SHORT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 5);
				{
				setState(316);
				match(INT);
				}
				break;
			case LONG:
				enterOuterAlt(_localctx, 6);
				{
				setState(317);
				match(LONG);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 7);
				{
				setState(318);
				match(FLOAT);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 8);
				{
				setState(319);
				match(DOUBLE);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 9);
				{
				setState(320);
				colorPrimitiveType();
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

	public static class ColorPrimitiveTypeContext extends ParserRuleContext {
		public ColorPrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colorPrimitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterColorPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitColorPrimitiveType(this);
		}
	}

	public final ColorPrimitiveTypeContext colorPrimitiveType() throws RecognitionException {
		ColorPrimitiveTypeContext _localctx = new ColorPrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_colorPrimitiveType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(T__0);
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

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(ProcessingParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ProcessingParser.IDENTIFIER, i);
		}
		public List<ColorPrimitiveTypeContext> colorPrimitiveType() {
			return getRuleContexts(ColorPrimitiveTypeContext.class);
		}
		public ColorPrimitiveTypeContext colorPrimitiveType(int i) {
			return getRuleContext(ColorPrimitiveTypeContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(ProcessingParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ProcessingParser.DOT, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitQualifiedName(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(325);
				match(IDENTIFIER);
				}
				break;
			case T__0:
				{
				setState(326);
				colorPrimitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(336);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(329);
					match(DOT);
					setState(332);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case IDENTIFIER:
						{
						setState(330);
						match(IDENTIFIER);
						}
						break;
					case T__0:
						{
						setState(331);
						colorPrimitiveType();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(338);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class LiteralContext extends ParserRuleContext {
		public IntegerLiteralContext integerLiteral() {
			return getRuleContext(IntegerLiteralContext.class,0);
		}
		public FloatLiteralContext floatLiteral() {
			return getRuleContext(FloatLiteralContext.class,0);
		}
		public TerminalNode CHAR_LITERAL() { return getToken(ProcessingParser.CHAR_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(ProcessingParser.STRING_LITERAL, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(ProcessingParser.BOOL_LITERAL, 0); }
		public TerminalNode NULL_LITERAL() { return getToken(ProcessingParser.NULL_LITERAL, 0); }
		public HexColorLiteralContext hexColorLiteral() {
			return getRuleContext(HexColorLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_literal);
		try {
			setState(346);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_LITERAL:
			case HEX_LITERAL:
			case OCT_LITERAL:
			case BINARY_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				integerLiteral();
				}
				break;
			case FLOAT_LITERAL:
			case HEX_FLOAT_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(340);
				floatLiteral();
				}
				break;
			case CHAR_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(341);
				match(CHAR_LITERAL);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(342);
				match(STRING_LITERAL);
				}
				break;
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(343);
				match(BOOL_LITERAL);
				}
				break;
			case NULL_LITERAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(344);
				match(NULL_LITERAL);
				}
				break;
			case HexColorLiteral:
				enterOuterAlt(_localctx, 7);
				{
				setState(345);
				hexColorLiteral();
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

	public static class HexColorLiteralContext extends ParserRuleContext {
		public TerminalNode HexColorLiteral() { return getToken(ProcessingParser.HexColorLiteral, 0); }
		public HexColorLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hexColorLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterHexColorLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitHexColorLiteral(this);
		}
	}

	public final HexColorLiteralContext hexColorLiteral() throws RecognitionException {
		HexColorLiteralContext _localctx = new HexColorLiteralContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_hexColorLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(HexColorLiteral);
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

	public static class CompilationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ProcessingParser.EOF, 0); }
		public PackageDeclarationContext packageDeclaration() {
			return getRuleContext(PackageDeclarationContext.class,0);
		}
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitCompilationUnit(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(350);
				packageDeclaration();
				}
				break;
			}
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(353);
				importDeclaration();
				}
				}
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << CLASS) | (1L << ENUM) | (1L << FINAL) | (1L << INTERFACE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==SEMI || _la==AT) {
				{
				{
				setState(359);
				typeDeclaration();
				}
				}
				setState(364);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(365);
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

	public static class PackageDeclarationContext extends ParserRuleContext {
		public TerminalNode PACKAGE() { return getToken(ProcessingParser.PACKAGE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ProcessingParser.SEMI, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public PackageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterPackageDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitPackageDeclaration(this);
		}
	}

	public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
		PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_packageDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(367);
				annotation();
				}
				}
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(373);
			match(PACKAGE);
			setState(374);
			qualifiedName();
			setState(375);
			match(SEMI);
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

	public static class ImportDeclarationContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(ProcessingParser.IMPORT, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ProcessingParser.SEMI, 0); }
		public TerminalNode STATIC() { return getToken(ProcessingParser.STATIC, 0); }
		public TerminalNode DOT() { return getToken(ProcessingParser.DOT, 0); }
		public TerminalNode MUL() { return getToken(ProcessingParser.MUL, 0); }
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitImportDeclaration(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			match(IMPORT);
			setState(379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(378);
				match(STATIC);
				}
			}

			setState(381);
			qualifiedName();
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(382);
				match(DOT);
				setState(383);
				match(MUL);
				}
			}

			setState(386);
			match(SEMI);
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

	public static class TypeDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public List<ClassOrInterfaceModifierContext> classOrInterfaceModifier() {
			return getRuleContexts(ClassOrInterfaceModifierContext.class);
		}
		public ClassOrInterfaceModifierContext classOrInterfaceModifier(int i) {
			return getRuleContext(ClassOrInterfaceModifierContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(ProcessingParser.SEMI, 0); }
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitTypeDeclaration(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeDeclaration);
		try {
			int _alt;
			setState(401);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ABSTRACT:
			case CLASS:
			case ENUM:
			case FINAL:
			case INTERFACE:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case STATIC:
			case STRICTFP:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(391);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(388);
						classOrInterfaceModifier();
						}
						} 
					}
					setState(393);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				setState(398);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CLASS:
					{
					setState(394);
					classDeclaration();
					}
					break;
				case ENUM:
					{
					setState(395);
					enumDeclaration();
					}
					break;
				case INTERFACE:
					{
					setState(396);
					interfaceDeclaration();
					}
					break;
				case AT:
					{
					setState(397);
					annotationTypeDeclaration();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(400);
				match(SEMI);
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

	public static class ModifierContext extends ParserRuleContext {
		public ClassOrInterfaceModifierContext classOrInterfaceModifier() {
			return getRuleContext(ClassOrInterfaceModifierContext.class,0);
		}
		public TerminalNode NATIVE() { return getToken(ProcessingParser.NATIVE, 0); }
		public TerminalNode SYNCHRONIZED() { return getToken(ProcessingParser.SYNCHRONIZED, 0); }
		public TerminalNode TRANSIENT() { return getToken(ProcessingParser.TRANSIENT, 0); }
		public TerminalNode VOLATILE() { return getToken(ProcessingParser.VOLATILE, 0); }
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitModifier(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_modifier);
		try {
			setState(408);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ABSTRACT:
			case FINAL:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case STATIC:
			case STRICTFP:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(403);
				classOrInterfaceModifier();
				}
				break;
			case NATIVE:
				enterOuterAlt(_localctx, 2);
				{
				setState(404);
				match(NATIVE);
				}
				break;
			case SYNCHRONIZED:
				enterOuterAlt(_localctx, 3);
				{
				setState(405);
				match(SYNCHRONIZED);
				}
				break;
			case TRANSIENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(406);
				match(TRANSIENT);
				}
				break;
			case VOLATILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(407);
				match(VOLATILE);
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

	public static class ClassOrInterfaceModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(ProcessingParser.PUBLIC, 0); }
		public TerminalNode PROTECTED() { return getToken(ProcessingParser.PROTECTED, 0); }
		public TerminalNode PRIVATE() { return getToken(ProcessingParser.PRIVATE, 0); }
		public TerminalNode STATIC() { return getToken(ProcessingParser.STATIC, 0); }
		public TerminalNode ABSTRACT() { return getToken(ProcessingParser.ABSTRACT, 0); }
		public TerminalNode FINAL() { return getToken(ProcessingParser.FINAL, 0); }
		public TerminalNode STRICTFP() { return getToken(ProcessingParser.STRICTFP, 0); }
		public ClassOrInterfaceModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterClassOrInterfaceModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitClassOrInterfaceModifier(this);
		}
	}

	public final ClassOrInterfaceModifierContext classOrInterfaceModifier() throws RecognitionException {
		ClassOrInterfaceModifierContext _localctx = new ClassOrInterfaceModifierContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_classOrInterfaceModifier);
		try {
			setState(418);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(411);
				match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(412);
				match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(413);
				match(PRIVATE);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 5);
				{
				setState(414);
				match(STATIC);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 6);
				{
				setState(415);
				match(ABSTRACT);
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 7);
				{
				setState(416);
				match(FINAL);
				}
				break;
			case STRICTFP:
				enterOuterAlt(_localctx, 8);
				{
				setState(417);
				match(STRICTFP);
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

	public static class VariableModifierContext extends ParserRuleContext {
		public TerminalNode FINAL() { return getToken(ProcessingParser.FINAL, 0); }
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public VariableModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterVariableModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitVariableModifier(this);
		}
	}

	public final VariableModifierContext variableModifier() throws RecognitionException {
		VariableModifierContext _localctx = new VariableModifierContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_variableModifier);
		try {
			setState(422);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FINAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(420);
				match(FINAL);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(421);
				annotation();
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

	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(ProcessingParser.CLASS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(ProcessingParser.EXTENDS, 0); }
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode IMPLEMENTS() { return getToken(ProcessingParser.IMPLEMENTS, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitClassDeclaration(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			match(CLASS);
			setState(425);
			match(IDENTIFIER);
			setState(427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(426);
				typeParameters();
				}
			}

			setState(431);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(429);
				match(EXTENDS);
				setState(430);
				typeType();
				}
			}

			setState(435);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(433);
				match(IMPLEMENTS);
				setState(434);
				typeList();
				}
			}

			setState(437);
			classBody();
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

	public static class TypeParametersContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(ProcessingParser.LT, 0); }
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
		}
		public TerminalNode GT() { return getToken(ProcessingParser.GT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ProcessingParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ProcessingParser.COMMA, i);
		}
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterTypeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitTypeParameters(this);
		}
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_typeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			match(LT);
			setState(440);
			typeParameter();
			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(441);
				match(COMMA);
				setState(442);
				typeParameter();
				}
				}
				setState(447);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(448);
			match(GT);
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

	public static class TypeParameterContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TerminalNode EXTENDS() { return getToken(ProcessingParser.EXTENDS, 0); }
		public TypeBoundContext typeBound() {
			return getRuleContext(TypeBoundContext.class,0);
		}
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitTypeParameter(this);
		}
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(450);
				annotation();
				}
				}
				setState(455);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(456);
			match(IDENTIFIER);
			setState(459);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(457);
				match(EXTENDS);
				setState(458);
				typeBound();
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

	public static class TypeBoundContext extends ParserRuleContext {
		public List<TypeTypeContext> typeType() {
			return getRuleContexts(TypeTypeContext.class);
		}
		public TypeTypeContext typeType(int i) {
			return getRuleContext(TypeTypeContext.class,i);
		}
		public List<TerminalNode> BITAND() { return getTokens(ProcessingParser.BITAND); }
		public TerminalNode BITAND(int i) {
			return getToken(ProcessingParser.BITAND, i);
		}
		public TypeBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterTypeBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitTypeBound(this);
		}
	}

	public final TypeBoundContext typeBound() throws RecognitionException {
		TypeBoundContext _localctx = new TypeBoundContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_typeBound);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			typeType();
			setState(466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITAND) {
				{
				{
				setState(462);
				match(BITAND);
				setState(463);
				typeType();
				}
				}
				setState(468);
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

	public static class EnumDeclarationContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(ProcessingParser.ENUM, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(ProcessingParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ProcessingParser.RBRACE, 0); }
		public TerminalNode IMPLEMENTS() { return getToken(ProcessingParser.IMPLEMENTS, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public EnumConstantsContext enumConstants() {
			return getRuleContext(EnumConstantsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ProcessingParser.COMMA, 0); }
		public EnumBodyDeclarationsContext enumBodyDeclarations() {
			return getRuleContext(EnumBodyDeclarationsContext.class,0);
		}
		public EnumDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterEnumDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitEnumDeclaration(this);
		}
	}

	public final EnumDeclarationContext enumDeclaration() throws RecognitionException {
		EnumDeclarationContext _localctx = new EnumDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_enumDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(ENUM);
			setState(470);
			match(IDENTIFIER);
			setState(473);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(471);
				match(IMPLEMENTS);
				setState(472);
				typeList();
				}
			}

			setState(475);
			match(LBRACE);
			setState(477);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT || _la==IDENTIFIER) {
				{
				setState(476);
				enumConstants();
				}
			}

			setState(480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(479);
				match(COMMA);
				}
			}

			setState(483);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(482);
				enumBodyDeclarations();
				}
			}

			setState(485);
			match(RBRACE);
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

	public static class EnumConstantsContext extends ParserRuleContext {
		public List<EnumConstantContext> enumConstant() {
			return getRuleContexts(EnumConstantContext.class);
		}
		public EnumConstantContext enumConstant(int i) {
			return getRuleContext(EnumConstantContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ProcessingParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ProcessingParser.COMMA, i);
		}
		public EnumConstantsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstants; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterEnumConstants(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitEnumConstants(this);
		}
	}

	public final EnumConstantsContext enumConstants() throws RecognitionException {
		EnumConstantsContext _localctx = new EnumConstantsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_enumConstants);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			enumConstant();
			setState(492);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(488);
					match(COMMA);
					setState(489);
					enumConstant();
					}
					} 
				}
				setState(494);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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

	public static class EnumConstantContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public EnumConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterEnumConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitEnumConstant(this);
		}
	}

	public final EnumConstantContext enumConstant() throws RecognitionException {
		EnumConstantContext _localctx = new EnumConstantContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_enumConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(495);
				annotation();
				}
				}
				setState(500);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(501);
			match(IDENTIFIER);
			setState(503);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(502);
				arguments();
				}
			}

			setState(506);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(505);
				classBody();
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

	public static class EnumBodyDeclarationsContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(ProcessingParser.SEMI, 0); }
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public EnumBodyDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBodyDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterEnumBodyDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitEnumBodyDeclarations(this);
		}
	}

	public final EnumBodyDeclarationsContext enumBodyDeclarations() throws RecognitionException {
		EnumBodyDeclarationsContext _localctx = new EnumBodyDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_enumBodyDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			match(SEMI);
			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << IMPORT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VAR) | (1L << VOID) | (1L << VOLATILE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (LBRACE - 69)) | (1L << (SEMI - 69)) | (1L << (LT - 69)) | (1L << (AT - 69)) | (1L << (IDENTIFIER - 69)))) != 0)) {
				{
				{
				setState(509);
				classBodyDeclaration();
				}
				}
				setState(514);
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

	public static class InterfaceDeclarationContext extends ParserRuleContext {
		public TerminalNode INTERFACE() { return getToken(ProcessingParser.INTERFACE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public InterfaceBodyContext interfaceBody() {
			return getRuleContext(InterfaceBodyContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(ProcessingParser.EXTENDS, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public InterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitInterfaceDeclaration(this);
		}
	}

	public final InterfaceDeclarationContext interfaceDeclaration() throws RecognitionException {
		InterfaceDeclarationContext _localctx = new InterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_interfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			match(INTERFACE);
			setState(516);
			match(IDENTIFIER);
			setState(518);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(517);
				typeParameters();
				}
			}

			setState(522);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(520);
				match(EXTENDS);
				setState(521);
				typeList();
				}
			}

			setState(524);
			interfaceBody();
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

	public static class ClassBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ProcessingParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ProcessingParser.RBRACE, 0); }
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitClassBody(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			match(LBRACE);
			setState(530);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << IMPORT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VAR) | (1L << VOID) | (1L << VOLATILE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (LBRACE - 69)) | (1L << (SEMI - 69)) | (1L << (LT - 69)) | (1L << (AT - 69)) | (1L << (IDENTIFIER - 69)))) != 0)) {
				{
				{
				setState(527);
				classBodyDeclaration();
				}
				}
				setState(532);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(533);
			match(RBRACE);
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

	public static class InterfaceBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ProcessingParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ProcessingParser.RBRACE, 0); }
		public List<InterfaceBodyDeclarationContext> interfaceBodyDeclaration() {
			return getRuleContexts(InterfaceBodyDeclarationContext.class);
		}
		public InterfaceBodyDeclarationContext interfaceBodyDeclaration(int i) {
			return getRuleContext(InterfaceBodyDeclarationContext.class,i);
		}
		public InterfaceBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterInterfaceBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitInterfaceBody(this);
		}
	}

	public final InterfaceBodyContext interfaceBody() throws RecognitionException {
		InterfaceBodyContext _localctx = new InterfaceBodyContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_interfaceBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			match(LBRACE);
			setState(539);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DEFAULT) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VAR) | (1L << VOID) | (1L << VOLATILE))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (SEMI - 73)) | (1L << (LT - 73)) | (1L << (AT - 73)) | (1L << (IDENTIFIER - 73)))) != 0)) {
				{
				{
				setState(536);
				interfaceBodyDeclaration();
				}
				}
				setState(541);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(542);
			match(RBRACE);
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

	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(ProcessingParser.SEMI, 0); }
		public ImportDeclarationContext importDeclaration() {
			return getRuleContext(ImportDeclarationContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode STATIC() { return getToken(ProcessingParser.STATIC, 0); }
		public MemberDeclarationContext memberDeclaration() {
			return getRuleContext(MemberDeclarationContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitClassBodyDeclaration(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_classBodyDeclaration);
		int _la;
		try {
			int _alt;
			setState(557);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(544);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(545);
				importDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(547);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STATIC) {
					{
					setState(546);
					match(STATIC);
					}
				}

				setState(549);
				block();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(553);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(550);
						modifier();
						}
						} 
					}
					setState(555);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
				}
				setState(556);
				memberDeclaration();
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

	public static class MemberDeclarationContext extends ParserRuleContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public GenericMethodDeclarationContext genericMethodDeclaration() {
			return getRuleContext(GenericMethodDeclarationContext.class,0);
		}
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public GenericConstructorDeclarationContext genericConstructorDeclaration() {
			return getRuleContext(GenericConstructorDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public MemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitMemberDeclaration(this);
		}
	}

	public final MemberDeclarationContext memberDeclaration() throws RecognitionException {
		MemberDeclarationContext _localctx = new MemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_memberDeclaration);
		try {
			setState(568);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(559);
				methodDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(560);
				genericMethodDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(561);
				fieldDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(562);
				constructorDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(563);
				genericConstructorDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(564);
				interfaceDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(565);
				annotationTypeDeclaration();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(566);
				classDeclaration();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(567);
				enumDeclaration();
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

	public static class MethodDeclarationContext extends ParserRuleContext {
		public TypeTypeOrVoidContext typeTypeOrVoid() {
			return getRuleContext(TypeTypeOrVoidContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(ProcessingParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(ProcessingParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(ProcessingParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(ProcessingParser.RBRACK, i);
		}
		public TerminalNode THROWS() { return getToken(ProcessingParser.THROWS, 0); }
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitMethodDeclaration(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			typeTypeOrVoid();
			setState(571);
			match(IDENTIFIER);
			setState(572);
			formalParameters();
			setState(577);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(573);
				match(LBRACK);
				setState(574);
				match(RBRACK);
				}
				}
				setState(579);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(582);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(580);
				match(THROWS);
				setState(581);
				qualifiedNameList();
				}
			}

			setState(584);
			methodBody();
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

	public static class MethodBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ProcessingParser.SEMI, 0); }
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitMethodBody(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_methodBody);
		try {
			setState(588);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(586);
				block();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(587);
				match(SEMI);
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

	public static class TypeTypeOrVoidContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(ProcessingParser.VOID, 0); }
		public TypeTypeOrVoidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeTypeOrVoid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterTypeTypeOrVoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitTypeTypeOrVoid(this);
		}
	}

	public final TypeTypeOrVoidContext typeTypeOrVoid() throws RecognitionException {
		TypeTypeOrVoidContext _localctx = new TypeTypeOrVoidContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_typeTypeOrVoid);
		try {
			setState(592);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case VAR:
			case AT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(590);
				typeType();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(591);
				match(VOID);
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

	public static class GenericMethodDeclarationContext extends ParserRuleContext {
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public GenericMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterGenericMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitGenericMethodDeclaration(this);
		}
	}

	public final GenericMethodDeclarationContext genericMethodDeclaration() throws RecognitionException {
		GenericMethodDeclarationContext _localctx = new GenericMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_genericMethodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(594);
			typeParameters();
			setState(595);
			methodDeclaration();
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

	public static class GenericConstructorDeclarationContext extends ParserRuleContext {
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public GenericConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericConstructorDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterGenericConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitGenericConstructorDeclaration(this);
		}
	}

	public final GenericConstructorDeclarationContext genericConstructorDeclaration() throws RecognitionException {
		GenericConstructorDeclarationContext _localctx = new GenericConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_genericConstructorDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
			typeParameters();
			setState(598);
			constructorDeclaration();
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

	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public BlockContext constructorBody;
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode THROWS() { return getToken(ProcessingParser.THROWS, 0); }
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitConstructorDeclaration(this);
		}
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_constructorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			match(IDENTIFIER);
			setState(601);
			formalParameters();
			setState(604);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(602);
				match(THROWS);
				setState(603);
				qualifiedNameList();
				}
			}

			setState(606);
			((ConstructorDeclarationContext)_localctx).constructorBody = block();
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

	public static class FieldDeclarationContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ProcessingParser.SEMI, 0); }
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitFieldDeclaration(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_fieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			typeType();
			setState(609);
			variableDeclarators();
			setState(610);
			match(SEMI);
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

	public static class InterfaceBodyDeclarationContext extends ParserRuleContext {
		public InterfaceMemberDeclarationContext interfaceMemberDeclaration() {
			return getRuleContext(InterfaceMemberDeclarationContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(ProcessingParser.SEMI, 0); }
		public InterfaceBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterInterfaceBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitInterfaceBodyDeclaration(this);
		}
	}

	public final InterfaceBodyDeclarationContext interfaceBodyDeclaration() throws RecognitionException {
		InterfaceBodyDeclarationContext _localctx = new InterfaceBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_interfaceBodyDeclaration);
		try {
			int _alt;
			setState(620);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case ABSTRACT:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case CLASS:
			case DEFAULT:
			case DOUBLE:
			case ENUM:
			case FINAL:
			case FLOAT:
			case INT:
			case INTERFACE:
			case LONG:
			case NATIVE:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case SHORT:
			case STATIC:
			case STRICTFP:
			case SYNCHRONIZED:
			case TRANSIENT:
			case VAR:
			case VOID:
			case VOLATILE:
			case LT:
			case AT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(615);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(612);
						modifier();
						}
						} 
					}
					setState(617);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
				}
				setState(618);
				interfaceMemberDeclaration();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(619);
				match(SEMI);
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

	public static class InterfaceMemberDeclarationContext extends ParserRuleContext {
		public ConstDeclarationContext constDeclaration() {
			return getRuleContext(ConstDeclarationContext.class,0);
		}
		public InterfaceMethodDeclarationContext interfaceMethodDeclaration() {
			return getRuleContext(InterfaceMethodDeclarationContext.class,0);
		}
		public GenericInterfaceMethodDeclarationContext genericInterfaceMethodDeclaration() {
			return getRuleContext(GenericInterfaceMethodDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public InterfaceMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMemberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterInterfaceMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitInterfaceMemberDeclaration(this);
		}
	}

	public final InterfaceMemberDeclarationContext interfaceMemberDeclaration() throws RecognitionException {
		InterfaceMemberDeclarationContext _localctx = new InterfaceMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_interfaceMemberDeclaration);
		try {
			setState(629);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(622);
				constDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(623);
				interfaceMethodDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(624);
				genericInterfaceMethodDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(625);
				interfaceDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(626);
				annotationTypeDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(627);
				classDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(628);
				enumDeclaration();
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

	public static class ConstDeclarationContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public List<ConstantDeclaratorContext> constantDeclarator() {
			return getRuleContexts(ConstantDeclaratorContext.class);
		}
		public ConstantDeclaratorContext constantDeclarator(int i) {
			return getRuleContext(ConstantDeclaratorContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(ProcessingParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ProcessingParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ProcessingParser.COMMA, i);
		}
		public ConstDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterConstDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitConstDeclaration(this);
		}
	}

	public final ConstDeclarationContext constDeclaration() throws RecognitionException {
		ConstDeclarationContext _localctx = new ConstDeclarationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_constDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(631);
			typeType();
			setState(632);
			constantDeclarator();
			setState(637);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(633);
				match(COMMA);
				setState(634);
				constantDeclarator();
				}
				}
				setState(639);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(640);
			match(SEMI);
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

	public static class ConstantDeclaratorContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(ProcessingParser.ASSIGN, 0); }
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(ProcessingParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(ProcessingParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(ProcessingParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(ProcessingParser.RBRACK, i);
		}
		public ConstantDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterConstantDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitConstantDeclarator(this);
		}
	}

	public final ConstantDeclaratorContext constantDeclarator() throws RecognitionException {
		ConstantDeclaratorContext _localctx = new ConstantDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_constantDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(642);
			match(IDENTIFIER);
			setState(647);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(643);
				match(LBRACK);
				setState(644);
				match(RBRACK);
				}
				}
				setState(649);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(650);
			match(ASSIGN);
			setState(651);
			variableInitializer();
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

	public static class InterfaceMethodDeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public TypeTypeOrVoidContext typeTypeOrVoid() {
			return getRuleContext(TypeTypeOrVoidContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public List<InterfaceMethodModifierContext> interfaceMethodModifier() {
			return getRuleContexts(InterfaceMethodModifierContext.class);
		}
		public InterfaceMethodModifierContext interfaceMethodModifier(int i) {
			return getRuleContext(InterfaceMethodModifierContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(ProcessingParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(ProcessingParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(ProcessingParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(ProcessingParser.RBRACK, i);
		}
		public TerminalNode THROWS() { return getToken(ProcessingParser.THROWS, 0); }
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public InterfaceMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterInterfaceMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitInterfaceMethodDeclaration(this);
		}
	}

	public final InterfaceMethodDeclarationContext interfaceMethodDeclaration() throws RecognitionException {
		InterfaceMethodDeclarationContext _localctx = new InterfaceMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_interfaceMethodDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(656);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(653);
					interfaceMethodModifier();
					}
					} 
				}
				setState(658);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			}
			setState(669);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case VAR:
			case VOID:
			case AT:
			case IDENTIFIER:
				{
				setState(659);
				typeTypeOrVoid();
				}
				break;
			case LT:
				{
				setState(660);
				typeParameters();
				setState(664);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(661);
						annotation();
						}
						} 
					}
					setState(666);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
				}
				setState(667);
				typeTypeOrVoid();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(671);
			match(IDENTIFIER);
			setState(672);
			formalParameters();
			setState(677);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(673);
				match(LBRACK);
				setState(674);
				match(RBRACK);
				}
				}
				setState(679);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(682);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(680);
				match(THROWS);
				setState(681);
				qualifiedNameList();
				}
			}

			setState(684);
			methodBody();
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

	public static class InterfaceMethodModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(ProcessingParser.PUBLIC, 0); }
		public TerminalNode ABSTRACT() { return getToken(ProcessingParser.ABSTRACT, 0); }
		public TerminalNode DEFAULT() { return getToken(ProcessingParser.DEFAULT, 0); }
		public TerminalNode STATIC() { return getToken(ProcessingParser.STATIC, 0); }
		public TerminalNode STRICTFP() { return getToken(ProcessingParser.STRICTFP, 0); }
		public InterfaceMethodModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterInterfaceMethodModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitInterfaceMethodModifier(this);
		}
	}

	public final InterfaceMethodModifierContext interfaceMethodModifier() throws RecognitionException {
		InterfaceMethodModifierContext _localctx = new InterfaceMethodModifierContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_interfaceMethodModifier);
		try {
			setState(692);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(686);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(687);
				match(PUBLIC);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 3);
				{
				setState(688);
				match(ABSTRACT);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 4);
				{
				setState(689);
				match(DEFAULT);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 5);
				{
				setState(690);
				match(STATIC);
				}
				break;
			case STRICTFP:
				enterOuterAlt(_localctx, 6);
				{
				setState(691);
				match(STRICTFP);
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

	public static class GenericInterfaceMethodDeclarationContext extends ParserRuleContext {
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public InterfaceMethodDeclarationContext interfaceMethodDeclaration() {
			return getRuleContext(InterfaceMethodDeclarationContext.class,0);
		}
		public GenericInterfaceMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericInterfaceMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterGenericInterfaceMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitGenericInterfaceMethodDeclaration(this);
		}
	}

	public final GenericInterfaceMethodDeclarationContext genericInterfaceMethodDeclaration() throws RecognitionException {
		GenericInterfaceMethodDeclarationContext _localctx = new GenericInterfaceMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_genericInterfaceMethodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
			typeParameters();
			setState(695);
			interfaceMethodDeclaration();
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

	public static class VariableDeclaratorsContext extends ParserRuleContext {
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ProcessingParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ProcessingParser.COMMA, i);
		}
		public VariableDeclaratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterVariableDeclarators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitVariableDeclarators(this);
		}
	}

	public final VariableDeclaratorsContext variableDeclarators() throws RecognitionException {
		VariableDeclaratorsContext _localctx = new VariableDeclaratorsContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_variableDeclarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			variableDeclarator();
			setState(702);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(698);
				match(COMMA);
				setState(699);
				variableDeclarator();
				}
				}
				setState(704);
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

	public static class VariableDeclaratorContext extends ParserRuleContext {
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ProcessingParser.ASSIGN, 0); }
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterVariableDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitVariableDeclarator(this);
		}
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(705);
			variableDeclaratorId();
			setState(708);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(706);
				match(ASSIGN);
				setState(707);
				variableInitializer();
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

	public static class VariableInitializerContext extends ParserRuleContext {
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterVariableInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitVariableInitializer(this);
		}
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_variableInitializer);
		try {
			setState(712);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(710);
				arrayInitializer();
				}
				break;
			case T__0:
			case HexColorLiteral:
			case CHAR_LITERAL:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VAR:
			case VOID:
			case DECIMAL_LITERAL:
			case HEX_LITERAL:
			case OCT_LITERAL:
			case BINARY_LITERAL:
			case FLOAT_LITERAL:
			case HEX_FLOAT_LITERAL:
			case BOOL_LITERAL:
			case STRING_LITERAL:
			case NULL_LITERAL:
			case LPAREN:
			case LT:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case AT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(711);
				expression(0);
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

	public static class ArrayInitializerContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ProcessingParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ProcessingParser.RBRACE, 0); }
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ProcessingParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ProcessingParser.COMMA, i);
		}
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitArrayInitializer(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_arrayInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(714);
			match(LBRACE);
			setState(726);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << HexColorLiteral) | (1L << CHAR_LITERAL) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VAR) | (1L << VOID) | (1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << OCT_LITERAL) | (1L << BINARY_LITERAL) | (1L << FLOAT_LITERAL) | (1L << HEX_FLOAT_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BOOL_LITERAL - 64)) | (1L << (STRING_LITERAL - 64)) | (1L << (NULL_LITERAL - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (AT - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
				{
				setState(715);
				variableInitializer();
				setState(720);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(716);
						match(COMMA);
						setState(717);
						variableInitializer();
						}
						} 
					}
					setState(722);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
				}
				setState(724);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(723);
					match(COMMA);
					}
				}

				}
			}

			setState(728);
			match(RBRACE);
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

	public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(ProcessingParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ProcessingParser.IDENTIFIER, i);
		}
		public List<TypeArgumentsContext> typeArguments() {
			return getRuleContexts(TypeArgumentsContext.class);
		}
		public TypeArgumentsContext typeArguments(int i) {
			return getRuleContext(TypeArgumentsContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(ProcessingParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ProcessingParser.DOT, i);
		}
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitClassOrInterfaceType(this);
		}
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_classOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			match(IDENTIFIER);
			setState(732);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				{
				setState(731);
				typeArguments();
				}
				break;
			}
			setState(741);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(734);
					match(DOT);
					setState(735);
					match(IDENTIFIER);
					setState(737);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
					case 1:
						{
						setState(736);
						typeArguments();
						}
						break;
					}
					}
					} 
				}
				setState(743);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
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

	public static class TypeArgumentContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(ProcessingParser.QUESTION, 0); }
		public TerminalNode EXTENDS() { return getToken(ProcessingParser.EXTENDS, 0); }
		public TerminalNode SUPER() { return getToken(ProcessingParser.SUPER, 0); }
		public TypeArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitTypeArgument(this);
		}
	}

	public final TypeArgumentContext typeArgument() throws RecognitionException {
		TypeArgumentContext _localctx = new TypeArgumentContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_typeArgument);
		int _la;
		try {
			setState(750);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case VAR:
			case AT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(744);
				typeType();
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(745);
				match(QUESTION);
				setState(748);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXTENDS || _la==SUPER) {
					{
					setState(746);
					_la = _input.LA(1);
					if ( !(_la==EXTENDS || _la==SUPER) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(747);
					typeType();
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

	public static class QualifiedNameListContext extends ParserRuleContext {
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ProcessingParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ProcessingParser.COMMA, i);
		}
		public QualifiedNameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedNameList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterQualifiedNameList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitQualifiedNameList(this);
		}
	}

	public final QualifiedNameListContext qualifiedNameList() throws RecognitionException {
		QualifiedNameListContext _localctx = new QualifiedNameListContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_qualifiedNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(752);
			qualifiedName();
			setState(757);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(753);
				match(COMMA);
				setState(754);
				qualifiedName();
				}
				}
				setState(759);
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

	public static class FormalParametersContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ProcessingParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ProcessingParser.RPAREN, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitFormalParameters(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(760);
			match(LPAREN);
			setState(762);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT) | (1L << VAR))) != 0) || _la==AT || _la==IDENTIFIER) {
				{
				setState(761);
				formalParameterList();
				}
			}

			setState(764);
			match(RPAREN);
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

	public static class FormalParameterListContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ProcessingParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ProcessingParser.COMMA, i);
		}
		public LastFormalParameterContext lastFormalParameter() {
			return getRuleContext(LastFormalParameterContext.class,0);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitFormalParameterList(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_formalParameterList);
		int _la;
		try {
			int _alt;
			setState(779);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(766);
				formalParameter();
				setState(771);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(767);
						match(COMMA);
						setState(768);
						formalParameter();
						}
						} 
					}
					setState(773);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
				}
				setState(776);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(774);
					match(COMMA);
					setState(775);
					lastFormalParameter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(778);
				lastFormalParameter();
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

	public static class FormalParameterContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitFormalParameter(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_formalParameter);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(784);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(781);
					variableModifier();
					}
					} 
				}
				setState(786);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			}
			setState(787);
			typeType();
			setState(788);
			variableDeclaratorId();
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

	public static class LastFormalParameterContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode ELLIPSIS() { return getToken(ProcessingParser.ELLIPSIS, 0); }
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public LastFormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastFormalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterLastFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitLastFormalParameter(this);
		}
	}

	public final LastFormalParameterContext lastFormalParameter() throws RecognitionException {
		LastFormalParameterContext _localctx = new LastFormalParameterContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_lastFormalParameter);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(793);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(790);
					variableModifier();
					}
					} 
				}
				setState(795);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
			}
			setState(796);
			typeType();
			setState(797);
			match(ELLIPSIS);
			setState(798);
			variableDeclaratorId();
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

	public static class IntegerLiteralContext extends ParserRuleContext {
		public TerminalNode DECIMAL_LITERAL() { return getToken(ProcessingParser.DECIMAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(ProcessingParser.HEX_LITERAL, 0); }
		public TerminalNode OCT_LITERAL() { return getToken(ProcessingParser.OCT_LITERAL, 0); }
		public TerminalNode BINARY_LITERAL() { return getToken(ProcessingParser.BINARY_LITERAL, 0); }
		public IntegerLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitIntegerLiteral(this);
		}
	}

	public final IntegerLiteralContext integerLiteral() throws RecognitionException {
		IntegerLiteralContext _localctx = new IntegerLiteralContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_integerLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(800);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << OCT_LITERAL) | (1L << BINARY_LITERAL))) != 0)) ) {
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

	public static class FloatLiteralContext extends ParserRuleContext {
		public TerminalNode FLOAT_LITERAL() { return getToken(ProcessingParser.FLOAT_LITERAL, 0); }
		public TerminalNode HEX_FLOAT_LITERAL() { return getToken(ProcessingParser.HEX_FLOAT_LITERAL, 0); }
		public FloatLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterFloatLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitFloatLiteral(this);
		}
	}

	public final FloatLiteralContext floatLiteral() throws RecognitionException {
		FloatLiteralContext _localctx = new FloatLiteralContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_floatLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(802);
			_la = _input.LA(1);
			if ( !(_la==FLOAT_LITERAL || _la==HEX_FLOAT_LITERAL) ) {
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

	public static class AnnotationContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(ProcessingParser.AT, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ProcessingParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ProcessingParser.RPAREN, 0); }
		public ElementValuePairsContext elementValuePairs() {
			return getRuleContext(ElementValuePairsContext.class,0);
		}
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitAnnotation(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(804);
			match(AT);
			setState(805);
			qualifiedName();
			setState(812);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(806);
				match(LPAREN);
				setState(809);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
				case 1:
					{
					setState(807);
					elementValuePairs();
					}
					break;
				case 2:
					{
					setState(808);
					elementValue();
					}
					break;
				}
				setState(811);
				match(RPAREN);
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

	public static class ElementValuePairsContext extends ParserRuleContext {
		public List<ElementValuePairContext> elementValuePair() {
			return getRuleContexts(ElementValuePairContext.class);
		}
		public ElementValuePairContext elementValuePair(int i) {
			return getRuleContext(ElementValuePairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ProcessingParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ProcessingParser.COMMA, i);
		}
		public ElementValuePairsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePairs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterElementValuePairs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitElementValuePairs(this);
		}
	}

	public final ElementValuePairsContext elementValuePairs() throws RecognitionException {
		ElementValuePairsContext _localctx = new ElementValuePairsContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_elementValuePairs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(814);
			elementValuePair();
			setState(819);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(815);
				match(COMMA);
				setState(816);
				elementValuePair();
				}
				}
				setState(821);
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

	public static class ElementValuePairContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(ProcessingParser.ASSIGN, 0); }
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public ElementValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterElementValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitElementValuePair(this);
		}
	}

	public final ElementValuePairContext elementValuePair() throws RecognitionException {
		ElementValuePairContext _localctx = new ElementValuePairContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_elementValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(822);
			match(IDENTIFIER);
			setState(823);
			match(ASSIGN);
			setState(824);
			elementValue();
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

	public static class ElementValueContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ElementValueArrayInitializerContext elementValueArrayInitializer() {
			return getRuleContext(ElementValueArrayInitializerContext.class,0);
		}
		public ElementValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterElementValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitElementValue(this);
		}
	}

	public final ElementValueContext elementValue() throws RecognitionException {
		ElementValueContext _localctx = new ElementValueContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_elementValue);
		try {
			setState(829);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(826);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(827);
				annotation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(828);
				elementValueArrayInitializer();
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

	public static class ElementValueArrayInitializerContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ProcessingParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ProcessingParser.RBRACE, 0); }
		public List<ElementValueContext> elementValue() {
			return getRuleContexts(ElementValueContext.class);
		}
		public ElementValueContext elementValue(int i) {
			return getRuleContext(ElementValueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ProcessingParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ProcessingParser.COMMA, i);
		}
		public ElementValueArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValueArrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterElementValueArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitElementValueArrayInitializer(this);
		}
	}

	public final ElementValueArrayInitializerContext elementValueArrayInitializer() throws RecognitionException {
		ElementValueArrayInitializerContext _localctx = new ElementValueArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_elementValueArrayInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(831);
			match(LBRACE);
			setState(840);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << HexColorLiteral) | (1L << CHAR_LITERAL) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VAR) | (1L << VOID) | (1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << OCT_LITERAL) | (1L << BINARY_LITERAL) | (1L << FLOAT_LITERAL) | (1L << HEX_FLOAT_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BOOL_LITERAL - 64)) | (1L << (STRING_LITERAL - 64)) | (1L << (NULL_LITERAL - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (AT - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
				{
				setState(832);
				elementValue();
				setState(837);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(833);
						match(COMMA);
						setState(834);
						elementValue();
						}
						} 
					}
					setState(839);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
				}
				}
			}

			setState(843);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(842);
				match(COMMA);
				}
			}

			setState(845);
			match(RBRACE);
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

	public static class AnnotationTypeDeclarationContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(ProcessingParser.AT, 0); }
		public TerminalNode INTERFACE() { return getToken(ProcessingParser.INTERFACE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public AnnotationTypeBodyContext annotationTypeBody() {
			return getRuleContext(AnnotationTypeBodyContext.class,0);
		}
		public AnnotationTypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterAnnotationTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitAnnotationTypeDeclaration(this);
		}
	}

	public final AnnotationTypeDeclarationContext annotationTypeDeclaration() throws RecognitionException {
		AnnotationTypeDeclarationContext _localctx = new AnnotationTypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_annotationTypeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(847);
			match(AT);
			setState(848);
			match(INTERFACE);
			setState(849);
			match(IDENTIFIER);
			setState(850);
			annotationTypeBody();
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

	public static class AnnotationTypeBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ProcessingParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ProcessingParser.RBRACE, 0); }
		public List<AnnotationTypeElementDeclarationContext> annotationTypeElementDeclaration() {
			return getRuleContexts(AnnotationTypeElementDeclarationContext.class);
		}
		public AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration(int i) {
			return getRuleContext(AnnotationTypeElementDeclarationContext.class,i);
		}
		public AnnotationTypeBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterAnnotationTypeBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitAnnotationTypeBody(this);
		}
	}

	public final AnnotationTypeBodyContext annotationTypeBody() throws RecognitionException {
		AnnotationTypeBodyContext _localctx = new AnnotationTypeBodyContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_annotationTypeBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(852);
			match(LBRACE);
			setState(856);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VAR) | (1L << VOLATILE))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (SEMI - 73)) | (1L << (AT - 73)) | (1L << (IDENTIFIER - 73)))) != 0)) {
				{
				{
				setState(853);
				annotationTypeElementDeclaration();
				}
				}
				setState(858);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(859);
			match(RBRACE);
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

	public static class AnnotationTypeElementDeclarationContext extends ParserRuleContext {
		public AnnotationTypeElementRestContext annotationTypeElementRest() {
			return getRuleContext(AnnotationTypeElementRestContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(ProcessingParser.SEMI, 0); }
		public AnnotationTypeElementDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterAnnotationTypeElementDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitAnnotationTypeElementDeclaration(this);
		}
	}

	public final AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration() throws RecognitionException {
		AnnotationTypeElementDeclarationContext _localctx = new AnnotationTypeElementDeclarationContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_annotationTypeElementDeclaration);
		try {
			int _alt;
			setState(869);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case ABSTRACT:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case CLASS:
			case DOUBLE:
			case ENUM:
			case FINAL:
			case FLOAT:
			case INT:
			case INTERFACE:
			case LONG:
			case NATIVE:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case SHORT:
			case STATIC:
			case STRICTFP:
			case SYNCHRONIZED:
			case TRANSIENT:
			case VAR:
			case VOLATILE:
			case AT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(864);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,99,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(861);
						modifier();
						}
						} 
					}
					setState(866);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,99,_ctx);
				}
				setState(867);
				annotationTypeElementRest();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(868);
				match(SEMI);
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

	public static class AnnotationTypeElementRestContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public AnnotationMethodOrConstantRestContext annotationMethodOrConstantRest() {
			return getRuleContext(AnnotationMethodOrConstantRestContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ProcessingParser.SEMI, 0); }
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public AnnotationTypeElementRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterAnnotationTypeElementRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitAnnotationTypeElementRest(this);
		}
	}

	public final AnnotationTypeElementRestContext annotationTypeElementRest() throws RecognitionException {
		AnnotationTypeElementRestContext _localctx = new AnnotationTypeElementRestContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_annotationTypeElementRest);
		try {
			setState(891);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(871);
				typeType();
				setState(872);
				annotationMethodOrConstantRest();
				setState(873);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(875);
				classDeclaration();
				setState(877);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
				case 1:
					{
					setState(876);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(879);
				interfaceDeclaration();
				setState(881);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
				case 1:
					{
					setState(880);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(883);
				enumDeclaration();
				setState(885);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
				case 1:
					{
					setState(884);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(887);
				annotationTypeDeclaration();
				setState(889);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
				case 1:
					{
					setState(888);
					match(SEMI);
					}
					break;
				}
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

	public static class AnnotationMethodOrConstantRestContext extends ParserRuleContext {
		public AnnotationMethodRestContext annotationMethodRest() {
			return getRuleContext(AnnotationMethodRestContext.class,0);
		}
		public AnnotationConstantRestContext annotationConstantRest() {
			return getRuleContext(AnnotationConstantRestContext.class,0);
		}
		public AnnotationMethodOrConstantRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationMethodOrConstantRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterAnnotationMethodOrConstantRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitAnnotationMethodOrConstantRest(this);
		}
	}

	public final AnnotationMethodOrConstantRestContext annotationMethodOrConstantRest() throws RecognitionException {
		AnnotationMethodOrConstantRestContext _localctx = new AnnotationMethodOrConstantRestContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_annotationMethodOrConstantRest);
		try {
			setState(895);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(893);
				annotationMethodRest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(894);
				annotationConstantRest();
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

	public static class AnnotationMethodRestContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(ProcessingParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ProcessingParser.RPAREN, 0); }
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public AnnotationMethodRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationMethodRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterAnnotationMethodRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitAnnotationMethodRest(this);
		}
	}

	public final AnnotationMethodRestContext annotationMethodRest() throws RecognitionException {
		AnnotationMethodRestContext _localctx = new AnnotationMethodRestContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_annotationMethodRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(897);
			match(IDENTIFIER);
			setState(898);
			match(LPAREN);
			setState(899);
			match(RPAREN);
			setState(901);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(900);
				defaultValue();
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

	public static class AnnotationConstantRestContext extends ParserRuleContext {
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public AnnotationConstantRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationConstantRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterAnnotationConstantRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitAnnotationConstantRest(this);
		}
	}

	public final AnnotationConstantRestContext annotationConstantRest() throws RecognitionException {
		AnnotationConstantRestContext _localctx = new AnnotationConstantRestContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_annotationConstantRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(903);
			variableDeclarators();
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

	public static class DefaultValueContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(ProcessingParser.DEFAULT, 0); }
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterDefaultValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitDefaultValue(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_defaultValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(905);
			match(DEFAULT);
			setState(906);
			elementValue();
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
		public TerminalNode LBRACE() { return getToken(ProcessingParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ProcessingParser.RBRACE, 0); }
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(908);
			match(LBRACE);
			setState(912);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << HexColorLiteral) | (1L << CHAR_LITERAL) | (1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SUPER) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VAR) | (1L << VOID) | (1L << WHILE) | (1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << OCT_LITERAL) | (1L << BINARY_LITERAL) | (1L << FLOAT_LITERAL) | (1L << HEX_FLOAT_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BOOL_LITERAL - 64)) | (1L << (STRING_LITERAL - 64)) | (1L << (NULL_LITERAL - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (AT - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
				{
				{
				setState(909);
				blockStatement();
				}
				}
				setState(914);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(915);
			match(RBRACE);
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

	public static class BlockStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ProcessingParser.SEMI, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LocalTypeDeclarationContext localTypeDeclaration() {
			return getRuleContext(LocalTypeDeclarationContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitBlockStatement(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_blockStatement);
		try {
			setState(922);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(917);
				localVariableDeclaration();
				setState(918);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(920);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(921);
				localTypeDeclaration();
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

	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterLocalVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitLocalVariableDeclaration(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_localVariableDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(927);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,110,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(924);
					variableModifier();
					}
					} 
				}
				setState(929);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,110,_ctx);
			}
			setState(930);
			typeType();
			setState(931);
			variableDeclarators();
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

	public static class LocalTypeDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public List<ClassOrInterfaceModifierContext> classOrInterfaceModifier() {
			return getRuleContexts(ClassOrInterfaceModifierContext.class);
		}
		public ClassOrInterfaceModifierContext classOrInterfaceModifier(int i) {
			return getRuleContext(ClassOrInterfaceModifierContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(ProcessingParser.SEMI, 0); }
		public LocalTypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localTypeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterLocalTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitLocalTypeDeclaration(this);
		}
	}

	public final LocalTypeDeclarationContext localTypeDeclaration() throws RecognitionException {
		LocalTypeDeclarationContext _localctx = new LocalTypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_localTypeDeclaration);
		int _la;
		try {
			setState(944);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ABSTRACT:
			case CLASS:
			case FINAL:
			case INTERFACE:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case STATIC:
			case STRICTFP:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(936);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==AT) {
					{
					{
					setState(933);
					classOrInterfaceModifier();
					}
					}
					setState(938);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(941);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CLASS:
					{
					setState(939);
					classDeclaration();
					}
					break;
				case INTERFACE:
					{
					setState(940);
					interfaceDeclaration();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(943);
				match(SEMI);
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

	public static class StatementContext extends ParserRuleContext {
		public BlockContext blockLabel;
		public ExpressionContext statementExpression;
		public Token identifierLabel;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode ASSERT() { return getToken(ProcessingParser.ASSERT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(ProcessingParser.SEMI, 0); }
		public TerminalNode COLON() { return getToken(ProcessingParser.COLON, 0); }
		public TerminalNode IF() { return getToken(ProcessingParser.IF, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ProcessingParser.ELSE, 0); }
		public TerminalNode FOR() { return getToken(ProcessingParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(ProcessingParser.LPAREN, 0); }
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ProcessingParser.RPAREN, 0); }
		public TerminalNode WHILE() { return getToken(ProcessingParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(ProcessingParser.DO, 0); }
		public TerminalNode TRY() { return getToken(ProcessingParser.TRY, 0); }
		public FinallyBlockContext finallyBlock() {
			return getRuleContext(FinallyBlockContext.class,0);
		}
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public ResourceSpecificationContext resourceSpecification() {
			return getRuleContext(ResourceSpecificationContext.class,0);
		}
		public TerminalNode SWITCH() { return getToken(ProcessingParser.SWITCH, 0); }
		public TerminalNode LBRACE() { return getToken(ProcessingParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ProcessingParser.RBRACE, 0); }
		public List<SwitchBlockStatementGroupContext> switchBlockStatementGroup() {
			return getRuleContexts(SwitchBlockStatementGroupContext.class);
		}
		public SwitchBlockStatementGroupContext switchBlockStatementGroup(int i) {
			return getRuleContext(SwitchBlockStatementGroupContext.class,i);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public TerminalNode SYNCHRONIZED() { return getToken(ProcessingParser.SYNCHRONIZED, 0); }
		public TerminalNode RETURN() { return getToken(ProcessingParser.RETURN, 0); }
		public TerminalNode THROW() { return getToken(ProcessingParser.THROW, 0); }
		public TerminalNode BREAK() { return getToken(ProcessingParser.BREAK, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public TerminalNode CONTINUE() { return getToken(ProcessingParser.CONTINUE, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(1050);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(946);
				((StatementContext)_localctx).blockLabel = block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(947);
				match(ASSERT);
				setState(948);
				expression(0);
				setState(951);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(949);
					match(COLON);
					setState(950);
					expression(0);
					}
				}

				setState(953);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(955);
				match(IF);
				setState(956);
				parExpression();
				setState(957);
				statement();
				setState(960);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
				case 1:
					{
					setState(958);
					match(ELSE);
					setState(959);
					statement();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(962);
				match(FOR);
				setState(963);
				match(LPAREN);
				setState(964);
				forControl();
				setState(965);
				match(RPAREN);
				setState(966);
				statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(968);
				match(WHILE);
				setState(969);
				parExpression();
				setState(970);
				statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(972);
				match(DO);
				setState(973);
				statement();
				setState(974);
				match(WHILE);
				setState(975);
				parExpression();
				setState(976);
				match(SEMI);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(978);
				match(TRY);
				setState(979);
				block();
				setState(989);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CATCH:
					{
					setState(981); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(980);
						catchClause();
						}
						}
						setState(983); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CATCH );
					setState(986);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==FINALLY) {
						{
						setState(985);
						finallyBlock();
						}
					}

					}
					break;
				case FINALLY:
					{
					setState(988);
					finallyBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(991);
				match(TRY);
				setState(992);
				resourceSpecification();
				setState(993);
				block();
				setState(997);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CATCH) {
					{
					{
					setState(994);
					catchClause();
					}
					}
					setState(999);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1001);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(1000);
					finallyBlock();
					}
				}

				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1003);
				match(SWITCH);
				setState(1004);
				parExpression();
				setState(1005);
				match(LBRACE);
				setState(1009);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,121,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1006);
						switchBlockStatementGroup();
						}
						} 
					}
					setState(1011);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,121,_ctx);
				}
				setState(1015);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(1012);
					switchLabel();
					}
					}
					setState(1017);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1018);
				match(RBRACE);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1020);
				match(SYNCHRONIZED);
				setState(1021);
				parExpression();
				setState(1022);
				block();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1024);
				match(RETURN);
				setState(1026);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << HexColorLiteral) | (1L << CHAR_LITERAL) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VAR) | (1L << VOID) | (1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << OCT_LITERAL) | (1L << BINARY_LITERAL) | (1L << FLOAT_LITERAL) | (1L << HEX_FLOAT_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BOOL_LITERAL - 64)) | (1L << (STRING_LITERAL - 64)) | (1L << (NULL_LITERAL - 64)) | (1L << (LPAREN - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (AT - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
					{
					setState(1025);
					expression(0);
					}
				}

				setState(1028);
				match(SEMI);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1029);
				match(THROW);
				setState(1030);
				expression(0);
				setState(1031);
				match(SEMI);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1033);
				match(BREAK);
				setState(1035);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(1034);
					match(IDENTIFIER);
					}
				}

				setState(1037);
				match(SEMI);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1038);
				match(CONTINUE);
				setState(1040);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(1039);
					match(IDENTIFIER);
					}
				}

				setState(1042);
				match(SEMI);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(1043);
				match(SEMI);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(1044);
				((StatementContext)_localctx).statementExpression = expression(0);
				setState(1045);
				match(SEMI);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(1047);
				((StatementContext)_localctx).identifierLabel = match(IDENTIFIER);
				setState(1048);
				match(COLON);
				setState(1049);
				statement();
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

	public static class CatchClauseContext extends ParserRuleContext {
		public TerminalNode CATCH() { return getToken(ProcessingParser.CATCH, 0); }
		public TerminalNode LPAREN() { return getToken(ProcessingParser.LPAREN, 0); }
		public CatchTypeContext catchType() {
			return getRuleContext(CatchTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public TerminalNode RPAREN() { return getToken(ProcessingParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitCatchClause(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_catchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1052);
			match(CATCH);
			setState(1053);
			match(LPAREN);
			setState(1057);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1054);
				variableModifier();
				}
				}
				setState(1059);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1060);
			catchType();
			setState(1061);
			match(IDENTIFIER);
			setState(1062);
			match(RPAREN);
			setState(1063);
			block();
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

	public static class CatchTypeContext extends ParserRuleContext {
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public List<TerminalNode> BITOR() { return getTokens(ProcessingParser.BITOR); }
		public TerminalNode BITOR(int i) {
			return getToken(ProcessingParser.BITOR, i);
		}
		public CatchTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterCatchType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitCatchType(this);
		}
	}

	public final CatchTypeContext catchType() throws RecognitionException {
		CatchTypeContext _localctx = new CatchTypeContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_catchType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1065);
			qualifiedName();
			setState(1070);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITOR) {
				{
				{
				setState(1066);
				match(BITOR);
				setState(1067);
				qualifiedName();
				}
				}
				setState(1072);
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

	public static class FinallyBlockContext extends ParserRuleContext {
		public TerminalNode FINALLY() { return getToken(ProcessingParser.FINALLY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FinallyBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterFinallyBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitFinallyBlock(this);
		}
	}

	public final FinallyBlockContext finallyBlock() throws RecognitionException {
		FinallyBlockContext _localctx = new FinallyBlockContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_finallyBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1073);
			match(FINALLY);
			setState(1074);
			block();
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

	public static class ResourceSpecificationContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ProcessingParser.LPAREN, 0); }
		public ResourcesContext resources() {
			return getRuleContext(ResourcesContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ProcessingParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(ProcessingParser.SEMI, 0); }
		public ResourceSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterResourceSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitResourceSpecification(this);
		}
	}

	public final ResourceSpecificationContext resourceSpecification() throws RecognitionException {
		ResourceSpecificationContext _localctx = new ResourceSpecificationContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_resourceSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1076);
			match(LPAREN);
			setState(1077);
			resources();
			setState(1079);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(1078);
				match(SEMI);
				}
			}

			setState(1081);
			match(RPAREN);
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

	public static class ResourcesContext extends ParserRuleContext {
		public List<ResourceContext> resource() {
			return getRuleContexts(ResourceContext.class);
		}
		public ResourceContext resource(int i) {
			return getRuleContext(ResourceContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(ProcessingParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(ProcessingParser.SEMI, i);
		}
		public ResourcesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resources; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterResources(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitResources(this);
		}
	}

	public final ResourcesContext resources() throws RecognitionException {
		ResourcesContext _localctx = new ResourcesContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_resources);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1083);
			resource();
			setState(1088);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1084);
					match(SEMI);
					setState(1085);
					resource();
					}
					} 
				}
				setState(1090);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
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

	public static class ResourceContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ProcessingParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public ResourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterResource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitResource(this);
		}
	}

	public final ResourceContext resource() throws RecognitionException {
		ResourceContext _localctx = new ResourceContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_resource);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1094);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1091);
				variableModifier();
				}
				}
				setState(1096);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1097);
			classOrInterfaceType();
			setState(1098);
			variableDeclaratorId();
			setState(1099);
			match(ASSIGN);
			setState(1100);
			expression(0);
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

	public static class SwitchBlockStatementGroupContext extends ParserRuleContext {
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public SwitchBlockStatementGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlockStatementGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterSwitchBlockStatementGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitSwitchBlockStatementGroup(this);
		}
	}

	public final SwitchBlockStatementGroupContext switchBlockStatementGroup() throws RecognitionException {
		SwitchBlockStatementGroupContext _localctx = new SwitchBlockStatementGroupContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_switchBlockStatementGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1103); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1102);
				switchLabel();
				}
				}
				setState(1105); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE || _la==DEFAULT );
			setState(1108); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1107);
				blockStatement();
				}
				}
				setState(1110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << HexColorLiteral) | (1L << CHAR_LITERAL) | (1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SUPER) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VAR) | (1L << VOID) | (1L << WHILE) | (1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << OCT_LITERAL) | (1L << BINARY_LITERAL) | (1L << FLOAT_LITERAL) | (1L << HEX_FLOAT_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BOOL_LITERAL - 64)) | (1L << (STRING_LITERAL - 64)) | (1L << (NULL_LITERAL - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (SEMI - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (AT - 64)) | (1L << (IDENTIFIER - 64)))) != 0) );
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

	public static class SwitchLabelContext extends ParserRuleContext {
		public ExpressionContext constantExpression;
		public Token enumConstantName;
		public TerminalNode CASE() { return getToken(ProcessingParser.CASE, 0); }
		public TerminalNode COLON() { return getToken(ProcessingParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public TerminalNode DEFAULT() { return getToken(ProcessingParser.DEFAULT, 0); }
		public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterSwitchLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitSwitchLabel(this);
		}
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_switchLabel);
		try {
			setState(1120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1112);
				match(CASE);
				setState(1115);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
				case 1:
					{
					setState(1113);
					((SwitchLabelContext)_localctx).constantExpression = expression(0);
					}
					break;
				case 2:
					{
					setState(1114);
					((SwitchLabelContext)_localctx).enumConstantName = match(IDENTIFIER);
					}
					break;
				}
				setState(1117);
				match(COLON);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1118);
				match(DEFAULT);
				setState(1119);
				match(COLON);
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

	public static class ForControlContext extends ParserRuleContext {
		public ExpressionListContext forUpdate;
		public EnhancedForControlContext enhancedForControl() {
			return getRuleContext(EnhancedForControlContext.class,0);
		}
		public List<TerminalNode> SEMI() { return getTokens(ProcessingParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(ProcessingParser.SEMI, i);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitForControl(this);
		}
	}

	public final ForControlContext forControl() throws RecognitionException {
		ForControlContext _localctx = new ForControlContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_forControl);
		int _la;
		try {
			setState(1134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1122);
				enhancedForControl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << HexColorLiteral) | (1L << CHAR_LITERAL) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VAR) | (1L << VOID) | (1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << OCT_LITERAL) | (1L << BINARY_LITERAL) | (1L << FLOAT_LITERAL) | (1L << HEX_FLOAT_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BOOL_LITERAL - 64)) | (1L << (STRING_LITERAL - 64)) | (1L << (NULL_LITERAL - 64)) | (1L << (LPAREN - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (AT - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
					{
					setState(1123);
					forInit();
					}
				}

				setState(1126);
				match(SEMI);
				setState(1128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << HexColorLiteral) | (1L << CHAR_LITERAL) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VAR) | (1L << VOID) | (1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << OCT_LITERAL) | (1L << BINARY_LITERAL) | (1L << FLOAT_LITERAL) | (1L << HEX_FLOAT_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BOOL_LITERAL - 64)) | (1L << (STRING_LITERAL - 64)) | (1L << (NULL_LITERAL - 64)) | (1L << (LPAREN - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (AT - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
					{
					setState(1127);
					expression(0);
					}
				}

				setState(1130);
				match(SEMI);
				setState(1132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << HexColorLiteral) | (1L << CHAR_LITERAL) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VAR) | (1L << VOID) | (1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << OCT_LITERAL) | (1L << BINARY_LITERAL) | (1L << FLOAT_LITERAL) | (1L << HEX_FLOAT_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BOOL_LITERAL - 64)) | (1L << (STRING_LITERAL - 64)) | (1L << (NULL_LITERAL - 64)) | (1L << (LPAREN - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (AT - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
					{
					setState(1131);
					((ForControlContext)_localctx).forUpdate = expressionList();
					}
				}

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

	public static class ForInitContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitForInit(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_forInit);
		try {
			setState(1138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1136);
				localVariableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1137);
				expressionList();
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

	public static class EnhancedForControlContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ProcessingParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public EnhancedForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterEnhancedForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitEnhancedForControl(this);
		}
	}

	public final EnhancedForControlContext enhancedForControl() throws RecognitionException {
		EnhancedForControlContext _localctx = new EnhancedForControlContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_enhancedForControl);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1143);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1140);
					variableModifier();
					}
					} 
				}
				setState(1145);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			}
			setState(1146);
			typeType();
			setState(1147);
			variableDeclaratorId();
			setState(1148);
			match(COLON);
			setState(1149);
			expression(0);
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

	public static class ParExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ProcessingParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ProcessingParser.RPAREN, 0); }
		public ParExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterParExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitParExpression(this);
		}
	}

	public final ParExpressionContext parExpression() throws RecognitionException {
		ParExpressionContext _localctx = new ParExpressionContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1151);
			match(LPAREN);
			setState(1152);
			expression(0);
			setState(1153);
			match(RPAREN);
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

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ProcessingParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ProcessingParser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitExpressionList(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1155);
			expression(0);
			setState(1160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1156);
				match(COMMA);
				setState(1157);
				expression(0);
				}
				}
				setState(1162);
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

	public static class ExpressionContext extends ParserRuleContext {
		public Token prefix;
		public Token bop;
		public Token postfix;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public TerminalNode NEW() { return getToken(ProcessingParser.NEW, 0); }
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ProcessingParser.LPAREN, 0); }
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ProcessingParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(ProcessingParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ProcessingParser.SUB, 0); }
		public TerminalNode INC() { return getToken(ProcessingParser.INC, 0); }
		public TerminalNode DEC() { return getToken(ProcessingParser.DEC, 0); }
		public TerminalNode TILDE() { return getToken(ProcessingParser.TILDE, 0); }
		public TerminalNode BANG() { return getToken(ProcessingParser.BANG, 0); }
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public TerminalNode COLONCOLON() { return getToken(ProcessingParser.COLONCOLON, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TerminalNode MUL() { return getToken(ProcessingParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(ProcessingParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(ProcessingParser.MOD, 0); }
		public List<TerminalNode> LT() { return getTokens(ProcessingParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(ProcessingParser.LT, i);
		}
		public List<TerminalNode> GT() { return getTokens(ProcessingParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(ProcessingParser.GT, i);
		}
		public TerminalNode LE() { return getToken(ProcessingParser.LE, 0); }
		public TerminalNode GE() { return getToken(ProcessingParser.GE, 0); }
		public TerminalNode EQUAL() { return getToken(ProcessingParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(ProcessingParser.NOTEQUAL, 0); }
		public TerminalNode BITAND() { return getToken(ProcessingParser.BITAND, 0); }
		public TerminalNode CARET() { return getToken(ProcessingParser.CARET, 0); }
		public TerminalNode BITOR() { return getToken(ProcessingParser.BITOR, 0); }
		public TerminalNode AND() { return getToken(ProcessingParser.AND, 0); }
		public TerminalNode OR() { return getToken(ProcessingParser.OR, 0); }
		public TerminalNode COLON() { return getToken(ProcessingParser.COLON, 0); }
		public TerminalNode QUESTION() { return getToken(ProcessingParser.QUESTION, 0); }
		public TerminalNode ASSIGN() { return getToken(ProcessingParser.ASSIGN, 0); }
		public TerminalNode ADD_ASSIGN() { return getToken(ProcessingParser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(ProcessingParser.SUB_ASSIGN, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(ProcessingParser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(ProcessingParser.DIV_ASSIGN, 0); }
		public TerminalNode AND_ASSIGN() { return getToken(ProcessingParser.AND_ASSIGN, 0); }
		public TerminalNode OR_ASSIGN() { return getToken(ProcessingParser.OR_ASSIGN, 0); }
		public TerminalNode XOR_ASSIGN() { return getToken(ProcessingParser.XOR_ASSIGN, 0); }
		public TerminalNode RSHIFT_ASSIGN() { return getToken(ProcessingParser.RSHIFT_ASSIGN, 0); }
		public TerminalNode URSHIFT_ASSIGN() { return getToken(ProcessingParser.URSHIFT_ASSIGN, 0); }
		public TerminalNode LSHIFT_ASSIGN() { return getToken(ProcessingParser.LSHIFT_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(ProcessingParser.MOD_ASSIGN, 0); }
		public TerminalNode DOT() { return getToken(ProcessingParser.DOT, 0); }
		public TerminalNode THIS() { return getToken(ProcessingParser.THIS, 0); }
		public InnerCreatorContext innerCreator() {
			return getRuleContext(InnerCreatorContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(ProcessingParser.SUPER, 0); }
		public SuperSuffixContext superSuffix() {
			return getRuleContext(SuperSuffixContext.class,0);
		}
		public ExplicitGenericInvocationContext explicitGenericInvocation() {
			return getRuleContext(ExplicitGenericInvocationContext.class,0);
		}
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(ProcessingParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(ProcessingParser.RBRACK, 0); }
		public TerminalNode INSTANCEOF() { return getToken(ProcessingParser.INSTANCEOF, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitExpression(this);
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
		int _startState = 182;
		enterRecursionRule(_localctx, 182, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
			case 1:
				{
				setState(1164);
				primary();
				}
				break;
			case 2:
				{
				setState(1165);
				methodCall();
				}
				break;
			case 3:
				{
				setState(1166);
				match(NEW);
				setState(1167);
				creator();
				}
				break;
			case 4:
				{
				setState(1168);
				match(LPAREN);
				setState(1169);
				typeType();
				setState(1170);
				match(RPAREN);
				setState(1171);
				expression(21);
				}
				break;
			case 5:
				{
				setState(1173);
				((ExpressionContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (INC - 89)) | (1L << (DEC - 89)) | (1L << (ADD - 89)) | (1L << (SUB - 89)))) != 0)) ) {
					((ExpressionContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1174);
				expression(19);
				}
				break;
			case 6:
				{
				setState(1175);
				((ExpressionContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
					((ExpressionContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1176);
				expression(18);
				}
				break;
			case 7:
				{
				setState(1177);
				lambdaExpression();
				}
				break;
			case 8:
				{
				setState(1178);
				typeType();
				setState(1179);
				match(COLONCOLON);
				setState(1185);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LT:
				case IDENTIFIER:
					{
					setState(1181);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LT) {
						{
						setState(1180);
						typeArguments();
						}
					}

					setState(1183);
					match(IDENTIFIER);
					}
					break;
				case NEW:
					{
					setState(1184);
					match(NEW);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 9:
				{
				setState(1187);
				classType();
				setState(1188);
				match(COLONCOLON);
				setState(1190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1189);
					typeArguments();
					}
				}

				setState(1192);
				match(NEW);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,152,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1274);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1196);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(1197);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (MUL - 93)) | (1L << (DIV - 93)) | (1L << (MOD - 93)))) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1198);
						expression(18);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1199);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(1200);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1201);
						expression(17);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1202);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1210);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
						case 1:
							{
							setState(1203);
							match(LT);
							setState(1204);
							match(LT);
							}
							break;
						case 2:
							{
							setState(1205);
							match(GT);
							setState(1206);
							match(GT);
							setState(1207);
							match(GT);
							}
							break;
						case 3:
							{
							setState(1208);
							match(GT);
							setState(1209);
							match(GT);
							}
							break;
						}
						setState(1212);
						expression(16);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1213);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1214);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (GT - 77)) | (1L << (LT - 77)) | (1L << (LE - 77)) | (1L << (GE - 77)))) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1215);
						expression(15);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1216);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1217);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1218);
						expression(13);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1219);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1220);
						((ExpressionContext)_localctx).bop = match(BITAND);
						setState(1221);
						expression(12);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1222);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1223);
						((ExpressionContext)_localctx).bop = match(CARET);
						setState(1224);
						expression(11);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1225);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1226);
						((ExpressionContext)_localctx).bop = match(BITOR);
						setState(1227);
						expression(10);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1228);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1229);
						((ExpressionContext)_localctx).bop = match(AND);
						setState(1230);
						expression(9);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1231);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1232);
						((ExpressionContext)_localctx).bop = match(OR);
						setState(1233);
						expression(8);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1234);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1235);
						((ExpressionContext)_localctx).bop = match(QUESTION);
						setState(1236);
						expression(0);
						setState(1237);
						match(COLON);
						setState(1238);
						expression(7);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1240);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1241);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (ASSIGN - 76)) | (1L << (ADD_ASSIGN - 76)) | (1L << (SUB_ASSIGN - 76)) | (1L << (MUL_ASSIGN - 76)) | (1L << (DIV_ASSIGN - 76)) | (1L << (AND_ASSIGN - 76)) | (1L << (OR_ASSIGN - 76)) | (1L << (XOR_ASSIGN - 76)) | (1L << (MOD_ASSIGN - 76)) | (1L << (LSHIFT_ASSIGN - 76)) | (1L << (RSHIFT_ASSIGN - 76)) | (1L << (URSHIFT_ASSIGN - 76)))) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1242);
						expression(5);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1243);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(1244);
						((ExpressionContext)_localctx).bop = match(DOT);
						setState(1256);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,149,_ctx) ) {
						case 1:
							{
							setState(1245);
							match(IDENTIFIER);
							}
							break;
						case 2:
							{
							setState(1246);
							methodCall();
							}
							break;
						case 3:
							{
							setState(1247);
							match(THIS);
							}
							break;
						case 4:
							{
							setState(1248);
							match(NEW);
							setState(1250);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==LT) {
								{
								setState(1249);
								nonWildcardTypeArguments();
								}
							}

							setState(1252);
							innerCreator();
							}
							break;
						case 5:
							{
							setState(1253);
							match(SUPER);
							setState(1254);
							superSuffix();
							}
							break;
						case 6:
							{
							setState(1255);
							explicitGenericInvocation();
							}
							break;
						}
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1258);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(1259);
						match(LBRACK);
						setState(1260);
						expression(0);
						setState(1261);
						match(RBRACK);
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1263);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(1264);
						((ExpressionContext)_localctx).postfix = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
							((ExpressionContext)_localctx).postfix = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1265);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1266);
						((ExpressionContext)_localctx).bop = match(INSTANCEOF);
						setState(1267);
						typeType();
						}
						break;
					case 17:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1268);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1269);
						match(COLONCOLON);
						setState(1271);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==LT) {
							{
							setState(1270);
							typeArguments();
							}
						}

						setState(1273);
						match(IDENTIFIER);
						}
						break;
					}
					} 
				}
				setState(1278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,152,_ctx);
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

	public static class LambdaExpressionContext extends ParserRuleContext {
		public LambdaParametersContext lambdaParameters() {
			return getRuleContext(LambdaParametersContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(ProcessingParser.ARROW, 0); }
		public LambdaBodyContext lambdaBody() {
			return getRuleContext(LambdaBodyContext.class,0);
		}
		public LambdaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterLambdaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitLambdaExpression(this);
		}
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1279);
			lambdaParameters();
			setState(1280);
			match(ARROW);
			setState(1281);
			lambdaBody();
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

	public static class LambdaParametersContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(ProcessingParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ProcessingParser.IDENTIFIER, i);
		}
		public TerminalNode LPAREN() { return getToken(ProcessingParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ProcessingParser.RPAREN, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ProcessingParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ProcessingParser.COMMA, i);
		}
		public LambdaParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterLambdaParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitLambdaParameters(this);
		}
	}

	public final LambdaParametersContext lambdaParameters() throws RecognitionException {
		LambdaParametersContext _localctx = new LambdaParametersContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_lambdaParameters);
		int _la;
		try {
			setState(1299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1283);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1284);
				match(LPAREN);
				setState(1286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT) | (1L << VAR))) != 0) || _la==AT || _la==IDENTIFIER) {
					{
					setState(1285);
					formalParameterList();
					}
				}

				setState(1288);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1289);
				match(LPAREN);
				setState(1290);
				match(IDENTIFIER);
				setState(1295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1291);
					match(COMMA);
					setState(1292);
					match(IDENTIFIER);
					}
					}
					setState(1297);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1298);
				match(RPAREN);
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

	public static class LambdaBodyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LambdaBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterLambdaBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitLambdaBody(this);
		}
	}

	public final LambdaBodyContext lambdaBody() throws RecognitionException {
		LambdaBodyContext _localctx = new LambdaBodyContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_lambdaBody);
		try {
			setState(1303);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case HexColorLiteral:
			case CHAR_LITERAL:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VAR:
			case VOID:
			case DECIMAL_LITERAL:
			case HEX_LITERAL:
			case OCT_LITERAL:
			case BINARY_LITERAL:
			case FLOAT_LITERAL:
			case HEX_FLOAT_LITERAL:
			case BOOL_LITERAL:
			case STRING_LITERAL:
			case NULL_LITERAL:
			case LPAREN:
			case LT:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case AT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1301);
				expression(0);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1302);
				block();
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

	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ProcessingParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ProcessingParser.RPAREN, 0); }
		public TerminalNode THIS() { return getToken(ProcessingParser.THIS, 0); }
		public TerminalNode SUPER() { return getToken(ProcessingParser.SUPER, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public TypeTypeOrVoidContext typeTypeOrVoid() {
			return getRuleContext(TypeTypeOrVoidContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ProcessingParser.DOT, 0); }
		public TerminalNode CLASS() { return getToken(ProcessingParser.CLASS, 0); }
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() {
			return getRuleContext(ExplicitGenericInvocationSuffixContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_primary);
		try {
			setState(1323);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1305);
				match(LPAREN);
				setState(1306);
				expression(0);
				setState(1307);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1309);
				match(THIS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1310);
				match(SUPER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1311);
				literal();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1312);
				match(IDENTIFIER);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1313);
				typeTypeOrVoid();
				setState(1314);
				match(DOT);
				setState(1315);
				match(CLASS);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1317);
				nonWildcardTypeArguments();
				setState(1321);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SUPER:
				case IDENTIFIER:
					{
					setState(1318);
					explicitGenericInvocationSuffix();
					}
					break;
				case THIS:
					{
					setState(1319);
					match(THIS);
					setState(1320);
					arguments();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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

	public static class ClassTypeContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ProcessingParser.DOT, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitClassType(this);
		}
	}

	public final ClassTypeContext classType() throws RecognitionException {
		ClassTypeContext _localctx = new ClassTypeContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_classType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
			case 1:
				{
				setState(1325);
				classOrInterfaceType();
				setState(1326);
				match(DOT);
				}
				break;
			}
			setState(1333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1330);
				annotation();
				}
				}
				setState(1335);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1336);
			match(IDENTIFIER);
			setState(1338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1337);
				typeArguments();
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

	public static class CreatorContext extends ParserRuleContext {
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public CreatedNameContext createdName() {
			return getRuleContext(CreatedNameContext.class,0);
		}
		public ClassCreatorRestContext classCreatorRest() {
			return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public ArrayCreatorRestContext arrayCreatorRest() {
			return getRuleContext(ArrayCreatorRestContext.class,0);
		}
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitCreator(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_creator);
		try {
			setState(1349);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1340);
				nonWildcardTypeArguments();
				setState(1341);
				createdName();
				setState(1342);
				classCreatorRest();
				}
				break;
			case T__0:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1344);
				createdName();
				setState(1347);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACK:
					{
					setState(1345);
					arrayCreatorRest();
					}
					break;
				case LPAREN:
					{
					setState(1346);
					classCreatorRest();
					}
					break;
				default:
					throw new NoViableAltException(this);
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

	public static class CreatedNameContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(ProcessingParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ProcessingParser.IDENTIFIER, i);
		}
		public List<TypeArgumentsOrDiamondContext> typeArgumentsOrDiamond() {
			return getRuleContexts(TypeArgumentsOrDiamondContext.class);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond(int i) {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(ProcessingParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ProcessingParser.DOT, i);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public CreatedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createdName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterCreatedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitCreatedName(this);
		}
	}

	public final CreatedNameContext createdName() throws RecognitionException {
		CreatedNameContext _localctx = new CreatedNameContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_createdName);
		int _la;
		try {
			setState(1366);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1351);
				match(IDENTIFIER);
				setState(1353);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1352);
					typeArgumentsOrDiamond();
					}
				}

				setState(1362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(1355);
					match(DOT);
					setState(1356);
					match(IDENTIFIER);
					setState(1358);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LT) {
						{
						setState(1357);
						typeArgumentsOrDiamond();
						}
					}

					}
					}
					setState(1364);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__0:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1365);
				primitiveType();
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

	public static class InnerCreatorContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public ClassCreatorRestContext classCreatorRest() {
			return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public NonWildcardTypeArgumentsOrDiamondContext nonWildcardTypeArgumentsOrDiamond() {
			return getRuleContext(NonWildcardTypeArgumentsOrDiamondContext.class,0);
		}
		public InnerCreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerCreator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterInnerCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitInnerCreator(this);
		}
	}

	public final InnerCreatorContext innerCreator() throws RecognitionException {
		InnerCreatorContext _localctx = new InnerCreatorContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_innerCreator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1368);
			match(IDENTIFIER);
			setState(1370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1369);
				nonWildcardTypeArgumentsOrDiamond();
				}
			}

			setState(1372);
			classCreatorRest();
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

	public static class ArrayCreatorRestContext extends ParserRuleContext {
		public List<TerminalNode> LBRACK() { return getTokens(ProcessingParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(ProcessingParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(ProcessingParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(ProcessingParser.RBRACK, i);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreatorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterArrayCreatorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitArrayCreatorRest(this);
		}
	}

	public final ArrayCreatorRestContext arrayCreatorRest() throws RecognitionException {
		ArrayCreatorRestContext _localctx = new ArrayCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_arrayCreatorRest);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1374);
			match(LBRACK);
			setState(1402);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RBRACK:
				{
				setState(1375);
				match(RBRACK);
				setState(1380);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1376);
					match(LBRACK);
					setState(1377);
					match(RBRACK);
					}
					}
					setState(1382);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1383);
				arrayInitializer();
				}
				break;
			case T__0:
			case HexColorLiteral:
			case CHAR_LITERAL:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VAR:
			case VOID:
			case DECIMAL_LITERAL:
			case HEX_LITERAL:
			case OCT_LITERAL:
			case BINARY_LITERAL:
			case FLOAT_LITERAL:
			case HEX_FLOAT_LITERAL:
			case BOOL_LITERAL:
			case STRING_LITERAL:
			case NULL_LITERAL:
			case LPAREN:
			case LT:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case AT:
			case IDENTIFIER:
				{
				setState(1384);
				expression(0);
				setState(1385);
				match(RBRACK);
				setState(1392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,170,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1386);
						match(LBRACK);
						setState(1387);
						expression(0);
						setState(1388);
						match(RBRACK);
						}
						} 
					}
					setState(1394);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,170,_ctx);
				}
				setState(1399);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1395);
						match(LBRACK);
						setState(1396);
						match(RBRACK);
						}
						} 
					}
					setState(1401);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ClassCreatorRestContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classCreatorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterClassCreatorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitClassCreatorRest(this);
		}
	}

	public final ClassCreatorRestContext classCreatorRest() throws RecognitionException {
		ClassCreatorRestContext _localctx = new ClassCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_classCreatorRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1404);
			arguments();
			setState(1406);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
			case 1:
				{
				setState(1405);
				classBody();
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

	public static class ExplicitGenericInvocationContext extends ParserRuleContext {
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() {
			return getRuleContext(ExplicitGenericInvocationSuffixContext.class,0);
		}
		public ExplicitGenericInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitGenericInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterExplicitGenericInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitExplicitGenericInvocation(this);
		}
	}

	public final ExplicitGenericInvocationContext explicitGenericInvocation() throws RecognitionException {
		ExplicitGenericInvocationContext _localctx = new ExplicitGenericInvocationContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_explicitGenericInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1408);
			nonWildcardTypeArguments();
			setState(1409);
			explicitGenericInvocationSuffix();
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

	public static class TypeArgumentsOrDiamondContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(ProcessingParser.LT, 0); }
		public TerminalNode GT() { return getToken(ProcessingParser.GT, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TypeArgumentsOrDiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentsOrDiamond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterTypeArgumentsOrDiamond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitTypeArgumentsOrDiamond(this);
		}
	}

	public final TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() throws RecognitionException {
		TypeArgumentsOrDiamondContext _localctx = new TypeArgumentsOrDiamondContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_typeArgumentsOrDiamond);
		try {
			setState(1414);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1411);
				match(LT);
				setState(1412);
				match(GT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1413);
				typeArguments();
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

	public static class NonWildcardTypeArgumentsOrDiamondContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(ProcessingParser.LT, 0); }
		public TerminalNode GT() { return getToken(ProcessingParser.GT, 0); }
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public NonWildcardTypeArgumentsOrDiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonWildcardTypeArgumentsOrDiamond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterNonWildcardTypeArgumentsOrDiamond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitNonWildcardTypeArgumentsOrDiamond(this);
		}
	}

	public final NonWildcardTypeArgumentsOrDiamondContext nonWildcardTypeArgumentsOrDiamond() throws RecognitionException {
		NonWildcardTypeArgumentsOrDiamondContext _localctx = new NonWildcardTypeArgumentsOrDiamondContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_nonWildcardTypeArgumentsOrDiamond);
		try {
			setState(1419);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,175,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1416);
				match(LT);
				setState(1417);
				match(GT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1418);
				nonWildcardTypeArguments();
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

	public static class NonWildcardTypeArgumentsContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(ProcessingParser.LT, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public TerminalNode GT() { return getToken(ProcessingParser.GT, 0); }
		public NonWildcardTypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonWildcardTypeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterNonWildcardTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitNonWildcardTypeArguments(this);
		}
	}

	public final NonWildcardTypeArgumentsContext nonWildcardTypeArguments() throws RecognitionException {
		NonWildcardTypeArgumentsContext _localctx = new NonWildcardTypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_nonWildcardTypeArguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1421);
			match(LT);
			setState(1422);
			typeList();
			setState(1423);
			match(GT);
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

	public static class TypeListContext extends ParserRuleContext {
		public List<TypeTypeContext> typeType() {
			return getRuleContexts(TypeTypeContext.class);
		}
		public TypeTypeContext typeType(int i) {
			return getRuleContext(TypeTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ProcessingParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ProcessingParser.COMMA, i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitTypeList(this);
		}
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1425);
			typeType();
			setState(1430);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1426);
				match(COMMA);
				setState(1427);
				typeType();
				}
				}
				setState(1432);
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

	public static class TypeTypeContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode VAR() { return getToken(ProcessingParser.VAR, 0); }
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(ProcessingParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(ProcessingParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(ProcessingParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(ProcessingParser.RBRACK, i);
		}
		public TypeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterTypeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitTypeType(this);
		}
	}

	public final TypeTypeContext typeType() throws RecognitionException {
		TypeTypeContext _localctx = new TypeTypeContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_typeType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1434);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT) {
				{
				setState(1433);
				annotation();
				}
			}

			setState(1439);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(1436);
				classOrInterfaceType();
				}
				break;
			case T__0:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				{
				setState(1437);
				primitiveType();
				}
				break;
			case VAR:
				{
				setState(1438);
				match(VAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1445);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,179,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1441);
					match(LBRACK);
					setState(1442);
					match(RBRACK);
					}
					} 
				}
				setState(1447);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,179,_ctx);
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

	public static class TypeArgumentsContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(ProcessingParser.LT, 0); }
		public List<TypeArgumentContext> typeArgument() {
			return getRuleContexts(TypeArgumentContext.class);
		}
		public TypeArgumentContext typeArgument(int i) {
			return getRuleContext(TypeArgumentContext.class,i);
		}
		public TerminalNode GT() { return getToken(ProcessingParser.GT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ProcessingParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ProcessingParser.COMMA, i);
		}
		public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitTypeArguments(this);
		}
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_typeArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1448);
			match(LT);
			setState(1449);
			typeArgument();
			setState(1454);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1450);
				match(COMMA);
				setState(1451);
				typeArgument();
				}
				}
				setState(1456);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1457);
			match(GT);
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

	public static class SuperSuffixContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ProcessingParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public SuperSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterSuperSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitSuperSuffix(this);
		}
	}

	public final SuperSuffixContext superSuffix() throws RecognitionException {
		SuperSuffixContext _localctx = new SuperSuffixContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_superSuffix);
		try {
			setState(1465);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(1459);
				arguments();
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1460);
				match(DOT);
				setState(1461);
				match(IDENTIFIER);
				setState(1463);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
				case 1:
					{
					setState(1462);
					arguments();
					}
					break;
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

	public static class ExplicitGenericInvocationSuffixContext extends ParserRuleContext {
		public TerminalNode SUPER() { return getToken(ProcessingParser.SUPER, 0); }
		public SuperSuffixContext superSuffix() {
			return getRuleContext(SuperSuffixContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ProcessingParser.IDENTIFIER, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExplicitGenericInvocationSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitGenericInvocationSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterExplicitGenericInvocationSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitExplicitGenericInvocationSuffix(this);
		}
	}

	public final ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() throws RecognitionException {
		ExplicitGenericInvocationSuffixContext _localctx = new ExplicitGenericInvocationSuffixContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_explicitGenericInvocationSuffix);
		try {
			setState(1471);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUPER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1467);
				match(SUPER);
				setState(1468);
				superSuffix();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1469);
				match(IDENTIFIER);
				setState(1470);
				arguments();
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

	public static class ArgumentsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ProcessingParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ProcessingParser.RPAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProcessingListener ) ((ProcessingListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1473);
			match(LPAREN);
			setState(1475);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << HexColorLiteral) | (1L << CHAR_LITERAL) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VAR) | (1L << VOID) | (1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << OCT_LITERAL) | (1L << BINARY_LITERAL) | (1L << FLOAT_LITERAL) | (1L << HEX_FLOAT_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BOOL_LITERAL - 64)) | (1L << (STRING_LITERAL - 64)) | (1L << (NULL_LITERAL - 64)) | (1L << (LPAREN - 64)) | (1L << (LT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (AT - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
				{
				setState(1474);
				expressionList();
				}
			}

			setState(1477);
			match(RPAREN);
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
		case 91:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 17);
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		case 8:
			return precpred(_ctx, 8);
		case 9:
			return precpred(_ctx, 7);
		case 10:
			return precpred(_ctx, 6);
		case 11:
			return precpred(_ctx, 5);
		case 12:
			return precpred(_ctx, 25);
		case 13:
			return precpred(_ctx, 24);
		case 14:
			return precpred(_ctx, 20);
		case 15:
			return precpred(_ctx, 13);
		case 16:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3t\u05ca\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\3\2\3\2\3\2\5\2\u00e6\n\2\3\3\5"+
		"\3\u00e9\n\3\3\3\7\3\u00ec\n\3\f\3\16\3\u00ef\13\3\3\3\6\3\u00f2\n\3\r"+
		"\3\16\3\u00f3\3\3\3\3\3\4\3\4\7\4\u00fa\n\4\f\4\16\4\u00fd\13\4\3\4\3"+
		"\4\3\5\3\5\7\5\u0103\n\5\f\5\16\5\u0106\13\5\3\5\3\5\3\6\3\6\3\6\3\6\7"+
		"\6\u010e\n\6\f\6\16\6\u0111\13\6\5\6\u0113\n\6\3\7\3\7\3\7\7\7\u0118\n"+
		"\7\f\7\16\7\u011b\13\7\3\7\3\7\3\b\3\b\3\b\3\b\5\b\u0123\n\b\3\b\3\b\3"+
		"\b\3\b\5\b\u0129\n\b\3\b\3\b\3\b\3\b\5\b\u012f\n\b\3\b\5\b\u0132\n\b\3"+
		"\t\3\t\3\t\5\t\u0137\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5"+
		"\n\u0144\n\n\3\13\3\13\3\f\3\f\5\f\u014a\n\f\3\f\3\f\3\f\5\f\u014f\n\f"+
		"\7\f\u0151\n\f\f\f\16\f\u0154\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u015d"+
		"\n\r\3\16\3\16\3\17\5\17\u0162\n\17\3\17\7\17\u0165\n\17\f\17\16\17\u0168"+
		"\13\17\3\17\7\17\u016b\n\17\f\17\16\17\u016e\13\17\3\17\3\17\3\20\7\20"+
		"\u0173\n\20\f\20\16\20\u0176\13\20\3\20\3\20\3\20\3\20\3\21\3\21\5\21"+
		"\u017e\n\21\3\21\3\21\3\21\5\21\u0183\n\21\3\21\3\21\3\22\7\22\u0188\n"+
		"\22\f\22\16\22\u018b\13\22\3\22\3\22\3\22\3\22\5\22\u0191\n\22\3\22\5"+
		"\22\u0194\n\22\3\23\3\23\3\23\3\23\3\23\5\23\u019b\n\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u01a5\n\24\3\25\3\25\5\25\u01a9\n\25\3"+
		"\26\3\26\3\26\5\26\u01ae\n\26\3\26\3\26\5\26\u01b2\n\26\3\26\3\26\5\26"+
		"\u01b6\n\26\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u01be\n\27\f\27\16\27\u01c1"+
		"\13\27\3\27\3\27\3\30\7\30\u01c6\n\30\f\30\16\30\u01c9\13\30\3\30\3\30"+
		"\3\30\5\30\u01ce\n\30\3\31\3\31\3\31\7\31\u01d3\n\31\f\31\16\31\u01d6"+
		"\13\31\3\32\3\32\3\32\3\32\5\32\u01dc\n\32\3\32\3\32\5\32\u01e0\n\32\3"+
		"\32\5\32\u01e3\n\32\3\32\5\32\u01e6\n\32\3\32\3\32\3\33\3\33\3\33\7\33"+
		"\u01ed\n\33\f\33\16\33\u01f0\13\33\3\34\7\34\u01f3\n\34\f\34\16\34\u01f6"+
		"\13\34\3\34\3\34\5\34\u01fa\n\34\3\34\5\34\u01fd\n\34\3\35\3\35\7\35\u0201"+
		"\n\35\f\35\16\35\u0204\13\35\3\36\3\36\3\36\5\36\u0209\n\36\3\36\3\36"+
		"\5\36\u020d\n\36\3\36\3\36\3\37\3\37\7\37\u0213\n\37\f\37\16\37\u0216"+
		"\13\37\3\37\3\37\3 \3 \7 \u021c\n \f \16 \u021f\13 \3 \3 \3!\3!\3!\5!"+
		"\u0226\n!\3!\3!\7!\u022a\n!\f!\16!\u022d\13!\3!\5!\u0230\n!\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u023b\n\"\3#\3#\3#\3#\3#\7#\u0242\n#\f"+
		"#\16#\u0245\13#\3#\3#\5#\u0249\n#\3#\3#\3$\3$\5$\u024f\n$\3%\3%\5%\u0253"+
		"\n%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3(\5(\u025f\n(\3(\3(\3)\3)\3)\3)\3*"+
		"\7*\u0268\n*\f*\16*\u026b\13*\3*\3*\5*\u026f\n*\3+\3+\3+\3+\3+\3+\3+\5"+
		"+\u0278\n+\3,\3,\3,\3,\7,\u027e\n,\f,\16,\u0281\13,\3,\3,\3-\3-\3-\7-"+
		"\u0288\n-\f-\16-\u028b\13-\3-\3-\3-\3.\7.\u0291\n.\f.\16.\u0294\13.\3"+
		".\3.\3.\7.\u0299\n.\f.\16.\u029c\13.\3.\3.\5.\u02a0\n.\3.\3.\3.\3.\7."+
		"\u02a6\n.\f.\16.\u02a9\13.\3.\3.\5.\u02ad\n.\3.\3.\3/\3/\3/\3/\3/\3/\5"+
		"/\u02b7\n/\3\60\3\60\3\60\3\61\3\61\3\61\7\61\u02bf\n\61\f\61\16\61\u02c2"+
		"\13\61\3\62\3\62\3\62\5\62\u02c7\n\62\3\63\3\63\5\63\u02cb\n\63\3\64\3"+
		"\64\3\64\3\64\7\64\u02d1\n\64\f\64\16\64\u02d4\13\64\3\64\5\64\u02d7\n"+
		"\64\5\64\u02d9\n\64\3\64\3\64\3\65\3\65\5\65\u02df\n\65\3\65\3\65\3\65"+
		"\5\65\u02e4\n\65\7\65\u02e6\n\65\f\65\16\65\u02e9\13\65\3\66\3\66\3\66"+
		"\3\66\5\66\u02ef\n\66\5\66\u02f1\n\66\3\67\3\67\3\67\7\67\u02f6\n\67\f"+
		"\67\16\67\u02f9\13\67\38\38\58\u02fd\n8\38\38\39\39\39\79\u0304\n9\f9"+
		"\169\u0307\139\39\39\59\u030b\n9\39\59\u030e\n9\3:\7:\u0311\n:\f:\16:"+
		"\u0314\13:\3:\3:\3:\3;\7;\u031a\n;\f;\16;\u031d\13;\3;\3;\3;\3;\3<\3<"+
		"\3=\3=\3>\3>\3>\3>\3>\5>\u032c\n>\3>\5>\u032f\n>\3?\3?\3?\7?\u0334\n?"+
		"\f?\16?\u0337\13?\3@\3@\3@\3@\3A\3A\3A\5A\u0340\nA\3B\3B\3B\3B\7B\u0346"+
		"\nB\fB\16B\u0349\13B\5B\u034b\nB\3B\5B\u034e\nB\3B\3B\3C\3C\3C\3C\3C\3"+
		"D\3D\7D\u0359\nD\fD\16D\u035c\13D\3D\3D\3E\7E\u0361\nE\fE\16E\u0364\13"+
		"E\3E\3E\5E\u0368\nE\3F\3F\3F\3F\3F\3F\5F\u0370\nF\3F\3F\5F\u0374\nF\3"+
		"F\3F\5F\u0378\nF\3F\3F\5F\u037c\nF\5F\u037e\nF\3G\3G\5G\u0382\nG\3H\3"+
		"H\3H\3H\5H\u0388\nH\3I\3I\3J\3J\3J\3K\3K\7K\u0391\nK\fK\16K\u0394\13K"+
		"\3K\3K\3L\3L\3L\3L\3L\5L\u039d\nL\3M\7M\u03a0\nM\fM\16M\u03a3\13M\3M\3"+
		"M\3M\3N\7N\u03a9\nN\fN\16N\u03ac\13N\3N\3N\5N\u03b0\nN\3N\5N\u03b3\nN"+
		"\3O\3O\3O\3O\3O\5O\u03ba\nO\3O\3O\3O\3O\3O\3O\3O\5O\u03c3\nO\3O\3O\3O"+
		"\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\6O\u03d8\nO\rO\16O\u03d9"+
		"\3O\5O\u03dd\nO\3O\5O\u03e0\nO\3O\3O\3O\3O\7O\u03e6\nO\fO\16O\u03e9\13"+
		"O\3O\5O\u03ec\nO\3O\3O\3O\3O\7O\u03f2\nO\fO\16O\u03f5\13O\3O\7O\u03f8"+
		"\nO\fO\16O\u03fb\13O\3O\3O\3O\3O\3O\3O\3O\3O\5O\u0405\nO\3O\3O\3O\3O\3"+
		"O\3O\3O\5O\u040e\nO\3O\3O\3O\5O\u0413\nO\3O\3O\3O\3O\3O\3O\3O\3O\5O\u041d"+
		"\nO\3P\3P\3P\7P\u0422\nP\fP\16P\u0425\13P\3P\3P\3P\3P\3P\3Q\3Q\3Q\7Q\u042f"+
		"\nQ\fQ\16Q\u0432\13Q\3R\3R\3R\3S\3S\3S\5S\u043a\nS\3S\3S\3T\3T\3T\7T\u0441"+
		"\nT\fT\16T\u0444\13T\3U\7U\u0447\nU\fU\16U\u044a\13U\3U\3U\3U\3U\3U\3"+
		"V\6V\u0452\nV\rV\16V\u0453\3V\6V\u0457\nV\rV\16V\u0458\3W\3W\3W\5W\u045e"+
		"\nW\3W\3W\3W\5W\u0463\nW\3X\3X\5X\u0467\nX\3X\3X\5X\u046b\nX\3X\3X\5X"+
		"\u046f\nX\5X\u0471\nX\3Y\3Y\5Y\u0475\nY\3Z\7Z\u0478\nZ\fZ\16Z\u047b\13"+
		"Z\3Z\3Z\3Z\3Z\3Z\3[\3[\3[\3[\3\\\3\\\3\\\7\\\u0489\n\\\f\\\16\\\u048c"+
		"\13\\\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\5]\u04a0\n"+
		"]\3]\3]\5]\u04a4\n]\3]\3]\3]\5]\u04a9\n]\3]\3]\5]\u04ad\n]\3]\3]\3]\3"+
		"]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\5]\u04bd\n]\3]\3]\3]\3]\3]\3]\3]\3]\3"+
		"]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3"+
		"]\3]\3]\3]\3]\3]\3]\5]\u04e5\n]\3]\3]\3]\3]\5]\u04eb\n]\3]\3]\3]\3]\3"+
		"]\3]\3]\3]\3]\3]\3]\3]\3]\5]\u04fa\n]\3]\7]\u04fd\n]\f]\16]\u0500\13]"+
		"\3^\3^\3^\3^\3_\3_\3_\5_\u0509\n_\3_\3_\3_\3_\3_\7_\u0510\n_\f_\16_\u0513"+
		"\13_\3_\5_\u0516\n_\3`\3`\5`\u051a\n`\3a\3a\3a\3a\3a\3a\3a\3a\3a\3a\3"+
		"a\3a\3a\3a\3a\3a\5a\u052c\na\5a\u052e\na\3b\3b\3b\5b\u0533\nb\3b\7b\u0536"+
		"\nb\fb\16b\u0539\13b\3b\3b\5b\u053d\nb\3c\3c\3c\3c\3c\3c\3c\5c\u0546\n"+
		"c\5c\u0548\nc\3d\3d\5d\u054c\nd\3d\3d\3d\5d\u0551\nd\7d\u0553\nd\fd\16"+
		"d\u0556\13d\3d\5d\u0559\nd\3e\3e\5e\u055d\ne\3e\3e\3f\3f\3f\3f\7f\u0565"+
		"\nf\ff\16f\u0568\13f\3f\3f\3f\3f\3f\3f\3f\7f\u0571\nf\ff\16f\u0574\13"+
		"f\3f\3f\7f\u0578\nf\ff\16f\u057b\13f\5f\u057d\nf\3g\3g\5g\u0581\ng\3h"+
		"\3h\3h\3i\3i\3i\5i\u0589\ni\3j\3j\3j\5j\u058e\nj\3k\3k\3k\3k\3l\3l\3l"+
		"\7l\u0597\nl\fl\16l\u059a\13l\3m\5m\u059d\nm\3m\3m\3m\5m\u05a2\nm\3m\3"+
		"m\7m\u05a6\nm\fm\16m\u05a9\13m\3n\3n\3n\3n\7n\u05af\nn\fn\16n\u05b2\13"+
		"n\3n\3n\3o\3o\3o\3o\5o\u05ba\no\5o\u05bc\no\3p\3p\3p\3p\5p\u05c2\np\3"+
		"q\3q\5q\u05c6\nq\3q\3q\3q\2\3\u00b8r\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098"+
		"\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0"+
		"\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8"+
		"\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0"+
		"\2\16\b\2\3\3\13\13\r\r\20\20\34\34##\4\2\31\31\60\60\3\2<?\3\2@A\3\2"+
		"[^\3\2QR\4\2_`dd\3\2]^\4\2OPVW\4\2UUXX\4\2NNeo\3\2[\\\2\u0675\2\u00e5"+
		"\3\2\2\2\4\u00e8\3\2\2\2\6\u00fb\3\2\2\2\b\u0104\3\2\2\2\n\u0112\3\2\2"+
		"\2\f\u0114\3\2\2\2\16\u0131\3\2\2\2\20\u0133\3\2\2\2\22\u0143\3\2\2\2"+
		"\24\u0145\3\2\2\2\26\u0149\3\2\2\2\30\u015c\3\2\2\2\32\u015e\3\2\2\2\34"+
		"\u0161\3\2\2\2\36\u0174\3\2\2\2 \u017b\3\2\2\2\"\u0193\3\2\2\2$\u019a"+
		"\3\2\2\2&\u01a4\3\2\2\2(\u01a8\3\2\2\2*\u01aa\3\2\2\2,\u01b9\3\2\2\2."+
		"\u01c7\3\2\2\2\60\u01cf\3\2\2\2\62\u01d7\3\2\2\2\64\u01e9\3\2\2\2\66\u01f4"+
		"\3\2\2\28\u01fe\3\2\2\2:\u0205\3\2\2\2<\u0210\3\2\2\2>\u0219\3\2\2\2@"+
		"\u022f\3\2\2\2B\u023a\3\2\2\2D\u023c\3\2\2\2F\u024e\3\2\2\2H\u0252\3\2"+
		"\2\2J\u0254\3\2\2\2L\u0257\3\2\2\2N\u025a\3\2\2\2P\u0262\3\2\2\2R\u026e"+
		"\3\2\2\2T\u0277\3\2\2\2V\u0279\3\2\2\2X\u0284\3\2\2\2Z\u0292\3\2\2\2\\"+
		"\u02b6\3\2\2\2^\u02b8\3\2\2\2`\u02bb\3\2\2\2b\u02c3\3\2\2\2d\u02ca\3\2"+
		"\2\2f\u02cc\3\2\2\2h\u02dc\3\2\2\2j\u02f0\3\2\2\2l\u02f2\3\2\2\2n\u02fa"+
		"\3\2\2\2p\u030d\3\2\2\2r\u0312\3\2\2\2t\u031b\3\2\2\2v\u0322\3\2\2\2x"+
		"\u0324\3\2\2\2z\u0326\3\2\2\2|\u0330\3\2\2\2~\u0338\3\2\2\2\u0080\u033f"+
		"\3\2\2\2\u0082\u0341\3\2\2\2\u0084\u0351\3\2\2\2\u0086\u0356\3\2\2\2\u0088"+
		"\u0367\3\2\2\2\u008a\u037d\3\2\2\2\u008c\u0381\3\2\2\2\u008e\u0383\3\2"+
		"\2\2\u0090\u0389\3\2\2\2\u0092\u038b\3\2\2\2\u0094\u038e\3\2\2\2\u0096"+
		"\u039c\3\2\2\2\u0098\u03a1\3\2\2\2\u009a\u03b2\3\2\2\2\u009c\u041c\3\2"+
		"\2\2\u009e\u041e\3\2\2\2\u00a0\u042b\3\2\2\2\u00a2\u0433\3\2\2\2\u00a4"+
		"\u0436\3\2\2\2\u00a6\u043d\3\2\2\2\u00a8\u0448\3\2\2\2\u00aa\u0451\3\2"+
		"\2\2\u00ac\u0462\3\2\2\2\u00ae\u0470\3\2\2\2\u00b0\u0474\3\2\2\2\u00b2"+
		"\u0479\3\2\2\2\u00b4\u0481\3\2\2\2\u00b6\u0485\3\2\2\2\u00b8\u04ac\3\2"+
		"\2\2\u00ba\u0501\3\2\2\2\u00bc\u0515\3\2\2\2\u00be\u0519\3\2\2\2\u00c0"+
		"\u052d\3\2\2\2\u00c2\u0532\3\2\2\2\u00c4\u0547\3\2\2\2\u00c6\u0558\3\2"+
		"\2\2\u00c8\u055a\3\2\2\2\u00ca\u0560\3\2\2\2\u00cc\u057e\3\2\2\2\u00ce"+
		"\u0582\3\2\2\2\u00d0\u0588\3\2\2\2\u00d2\u058d\3\2\2\2\u00d4\u058f\3\2"+
		"\2\2\u00d6\u0593\3\2\2\2\u00d8\u059c\3\2\2\2\u00da\u05aa\3\2\2\2\u00dc"+
		"\u05bb\3\2\2\2\u00de\u05c1\3\2\2\2\u00e0\u05c3\3\2\2\2\u00e2\u00e6\5\4"+
		"\3\2\u00e3\u00e6\5\6\4\2\u00e4\u00e6\5\b\5\2\u00e5\u00e2\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6\3\3\2\2\2\u00e7\u00e9\5\36\20"+
		"\2\u00e8\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ed\3\2\2\2\u00ea\u00ec"+
		"\5 \21\2\u00eb\u00ea\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f2\5\""+
		"\22\2\u00f1\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\7\2\2\3\u00f6\5\3\2\2\2"+
		"\u00f7\u00fa\5 \21\2\u00f8\u00fa\5\u0096L\2\u00f9\u00f7\3\2\2\2\u00f9"+
		"\u00f8\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2"+
		"\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\7\2\2\3\u00ff"+
		"\7\3\2\2\2\u0100\u0103\5 \21\2\u0101\u0103\5@!\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0101\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2"+
		"\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0108\7\2\2\3\u0108"+
		"\t\3\2\2\2\u0109\u0113\5\f\7\2\u010a\u010f\7t\2\2\u010b\u010c\7I\2\2\u010c"+
		"\u010e\7J\2\2\u010d\u010b\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2"+
		"\2\2\u010f\u0110\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0112"+
		"\u0109\3\2\2\2\u0112\u010a\3\2\2\2\u0113\13\3\2\2\2\u0114\u0119\5\22\n"+
		"\2\u0115\u0116\7I\2\2\u0116\u0118\7J\2\2\u0117\u0115\3\2\2\2\u0118\u011b"+
		"\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\3\2\2\2\u011b"+
		"\u0119\3\2\2\2\u011c\u011d\b\7\1\2\u011d\r\3\2\2\2\u011e\u0132\5\20\t"+
		"\2\u011f\u0120\7t\2\2\u0120\u0122\7E\2\2\u0121\u0123\5\u00b6\\\2\u0122"+
		"\u0121\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0132\7F"+
		"\2\2\u0125\u0126\7\63\2\2\u0126\u0128\7E\2\2\u0127\u0129\5\u00b6\\\2\u0128"+
		"\u0127\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0132\7F"+
		"\2\2\u012b\u012c\7\60\2\2\u012c\u012e\7E\2\2\u012d\u012f\5\u00b6\\\2\u012e"+
		"\u012d\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0132\7F"+
		"\2\2\u0131\u011e\3\2\2\2\u0131\u011f\3\2\2\2\u0131\u0125\3\2\2\2\u0131"+
		"\u012b\3\2\2\2\u0132\17\3\2\2\2\u0133\u0134\t\2\2\2\u0134\u0136\7E\2\2"+
		"\u0135\u0137\5\u00b6\\\2\u0136\u0135\3\2\2\2\u0136\u0137\3\2\2\2\u0137"+
		"\u0138\3\2\2\2\u0138\u0139\7F\2\2\u0139\21\3\2\2\2\u013a\u0144\7\13\2"+
		"\2\u013b\u0144\7\20\2\2\u013c\u0144\7\r\2\2\u013d\u0144\7-\2\2\u013e\u0144"+
		"\7#\2\2\u013f\u0144\7%\2\2\u0140\u0144\7\34\2\2\u0141\u0144\7\26\2\2\u0142"+
		"\u0144\5\24\13\2\u0143\u013a\3\2\2\2\u0143\u013b\3\2\2\2\u0143\u013c\3"+
		"\2\2\2\u0143\u013d\3\2\2\2\u0143\u013e\3\2\2\2\u0143\u013f\3\2\2\2\u0143"+
		"\u0140\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0142\3\2\2\2\u0144\23\3\2\2"+
		"\2\u0145\u0146\7\3\2\2\u0146\25\3\2\2\2\u0147\u014a\7t\2\2\u0148\u014a"+
		"\5\24\13\2\u0149\u0147\3\2\2\2\u0149\u0148\3\2\2\2\u014a\u0152\3\2\2\2"+
		"\u014b\u014e\7M\2\2\u014c\u014f\7t\2\2\u014d\u014f\5\24\13\2\u014e\u014c"+
		"\3\2\2\2\u014e\u014d\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u014b\3\2\2\2\u0151"+
		"\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\27\3\2\2"+
		"\2\u0154\u0152\3\2\2\2\u0155\u015d\5v<\2\u0156\u015d\5x=\2\u0157\u015d"+
		"\7\b\2\2\u0158\u015d\7C\2\2\u0159\u015d\7B\2\2\u015a\u015d\7D\2\2\u015b"+
		"\u015d\5\32\16\2\u015c\u0155\3\2\2\2\u015c\u0156\3\2\2\2\u015c\u0157\3"+
		"\2\2\2\u015c\u0158\3\2\2\2\u015c\u0159\3\2\2\2\u015c\u015a\3\2\2\2\u015c"+
		"\u015b\3\2\2\2\u015d\31\3\2\2\2\u015e\u015f\7\4\2\2\u015f\33\3\2\2\2\u0160"+
		"\u0162\5\36\20\2\u0161\u0160\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0166\3"+
		"\2\2\2\u0163\u0165\5 \21\2\u0164\u0163\3\2\2\2\u0165\u0168\3\2\2\2\u0166"+
		"\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u016c\3\2\2\2\u0168\u0166\3\2"+
		"\2\2\u0169\u016b\5\"\22\2\u016a\u0169\3\2\2\2\u016b\u016e\3\2\2\2\u016c"+
		"\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016f\3\2\2\2\u016e\u016c\3\2"+
		"\2\2\u016f\u0170\7\2\2\3\u0170\35\3\2\2\2\u0171\u0173\5z>\2\u0172\u0171"+
		"\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175"+
		"\u0177\3\2\2\2\u0176\u0174\3\2\2\2\u0177\u0178\7(\2\2\u0178\u0179\5\26"+
		"\f\2\u0179\u017a\7K\2\2\u017a\37\3\2\2\2\u017b\u017d\7!\2\2\u017c\u017e"+
		"\7.\2\2\u017d\u017c\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f\3\2\2\2\u017f"+
		"\u0182\5\26\f\2\u0180\u0181\7M\2\2\u0181\u0183\7_\2\2\u0182\u0180\3\2"+
		"\2\2\u0182\u0183\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0185\7K\2\2\u0185"+
		"!\3\2\2\2\u0186\u0188\5&\24\2\u0187\u0186\3\2\2\2\u0188\u018b\3\2\2\2"+
		"\u0189\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u0190\3\2\2\2\u018b\u0189"+
		"\3\2\2\2\u018c\u0191\5*\26\2\u018d\u0191\5\62\32\2\u018e\u0191\5:\36\2"+
		"\u018f\u0191\5\u0084C\2\u0190\u018c\3\2\2\2\u0190\u018d\3\2\2\2\u0190"+
		"\u018e\3\2\2\2\u0190\u018f\3\2\2\2\u0191\u0194\3\2\2\2\u0192\u0194\7K"+
		"\2\2\u0193\u0189\3\2\2\2\u0193\u0192\3\2\2\2\u0194#\3\2\2\2\u0195\u019b"+
		"\5&\24\2\u0196\u019b\7&\2\2\u0197\u019b\7\62\2\2\u0198\u019b\7\66\2\2"+
		"\u0199\u019b\7:\2\2\u019a\u0195\3\2\2\2\u019a\u0196\3\2\2\2\u019a\u0197"+
		"\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u0199\3\2\2\2\u019b%\3\2\2\2\u019c"+
		"\u01a5\5z>\2\u019d\u01a5\7+\2\2\u019e\u01a5\7*\2\2\u019f\u01a5\7)\2\2"+
		"\u01a0\u01a5\7.\2\2\u01a1\u01a5\7\t\2\2\u01a2\u01a5\7\32\2\2\u01a3\u01a5"+
		"\7/\2\2\u01a4\u019c\3\2\2\2\u01a4\u019d\3\2\2\2\u01a4\u019e\3\2\2\2\u01a4"+
		"\u019f\3\2\2\2\u01a4\u01a0\3\2\2\2\u01a4\u01a1\3\2\2\2\u01a4\u01a2\3\2"+
		"\2\2\u01a4\u01a3\3\2\2\2\u01a5\'\3\2\2\2\u01a6\u01a9\7\32\2\2\u01a7\u01a9"+
		"\5z>\2\u01a8\u01a6\3\2\2\2\u01a8\u01a7\3\2\2\2\u01a9)\3\2\2\2\u01aa\u01ab"+
		"\7\21\2\2\u01ab\u01ad\7t\2\2\u01ac\u01ae\5,\27\2\u01ad\u01ac\3\2\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae\u01b1\3\2\2\2\u01af\u01b0\7\31\2\2\u01b0\u01b2\5"+
		"\u00d8m\2\u01b1\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b5\3\2\2\2"+
		"\u01b3\u01b4\7 \2\2\u01b4\u01b6\5\u00d6l\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6"+
		"\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b8\5<\37\2\u01b8+\3\2\2\2\u01b9"+
		"\u01ba\7P\2\2\u01ba\u01bf\5.\30\2\u01bb\u01bc\7L\2\2\u01bc\u01be\5.\30"+
		"\2\u01bd\u01bb\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0"+
		"\3\2\2\2\u01c0\u01c2\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01c3\7O\2\2\u01c3"+
		"-\3\2\2\2\u01c4\u01c6\5z>\2\u01c5\u01c4\3\2\2\2\u01c6\u01c9\3\2\2\2\u01c7"+
		"\u01c5\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01ca\3\2\2\2\u01c9\u01c7\3\2"+
		"\2\2\u01ca\u01cd\7t\2\2\u01cb\u01cc\7\31\2\2\u01cc\u01ce\5\60\31\2\u01cd"+
		"\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce/\3\2\2\2\u01cf\u01d4\5\u00d8"+
		"m\2\u01d0\u01d1\7a\2\2\u01d1\u01d3\5\u00d8m\2\u01d2\u01d0\3\2\2\2\u01d3"+
		"\u01d6\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\61\3\2\2"+
		"\2\u01d6\u01d4\3\2\2\2\u01d7\u01d8\7\30\2\2\u01d8\u01db\7t\2\2\u01d9\u01da"+
		"\7 \2\2\u01da\u01dc\5\u00d6l\2\u01db\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2"+
		"\u01dc\u01dd\3\2\2\2\u01dd\u01df\7G\2\2\u01de\u01e0\5\64\33\2\u01df\u01de"+
		"\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e2\3\2\2\2\u01e1\u01e3\7L\2\2\u01e2"+
		"\u01e1\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e5\3\2\2\2\u01e4\u01e6\58"+
		"\35\2\u01e5\u01e4\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7"+
		"\u01e8\7H\2\2\u01e8\63\3\2\2\2\u01e9\u01ee\5\66\34\2\u01ea\u01eb\7L\2"+
		"\2\u01eb\u01ed\5\66\34\2\u01ec\u01ea\3\2\2\2\u01ed\u01f0\3\2\2\2\u01ee"+
		"\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\65\3\2\2\2\u01f0\u01ee\3\2\2"+
		"\2\u01f1\u01f3\5z>\2\u01f2\u01f1\3\2\2\2\u01f3\u01f6\3\2\2\2\u01f4\u01f2"+
		"\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f7\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f7"+
		"\u01f9\7t\2\2\u01f8\u01fa\5\u00e0q\2\u01f9\u01f8\3\2\2\2\u01f9\u01fa\3"+
		"\2\2\2\u01fa\u01fc\3\2\2\2\u01fb\u01fd\5<\37\2\u01fc\u01fb\3\2\2\2\u01fc"+
		"\u01fd\3\2\2\2\u01fd\67\3\2\2\2\u01fe\u0202\7K\2\2\u01ff\u0201\5@!\2\u0200"+
		"\u01ff\3\2\2\2\u0201\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0202\u0203\3\2"+
		"\2\2\u02039\3\2\2\2\u0204\u0202\3\2\2\2\u0205\u0206\7$\2\2\u0206\u0208"+
		"\7t\2\2\u0207\u0209\5,\27\2\u0208\u0207\3\2\2\2\u0208\u0209\3\2\2\2\u0209"+
		"\u020c\3\2\2\2\u020a\u020b\7\31\2\2\u020b\u020d\5\u00d6l\2\u020c\u020a"+
		"\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u020f\5> \2\u020f"+
		";\3\2\2\2\u0210\u0214\7G\2\2\u0211\u0213\5@!\2\u0212\u0211\3\2\2\2\u0213"+
		"\u0216\3\2\2\2\u0214\u0212\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0217\3\2"+
		"\2\2\u0216\u0214\3\2\2\2\u0217\u0218\7H\2\2\u0218=\3\2\2\2\u0219\u021d"+
		"\7G\2\2\u021a\u021c\5R*\2\u021b\u021a\3\2\2\2\u021c\u021f\3\2\2\2\u021d"+
		"\u021b\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u0220\3\2\2\2\u021f\u021d\3\2"+
		"\2\2\u0220\u0221\7H\2\2\u0221?\3\2\2\2\u0222\u0230\7K\2\2\u0223\u0230"+
		"\5 \21\2\u0224\u0226\7.\2\2\u0225\u0224\3\2\2\2\u0225\u0226\3\2\2\2\u0226"+
		"\u0227\3\2\2\2\u0227\u0230\5\u0094K\2\u0228\u022a\5$\23\2\u0229\u0228"+
		"\3\2\2\2\u022a\u022d\3\2\2\2\u022b\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c"+
		"\u022e\3\2\2\2\u022d\u022b\3\2\2\2\u022e\u0230\5B\"\2\u022f\u0222\3\2"+
		"\2\2\u022f\u0223\3\2\2\2\u022f\u0225\3\2\2\2\u022f\u022b\3\2\2\2\u0230"+
		"A\3\2\2\2\u0231\u023b\5D#\2\u0232\u023b\5J&\2\u0233\u023b\5P)\2\u0234"+
		"\u023b\5N(\2\u0235\u023b\5L\'\2\u0236\u023b\5:\36\2\u0237\u023b\5\u0084"+
		"C\2\u0238\u023b\5*\26\2\u0239\u023b\5\62\32\2\u023a\u0231\3\2\2\2\u023a"+
		"\u0232\3\2\2\2\u023a\u0233\3\2\2\2\u023a\u0234\3\2\2\2\u023a\u0235\3\2"+
		"\2\2\u023a\u0236\3\2\2\2\u023a\u0237\3\2\2\2\u023a\u0238\3\2\2\2\u023a"+
		"\u0239\3\2\2\2\u023bC\3\2\2\2\u023c\u023d\5H%\2\u023d\u023e\7t\2\2\u023e"+
		"\u0243\5n8\2\u023f\u0240\7I\2\2\u0240\u0242\7J\2\2\u0241\u023f\3\2\2\2"+
		"\u0242\u0245\3\2\2\2\u0243\u0241\3\2\2\2\u0243\u0244\3\2\2\2\u0244\u0248"+
		"\3\2\2\2\u0245\u0243\3\2\2\2\u0246\u0247\7\65\2\2\u0247\u0249\5l\67\2"+
		"\u0248\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u024b"+
		"\5F$\2\u024bE\3\2\2\2\u024c\u024f\5\u0094K\2\u024d\u024f\7K\2\2\u024e"+
		"\u024c\3\2\2\2\u024e\u024d\3\2\2\2\u024fG\3\2\2\2\u0250\u0253\5\u00d8"+
		"m\2\u0251\u0253\79\2\2\u0252\u0250\3\2\2\2\u0252\u0251\3\2\2\2\u0253I"+
		"\3\2\2\2\u0254\u0255\5,\27\2\u0255\u0256\5D#\2\u0256K\3\2\2\2\u0257\u0258"+
		"\5,\27\2\u0258\u0259\5N(\2\u0259M\3\2\2\2\u025a\u025b\7t\2\2\u025b\u025e"+
		"\5n8\2\u025c\u025d\7\65\2\2\u025d\u025f\5l\67\2\u025e\u025c\3\2\2\2\u025e"+
		"\u025f\3\2\2\2\u025f\u0260\3\2\2\2\u0260\u0261\5\u0094K\2\u0261O\3\2\2"+
		"\2\u0262\u0263\5\u00d8m\2\u0263\u0264\5`\61\2\u0264\u0265\7K\2\2\u0265"+
		"Q\3\2\2\2\u0266\u0268\5$\23\2\u0267\u0266\3\2\2\2\u0268\u026b\3\2\2\2"+
		"\u0269\u0267\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u026c\3\2\2\2\u026b\u0269"+
		"\3\2\2\2\u026c\u026f\5T+\2\u026d\u026f\7K\2\2\u026e\u0269\3\2\2\2\u026e"+
		"\u026d\3\2\2\2\u026fS\3\2\2\2\u0270\u0278\5V,\2\u0271\u0278\5Z.\2\u0272"+
		"\u0278\5^\60\2\u0273\u0278\5:\36\2\u0274\u0278\5\u0084C\2\u0275\u0278"+
		"\5*\26\2\u0276\u0278\5\62\32\2\u0277\u0270\3\2\2\2\u0277\u0271\3\2\2\2"+
		"\u0277\u0272\3\2\2\2\u0277\u0273\3\2\2\2\u0277\u0274\3\2\2\2\u0277\u0275"+
		"\3\2\2\2\u0277\u0276\3\2\2\2\u0278U\3\2\2\2\u0279\u027a\5\u00d8m\2\u027a"+
		"\u027f\5X-\2\u027b\u027c\7L\2\2\u027c\u027e\5X-\2\u027d\u027b\3\2\2\2"+
		"\u027e\u0281\3\2\2\2\u027f\u027d\3\2\2\2\u027f\u0280\3\2\2\2\u0280\u0282"+
		"\3\2\2\2\u0281\u027f\3\2\2\2\u0282\u0283\7K\2\2\u0283W\3\2\2\2\u0284\u0289"+
		"\7t\2\2\u0285\u0286\7I\2\2\u0286\u0288\7J\2\2\u0287\u0285\3\2\2\2\u0288"+
		"\u028b\3\2\2\2\u0289\u0287\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028c\3\2"+
		"\2\2\u028b\u0289\3\2\2\2\u028c\u028d\7N\2\2\u028d\u028e\5d\63\2\u028e"+
		"Y\3\2\2\2\u028f\u0291\5\\/\2\u0290\u028f\3\2\2\2\u0291\u0294\3\2\2\2\u0292"+
		"\u0290\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u029f\3\2\2\2\u0294\u0292\3\2"+
		"\2\2\u0295\u02a0\5H%\2\u0296\u029a\5,\27\2\u0297\u0299\5z>\2\u0298\u0297"+
		"\3\2\2\2\u0299\u029c\3\2\2\2\u029a\u0298\3\2\2\2\u029a\u029b\3\2\2\2\u029b"+
		"\u029d\3\2\2\2\u029c\u029a\3\2\2\2\u029d\u029e\5H%\2\u029e\u02a0\3\2\2"+
		"\2\u029f\u0295\3\2\2\2\u029f\u0296\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02a2"+
		"\7t\2\2\u02a2\u02a7\5n8\2\u02a3\u02a4\7I\2\2\u02a4\u02a6\7J\2\2\u02a5"+
		"\u02a3\3\2\2\2\u02a6\u02a9\3\2\2\2\u02a7\u02a5\3\2\2\2\u02a7\u02a8\3\2"+
		"\2\2\u02a8\u02ac\3\2\2\2\u02a9\u02a7\3\2\2\2\u02aa\u02ab\7\65\2\2\u02ab"+
		"\u02ad\5l\67\2\u02ac\u02aa\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02ae\3\2"+
		"\2\2\u02ae\u02af\5F$\2\u02af[\3\2\2\2\u02b0\u02b7\5z>\2\u02b1\u02b7\7"+
		"+\2\2\u02b2\u02b7\7\t\2\2\u02b3\u02b7\7\24\2\2\u02b4\u02b7\7.\2\2\u02b5"+
		"\u02b7\7/\2\2\u02b6\u02b0\3\2\2\2\u02b6\u02b1\3\2\2\2\u02b6\u02b2\3\2"+
		"\2\2\u02b6\u02b3\3\2\2\2\u02b6\u02b4\3\2\2\2\u02b6\u02b5\3\2\2\2\u02b7"+
		"]\3\2\2\2\u02b8\u02b9\5,\27\2\u02b9\u02ba\5Z.\2\u02ba_\3\2\2\2\u02bb\u02c0"+
		"\5b\62\2\u02bc\u02bd\7L\2\2\u02bd\u02bf\5b\62\2\u02be\u02bc\3\2\2\2\u02bf"+
		"\u02c2\3\2\2\2\u02c0\u02be\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1a\3\2\2\2"+
		"\u02c2\u02c0\3\2\2\2\u02c3\u02c6\5\n\6\2\u02c4\u02c5\7N\2\2\u02c5\u02c7"+
		"\5d\63\2\u02c6\u02c4\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7c\3\2\2\2\u02c8"+
		"\u02cb\5f\64\2\u02c9\u02cb\5\u00b8]\2\u02ca\u02c8\3\2\2\2\u02ca\u02c9"+
		"\3\2\2\2\u02cbe\3\2\2\2\u02cc\u02d8\7G\2\2\u02cd\u02d2\5d\63\2\u02ce\u02cf"+
		"\7L\2\2\u02cf\u02d1\5d\63\2\u02d0\u02ce\3\2\2\2\u02d1\u02d4\3\2\2\2\u02d2"+
		"\u02d0\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3\u02d6\3\2\2\2\u02d4\u02d2\3\2"+
		"\2\2\u02d5\u02d7\7L\2\2\u02d6\u02d5\3\2\2\2\u02d6\u02d7\3\2\2\2\u02d7"+
		"\u02d9\3\2\2\2\u02d8\u02cd\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02da\3\2"+
		"\2\2\u02da\u02db\7H\2\2\u02dbg\3\2\2\2\u02dc\u02de\7t\2\2\u02dd\u02df"+
		"\5\u00dan\2\u02de\u02dd\3\2\2\2\u02de\u02df\3\2\2\2\u02df\u02e7\3\2\2"+
		"\2\u02e0\u02e1\7M\2\2\u02e1\u02e3\7t\2\2\u02e2\u02e4\5\u00dan\2\u02e3"+
		"\u02e2\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e6\3\2\2\2\u02e5\u02e0\3\2"+
		"\2\2\u02e6\u02e9\3\2\2\2\u02e7\u02e5\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8"+
		"i\3\2\2\2\u02e9\u02e7\3\2\2\2\u02ea\u02f1\5\u00d8m\2\u02eb\u02ee\7S\2"+
		"\2\u02ec\u02ed\t\3\2\2\u02ed\u02ef\5\u00d8m\2\u02ee\u02ec\3\2\2\2\u02ee"+
		"\u02ef\3\2\2\2\u02ef\u02f1\3\2\2\2\u02f0\u02ea\3\2\2\2\u02f0\u02eb\3\2"+
		"\2\2\u02f1k\3\2\2\2\u02f2\u02f7\5\26\f\2\u02f3\u02f4\7L\2\2\u02f4\u02f6"+
		"\5\26\f\2\u02f5\u02f3\3\2\2\2\u02f6\u02f9\3\2\2\2\u02f7\u02f5\3\2\2\2"+
		"\u02f7\u02f8\3\2\2\2\u02f8m\3\2\2\2\u02f9\u02f7\3\2\2\2\u02fa\u02fc\7"+
		"E\2\2\u02fb\u02fd\5p9\2\u02fc\u02fb\3\2\2\2\u02fc\u02fd\3\2\2\2\u02fd"+
		"\u02fe\3\2\2\2\u02fe\u02ff\7F\2\2\u02ffo\3\2\2\2\u0300\u0305\5r:\2\u0301"+
		"\u0302\7L\2\2\u0302\u0304\5r:\2\u0303\u0301\3\2\2\2\u0304\u0307\3\2\2"+
		"\2\u0305\u0303\3\2\2\2\u0305\u0306\3\2\2\2\u0306\u030a\3\2\2\2\u0307\u0305"+
		"\3\2\2\2\u0308\u0309\7L\2\2\u0309\u030b\5t;\2\u030a\u0308\3\2\2\2\u030a"+
		"\u030b\3\2\2\2\u030b\u030e\3\2\2\2\u030c\u030e\5t;\2\u030d\u0300\3\2\2"+
		"\2\u030d\u030c\3\2\2\2\u030eq\3\2\2\2\u030f\u0311\5(\25\2\u0310\u030f"+
		"\3\2\2\2\u0311\u0314\3\2\2\2\u0312\u0310\3\2\2\2\u0312\u0313\3\2\2\2\u0313"+
		"\u0315\3\2\2\2\u0314\u0312\3\2\2\2\u0315\u0316\5\u00d8m\2\u0316\u0317"+
		"\5\n\6\2\u0317s\3\2\2\2\u0318\u031a\5(\25\2\u0319\u0318\3\2\2\2\u031a"+
		"\u031d\3\2\2\2\u031b\u0319\3\2\2\2\u031b\u031c\3\2\2\2\u031c\u031e\3\2"+
		"\2\2\u031d\u031b\3\2\2\2\u031e\u031f\5\u00d8m\2\u031f\u0320\7s\2\2\u0320"+
		"\u0321\5\n\6\2\u0321u\3\2\2\2\u0322\u0323\t\4\2\2\u0323w\3\2\2\2\u0324"+
		"\u0325\t\5\2\2\u0325y\3\2\2\2\u0326\u0327\7r\2\2\u0327\u032e\5\26\f\2"+
		"\u0328\u032b\7E\2\2\u0329\u032c\5|?\2\u032a\u032c\5\u0080A\2\u032b\u0329"+
		"\3\2\2\2\u032b\u032a\3\2\2\2\u032b\u032c\3\2\2\2\u032c\u032d\3\2\2\2\u032d"+
		"\u032f\7F\2\2\u032e\u0328\3\2\2\2\u032e\u032f\3\2\2\2\u032f{\3\2\2\2\u0330"+
		"\u0335\5~@\2\u0331\u0332\7L\2\2\u0332\u0334\5~@\2\u0333\u0331\3\2\2\2"+
		"\u0334\u0337\3\2\2\2\u0335\u0333\3\2\2\2\u0335\u0336\3\2\2\2\u0336}\3"+
		"\2\2\2\u0337\u0335\3\2\2\2\u0338\u0339\7t\2\2\u0339\u033a\7N\2\2\u033a"+
		"\u033b\5\u0080A\2\u033b\177\3\2\2\2\u033c\u0340\5\u00b8]\2\u033d\u0340"+
		"\5z>\2\u033e\u0340\5\u0082B\2\u033f\u033c\3\2\2\2\u033f\u033d\3\2\2\2"+
		"\u033f\u033e\3\2\2\2\u0340\u0081\3\2\2\2\u0341\u034a\7G\2\2\u0342\u0347"+
		"\5\u0080A\2\u0343\u0344\7L\2\2\u0344\u0346\5\u0080A\2\u0345\u0343\3\2"+
		"\2\2\u0346\u0349\3\2\2\2\u0347\u0345\3\2\2\2\u0347\u0348\3\2\2\2\u0348"+
		"\u034b\3\2\2\2\u0349\u0347\3\2\2\2\u034a\u0342\3\2\2\2\u034a\u034b\3\2"+
		"\2\2\u034b\u034d\3\2\2\2\u034c\u034e\7L\2\2\u034d\u034c\3\2\2\2\u034d"+
		"\u034e\3\2\2\2\u034e\u034f\3\2\2\2\u034f\u0350\7H\2\2\u0350\u0083\3\2"+
		"\2\2\u0351\u0352\7r\2\2\u0352\u0353\7$\2\2\u0353\u0354\7t\2\2\u0354\u0355"+
		"\5\u0086D\2\u0355\u0085\3\2\2\2\u0356\u035a\7G\2\2\u0357\u0359\5\u0088"+
		"E\2\u0358\u0357\3\2\2\2\u0359\u035c\3\2\2\2\u035a\u0358\3\2\2\2\u035a"+
		"\u035b\3\2\2\2\u035b\u035d\3\2\2\2\u035c\u035a\3\2\2\2\u035d\u035e\7H"+
		"\2\2\u035e\u0087\3\2\2\2\u035f\u0361\5$\23\2\u0360\u035f\3\2\2\2\u0361"+
		"\u0364\3\2\2\2\u0362\u0360\3\2\2\2\u0362\u0363\3\2\2\2\u0363\u0365\3\2"+
		"\2\2\u0364\u0362\3\2\2\2\u0365\u0368\5\u008aF\2\u0366\u0368\7K\2\2\u0367"+
		"\u0362\3\2\2\2\u0367\u0366\3\2\2\2\u0368\u0089\3\2\2\2\u0369\u036a\5\u00d8"+
		"m\2\u036a\u036b\5\u008cG\2\u036b\u036c\7K\2\2\u036c\u037e\3\2\2\2\u036d"+
		"\u036f\5*\26\2\u036e\u0370\7K\2\2\u036f\u036e\3\2\2\2\u036f\u0370\3\2"+
		"\2\2\u0370\u037e\3\2\2\2\u0371\u0373\5:\36\2\u0372\u0374\7K\2\2\u0373"+
		"\u0372\3\2\2\2\u0373\u0374\3\2\2\2\u0374\u037e\3\2\2\2\u0375\u0377\5\62"+
		"\32\2\u0376\u0378\7K\2\2\u0377\u0376\3\2\2\2\u0377\u0378\3\2\2\2\u0378"+
		"\u037e\3\2\2\2\u0379\u037b\5\u0084C\2\u037a\u037c\7K\2\2\u037b\u037a\3"+
		"\2\2\2\u037b\u037c\3\2\2\2\u037c\u037e\3\2\2\2\u037d\u0369\3\2\2\2\u037d"+
		"\u036d\3\2\2\2\u037d\u0371\3\2\2\2\u037d\u0375\3\2\2\2\u037d\u0379\3\2"+
		"\2\2\u037e\u008b\3\2\2\2\u037f\u0382\5\u008eH\2\u0380\u0382\5\u0090I\2"+
		"\u0381\u037f\3\2\2\2\u0381\u0380\3\2\2\2\u0382\u008d\3\2\2\2\u0383\u0384"+
		"\7t\2\2\u0384\u0385\7E\2\2\u0385\u0387\7F\2\2\u0386\u0388\5\u0092J\2\u0387"+
		"\u0386\3\2\2\2\u0387\u0388\3\2\2\2\u0388\u008f\3\2\2\2\u0389\u038a\5`"+
		"\61\2\u038a\u0091\3\2\2\2\u038b\u038c\7\24\2\2\u038c\u038d\5\u0080A\2"+
		"\u038d\u0093\3\2\2\2\u038e\u0392\7G\2\2\u038f\u0391\5\u0096L\2\u0390\u038f"+
		"\3\2\2\2\u0391\u0394\3\2\2\2\u0392\u0390\3\2\2\2\u0392\u0393\3\2\2\2\u0393"+
		"\u0395\3\2\2\2\u0394\u0392\3\2\2\2\u0395\u0396\7H\2\2\u0396\u0095\3\2"+
		"\2\2\u0397\u0398\5\u0098M\2\u0398\u0399\7K\2\2\u0399\u039d\3\2\2\2\u039a"+
		"\u039d\5\u009cO\2\u039b\u039d\5\u009aN\2\u039c\u0397\3\2\2\2\u039c\u039a"+
		"\3\2\2\2\u039c\u039b\3\2\2\2\u039d\u0097\3\2\2\2\u039e\u03a0\5(\25\2\u039f"+
		"\u039e\3\2\2\2\u03a0\u03a3\3\2\2\2\u03a1\u039f\3\2\2\2\u03a1\u03a2\3\2"+
		"\2\2\u03a2\u03a4\3\2\2\2\u03a3\u03a1\3\2\2\2\u03a4\u03a5\5\u00d8m\2\u03a5"+
		"\u03a6\5`\61\2\u03a6\u0099\3\2\2\2\u03a7\u03a9\5&\24\2\u03a8\u03a7\3\2"+
		"\2\2\u03a9\u03ac\3\2\2\2\u03aa\u03a8\3\2\2\2\u03aa\u03ab\3\2\2\2\u03ab"+
		"\u03af\3\2\2\2\u03ac\u03aa\3\2\2\2\u03ad\u03b0\5*\26\2\u03ae\u03b0\5:"+
		"\36\2\u03af\u03ad\3\2\2\2\u03af\u03ae\3\2\2\2\u03b0\u03b3\3\2\2\2\u03b1"+
		"\u03b3\7K\2\2\u03b2\u03aa\3\2\2\2\u03b2\u03b1\3\2\2\2\u03b3\u009b\3\2"+
		"\2\2\u03b4\u041d\5\u0094K\2\u03b5\u03b6\7\n\2\2\u03b6\u03b9\5\u00b8]\2"+
		"\u03b7\u03b8\7T\2\2\u03b8\u03ba\5\u00b8]\2\u03b9\u03b7\3\2\2\2\u03b9\u03ba"+
		"\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb\u03bc\7K\2\2\u03bc\u041d\3\2\2\2\u03bd"+
		"\u03be\7\36\2\2\u03be\u03bf\5\u00b4[\2\u03bf\u03c2\5\u009cO\2\u03c0\u03c1"+
		"\7\27\2\2\u03c1\u03c3\5\u009cO\2\u03c2\u03c0\3\2\2\2\u03c2\u03c3\3\2\2"+
		"\2\u03c3\u041d\3\2\2\2\u03c4\u03c5\7\35\2\2\u03c5\u03c6\7E\2\2\u03c6\u03c7"+
		"\5\u00aeX\2\u03c7\u03c8\7F\2\2\u03c8\u03c9\5\u009cO\2\u03c9\u041d\3\2"+
		"\2\2\u03ca\u03cb\7;\2\2\u03cb\u03cc\5\u00b4[\2\u03cc\u03cd\5\u009cO\2"+
		"\u03cd\u041d\3\2\2\2\u03ce\u03cf\7\25\2\2\u03cf\u03d0\5\u009cO\2\u03d0"+
		"\u03d1\7;\2\2\u03d1\u03d2\5\u00b4[\2\u03d2\u03d3\7K\2\2\u03d3\u041d\3"+
		"\2\2\2\u03d4\u03d5\7\67\2\2\u03d5\u03df\5\u0094K\2\u03d6\u03d8\5\u009e"+
		"P\2\u03d7\u03d6\3\2\2\2\u03d8\u03d9\3\2\2\2\u03d9\u03d7\3\2\2\2\u03d9"+
		"\u03da\3\2\2\2\u03da\u03dc\3\2\2\2\u03db\u03dd\5\u00a2R\2\u03dc\u03db"+
		"\3\2\2\2\u03dc\u03dd\3\2\2\2\u03dd\u03e0\3\2\2\2\u03de\u03e0\5\u00a2R"+
		"\2\u03df\u03d7\3\2\2\2\u03df\u03de\3\2\2\2\u03e0\u041d\3\2\2\2\u03e1\u03e2"+
		"\7\67\2\2\u03e2\u03e3\5\u00a4S\2\u03e3\u03e7\5\u0094K\2\u03e4\u03e6\5"+
		"\u009eP\2\u03e5\u03e4\3\2\2\2\u03e6\u03e9\3\2\2\2\u03e7\u03e5\3\2\2\2"+
		"\u03e7\u03e8\3\2\2\2\u03e8\u03eb\3\2\2\2\u03e9\u03e7\3\2\2\2\u03ea\u03ec"+
		"\5\u00a2R\2\u03eb\u03ea\3\2\2\2\u03eb\u03ec\3\2\2\2\u03ec\u041d\3\2\2"+
		"\2\u03ed\u03ee\7\61\2\2\u03ee\u03ef\5\u00b4[\2\u03ef\u03f3\7G\2\2\u03f0"+
		"\u03f2\5\u00aaV\2\u03f1\u03f0\3\2\2\2\u03f2\u03f5\3\2\2\2\u03f3\u03f1"+
		"\3\2\2\2\u03f3\u03f4\3\2\2\2\u03f4\u03f9\3\2\2\2\u03f5\u03f3\3\2\2\2\u03f6"+
		"\u03f8\5\u00acW\2\u03f7\u03f6\3\2\2\2\u03f8\u03fb\3\2\2\2\u03f9\u03f7"+
		"\3\2\2\2\u03f9\u03fa\3\2\2\2\u03fa\u03fc\3\2\2\2\u03fb\u03f9\3\2\2\2\u03fc"+
		"\u03fd\7H\2\2\u03fd\u041d\3\2\2\2\u03fe\u03ff\7\62\2\2\u03ff\u0400\5\u00b4"+
		"[\2\u0400\u0401\5\u0094K\2\u0401\u041d\3\2\2\2\u0402\u0404\7,\2\2\u0403"+
		"\u0405\5\u00b8]\2\u0404\u0403\3\2\2\2\u0404\u0405\3\2\2\2\u0405\u0406"+
		"\3\2\2\2\u0406\u041d\7K\2\2\u0407\u0408\7\64\2\2\u0408\u0409\5\u00b8]"+
		"\2\u0409\u040a\7K\2\2\u040a\u041d\3\2\2\2\u040b\u040d\7\f\2\2\u040c\u040e"+
		"\7t\2\2\u040d\u040c\3\2\2\2\u040d\u040e\3\2\2\2\u040e\u040f\3\2\2\2\u040f"+
		"\u041d\7K\2\2\u0410\u0412\7\23\2\2\u0411\u0413\7t\2\2\u0412\u0411\3\2"+
		"\2\2\u0412\u0413\3\2\2\2\u0413\u0414\3\2\2\2\u0414\u041d\7K\2\2\u0415"+
		"\u041d\7K\2\2\u0416\u0417\5\u00b8]\2\u0417\u0418\7K\2\2\u0418\u041d\3"+
		"\2\2\2\u0419\u041a\7t\2\2\u041a\u041b\7T\2\2\u041b\u041d\5\u009cO\2\u041c"+
		"\u03b4\3\2\2\2\u041c\u03b5\3\2\2\2\u041c\u03bd\3\2\2\2\u041c\u03c4\3\2"+
		"\2\2\u041c\u03ca\3\2\2\2\u041c\u03ce\3\2\2\2\u041c\u03d4\3\2\2\2\u041c"+
		"\u03e1\3\2\2\2\u041c\u03ed\3\2\2\2\u041c\u03fe\3\2\2\2\u041c\u0402\3\2"+
		"\2\2\u041c\u0407\3\2\2\2\u041c\u040b\3\2\2\2\u041c\u0410\3\2\2\2\u041c"+
		"\u0415\3\2\2\2\u041c\u0416\3\2\2\2\u041c\u0419\3\2\2\2\u041d\u009d\3\2"+
		"\2\2\u041e\u041f\7\17\2\2\u041f\u0423\7E\2\2\u0420\u0422\5(\25\2\u0421"+
		"\u0420\3\2\2\2\u0422\u0425\3\2\2\2\u0423\u0421\3\2\2\2\u0423\u0424\3\2"+
		"\2\2\u0424\u0426\3\2\2\2\u0425\u0423\3\2\2\2\u0426\u0427\5\u00a0Q\2\u0427"+
		"\u0428\7t\2\2\u0428\u0429\7F\2\2\u0429\u042a\5\u0094K\2\u042a\u009f\3"+
		"\2\2\2\u042b\u0430\5\26\f\2\u042c\u042d\7b\2\2\u042d\u042f\5\26\f\2\u042e"+
		"\u042c\3\2\2\2\u042f\u0432\3\2\2\2\u0430\u042e\3\2\2\2\u0430\u0431\3\2"+
		"\2\2\u0431\u00a1\3\2\2\2\u0432\u0430\3\2\2\2\u0433\u0434\7\33\2\2\u0434"+
		"\u0435\5\u0094K\2\u0435\u00a3\3\2\2\2\u0436\u0437\7E\2\2\u0437\u0439\5"+
		"\u00a6T\2\u0438\u043a\7K\2\2\u0439\u0438\3\2\2\2\u0439\u043a\3\2\2\2\u043a"+
		"\u043b\3\2\2\2\u043b\u043c\7F\2\2\u043c\u00a5\3\2\2\2\u043d\u0442\5\u00a8"+
		"U\2\u043e\u043f\7K\2\2\u043f\u0441\5\u00a8U\2\u0440\u043e\3\2\2\2\u0441"+
		"\u0444\3\2\2\2\u0442\u0440\3\2\2\2\u0442\u0443\3\2\2\2\u0443\u00a7\3\2"+
		"\2\2\u0444\u0442\3\2\2\2\u0445\u0447\5(\25\2\u0446\u0445\3\2\2\2\u0447"+
		"\u044a\3\2\2\2\u0448\u0446\3\2\2\2\u0448\u0449\3\2\2\2\u0449\u044b\3\2"+
		"\2\2\u044a\u0448\3\2\2\2\u044b\u044c\5h\65\2\u044c\u044d\5\n\6\2\u044d"+
		"\u044e\7N\2\2\u044e\u044f\5\u00b8]\2\u044f\u00a9\3\2\2\2\u0450\u0452\5"+
		"\u00acW\2\u0451\u0450\3\2\2\2\u0452\u0453\3\2\2\2\u0453\u0451\3\2\2\2"+
		"\u0453\u0454\3\2\2\2\u0454\u0456\3\2\2\2\u0455\u0457\5\u0096L\2\u0456"+
		"\u0455\3\2\2\2\u0457\u0458\3\2\2\2\u0458\u0456\3\2\2\2\u0458\u0459\3\2"+
		"\2\2\u0459\u00ab\3\2\2\2\u045a\u045d\7\16\2\2\u045b\u045e\5\u00b8]\2\u045c"+
		"\u045e\7t\2\2\u045d\u045b\3\2\2\2\u045d\u045c\3\2\2\2\u045e\u045f\3\2"+
		"\2\2\u045f\u0463\7T\2\2\u0460\u0461\7\24\2\2\u0461\u0463\7T\2\2\u0462"+
		"\u045a\3\2\2\2\u0462\u0460\3\2\2\2\u0463\u00ad\3\2\2\2\u0464\u0471\5\u00b2"+
		"Z\2\u0465\u0467\5\u00b0Y\2\u0466\u0465\3\2\2\2\u0466\u0467\3\2\2\2\u0467"+
		"\u0468\3\2\2\2\u0468\u046a\7K\2\2\u0469\u046b\5\u00b8]\2\u046a\u0469\3"+
		"\2\2\2\u046a\u046b\3\2\2\2\u046b\u046c\3\2\2\2\u046c\u046e\7K\2\2\u046d"+
		"\u046f\5\u00b6\\\2\u046e\u046d\3\2\2\2\u046e\u046f\3\2\2\2\u046f\u0471"+
		"\3\2\2\2\u0470\u0464\3\2\2\2\u0470\u0466\3\2\2\2\u0471\u00af\3\2\2\2\u0472"+
		"\u0475\5\u0098M\2\u0473\u0475\5\u00b6\\\2\u0474\u0472\3\2\2\2\u0474\u0473"+
		"\3\2\2\2\u0475\u00b1\3\2\2\2\u0476\u0478\5(\25\2\u0477\u0476\3\2\2\2\u0478"+
		"\u047b\3\2\2\2\u0479\u0477\3\2\2\2\u0479\u047a\3\2\2\2\u047a\u047c\3\2"+
		"\2\2\u047b\u0479\3\2\2\2\u047c\u047d\5\u00d8m\2\u047d\u047e\5\n\6\2\u047e"+
		"\u047f\7T\2\2\u047f\u0480\5\u00b8]\2\u0480\u00b3\3\2\2\2\u0481\u0482\7"+
		"E\2\2\u0482\u0483\5\u00b8]\2\u0483\u0484\7F\2\2\u0484\u00b5\3\2\2\2\u0485"+
		"\u048a\5\u00b8]\2\u0486\u0487\7L\2\2\u0487\u0489\5\u00b8]\2\u0488\u0486"+
		"\3\2\2\2\u0489\u048c\3\2\2\2\u048a\u0488\3\2\2\2\u048a\u048b\3\2\2\2\u048b"+
		"\u00b7\3\2\2\2\u048c\u048a\3\2\2\2\u048d\u048e\b]\1\2\u048e\u04ad\5\u00c0"+
		"a\2\u048f\u04ad\5\16\b\2\u0490\u0491\7\'\2\2\u0491\u04ad\5\u00c4c\2\u0492"+
		"\u0493\7E\2\2\u0493\u0494\5\u00d8m\2\u0494\u0495\7F\2\2\u0495\u0496\5"+
		"\u00b8]\27\u0496\u04ad\3\2\2\2\u0497\u0498\t\6\2\2\u0498\u04ad\5\u00b8"+
		"]\25\u0499\u049a\t\7\2\2\u049a\u04ad\5\u00b8]\24\u049b\u04ad\5\u00ba^"+
		"\2\u049c\u049d\5\u00d8m\2\u049d\u04a3\7q\2\2\u049e\u04a0\5\u00dan\2\u049f"+
		"\u049e\3\2\2\2\u049f\u04a0\3\2\2\2\u04a0\u04a1\3\2\2\2\u04a1\u04a4\7t"+
		"\2\2\u04a2\u04a4\7\'\2\2\u04a3\u049f\3\2\2\2\u04a3\u04a2\3\2\2\2\u04a4"+
		"\u04ad\3\2\2\2\u04a5\u04a6\5\u00c2b\2\u04a6\u04a8\7q\2\2\u04a7\u04a9\5"+
		"\u00dan\2\u04a8\u04a7\3\2\2\2\u04a8\u04a9\3\2\2\2\u04a9\u04aa\3\2\2\2"+
		"\u04aa\u04ab\7\'\2\2\u04ab\u04ad\3\2\2\2\u04ac\u048d\3\2\2\2\u04ac\u048f"+
		"\3\2\2\2\u04ac\u0490\3\2\2\2\u04ac\u0492\3\2\2\2\u04ac\u0497\3\2\2\2\u04ac"+
		"\u0499\3\2\2\2\u04ac\u049b\3\2\2\2\u04ac\u049c\3\2\2\2\u04ac\u04a5\3\2"+
		"\2\2\u04ad\u04fe\3\2\2\2\u04ae\u04af\f\23\2\2\u04af\u04b0\t\b\2\2\u04b0"+
		"\u04fd\5\u00b8]\24\u04b1\u04b2\f\22\2\2\u04b2\u04b3\t\t\2\2\u04b3\u04fd"+
		"\5\u00b8]\23\u04b4\u04bc\f\21\2\2\u04b5\u04b6\7P\2\2\u04b6\u04bd\7P\2"+
		"\2\u04b7\u04b8\7O\2\2\u04b8\u04b9\7O\2\2\u04b9\u04bd\7O\2\2\u04ba\u04bb"+
		"\7O\2\2\u04bb\u04bd\7O\2\2\u04bc\u04b5\3\2\2\2\u04bc\u04b7\3\2\2\2\u04bc"+
		"\u04ba\3\2\2\2\u04bd\u04be\3\2\2\2\u04be\u04fd\5\u00b8]\22\u04bf\u04c0"+
		"\f\20\2\2\u04c0\u04c1\t\n\2\2\u04c1\u04fd\5\u00b8]\21\u04c2\u04c3\f\16"+
		"\2\2\u04c3\u04c4\t\13\2\2\u04c4\u04fd\5\u00b8]\17\u04c5\u04c6\f\r\2\2"+
		"\u04c6\u04c7\7a\2\2\u04c7\u04fd\5\u00b8]\16\u04c8\u04c9\f\f\2\2\u04c9"+
		"\u04ca\7c\2\2\u04ca\u04fd\5\u00b8]\r\u04cb\u04cc\f\13\2\2\u04cc\u04cd"+
		"\7b\2\2\u04cd\u04fd\5\u00b8]\f\u04ce\u04cf\f\n\2\2\u04cf\u04d0\7Y\2\2"+
		"\u04d0\u04fd\5\u00b8]\13\u04d1\u04d2\f\t\2\2\u04d2\u04d3\7Z\2\2\u04d3"+
		"\u04fd\5\u00b8]\n\u04d4\u04d5\f\b\2\2\u04d5\u04d6\7S\2\2\u04d6\u04d7\5"+
		"\u00b8]\2\u04d7\u04d8\7T\2\2\u04d8\u04d9\5\u00b8]\t\u04d9\u04fd\3\2\2"+
		"\2\u04da\u04db\f\7\2\2\u04db\u04dc\t\f\2\2\u04dc\u04fd\5\u00b8]\7\u04dd"+
		"\u04de\f\33\2\2\u04de\u04ea\7M\2\2\u04df\u04eb\7t\2\2\u04e0\u04eb\5\16"+
		"\b\2\u04e1\u04eb\7\63\2\2\u04e2\u04e4\7\'\2\2\u04e3\u04e5\5\u00d4k\2\u04e4"+
		"\u04e3\3\2\2\2\u04e4\u04e5\3\2\2\2\u04e5\u04e6\3\2\2\2\u04e6\u04eb\5\u00c8"+
		"e\2\u04e7\u04e8\7\60\2\2\u04e8\u04eb\5\u00dco\2\u04e9\u04eb\5\u00ceh\2"+
		"\u04ea\u04df\3\2\2\2\u04ea\u04e0\3\2\2\2\u04ea\u04e1\3\2\2\2\u04ea\u04e2"+
		"\3\2\2\2\u04ea\u04e7\3\2\2\2\u04ea\u04e9\3\2\2\2\u04eb\u04fd\3\2\2\2\u04ec"+
		"\u04ed\f\32\2\2\u04ed\u04ee\7I\2\2\u04ee\u04ef\5\u00b8]\2\u04ef\u04f0"+
		"\7J\2\2\u04f0\u04fd\3\2\2\2\u04f1\u04f2\f\26\2\2\u04f2\u04fd\t\r\2\2\u04f3"+
		"\u04f4\f\17\2\2\u04f4\u04f5\7\"\2\2\u04f5\u04fd\5\u00d8m\2\u04f6\u04f7"+
		"\f\5\2\2\u04f7\u04f9\7q\2\2\u04f8\u04fa\5\u00dan\2\u04f9\u04f8\3\2\2\2"+
		"\u04f9\u04fa\3\2\2\2\u04fa\u04fb\3\2\2\2\u04fb\u04fd\7t\2\2\u04fc\u04ae"+
		"\3\2\2\2\u04fc\u04b1\3\2\2\2\u04fc\u04b4\3\2\2\2\u04fc\u04bf\3\2\2\2\u04fc"+
		"\u04c2\3\2\2\2\u04fc\u04c5\3\2\2\2\u04fc\u04c8\3\2\2\2\u04fc\u04cb\3\2"+
		"\2\2\u04fc\u04ce\3\2\2\2\u04fc\u04d1\3\2\2\2\u04fc\u04d4\3\2\2\2\u04fc"+
		"\u04da\3\2\2\2\u04fc\u04dd\3\2\2\2\u04fc\u04ec\3\2\2\2\u04fc\u04f1\3\2"+
		"\2\2\u04fc\u04f3\3\2\2\2\u04fc\u04f6\3\2\2\2\u04fd\u0500\3\2\2\2\u04fe"+
		"\u04fc\3\2\2\2\u04fe\u04ff\3\2\2\2\u04ff\u00b9\3\2\2\2\u0500\u04fe\3\2"+
		"\2\2\u0501\u0502\5\u00bc_\2\u0502\u0503\7p\2\2\u0503\u0504\5\u00be`\2"+
		"\u0504\u00bb\3\2\2\2\u0505\u0516\7t\2\2\u0506\u0508\7E\2\2\u0507\u0509"+
		"\5p9\2\u0508\u0507\3\2\2\2\u0508\u0509\3\2\2\2\u0509\u050a\3\2\2\2\u050a"+
		"\u0516\7F\2\2\u050b\u050c\7E\2\2\u050c\u0511\7t\2\2\u050d\u050e\7L\2\2"+
		"\u050e\u0510\7t\2\2\u050f\u050d\3\2\2\2\u0510\u0513\3\2\2\2\u0511\u050f"+
		"\3\2\2\2\u0511\u0512\3\2\2\2\u0512\u0514\3\2\2\2\u0513\u0511\3\2\2\2\u0514"+
		"\u0516\7F\2\2\u0515\u0505\3\2\2\2\u0515\u0506\3\2\2\2\u0515\u050b\3\2"+
		"\2\2\u0516\u00bd\3\2\2\2\u0517\u051a\5\u00b8]\2\u0518\u051a\5\u0094K\2"+
		"\u0519\u0517\3\2\2\2\u0519\u0518\3\2\2\2\u051a\u00bf\3\2\2\2\u051b\u051c"+
		"\7E\2\2\u051c\u051d\5\u00b8]\2\u051d\u051e\7F\2\2\u051e\u052e\3\2\2\2"+
		"\u051f\u052e\7\63\2\2\u0520\u052e\7\60\2\2\u0521\u052e\5\30\r\2\u0522"+
		"\u052e\7t\2\2\u0523\u0524\5H%\2\u0524\u0525\7M\2\2\u0525\u0526\7\21\2"+
		"\2\u0526\u052e\3\2\2\2\u0527\u052b\5\u00d4k\2\u0528\u052c\5\u00dep\2\u0529"+
		"\u052a\7\63\2\2\u052a\u052c\5\u00e0q\2\u052b\u0528\3\2\2\2\u052b\u0529"+
		"\3\2\2\2\u052c\u052e\3\2\2\2\u052d\u051b\3\2\2\2\u052d\u051f\3\2\2\2\u052d"+
		"\u0520\3\2\2\2\u052d\u0521\3\2\2\2\u052d\u0522\3\2\2\2\u052d\u0523\3\2"+
		"\2\2\u052d\u0527\3\2\2\2\u052e\u00c1\3\2\2\2\u052f\u0530\5h\65\2\u0530"+
		"\u0531\7M\2\2\u0531\u0533\3\2\2\2\u0532\u052f\3\2\2\2\u0532\u0533\3\2"+
		"\2\2\u0533\u0537\3\2\2\2\u0534\u0536\5z>\2\u0535\u0534\3\2\2\2\u0536\u0539"+
		"\3\2\2\2\u0537\u0535\3\2\2\2\u0537\u0538\3\2\2\2\u0538\u053a\3\2\2\2\u0539"+
		"\u0537\3\2\2\2\u053a\u053c\7t\2\2\u053b\u053d\5\u00dan\2\u053c\u053b\3"+
		"\2\2\2\u053c\u053d\3\2\2\2\u053d\u00c3\3\2\2\2\u053e\u053f\5\u00d4k\2"+
		"\u053f\u0540\5\u00c6d\2\u0540\u0541\5\u00ccg\2\u0541\u0548\3\2\2\2\u0542"+
		"\u0545\5\u00c6d\2\u0543\u0546\5\u00caf\2\u0544\u0546\5\u00ccg\2\u0545"+
		"\u0543\3\2\2\2\u0545\u0544\3\2\2\2\u0546\u0548\3\2\2\2\u0547\u053e\3\2"+
		"\2\2\u0547\u0542\3\2\2\2\u0548\u00c5\3\2\2\2\u0549\u054b\7t\2\2\u054a"+
		"\u054c\5\u00d0i\2\u054b\u054a\3\2\2\2\u054b\u054c\3\2\2\2\u054c\u0554"+
		"\3\2\2\2\u054d\u054e\7M\2\2\u054e\u0550\7t\2\2\u054f\u0551\5\u00d0i\2"+
		"\u0550\u054f\3\2\2\2\u0550\u0551\3\2\2\2\u0551\u0553\3\2\2\2\u0552\u054d"+
		"\3\2\2\2\u0553\u0556\3\2\2\2\u0554\u0552\3\2\2\2\u0554\u0555\3\2\2\2\u0555"+
		"\u0559\3\2\2\2\u0556\u0554\3\2\2\2\u0557\u0559\5\22\n\2\u0558\u0549\3"+
		"\2\2\2\u0558\u0557\3\2\2\2\u0559\u00c7\3\2\2\2\u055a\u055c\7t\2\2\u055b"+
		"\u055d\5\u00d2j\2\u055c\u055b\3\2\2\2\u055c\u055d\3\2\2\2\u055d\u055e"+
		"\3\2\2\2\u055e\u055f\5\u00ccg\2\u055f\u00c9\3\2\2\2\u0560\u057c\7I\2\2"+
		"\u0561\u0566\7J\2\2\u0562\u0563\7I\2\2\u0563\u0565\7J\2\2\u0564\u0562"+
		"\3\2\2\2\u0565\u0568\3\2\2\2\u0566\u0564\3\2\2\2\u0566\u0567\3\2\2\2\u0567"+
		"\u0569\3\2\2\2\u0568\u0566\3\2\2\2\u0569\u057d\5f\64\2\u056a\u056b\5\u00b8"+
		"]\2\u056b\u0572\7J\2\2\u056c\u056d\7I\2\2\u056d\u056e\5\u00b8]\2\u056e"+
		"\u056f\7J\2\2\u056f\u0571\3\2\2\2\u0570\u056c\3\2\2\2\u0571\u0574\3\2"+
		"\2\2\u0572\u0570\3\2\2\2\u0572\u0573\3\2\2\2\u0573\u0579\3\2\2\2\u0574"+
		"\u0572\3\2\2\2\u0575\u0576\7I\2\2\u0576\u0578\7J\2\2\u0577\u0575\3\2\2"+
		"\2\u0578\u057b\3\2\2\2\u0579\u0577\3\2\2\2\u0579\u057a\3\2\2\2\u057a\u057d"+
		"\3\2\2\2\u057b\u0579\3\2\2\2\u057c\u0561\3\2\2\2\u057c\u056a\3\2\2\2\u057d"+
		"\u00cb\3\2\2\2\u057e\u0580\5\u00e0q\2\u057f\u0581\5<\37\2\u0580\u057f"+
		"\3\2\2\2\u0580\u0581\3\2\2\2\u0581\u00cd\3\2\2\2\u0582\u0583\5\u00d4k"+
		"\2\u0583\u0584\5\u00dep\2\u0584\u00cf\3\2\2\2\u0585\u0586\7P\2\2\u0586"+
		"\u0589\7O\2\2\u0587\u0589\5\u00dan\2\u0588\u0585\3\2\2\2\u0588\u0587\3"+
		"\2\2\2\u0589\u00d1\3\2\2\2\u058a\u058b\7P\2\2\u058b\u058e\7O\2\2\u058c"+
		"\u058e\5\u00d4k\2\u058d\u058a\3\2\2\2\u058d\u058c\3\2\2\2\u058e\u00d3"+
		"\3\2\2\2\u058f\u0590\7P\2\2\u0590\u0591\5\u00d6l\2\u0591\u0592\7O\2\2"+
		"\u0592\u00d5\3\2\2\2\u0593\u0598\5\u00d8m\2\u0594\u0595\7L\2\2\u0595\u0597"+
		"\5\u00d8m\2\u0596\u0594\3\2\2\2\u0597\u059a\3\2\2\2\u0598\u0596\3\2\2"+
		"\2\u0598\u0599\3\2\2\2\u0599\u00d7\3\2\2\2\u059a\u0598\3\2\2\2\u059b\u059d"+
		"\5z>\2\u059c\u059b\3\2\2\2\u059c\u059d\3\2\2\2\u059d\u05a1\3\2\2\2\u059e"+
		"\u05a2\5h\65\2\u059f\u05a2\5\22\n\2\u05a0\u05a2\78\2\2\u05a1\u059e\3\2"+
		"\2\2\u05a1\u059f\3\2\2\2\u05a1\u05a0\3\2\2\2\u05a2\u05a7\3\2\2\2\u05a3"+
		"\u05a4\7I\2\2\u05a4\u05a6\7J\2\2\u05a5\u05a3\3\2\2\2\u05a6\u05a9\3\2\2"+
		"\2\u05a7\u05a5\3\2\2\2\u05a7\u05a8\3\2\2\2\u05a8\u00d9\3\2\2\2\u05a9\u05a7"+
		"\3\2\2\2\u05aa\u05ab\7P\2\2\u05ab\u05b0\5j\66\2\u05ac\u05ad\7L\2\2\u05ad"+
		"\u05af\5j\66\2\u05ae\u05ac\3\2\2\2\u05af\u05b2\3\2\2\2\u05b0\u05ae\3\2"+
		"\2\2\u05b0\u05b1\3\2\2\2\u05b1\u05b3\3\2\2\2\u05b2\u05b0\3\2\2\2\u05b3"+
		"\u05b4\7O\2\2\u05b4\u00db\3\2\2\2\u05b5\u05bc\5\u00e0q\2\u05b6\u05b7\7"+
		"M\2\2\u05b7\u05b9\7t\2\2\u05b8\u05ba\5\u00e0q\2\u05b9\u05b8\3\2\2\2\u05b9"+
		"\u05ba\3\2\2\2\u05ba\u05bc\3\2\2\2\u05bb\u05b5\3\2\2\2\u05bb\u05b6\3\2"+
		"\2\2\u05bc\u00dd\3\2\2\2\u05bd\u05be\7\60\2\2\u05be\u05c2\5\u00dco\2\u05bf"+
		"\u05c0\7t\2\2\u05c0\u05c2\5\u00e0q\2\u05c1\u05bd\3\2\2\2\u05c1\u05bf\3"+
		"\2\2\2\u05c2\u00df\3\2\2\2\u05c3\u05c5\7E\2\2\u05c4\u05c6\5\u00b6\\\2"+
		"\u05c5\u05c4\3\2\2\2\u05c5\u05c6\3\2\2\2\u05c6\u05c7\3\2\2\2\u05c7\u05c8"+
		"\7F\2\2\u05c8\u00e1\3\2\2\2\u00bb\u00e5\u00e8\u00ed\u00f3\u00f9\u00fb"+
		"\u0102\u0104\u010f\u0112\u0119\u0122\u0128\u012e\u0131\u0136\u0143\u0149"+
		"\u014e\u0152\u015c\u0161\u0166\u016c\u0174\u017d\u0182\u0189\u0190\u0193"+
		"\u019a\u01a4\u01a8\u01ad\u01b1\u01b5\u01bf\u01c7\u01cd\u01d4\u01db\u01df"+
		"\u01e2\u01e5\u01ee\u01f4\u01f9\u01fc\u0202\u0208\u020c\u0214\u021d\u0225"+
		"\u022b\u022f\u023a\u0243\u0248\u024e\u0252\u025e\u0269\u026e\u0277\u027f"+
		"\u0289\u0292\u029a\u029f\u02a7\u02ac\u02b6\u02c0\u02c6\u02ca\u02d2\u02d6"+
		"\u02d8\u02de\u02e3\u02e7\u02ee\u02f0\u02f7\u02fc\u0305\u030a\u030d\u0312"+
		"\u031b\u032b\u032e\u0335\u033f\u0347\u034a\u034d\u035a\u0362\u0367\u036f"+
		"\u0373\u0377\u037b\u037d\u0381\u0387\u0392\u039c\u03a1\u03aa\u03af\u03b2"+
		"\u03b9\u03c2\u03d9\u03dc\u03df\u03e7\u03eb\u03f3\u03f9\u0404\u040d\u0412"+
		"\u041c\u0423\u0430\u0439\u0442\u0448\u0453\u0458\u045d\u0462\u0466\u046a"+
		"\u046e\u0470\u0474\u0479\u048a\u049f\u04a3\u04a8\u04ac\u04bc\u04e4\u04ea"+
		"\u04f9\u04fc\u04fe\u0508\u0511\u0515\u0519\u052b\u052d\u0532\u0537\u053c"+
		"\u0545\u0547\u054b\u0550\u0554\u0558\u055c\u0566\u0572\u0579\u057c\u0580"+
		"\u0588\u058d\u0598\u059c\u05a1\u05a7\u05b0\u05b9\u05bb\u05c1\u05c5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}