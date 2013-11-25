package test;

public class Fib {

    public static long fib(int n) {
        if (n < 0) {
            throw new ArithmeticException();
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
//        long[] testData = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233,
//            377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711,
//            28657, 46368, 75025, 121393, 196418, 317811, 514229,
//            832040, 1346269, 2178309, 3524578, 5702887, 9227465,
//            14930352, 24157817, 39088169};
//        for (int i = 0; i < 30; i++) {
//            long f = fib(i);
//            if (f == testData[i]) {
//                System.out.print(fib(i) + "; ");
//            } else {
//                System.out.println(f + "doesn't equal" + testData[i]);
//            }
//        }
        long start = System.currentTimeMillis();
        System.out.println("" + fib(46) + " - " + (System.currentTimeMillis() - start));
    }
}
