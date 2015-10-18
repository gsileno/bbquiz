// Generated from /home/giovanni/dev/myparsers/src/grammar/BBQuiz.g4 by ANTLR 4.5
package parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BBQuizParser}.
 */
public interface BBQuizListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BBQuizParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(@NotNull BBQuizParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link BBQuizParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(@NotNull BBQuizParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link BBQuizParser#quiz}.
	 * @param ctx the parse tree
	 */
	void enterQuiz(@NotNull BBQuizParser.QuizContext ctx);
	/**
	 * Exit a parse tree produced by {@link BBQuizParser#quiz}.
	 * @param ctx the parse tree
	 */
	void exitQuiz(@NotNull BBQuizParser.QuizContext ctx);
}