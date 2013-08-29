package arrays.p18;

import arrays.p01.BerylliumSphere;
import java.util.Arrays;

public class ShallowCopyTest {
    public static void main(String[] args) {
        BerylliumSphere[] b1 = new BerylliumSphere[10];
        BerylliumSphere[] b2 = new BerylliumSphere[5];
        
        for (int i = 0; i < b1.length; i++) {
            b1[i] = new BerylliumSphere();
        }
        System.arraycopy(b1, 2, b2, 0, 3);
        System.out.println("b1 = " + Arrays.toString(b1));
        System.out.println("b2 = " + Arrays.toString(b2));
    }
}
