/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inner.classes.pkg06;
import inner.classes.pkg06b.MyClass;
import inner.classes.pkg06a.MyInterface;
/**
 *
 * @author aamelin
 */
public class InnerClasses06 extends MyClass {

    public static void main(String[] args) {
        InnerClasses06 ic06 = new InnerClasses06();
        MyInterface mi = ic06.getMyInnerClass("Mayflower");
        System.out.println(mi.getName());
        
    }
}
