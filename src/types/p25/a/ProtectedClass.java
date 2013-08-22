/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package types.p25.a;

/**
 *
 * @author rage
 */
public class ProtectedClass {
    void packageMethod() {
        System.out.println("Package access method");
    }
    protected void protectedMethod() {
        System.out.println("Protected method");
    }
    private void privateMethod() {
        System.out.println("Private method");
    }
}
