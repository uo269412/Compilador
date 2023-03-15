// Generated from C:/Users/javie/IdeaProjects/DLP/src/parser\Pmm.g4 by ANTLR 4.9.1
package parser;

import ast.*;
import ast.expressions.*;
import ast.expressions.literals.*;
import ast.statements.*;
import ast.types.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PmmParser}.
 */
public interface PmmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PmmParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PmmParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(PmmParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(PmmParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PmmParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PmmParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PmmParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PmmParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#function_invocation}.
	 * @param ctx the parse tree
	 */
	void enterFunction_invocation(PmmParser.Function_invocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#function_invocation}.
	 * @param ctx the parse tree
	 */
	void exitFunction_invocation(PmmParser.Function_invocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#variable_definition}.
	 * @param ctx the parse tree
	 */
	void enterVariable_definition(PmmParser.Variable_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#variable_definition}.
	 * @param ctx the parse tree
	 */
	void exitVariable_definition(PmmParser.Variable_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#multiple_ids_definitions}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_ids_definitions(PmmParser.Multiple_ids_definitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#multiple_ids_definitions}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_ids_definitions(PmmParser.Multiple_ids_definitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunction_definition(PmmParser.Function_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunction_definition(PmmParser.Function_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PmmParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PmmParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#terminal_types}.
	 * @param ctx the parse tree
	 */
	void enterTerminal_types(PmmParser.Terminal_typesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#terminal_types}.
	 * @param ctx the parse tree
	 */
	void exitTerminal_types(PmmParser.Terminal_typesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#record_field}.
	 * @param ctx the parse tree
	 */
	void enterRecord_field(PmmParser.Record_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#record_field}.
	 * @param ctx the parse tree
	 */
	void exitRecord_field(PmmParser.Record_fieldContext ctx);
}