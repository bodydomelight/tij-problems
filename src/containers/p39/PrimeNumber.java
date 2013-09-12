package containers.p39;

public class PrimeNumber {

    public static int getNextPrimeNumberAfter(int number) {
        if (number < 1 || number == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("The argument must be "
                    + "greater than 0 and less than Integer.MAX_VALUE. "
                    + "The argument is: " + number);
        }
        if (number == Integer.MAX_VALUE - 1) {
            return Integer.MAX_VALUE;
        }
        int size;
        if (number > (int) Integer.MAX_VALUE * 0.99999) {
            size = Integer.MAX_VALUE - 1;
        } else {
            size = (int) (number * 1.000005) + 1;
        }
        boolean[] ints = new boolean[size + 1 - number];
        int factor = (int) Math.floor(Math.sqrt(size));
        for (int i = 2; i <= factor; i++) {
            for (int j = i * 2; j <= size; j += i) {
                if (j - number > 0) {
                    ints[j - number] = true;
                }
            }
        }
        for (int i = 1; i < ints.length; i++) {
            if (!ints[i]) {
                return i + number;
            }
        }
        return getNextPrimeNumberAfter(size);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 30; i++) {
            System.out.println("Next prime number after " + i + " is " + getNextPrimeNumberAfter(i));
        }
        System.out.println();
        int n = 1000000000;
        long start = System.currentTimeMillis();
        System.out.println("Next prime number after " + n + " is " + getNextPrimeNumberAfter(n));
        long total = System.currentTimeMillis() - start;
        System.out.println("Time taken " + total + " ms");
    }
}
