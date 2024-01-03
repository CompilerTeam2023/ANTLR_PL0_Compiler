import antlr.PL0.Intermediater;
import antlr.PL0.PL0VisitorImpl;
import antlr.PL0.Table;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import PL0.PL0Lexer;
import PL0.PL0Parser;
import PL0.PL0BaseVisitor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean tableDisplay = false; // 显示符号表与否
        System.out.println("=============================== PL0 Compiler Start ===============================");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("请输入pl0文件名(或者输入 exit 退出程序): ");
                String userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting PL0 Compiler.");
                    break;
                }
                String filePath = userInput;
                String fileContent = readFileContent(filePath);

                // 构造编译器并初始化
                PL0Lexer lexer = new PL0Lexer(CharStreams.fromString(fileContent));
                PL0Parser parser = new PL0Parser(new CommonTokenStream(lexer));
                parser.setBuildParseTree(true);
                PL0Parser.ProgramContext tree = parser.program();

                Table table =new Table(); // 对符号表的引用
                Intermediater intermediater= new Intermediater(); // 对中间代码生成器的引用
                PL0BaseVisitor<String> visitor = new PL0VisitorImpl(table,intermediater);
                visitor.visit(tree);

                // 是否输出符号表
                System.out.print("是否展示符号表呢？(Y/N)");
                // 读取用户输入
                String option = scanner.nextLine().trim().toUpperCase();
                // 检查用户输入
                if (option.equals("Y")) {
                    tableDisplay = true;
                }
                if (tableDisplay) {
                    // 输出符号表的代码
                    System.out.println("\n-----------------Printing symbol table---------------------");
                    table.printTable();
                    System.out.println("-----------------------------------------------------------");
                } else {
                    System.out.println("Symbol table will not be printed.");
                }

                System.out.println("\n----------------Printing intermediater code----------------");
                intermediater.ouputCode();// 输出中间代码
                System.out.println("-----------------------------------------------------------");
                System.out.println();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("=============================== PL0 Compiler End ===============================");
    }

    private static String readFileContent(String filePath) throws IOException {
        byte[] encodedBytes = Files.readAllBytes(Paths.get(filePath));
        return new String(encodedBytes, StandardCharsets.UTF_8);
    }
}