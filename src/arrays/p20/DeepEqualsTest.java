/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays.p20;

import java.util.Arrays;

public class DeepEqualsTest {

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.deepToString(b));
        System.out.println(Arrays.deepEquals(a, b));
        b[2][0] = 0;
        System.out.println(Arrays.deepToString(b));
        System.out.println(Arrays.deepEquals(a, b));

        String[][] s1 = {{"Mary", "has", "a"}, {"little", "lamb", "."}};
        String[][] s2 = {{"Mary", "has", "a"}, {"little", "lamb", "."}};
        System.out.println(Arrays.deepToString(s1));
        System.out.println(Arrays.deepToString(s2));
        System.out.println(Arrays.deepEquals(s1, s2));
        s2[1][0] = "big";
        System.out.println(Arrays.deepToString(s2));
        System.out.println(Arrays.deepEquals(s1, s2));

    }
}
