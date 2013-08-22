package generics.p34;

abstract class SB<T extends SB<T>> {
    abstract public T get(T t);
    public T concreteGet(T t) {
        return get(t);
    }
}

class ConcreteClass extends SB<ConcreteClass> {
    @Override
    public ConcreteClass get(ConcreteClass c) {
        return c;
    }
}

public class SelfBoundTest {
    public static void main(String[] args) {
        ConcreteClass c = new ConcreteClass();
        ConcreteClass c2 = c.concreteGet(new ConcreteClass());
        c2 = c.concreteGet(c);
        c2.concreteGet(c2);
    }
}
