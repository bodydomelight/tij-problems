package arrays.p12;

import java.util.Arrays;

public class ArrayOfDoubleTest {
    public static void main(String[] args) {
        double[] d = new double[10];
        CountingGenerator.Double generator = new CountingGenerator.Double();
        for (int i = 0; i < d.length; i++)
            d[i] = generator.next();
        System.out.println(Arrays.toString(d));
    }
}
