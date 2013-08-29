package arrays.p23;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ComparatorTest {

    public static void main(String[] args) {
        Random r = new Random();
        Integer[] in = new Integer[10];
        for (int i = 0; i < in.length; i++) {
            in[i] = (int) r.nextInt(100);
        }
        System.out.println("Before sort:" + Arrays.toString(in));
        Arrays.sort(in, Collections.reverseOrder());
        System.out.println("After sort:" + Arrays.toString(in));
    }
}
