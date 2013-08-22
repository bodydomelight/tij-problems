/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inner.classes.pkg18;

/**
 *
 * @author aamelin
 */
public class NewClass {
    protected static class NestedClass {
        private String name;
        private void setName(String str) {
            name = str;
            System.out.println("Nested class created.\n" + name);
        }
    }
    public static void main(String[] args) {
        //NewClass nc = new NewClass();
        NestedClass nested = new NestedClass();
        nested.setName("Bumblebee");
    }
}
