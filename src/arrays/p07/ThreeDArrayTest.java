package arrays.p07;

import java.util.Arrays;
import arrays.p01.BerylliumSphere;

public class ThreeDArrayTest {

    public static BerylliumSphere[][][] generateArray(int x, int y, int z) {
        if (!(x > 0 && y > 0 && z > 0)) {
            throw new RuntimeException("Bad indices");
        }
        BerylliumSphere[][][] bs = new BerylliumSphere[x][y][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    bs[i][j][k] = new BerylliumSphere();
                }
            }
        }
        return bs;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateArray(4, 5, 6)));
    }
}
