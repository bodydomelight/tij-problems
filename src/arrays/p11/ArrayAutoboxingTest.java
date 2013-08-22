package arrays.p11;

public class ArrayAutoboxingTest {
    public static void main(String[] args) {
        Integer[] array = new Integer[5];
        array[0] = 2;
        int[] array2 = new int[5];
        array2[0] = new Integer(2);
        //array = array2;
        //array2 = array;
    }
}
