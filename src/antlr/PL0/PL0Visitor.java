// Generated from D:/mycreate/compiler/ANTLR/src/antlr/PL0.g4 by ANTLR 4.13.1
package PL0;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PL0Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PL0Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PL0Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PL0Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#program_header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram_header(PL0Parser.Program_headerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#subprogram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubprogram(PL0Parser.SubprogramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#constant_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant_declaration(PL0Parser.Constant_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#constant_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant_definition(PL0Parser.Constant_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#unsigned_integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsigned_integer(PL0Parser.Unsigned_integerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_declaration(PL0Parser.Variable_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(PL0Parser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#compound_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_statement(PL0Parser.Compound_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignStatement}
	 * labeled alternative in {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStatement(PL0Parser.AssignStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionStatement}
	 * labeled alternative in {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionStatement(PL0Parser.ConditionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopStatement}
	 * labeled alternative in {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(PL0Parser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundStatement}
	 * labeled alternative in {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(PL0Parser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyStatement1}
	 * labeled alternative in {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement1(PL0Parser.EmptyStatement1Context ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#assignment_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_statement(PL0Parser.Assignment_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ZhengFu}
	 * labeled alternative in {@link PL0Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZhengFu(PL0Parser.ZhengFuContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JiaJian}
	 * labeled alternative in {@link PL0Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJiaJian(PL0Parser.JiaJianContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChengChu}
	 * labeled alternative in {@link PL0Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChengChu(PL0Parser.ChengChuContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleFactor}
	 * labeled alternative in {@link PL0Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleFactor(PL0Parser.SingleFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link PL0Parser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(PL0Parser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link PL0Parser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(PL0Parser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link PL0Parser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(PL0Parser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#add_sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_sub(PL0Parser.Add_subContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#mul_div}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul_div(PL0Parser.Mul_divContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#condition_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_statement(PL0Parser.Condition_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#loop_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_statement(PL0Parser.Loop_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(PL0Parser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#comparison_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison_operator(PL0Parser.Comparison_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#empty_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty_statement(PL0Parser.Empty_statementContext ctx);
}