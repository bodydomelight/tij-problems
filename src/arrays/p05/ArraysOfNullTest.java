/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays.p05;

/**
 *
 * @author rage
 */
public class ArraysOfNullTest {
    public static void main(String[] args) {
        String[][][] str = new String[2][3][4];
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {
                for (int k = 0; k < str[i][j].length; k++) {
                    System.out.printf("%s ", str[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
