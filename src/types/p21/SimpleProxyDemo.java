package types.p21;

import java.util.Date;
import static net.mindview.util.Print.*;

interface Interface {

    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {

    @Override
    public void doSomething() {
        print("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        print("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {

    private Interface proxied;
    private long startTime;
    private long endTime;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        print("SimpleProxy doSomething");
        startTime = System.nanoTime();
        proxied.doSomething();
        endTime = System.nanoTime();
        showTime(startTime, endTime);
    }

    @Override
    public void somethingElse(String arg) {
        print("SimpleProxy somethingElse " + arg);
        startTime = System.nanoTime();
        proxied.somethingElse(arg);
        endTime = System.nanoTime();
        showTime(startTime, endTime);
    }

    private void showTime(long start, long end) {
        System.out.println("Method-call time is:" + (endTime - startTime)
                + "ns.");
    }
}

class SimpleProxyDemo {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
