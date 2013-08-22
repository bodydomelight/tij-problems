package generics.p28;

import typeinfo.pets.*;

public class GenericTest {

    public static <T> void f1(Generic1<? super T> ge1, T arg) {
        ge1.set(arg);
    }

    public static <T extends Generic2> void f2(T ge2) {
        ge2.get();
    }

    public static void main(String[] args) {
        Generic1<Rodent> g1 = new Generic1<>();
        f1(g1, new Rat());
        f1(g1, new Rodent());
        //f1(g1, new Cat());
        Generic2<Rodent> g2 = new Generic2<>();
        f2(g2);
    }
}

class Generic1<T> {

    public void set(T arg) {
    }
}

class Generic2<T> {

    public T get() {
        return null;
    }
}