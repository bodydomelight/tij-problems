package types.p22;

import java.lang.reflect.*;
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

class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) 
            throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass()
                + ", method: " + method + ", args: " + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println(" " + arg);
            }
        }
        long startTime = System.nanoTime();
        Object obj = method.invoke(proxied, args);
        long endTime = System.nanoTime();
        System.out.println("Method-call time is: " + (endTime - startTime)
                + "ns.");
        return obj;
    }
}

class SimpleDynamicProxy {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // Insert a proxy and call again:
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(), new Class[]{Interface.class},
                new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
