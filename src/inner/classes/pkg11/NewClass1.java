/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inner.classes.pkg11;

/**
 *
 * @author aamelin
 */
public class NewClass1 {
    public static void main(String[] args) {
        NewClass nc = new NewClass();
        NewInterface ni = nc.getInner();
        System.out.println(ni.getName());
        //Inner ni2 = (Inner)ni;
    }
}
