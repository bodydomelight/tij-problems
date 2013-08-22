package generics.p36;
//: generics/ThrowGenericException.java
import java.util.*;

interface Processor<T, E extends Exception, F extends Exception> {

    void process(List<T> resultCollector) throws E, F;
}

class ProcessRunner<T, E extends Exception, F extends Exception>
        extends ArrayList<Processor<T, E, F>> {

    List<T> processAll() throws E, F {
        List<T> resultCollector = new ArrayList<>();
        for (Processor<T, E, F> processor : this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Failure1 extends Exception {
}
class Failure2 extends Exception {
}

class Processor1 implements Processor<String, Failure1, Failure2> {

    static int count = 3;

    public void process(List<String> resultCollector) throws Failure1, Failure2 {
        if (count-- > 1) {
            resultCollector.add("Hep!");
        } else {
            throw new Failure2();
        }
        if (count < 0) {
            throw new Failure1();
        }
    }
}

class Failure3 extends Exception {
}

class Processor2 implements Processor<Integer, Failure2, Failure3> {

    static int count = 2;

    public void process(List<Integer> resultCollector) throws Failure2, Failure3 {
        if (count-- == 0) {
            resultCollector.add(47);
        } else {
            throw new Failure3();
        }
        if (count < 0) {
            throw new Failure2();
        }
    }
}

public class ThrowGenericException {

    public static void main(String[] args) {
        ProcessRunner<String, Failure1, Failure2> runner =
                new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner.add(new Processor1());
        }
        try {
            System.out.println(runner.processAll());
        } catch (Failure1 | Failure2 e) {
            System.out.println(e);
        }
        ProcessRunner<Integer, Failure2, Failure3> runner2 =
                new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner2.add(new Processor2());
        }
        try {
            System.out.println(runner2.processAll());
        } catch (Failure2 | Failure3 e) {
            System.out.println(e);
        }
    }
}
