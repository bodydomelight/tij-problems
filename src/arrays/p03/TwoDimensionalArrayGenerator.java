package arrays.p03;

import java.util.Random;

public class TwoDimensionalArrayGenerator {

    public static double[][] generateArray(int x, int y, double minValue, double maxValue) {
        if (!(x > 0 && y > 0)) {
            throw new RuntimeException("Indices are less than or equal to 0");
        }
        double[][] array = new double[x][y];
        double delta = maxValue - minValue;
        Random rand = new Random();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                array[i][j] = minValue + rand.nextDouble() * delta;
            }
        }
        return array;
    }

    public static void printArray(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%.2f  ", array[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printArray(generateArray(3, 5, 0, 10));
    }
}
