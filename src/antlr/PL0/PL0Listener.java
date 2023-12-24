// Generated from D:/mycreate/compiler/ANTLR/src/antlr/PL0.g4 by ANTLR 4.13.1
package PL0;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PL0Parser}.
 */
public interface PL0Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PL0Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PL0Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PL0Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#program_header}.
	 * @param ctx the parse tree
	 */
	void enterProgram_header(PL0Parser.Program_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#program_header}.
	 * @param ctx the parse tree
	 */
	void exitProgram_header(PL0Parser.Program_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#subprogram}.
	 * @param ctx the parse tree
	 */
	void enterSubprogram(PL0Parser.SubprogramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#subprogram}.
	 * @param ctx the parse tree
	 */
	void exitSubprogram(PL0Parser.SubprogramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#constant_declaration}.
	 * @param ctx the parse tree
	 */
	void enterConstant_declaration(PL0Parser.Constant_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#constant_declaration}.
	 * @param ctx the parse tree
	 */
	void exitConstant_declaration(PL0Parser.Constant_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#constant_definition}.
	 * @param ctx the parse tree
	 */
	void enterConstant_definition(PL0Parser.Constant_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#constant_definition}.
	 * @param ctx the parse tree
	 */
	void exitConstant_definition(PL0Parser.Constant_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#unsigned_integer}.
	 * @param ctx the parse tree
	 */
	void enterUnsigned_integer(PL0Parser.Unsigned_integerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#unsigned_integer}.
	 * @param ctx the parse tree
	 */
	void exitUnsigned_integer(PL0Parser.Unsigned_integerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariable_declaration(PL0Parser.Variable_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariable_declaration(PL0Parser.Variable_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(PL0Parser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(PL0Parser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void enterCompound_statement(PL0Parser.Compound_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void exitCompound_statement(PL0Parser.Compound_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignStatement}
	 * labeled alternative in {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStatement(PL0Parser.AssignStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignStatement}
	 * labeled alternative in {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStatement(PL0Parser.AssignStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionStatement}
	 * labeled alternative in {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterConditionStatement(PL0Parser.ConditionStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionStatement}
	 * labeled alternative in {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitConditionStatement(PL0Parser.ConditionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopStatement}
	 * labeled alternative in {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(PL0Parser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopStatement}
	 * labeled alternative in {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(PL0Parser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundStatement}
	 * labeled alternative in {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(PL0Parser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundStatement}
	 * labeled alternative in {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(PL0Parser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyStatement1}
	 * labeled alternative in {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement1(PL0Parser.EmptyStatement1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyStatement1}
	 * labeled alternative in {@link PL0Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement1(PL0Parser.EmptyStatement1Context ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_statement(PL0Parser.Assignment_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_statement(PL0Parser.Assignment_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ZhengFu}
	 * labeled alternative in {@link PL0Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterZhengFu(PL0Parser.ZhengFuContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ZhengFu}
	 * labeled alternative in {@link PL0Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitZhengFu(PL0Parser.ZhengFuContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JiaJian}
	 * labeled alternative in {@link PL0Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterJiaJian(PL0Parser.JiaJianContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JiaJian}
	 * labeled alternative in {@link PL0Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitJiaJian(PL0Parser.JiaJianContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChengChu}
	 * labeled alternative in {@link PL0Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterChengChu(PL0Parser.ChengChuContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChengChu}
	 * labeled alternative in {@link PL0Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitChengChu(PL0Parser.ChengChuContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleFactor}
	 * labeled alternative in {@link PL0Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterSingleFactor(PL0Parser.SingleFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleFactor}
	 * labeled alternative in {@link PL0Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitSingleFactor(PL0Parser.SingleFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Id}
	 * labeled alternative in {@link PL0Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterId(PL0Parser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link PL0Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitId(PL0Parser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link PL0Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterInt(PL0Parser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link PL0Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitInt(PL0Parser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link PL0Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterParens(PL0Parser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link PL0Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitParens(PL0Parser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#add_sub}.
	 * @param ctx the parse tree
	 */
	void enterAdd_sub(PL0Parser.Add_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#add_sub}.
	 * @param ctx the parse tree
	 */
	void exitAdd_sub(PL0Parser.Add_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#mul_div}.
	 * @param ctx the parse tree
	 */
	void enterMul_div(PL0Parser.Mul_divContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#mul_div}.
	 * @param ctx the parse tree
	 */
	void exitMul_div(PL0Parser.Mul_divContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#condition_statement}.
	 * @param ctx the parse tree
	 */
	void enterCondition_statement(PL0Parser.Condition_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#condition_statement}.
	 * @param ctx the parse tree
	 */
	void exitCondition_statement(PL0Parser.Condition_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#loop_statement}.
	 * @param ctx the parse tree
	 */
	void enterLoop_statement(PL0Parser.Loop_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#loop_statement}.
	 * @param ctx the parse tree
	 */
	void exitLoop_statement(PL0Parser.Loop_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(PL0Parser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(PL0Parser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void enterComparison_operator(PL0Parser.Comparison_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void exitComparison_operator(PL0Parser.Comparison_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PL0Parser#empty_statement}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_statement(PL0Parser.Empty_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PL0Parser#empty_statement}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_statement(PL0Parser.Empty_statementContext ctx);
}