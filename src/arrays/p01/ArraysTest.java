package arrays.p01;

import java.util.Arrays;

public class ArraysTest {

    public static void print(BerylliumSphere[] bs) {
        System.out.println(Arrays.toString(bs));
    }

    public static void main(String[] args) {
        print(new BerylliumSphere[]{new BerylliumSphere(),
            new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()});
        BerylliumSphere[] bs;
//        bs = {new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};
        BerylliumSphere[] bs2 = {new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};
        BerylliumSphere[] bs3 = new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};
        
    }
}
