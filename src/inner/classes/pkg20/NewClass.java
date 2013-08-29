/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inner.classes.pkg20;

/**
 *
 * @author aamelin
 */
public class NewClass implements Interface{
    @Override
    public void print(InterfaceInner i) {
        System.out.println(i);
    }
    public static void main(String[] args) {
        NewClass nc = new NewClass();
        nc.print(new InterfaceInner("Ant"));
    }
}
