import antlr.PL0.PL0VisitorImpl;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import PL0.PL0Lexer;
import PL0.PL0Parser;
import PL0.PL0BaseVisitor;

public class Main {
    public static void main(String[] args) {

        PL0Lexer lexer = new PL0Lexer(CharStreams.fromString("PROGRAM add\n" +
                "VAR x,y;\n" +
                "BEGIN\n" +
                "  x:=1;\n" +
                "  y:=2;\n" +
                "  WHILE x<5 DO x:=x+1;\n" +
                "  IF y>0 THEN y:=y-1;\n" +
                "  y:=y+x\n" +
                "END"));
        PL0Parser parser = new PL0Parser((new CommonTokenStream(lexer)));
//        parser.start();
        parser.setBuildParseTree(true);
        PL0Parser.ProgramContext tree = parser.program();
        PL0BaseVisitor<String> visitor = new PL0VisitorImpl();
        visitor.visit(tree);
        ((PL0VisitorImpl) visitor).ouputCode();
        System.out.println("parser has executed");

    }
}