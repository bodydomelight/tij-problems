package inner.classes.pkg23;

public class A {
    private String name = "Class A";
    public U getU() {
        return new U() {
            @Override
            public void a() {
                System.out.println("a()");
            };
            @Override
            public void b() {
                System.out.println("b()");
            };
            @Override
            public void c() {
                System.out.println("c()");
            };
            @Override
            public String toString() {
                return name;
            }
        };
    }
}
