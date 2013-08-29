package generics.p23;

interface FactoryI<T, V> {

    T create(V v);
}

class Foo2<T, V> {

    private T x;

    public <F extends FactoryI<T, V>> Foo2(F factory, V arg) {
        x = factory.create(arg);
    }
// ...
}

class IntegerFactory implements FactoryI<Integer, Integer> {

    @Override
    public Integer create(Integer i) {
        return new Integer(0);
    }
}

class Widget {

    public Widget(String s) {
    }

    public static class Factory implements FactoryI<Widget, String> {

        @Override
        public Widget create(String str) {
            return new Widget(str);
        }
    }
}

public class FactoryConstraint {

    public static void main(String[] args) {
        Foo2<Integer, Integer> foo2;
        Foo2<Widget, String> foo21;
        foo2 = new Foo2<>(new IntegerFactory(), 0);
        foo21 = new Foo2<>(new Widget.Factory(), "");
    }
}
