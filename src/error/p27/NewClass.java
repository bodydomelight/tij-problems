package error.p27;

public class NewClass {
    
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5};
        try {
            array[7] = 3;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }
}
