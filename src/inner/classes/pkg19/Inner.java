package inner.classes.pkg19;

public class Inner {
    public Inner() {
        System.out.println("Inner class");
    }
    class Inner2 {
        public Inner2() {
            System.out.println("Inner2 class");
        }
        class Inner3 {
            public Inner3() {
                System.out.println("Inner3 class");
            }
        }
    }
    public static void main(String[] args) {
        Inner i = new Inner();
        Inner.Inner2 i2 = i.new Inner2();
        Inner.Inner2.Inner3 i3 = i2.new Inner3();
    }
}
