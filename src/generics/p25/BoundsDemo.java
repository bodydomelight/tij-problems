package generics.p25;

public class BoundsDemo {
    static <T extends A> void aI(T t){
        System.out.println(t.getClass().getName());
    }
    static <T extends B> void bI(T t) {
        System.out.println(t.getClass().getName());
    }
    public static void main(String[] args) {
        SomeClass sc = new SomeClass();
        aI(sc);
        bI(sc);
    }
}

interface A{}
interface B{}
class SomeClass implements A, B {}