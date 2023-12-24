package antlr.PL0;

import PL0.PL0BaseVisitor;
import PL0.PL0Parser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.ArrayList;

public class PL0VisitorImpl extends PL0BaseVisitor<String> {
    private int tempVarCounter = 0; // 临时变量
    private final int initStat = 100; //初始地址
    private int nextStat = initStat; // 下一条代码地址

    private ArrayList<String> IntermediateCode = new ArrayList<>();

    private String newTempVar() {
        return "T" + tempVarCounter++;
    }

    /*
        保存中间代码
     */
    public void emit(String code) {
        IntermediateCode.add(code);
    }

    /*
        遍历并输出所有中间代码
     */
    public void ouputCode() {
        String fileName = "IntermediateCode.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            for (String code : IntermediateCode) {
                System.out.println(code);
                writer.write(code + "\n"); // 写入文件
            }
        } catch (IOException e) {
            System.out.println("中间代码写入文件失败！");
            e.printStackTrace();
        }
    }

    /*
        回填地址
     */
    public void BackPatch(ArrayList<Integer> list, Integer addr) {
        for (Integer value : list) {
            int index = value - initStat; // 计算数组下标
            // 检查数组下标是否合法
            if (index >= 0 && index < IntermediateCode.size()) {
                String ic = IntermediateCode.get(index); // 获取对应下标的数据
                ic += (addr.toString()); // 在尾部添加地址 addr
                IntermediateCode.set(index, ic);
            } else {
                System.out.println("回填地址出错！");
            }
        }
    }

    /*
        合并两个链表，并返回合并后的链首
     */
    public ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        return mergedList;
    }


    @Override
    public String visitConstant_definition(PL0Parser.Constant_definitionContext ctx) {
        String id = ctx.identifier().IDENTIFIER().getText();
        String op = ctx.ASSIGN().getText();
        String un_int = ctx.unsigned_integer().INTEGER().getText();
        String code = Integer.toString(nextStat) + ":    " + id + op + un_int;
        emit(code);
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
        String code = Integer.toString(nextStat) + ":    " + left + op + right;
        emit(code);
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
            String tempVar = newTempVar();
            String code = Integer.toString(nextStat) + ":    " + tempVar + ":=" + p0 + p1;
            emit(code);
            nextStat++;
            return tempVar;
        }
    }


    @Override
    public String visitJiaJian(PL0Parser.JiaJianContext ctx) {
        String p0 = visit(ctx.expression());
        String p1 = ctx.add_sub().getText();
        String p2 = visit(ctx.term());
        String tempVar = newTempVar();
        String code = Integer.toString(nextStat) + ":    " + tempVar + ":=" + p0 + p1 + p2;
        emit(code);
        nextStat++;
        return tempVar;
    }


    @Override
    public String visitSingleFactor(PL0Parser.SingleFactorContext ctx) {
        if (ctx.factor().getChild(1) instanceof PL0Parser.ExpressionContext) {
            String p1 = visit(ctx.factor());
            return p1;
        } else {
            return ctx.factor().getText();
        }
    }


    @Override
    public String visitChengChu(PL0Parser.ChengChuContext ctx) {
        String p0 = visit(ctx.term());
        String p1 = ctx.mul_div().getText();
        String p2 = visit(ctx.factor());
        String tempVar = newTempVar();
        String code = Integer.toString(nextStat) + ":    " + tempVar + ":=" + p0 + p1 + p2;
        emit(code);
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

        ctx.getTrueList().add(nextStat); //写死，真链一定在nextStat+2
        ctx.getFalseList().add(nextStat + 1);
        String code = Integer.toString(nextStat) + ":    if " + left + op + right + " goto "; //待回填：true
        emit(code);
        nextStat++;
        emit(Integer.toString(nextStat) + ":    goto "); //待回填：false
        nextStat++;
        return null;
    }


    @Override
    public String visitCondition_statement(PL0Parser.Condition_statementContext ctx) {
        // Condition_statement -> IF Condition THEN (M1) Statement (M2)

        visit(ctx.condition());
        int M1 = nextStat;
        BackPatch(ctx.condition().getTrueList(), M1); //回填trueList地址:此时nextStat一定为M1.quard

        visit(ctx.statement());
        int M2 = nextStat;
        BackPatch(ctx.condition().getFalseList(), M2); //回填E.falseList地址:此时nextStat一定为M2.quard

        ArrayList<Integer> S1 = ctx.statement().getNextList();
        ArrayList<Integer> S = ctx.getNextList();
        S = merge(ctx.condition().getFalseList(), S1); //合并链
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
        BackPatch(S1,M1);

        BackPatch(ctx.condition().getTrueList(),M2);
        S = ctx.condition().getFalseList();

        BackPatch(ctx.condition().getFalseList(), M3); //回填E.falseList地址:此时nextStat一定为M3.quard

        String code = Integer.toString(nextStat) + ":    goto " + Integer.toString(M1);
        emit(code);
        nextStat++;

        return null;
    }

    
    @Override
    public String visitCompound_statement(PL0Parser.Compound_statementContext ctx) {
        int count = (ctx.getChildCount() - 1) / 2;
        for (int i = 0; i < count ; i++) {
            visit(ctx.statement(i));
        }
        return null;
    }

}

