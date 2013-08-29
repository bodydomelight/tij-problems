/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author rage
 */
public class SimpleElseTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println("if " + i);
            } else if (i == 6) {
                System.out.println("else if " + i);
            } else {
                System.out.println("else " + i);
            }
        }
    }
}
