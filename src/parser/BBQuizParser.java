// Generated from /home/giovanni/dev/myparsers/src/grammar/BBQuiz.g4 by ANTLR 4.5
package parser;
import components.Quiz; import components.Answer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BBQuizParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, LineBreak=3, LineText=4, Spaces=5;
	public static final int
		RULE_file = 0, RULE_quiz = 1;
	public static final String[] ruleNames = {
		"file", "quiz"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\t'", "'X'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "LineBreak", "LineText", "Spaces"
	};
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
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "BBQuiz.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BBQuizParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public String header;
		public List<Quiz> data;
		public QuizContext quiz;
		public TerminalNode EOF() { return getToken(BBQuizParser.EOF, 0); }
		public List<QuizContext> quiz() {
			return getRuleContexts(QuizContext.class);
		}
		public QuizContext quiz(int i) {
			return getRuleContext(QuizContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BBQuizListener ) ((BBQuizListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BBQuizListener ) ((BBQuizListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		((FileContext)_localctx).data =  new ArrayList<Quiz>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(7); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(4); 
				((FileContext)_localctx).quiz = quiz();
				_localctx.data.add(((FileContext)_localctx).quiz.elem);
				}
				}
				setState(9); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LineText );
			setState(11); 
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

	public static class QuizContext extends ParserRuleContext {
		public Quiz elem;
		public Token q;
		public Token a;
		public List<TerminalNode> LineBreak() { return getTokens(BBQuizParser.LineBreak); }
		public TerminalNode LineBreak(int i) {
			return getToken(BBQuizParser.LineBreak, i);
		}
		public List<TerminalNode> LineText() { return getTokens(BBQuizParser.LineText); }
		public TerminalNode LineText(int i) {
			return getToken(BBQuizParser.LineText, i);
		}
		public QuizContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quiz; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BBQuizListener ) ((BBQuizListener)listener).enterQuiz(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BBQuizListener ) ((BBQuizListener)listener).exitQuiz(this);
		}
	}

	public final QuizContext quiz() throws RecognitionException {
		QuizContext _localctx = new QuizContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_quiz);
		((QuizContext)_localctx).elem =  new Quiz(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			((QuizContext)_localctx).q = match(LineText);
			_localctx.elem.setQuestion((((QuizContext)_localctx).q!=null?((QuizContext)_localctx).q.getText():null).trim());
			setState(15); 
			match(LineBreak);
			setState(24); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(16); 
					((QuizContext)_localctx).a = match(LineText);
					Answer answer = new Answer(); answer.setText((((QuizContext)_localctx).a!=null?((QuizContext)_localctx).a.getText():null).trim()); _localctx.elem.addAnswer(answer); 
					setState(21);
					_la = _input.LA(1);
					if (_la==T__0) {
						{
						setState(18); 
						match(T__0);
						setState(19); 
						match(T__1);
						 answer.setCorrect(true); 
						}
					}

					{
					setState(23); 
					match(LineBreak);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(26); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LineBreak) {
				{
				{
				setState(28); 
				match(LineBreak);
				}
				}
				setState(33);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\7%\4\2\t\2\4\3\t"+
		"\3\3\2\3\2\3\2\6\2\n\n\2\r\2\16\2\13\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3\30\n\3\3\3\6\3\33\n\3\r\3\16\3\34\3\3\7\3 \n\3\f\3\16\3#\13"+
		"\3\3\3\2\2\4\2\4\2\2&\2\t\3\2\2\2\4\17\3\2\2\2\6\7\5\4\3\2\7\b\b\2\1\2"+
		"\b\n\3\2\2\2\t\6\3\2\2\2\n\13\3\2\2\2\13\t\3\2\2\2\13\f\3\2\2\2\f\r\3"+
		"\2\2\2\r\16\7\2\2\3\16\3\3\2\2\2\17\20\7\6\2\2\20\21\b\3\1\2\21\32\7\5"+
		"\2\2\22\23\7\6\2\2\23\27\b\3\1\2\24\25\7\3\2\2\25\26\7\4\2\2\26\30\b\3"+
		"\1\2\27\24\3\2\2\2\27\30\3\2\2\2\30\31\3\2\2\2\31\33\7\5\2\2\32\22\3\2"+
		"\2\2\33\34\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35!\3\2\2\2\36 \7\5\2\2"+
		"\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\5\3\2\2\2#!\3\2\2\2"+
		"\6\13\27\34!";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}