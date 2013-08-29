package generics.p39;

import java.lang.reflect.*;
import java.util.*;

class TwoTuple<A, B> {

    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

interface TimeStamped {

    long getStamp();
}

class TimeStampedImp implements TimeStamped {

    private final long timeStamp;

    public TimeStampedImp() {
        timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered {

    long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {

    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Colored {

    String getColor();

    void setColor(String colour);
}

class ColoredImpl implements Colored {

    private String color;

    ColoredImpl(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }
}

interface Basic {

    public void set(String val);

    public String get();
}

class BasicImp implements Basic {

    private String value;

    @Override
    public void set(String val) {
        value = val;
    }

    @Override
    public String get() {
        return value;
    }
}

class Mixin extends BasicImp
        implements TimeStamped, SerialNumbered, Colored {

    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();
    private Colored color = new ColoredImpl("black");

    @Override
    public void setColor(String color) {
        this.color.setColor(color);
    }

    @Override
    public String getColor() {
        return color.getColor();
    }

    @Override
    public long getStamp() {
        return timeStamp.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }
}

class MixinProxy implements InvocationHandler {

    Map<String, Object> delegatesByMethod;

    public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
        delegatesByMethod = new HashMap<>();
        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {
                String methodName = method.getName();
// The first interface in the map
// implements the method.
                if (!delegatesByMethod.containsKey(methodName)) {
                    delegatesByMethod.put(methodName, pair.first);
                }
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method,
            Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }

    @SuppressWarnings("unchecked")
    public static Object newInstance(TwoTuple... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].second;
        }
        ClassLoader cl =
                pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(
                cl, interfaces, new MixinProxy(pairs));
    }
}

public class DynamicProxyMixin {

    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                new TwoTuple(new BasicImp(), Basic.class),
                new TwoTuple(new TimeStampedImp(), TimeStamped.class),
                new TwoTuple(new SerialNumberedImp(), SerialNumbered.class),
                new TwoTuple(new ColoredImpl("white"), Colored.class));
        Basic b = (Basic) mixin;
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;
        Colored c = (Colored) mixin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
        System.out.println(c.getColor());
    }
}
