package antlr.PL0;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 【PL/0编译器的中间代码生成工具】
 * 生成易读的三地址代码
 */
public class Intermediater {
    public ArrayList<String> IntermediateCode = new ArrayList<>();

    public final int initStat = 100; // 初始地址
    public int nextStat = initStat; // 下一条代码地址
    public int tempVarCounter = 0;// 中间代码临时变量

    public ArrayList<Integer> makeList() {
        return new ArrayList<>();
    }

    public String newTempVar() {
        return "T" + tempVarCounter++;
    }

    /*
     * 保存中间代码
     */
    public void emit(String code) {
        IntermediateCode.add(code);
    }

    /*
     * 遍历并输出所有中间代码
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
        }
    }

    /*
     * 回填地址
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
     * 合并两个链表，并返回合并后的链首
     */
    public ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        return mergedList;
    }

}
