package error.p07;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class NewClass {
    private static final Logger logger = Logger.getLogger("My Message!");
    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5};
        try {
            array[7] = 3;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(System.out);
            logException(e);
        }
    }
}
