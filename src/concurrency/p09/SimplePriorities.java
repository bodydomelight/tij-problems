package concurrency.p09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorities implements Runnable {

    private int countDown = 5;
    private volatile double d; // No optimization

    public SimplePriorities() {
    }

    @Override
    public String toString() {
        return Thread.currentThread() + " PR:"
                + Thread.currentThread().getPriority() + ": " + countDown;
    }

    @Override
    public void run() {
        while (true) {
// An expensive, interruptable operation:
            for (int i = 1; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new PriorityThreadFactory());
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities());
        }
        exec.execute(new SimplePriorities());
        exec.shutdown();
    }
}
