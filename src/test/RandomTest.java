package test;

import java.util.Random;

public class RandomTest {
    static Random rand = new Random();
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1600000; i++){
            System.out.println(rand.nextFloat());
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");
    }
}
