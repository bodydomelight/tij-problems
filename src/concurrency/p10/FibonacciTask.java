package concurrency.p10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonacciTask {

    private final ExecutorService exec = Executors.newCachedThreadPool();

    public Future<Long> runTask(int number) {
        Callable<Long> callable = () -> {
            long sum = 0;
            for (int i = 1; i <= number; i++) {
                sum += Fibonacci.getFibonacciNumbers(i);
            }
            return sum;
        };
        return exec.submit(callable);
    }

    public void shutdown() {
        exec.shutdown();
    }

    public static void main(String[] args) {
        FibonacciTask ft = new FibonacciTask();
        List<Future<Long>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(ft.runTask(i));
        }
        try {
            for (Future<Long> future : results) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex);
        } finally {
            ft.shutdown();
        }
    }
}
