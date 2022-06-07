// Generated from com\itsav\analizador\Syntax.g4 by ANTLR 4.5.1
package com.itsav.analizador;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SyntaxParser}.
 */
public interface SyntaxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SyntaxParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(SyntaxParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyntaxParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(SyntaxParser.StartContext ctx);
}