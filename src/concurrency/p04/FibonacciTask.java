package concurrency.p04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FibonacciTask implements Runnable {

    private final int number;

    public FibonacciTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        Fibonacci.printFibonacciNumbers(number);
    }
    
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            exec.execute(new FibonacciTask(10));
        }
        exec.shutdown();
    }
}
