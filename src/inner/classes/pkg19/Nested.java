package inner.classes.pkg19;

public class Nested {
    Nested() {
        System.out.println("Nested.");
    }
    static class Nested2 {
        Nested2() {
            System.out.println("Nested2.");
        }
        static class Nested3 {
            Nested3() {
                System.out.println("Nested3.");
            }
        }
    }
    public static void main(String[] args) {
        Nested n = new Nested();
        Nested2 n2 = new Nested2();
        Nested2.Nested3 n3 = new Nested2.Nested3();
    }
}
