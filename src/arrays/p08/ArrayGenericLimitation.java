package arrays.p08;

public class ArrayGenericLimitation<T> {
    T[] array;
    public ArrayGenericLimitation(int i) {
        array = (T[]) new Object[i];
    }
    public static void main(String[] args) {
        ArrayGenericLimitation<String> sa = new ArrayGenericLimitation<>(5);
        sa.array[0] = "3";
    }
}
