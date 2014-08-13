package concurrency.p18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Interrupt {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Interrupter());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Calling exec.shutdownNow()");
        exec.shutdownNow();
    }
}

class NonTaskSleeper {

    public void putToSleep() {
        try {
            System.out.println("Put to sleep");
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException ex) {
            System.out.println("NonTaskSleeper interrupted!");
        }
    }
}

class Interrupter implements Runnable {

    @Override
    public void run() {
        new NonTaskSleeper().putToSleep();
    }

}
