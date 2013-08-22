/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author aamelin
 */
public class B extends A {
    private BB bb;
    protected class BB extends A.AA {
        public BB() { System.out.println("BB"); }
        @Override
        public void f() {System.out.println("BB.f()"); }
    }
    public B() { System.out.println("B"); }
    
    public static void main(String[] args) {
        B b = new B();
        System.out.println("___");
        BB bb = b.new BB();
        System.out.println("___");
        bb.f();
    }
}
