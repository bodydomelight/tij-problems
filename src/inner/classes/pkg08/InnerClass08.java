/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inner.classes.pkg08;

/**
 *
 * @author aamelin
 */
public class InnerClass08 {

    class Inner {
        private String name = "You could read my name!";
        private String getName() {
            return name;
        }
    }
    public static void main(String[] args) {
        InnerClass08 ic08 = new InnerClass08();
        InnerClass08.Inner inner = ic08.new Inner();
        System.out.println("Accessing a private field of inner class");
        System.out.println(inner.name);
        System.out.println("Accessing a private method of inner class");
        System.out.println(inner.getName());
    }
}
