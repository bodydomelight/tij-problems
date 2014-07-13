package concurrency.p09;

import java.util.Random;
import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {

    private final static Random RAND = new Random();

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority((RAND.nextInt(9) + 1));
        return t;
    }

}
