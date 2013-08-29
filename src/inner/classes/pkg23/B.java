/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inner.classes.pkg23;

/**
 *
 * @author aamelin
 */
public class B {
    
    private U[] array;
    
    public B(int i) {
        array = new U[i];
    }
    public void setU(U u, int i) {
        if (i < array.length && i >= 0) {
            array[i] = u;
        } else {
            System.out.println("Index is out of array boundaries.");
        }
    }
    public void setNull(int i) {
        if (i < array.length && i >= 0) {
            array[i] = null;
        } else {
            System.out.println("Index is out of array boundaries.");
        }  
    }
    public void callAllU() {
        for (U u : array) {
            if (u != null){
                System.out.println();
                u.a();
                u.b();
                u.c();
                System.out.println(u);
            } else {
                System.out.println();
                System.out.println("Current cell is empty");
            }
        }
    }
    public static void main(String[] args) {
        B b = new B(10);
        for (int i = 0; i < b.array.length; i++) {
            b.array[i] = (new A()).getU();
            System.out.print(i + " ");
        }
        System.out.println();
        b.setNull(0);
        b.setNull(1);
        b.setNull(8);
        b.setNull(9);
        b.callAllU();
    }
}
