package arrays.p02;

import java.util.Arrays;
import arrays.p01.BerylliumSphere;

public class GenerateArray {

    public static BerylliumSphere[] createBerylliumSphere(int n) {
        if (n < 0) {
            n = 0;
        }
        BerylliumSphere[] bs = new BerylliumSphere[n];
        for (int i = 0; i < n; i++) {
            bs[i] = new BerylliumSphere();
        }
        return bs;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(createBerylliumSphere(6)));
        System.out.println(Arrays.toString(createBerylliumSphere(3)));
        System.out.println(Arrays.toString(createBerylliumSphere(0)));
        System.out.println(Arrays.toString(createBerylliumSphere(-1)));
    }
}
