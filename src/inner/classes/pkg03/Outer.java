package inner.classes.pkg03;

public class Outer {
    private String outerName;
    
    public Outer(String str) {
        System.out.println("Object of Outer class initialized");
        outerName = str;
    }
    
    class Inner {
        Inner() {
            System.out.println("Object of Inner class initialized");
        }
        @Override
        public String toString() {
            return outerName;
        }
    }
    
    public Inner getInner() {
        return new Inner();
    }
    
    public static void main(String[] args) {
        Outer outer = new Outer("Name of my Outer class");
        Outer.Inner inner = outer.getInner();
        System.out.println(inner);
    }
}