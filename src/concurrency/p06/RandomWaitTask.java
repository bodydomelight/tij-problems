package concurrency.p06;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RandomWaitTask implements Runnable {

    private static final Random RANDOM = new Random();
    private int wait;

    @Override
    public void run() {
        wait = getDelayTime();
        try {
            TimeUnit.SECONDS.sleep(wait);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Delay time was " + wait);
    }

    private int getDelayTime() {
        return RANDOM.nextInt(10) + 1;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Specify the number of tasks");
        } else {
            int tasksNumber = Integer.parseInt(args[0]);
            ExecutorService exec = Executors.newFixedThreadPool(10);
            for (int i = 0; i < tasksNumber; i++) {
                exec.execute(new RandomWaitTask());
            }
            exec.shutdown();
        }
    }
}
