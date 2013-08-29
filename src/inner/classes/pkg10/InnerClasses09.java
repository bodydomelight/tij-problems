/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inner.classes.pkg10;

/**
 *
 * @author aamelin
 */
public class InnerClasses09 {
    String name = "null";
    NewInterface getInnerclass() {
        NewInterface a;
        {
            class Inner implements NewInterface {
                @Override
                public String getName() { return name; }
                @Override
                public String toString() { return "Inner class."; }
            }
            a = new Inner();
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println((new InnerClasses09()).getInnerclass());
    }
}
