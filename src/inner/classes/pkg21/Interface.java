
package inner.classes.pkg21;

public interface Interface {
    String getName();
    void print();
    
    static class Nested {
        static void methodCall(Interface i) {
            i.getName();
            i.print();
        }
    }
}
