/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package error.p03;

/**
 *
 * @author aamelin
 */
public class NewClass {
    
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5};
        try {
            array[7] = 3;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(System.out);
        }
    }
}
