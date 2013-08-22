/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.p14;

/**
 *
 * @author rage
 */
public class Interfaces14 extends ConcreteClass implements InterfaceABC {
    static void iA (InterfaceA i) {
        System.out.println(i + " interface A");
    }
    static void iB (InterfaceB i) {
        System.out.println(i + " interface B");
    }
    static void iC (InterfaceC i) {
        System.out.println(i + " interface C");
    }
    static void iABC (InterfaceABC i) {
        System.out.println(i + " interface ABC");
    }
    public void a1(String str) {}
    public void a2(String str) {}
    public void b1(String str) {}
    public void b2(String str) {}
    public void c1(String str) {}
    public void c2(String str) {}
    public void abc(String str) {}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interfaces14 x = new Interfaces14();
        iA(x);
        iB(x);
        iC(x);
        iABC(x);
    }
}
