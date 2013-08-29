package error.p06;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class MyException1 extends Exception {
    private static final Logger logger = Logger.getLogger("myException1");
    public MyException1() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

class MyException2 extends Exception {
    private static final Logger logger = Logger.getLogger("myException2");
    public MyException2() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class NewClass {
    public static void main(String[] args) {
        try {
            throw new MyException1();
        } catch(MyException1 e) {}
        try{
            throw new MyException2();
        } catch(MyException2 e) {}
    }
}
