package concurrency.p05;

public class Fibonacci {

    public static long getFibonacciNumbers(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number can't be negative or zero.");
        } else {
            long first = 0;
            long second = 1;
            long third;
            int i = 1;
            do {
                third = first + second;
                first = second;
                second = third;
                i++;
            } while (i < number);
            return third;
        }

    }

    public static void main(String[] args) {
        for (int i = 1; i < 15; i++) {
            System.out.println(getFibonacciNumbers(i));
        }
    }
}
