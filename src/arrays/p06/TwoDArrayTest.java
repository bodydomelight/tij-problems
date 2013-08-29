/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays.p06;

import java.util.Arrays;
import arrays.p01.BerylliumSphere;

public class TwoDArrayTest {
    public static BerylliumSphere[][] generateArray(int x, int y) {
        if (!(x > 0 && y > 0)) {
            throw new RuntimeException("Bad indices");
        }
        BerylliumSphere[][] bs = new BerylliumSphere[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                bs[i][j] = new BerylliumSphere();
            }
        }
        return bs;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateArray(4, 5)));
    }
}
