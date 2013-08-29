package generics.p20;

public class SecondClass {
    public <T extends p20interface> void sa(T t) {
        t.a();
        t.b();
    }
    public static void main(String[] args) {
        SecondClass sc = new SecondClass();
        sc.sa(new FirstClass());
    }
}
