/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author aamelin
 */
public class A {
    private AA aa = new AA();
    protected class AA {
        public AA() {System.out.println("AA"); }
        public void f() {System.out.println("AA.f()"); }
    }
    public A() { System.out.println("A"); }
}
