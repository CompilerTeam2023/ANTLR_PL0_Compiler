import antlr.PL0.PL0VisitorImpl;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import PL0.PL0Lexer;
import PL0.PL0Parser;
import PL0.PL0BaseVisitor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        System.out.println("============== PL0 Compiler Start ==============");
        try {
            String filePath = "test.pl0";
            String fileContent = readFileContent(filePath);

            PL0Lexer lexer = new PL0Lexer(CharStreams.fromString(fileContent));
            PL0Parser parser = new PL0Parser(new CommonTokenStream(lexer));
            parser.setBuildParseTree(true);
            PL0Parser.ProgramContext tree = parser.program();
            PL0BaseVisitor<String> visitor = new PL0VisitorImpl();
            visitor.visit(tree);
            ((PL0VisitorImpl) visitor).ouputCode();
            System.out.println("============== PL0 Compiler End ==============");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFileContent(String filePath) throws IOException {
        byte[] encodedBytes = Files.readAllBytes(Paths.get(filePath));
        return new String(encodedBytes, StandardCharsets.UTF_8);
    }
}