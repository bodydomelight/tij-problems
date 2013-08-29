package arrays.p22;

import java.util.Arrays;

public class BinarySortTest {
    public static void main(String[] args) {
        String[] array = {"one", "two", "three", "four", "five", "six"};
        System.out.println(Arrays.binarySearch(array, "four"));
        System.out.println("Before sort: " + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("After sort: " + Arrays.toString(array));
        System.out.println(Arrays.binarySearch(array, "four"));
    }
}
