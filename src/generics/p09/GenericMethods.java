package generics.p09;

public class GenericMethods {

    public <T, U, V> void f(T x, U y, V z) {
        System.out.println(x.getClass().getName() + "\n" +
                y.getClass().getName() + "\n" + 
                z.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("", 1, 1);
        gm.f(1, gm, new String());
        gm.f(1.0, 2f, true);
    }
}
