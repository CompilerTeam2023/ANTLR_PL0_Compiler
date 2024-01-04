package antlr.PL0;

import PL0.PL0BaseVisitor;
import PL0.PL0Parser;

import java.util.ArrayList;

public class PL0VisitorImpl extends PL0BaseVisitor<String> {
    private int tempVarCounter; // 临时变量
    private final int initStat; // 初始地址
    private int nextStat; // 下一条代码地址

    private final Table table; // 对符号表的引用
    private final Intermediater intermediater; // 对中间代码生成器的引用

    // 构造函数，初始化符号表和中间代码生成工具等
    public PL0VisitorImpl(Table t, Intermediater i) {
        table = t;
        intermediater = i;
        tempVarCounter = i.tempVarCounter;
        initStat = i.initStat;
        nextStat = i.nextStat;
    }

    @Override
    public String visitVariable_declaration(PL0Parser.Variable_declarationContext ctx) {
        String id = "";
        int count = (ctx.getChildCount() - 1) / 2;// 变量个数
        for (int i = 0; i < count; i++) {
            id = ctx.identifier(i).IDENTIFIER().getText();
            if (!table.addItem(id, "Variable"))
                Err.handleError("Variable identifier [" + id + "] repeat.", ctx.getStart().getLine());
        }
        return null;
    }

    @Override
    public String visitConstant_definition(PL0Parser.Constant_definitionContext ctx) {
        String id = ctx.identifier().IDENTIFIER().getText();
        if (!table.addItem(id, "Constant"))
            Err.handleError("Constant identifier [" + id + "] repeat.", ctx.getStart().getLine());
        String op = ctx.ASSIGN().getText();
        String un_int = ctx.unsigned_integer().INTEGER().getText();
        String code = Integer.toString(nextStat) + ":    " + id + op + un_int;
        intermediater.emit(code);
        nextStat++;
        return null;
    }

    @Override
    public String visitUnsigned_integer(PL0Parser.Unsigned_integerContext ctx) {
        return ctx.INTEGER().getText();
    }

    @Override
    public String visitIdentifier(PL0Parser.IdentifierContext ctx) {
        return ctx.IDENTIFIER().getText();
    }


    @Override
    public String visitAssignment_statement(PL0Parser.Assignment_statementContext ctx) {
        String left = ctx.identifier().IDENTIFIER().getText();
        String op = ctx.ASSIGN().getText();
        String right = visit(ctx.expression());
        // 标识符未定义
        if (!table.lookup(left)) {
            Err.handleError("Error in assignStatement: Identifier [" + left + "] undefined!", ctx.getStart().getLine());
        }
        //标识符已定义，但为常量
        if(table.getType(left) == "Constant"){
            Err.handleError("Constant identifier [" + left + "] can't be modified.", ctx.getStart().getLine());
        }
        String code = Integer.toString(nextStat) + ":    " + left + op + right;
        intermediater.emit(code);
        nextStat++;
        return right;
    }


    @Override
    public String visitZhengFu(PL0Parser.ZhengFuContext ctx) {
        String p0;
        if (ctx.add_sub() == null) {
            p0 = "";
            return visit(ctx.term());
        } else {
            p0 = ctx.add_sub().getText();
            String p1 = visit(ctx.term());
            String tempVar = intermediater.newTempVar();
            String code = Integer.toString(nextStat) + ":    " + tempVar + ":=" + p0 + p1;
            intermediater.emit(code);
            nextStat++;
            return tempVar;
        }
    }


    @Override
    public String visitJiaJian(PL0Parser.JiaJianContext ctx) {
        String p0 = visit(ctx.expression());
        String p1 = ctx.add_sub().getText();
        String p2 = visit(ctx.term());
        String tempVar = intermediater.newTempVar();
        String code = Integer.toString(nextStat) + ":    " + tempVar + ":=" + p0 + p1 + p2;
        intermediater.emit(code);
        nextStat++;
        return tempVar;
    }


    @Override
    public String visitSingleFactor(PL0Parser.SingleFactorContext ctx) {
        if (ctx.factor().getChild(1) instanceof PL0Parser.ExpressionContext) {
            String p1 = visit(ctx.factor());
            return p1;
        } else if (ctx.factor().getChild(0) instanceof PL0Parser.IdentifierContext) {
            String id = ctx.factor().getText();
            // 错误处理，标识符进符号表并做存在性检查
            if (!table.lookup(id))
                Err.handleError("Identifier [" + id + "] undefined!", ctx.getStart().getLine());
            return id;
        }
        return ctx.factor().getText();
    }


    @Override
    public String visitChengChu(PL0Parser.ChengChuContext ctx) {
        String p0 = visit(ctx.term());
        String p1 = ctx.mul_div().getText();
        String p2 = visit(ctx.factor());
        String tempVar = intermediater.newTempVar();
        String code = Integer.toString(nextStat) + ":    " + tempVar + ":=" + p0 + p1 + p2;
        intermediater.emit(code);
        nextStat++;
        return tempVar;
    }


    @Override
    public String visitId(PL0Parser.IdContext ctx) {
        return ctx.identifier().IDENTIFIER().getText();
    }


    @Override
    public String visitInt(PL0Parser.IntContext ctx) {
        return ctx.unsigned_integer().getText();
    }


    @Override
    public String visitParens(PL0Parser.ParensContext ctx) {
        return visit(ctx.expression());
    }


    @Override
    public String visitCondition(PL0Parser.ConditionContext ctx) {
        String left = visit(ctx.expression(0));
        String op = ctx.comparison_operator().getText();
        String right = visit(ctx.expression(1));

        ctx.getTrueList().add(nextStat); // 写死，真链一定在nextStat+2
        ctx.getFalseList().add(nextStat + 1);
        String code = Integer.toString(nextStat) + ":    if " + left + op + right + " goto "; // 待回填：true
        intermediater.emit(code);
        nextStat++;
        intermediater.emit(Integer.toString(nextStat) + ":    goto "); // 待回填：false
        nextStat++;
        return null;
    }


    @Override
    public String visitCondition_statement(PL0Parser.Condition_statementContext ctx) {
        // Condition_statement -> IF Condition THEN (M1) Statement (M2)

        visit(ctx.condition());
        int M1 = nextStat;
        intermediater.BackPatch(ctx.condition().getTrueList(), M1); // 回填trueList地址:此时nextStat一定为M1.quard

        visit(ctx.statement());
        int M2 = nextStat;
        intermediater.BackPatch(ctx.condition().getFalseList(), M2); // 回填E.falseList地址:此时nextStat一定为M2.quard

        ArrayList<Integer> S1 = ctx.statement().getNextList();
        ArrayList<Integer> S = ctx.getNextList();
        S = intermediater.merge(ctx.condition().getFalseList(), S1); // 合并链
        return null;
    }


    @Override
    public String visitLoop_statement(PL0Parser.Loop_statementContext ctx) {
        // Loop_statement -> WHILE (M1)Condition DO (M2)Statement (M3)

        int M1 = nextStat;
        visit(ctx.condition());

        int M2 = nextStat;
        visit(ctx.statement());
        int M3 = nextStat + 1;

        ArrayList<Integer> S = ctx.getNextList();
        ArrayList<Integer> S1 = ctx.statement().getNextList();
        intermediater.BackPatch(S1, M1);

        intermediater.BackPatch(ctx.condition().getTrueList(), M2);
        S = ctx.condition().getFalseList();

        intermediater.BackPatch(ctx.condition().getFalseList(), M3); // 回填E.falseList地址:此时nextStat一定为M3.quard

        String code = Integer.toString(nextStat) + ":    goto " + Integer.toString(M1);
        intermediater.emit(code);
        nextStat++;

        return null;
    }


    @Override
    public String visitCompound_statement(PL0Parser.Compound_statementContext ctx) {
        int count = (ctx.getChildCount() - 1) / 2;
        for (int i = 0; i < count; i++) {
            visit(ctx.statement(i));
        }
        return null;
    }

}

