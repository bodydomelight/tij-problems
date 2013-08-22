/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inner.classes.pkg01;

/**
 *
 * @author aamelin
 */
public class Outer {
    
    public Outer() {
        System.out.println("Object of Outer class initialized");
    }
    
    class Inner {
        Inner() {
            System.out.println("Object of Inner class initialized");
        }
    }
    
    public Inner getInner() {
        return new Inner();
    }
    
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.getInner();
    }
}
