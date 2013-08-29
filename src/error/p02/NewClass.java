/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package error.p02;

/**
 *
 * @author aamelin
 */
public class NewClass {
    
    public static void main(String[] args) {
        String str = null;
        try {
            str.isEmpty();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException is caught!");
            e.printStackTrace(System.out);
        }
    }
}
