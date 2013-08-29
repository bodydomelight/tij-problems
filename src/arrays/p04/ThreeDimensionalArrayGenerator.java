package arrays.p04;

import java.util.Random;

public class ThreeDimensionalArrayGenerator {

    public static double[][][] generateArray(int x, int y, int z, double minValue, double maxValue) {
        if (!(x > 0 && y > 0 && z > 0)) {
            throw new RuntimeException("Indices are less than or equal to 0");
        }
        double[][][] array = new double[x][y][z];
        double delta = maxValue - minValue;
        Random rand = new Random();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    array[i][j][k] = minValue + rand.nextDouble() * delta;
                }
            }
        }
        return array;
    }

    public static void printArray(double[][][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    System.out.printf("%.2f  ", array[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printArray(generateArray(3, 3, 3, 0, 10));
    }
}
