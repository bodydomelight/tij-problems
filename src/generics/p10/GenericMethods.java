package generics.p10;

public class GenericMethods {

    public <T, U> void f(T x, U y, String z) {
        System.out.println(x.getClass().getName() + "\n"
                + y.getClass().getName() + "\n"
                + z.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("", 1, "a");
        gm.f(1, gm, new String());
        gm.f(1.0, 2f, "true");
    }
}
