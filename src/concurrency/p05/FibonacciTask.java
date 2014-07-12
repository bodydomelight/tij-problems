package concurrency.p05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FibonacciTask implements Callable<Long> {

    private final int number;

    public FibonacciTask(int number) {
        this.number = number;
    }

    @Override
    public Long call() {
        long sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += Fibonacci.getFibonacciNumbers(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        List<Future<Long>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new FibonacciTask(i)));
        }
        try {
            for (Future<Long> future : results) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        exec.shutdown();
    }
}
