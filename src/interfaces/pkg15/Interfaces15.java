/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.pkg15;

/**
 *
 * @author rage
 */
public class Interfaces15 extends AbstractClass implements InterfaceABC {

    static void iA(InterfaceA i) {
        System.out.println(i + " interface A");
    }

    static void iB(InterfaceB i) {
        System.out.println(i + " interface B");
    }

    static void iC(InterfaceC i) {
        System.out.println(i + " interface C");
    }

    static void iABC(InterfaceABC i) {
        System.out.println(i + " interface ABC");
    }

    @Override
    public void a1(String str) {
    }

    @Override
    public void a2(String str) {
    }

    @Override
    public void b1(String str) {
    }

    @Override
    public void b2(String str) {
    }

    public void c1(String str) {
    }

    public void c2(String str) {
    }

    @Override
    public void abc(String str) {
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interfaces15 x = new Interfaces15();
        iA(x);
        iB(x);
        //iC(x);
        iABC(x);
    }
}
