package concurrency.p04;

public class Fibonacci {

    public static void printFibonacciNumbers(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number can't be negative or zero.");
        }
        System.out.println(1);
        if (number > 1) {
            System.out.println(1);

            long first = 1;
            long second = 1;
            int i = 2;
            long third;
            while (i < number) {
                third = first + second;
                System.out.println(third);
                first = second;
                second = third;
                i++;
            }
        }

    }

    public static void main(String[] args) {
        printFibonacciNumbers(50);
    }
}
