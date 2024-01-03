package antlr.PL0;

/**
 * @Description 错误处理类，输出错误信息并终止程序
 * @Author fjy
 * @Date 2024-01-03
 **/
public class Err {

    /**
     * 报错函数
     *
     * @param errorMsg 错误信息
     * @param line     所在行数
     */
    public static void handleError(String errorMsg, int line) {
        System.out.println("Error at line " + line + ": " + errorMsg);
        System.exit(0);
    }
}
