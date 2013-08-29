/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package error.p05;

import java.util.Random;

/**
 *
 * @author aamelin
 */
public class Runner {

    static int[] intArray = new int[5];
    static boolean exception = true;

    public static void main(String[] args) {
        Random rand = new Random();
        while (exception) {
            try {
                intArray[rand.nextInt(30)] = 6;
                exception = false;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Exception was caught, trying once again.");
            }
        }
        System.out.println("Out of loop");
    }
}
