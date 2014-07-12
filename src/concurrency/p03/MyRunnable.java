package concurrency.p03;

public class MyRunnable implements Runnable {

    private static int counter = 0;
    private final int mark;

    public MyRunnable() {
        mark = ++counter;
        System.out.printf("Task %s initialized.\n", mark);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.printf("Message %s.\n", i);
            Thread.yield();
        }
        System.out.printf("Task %s terminattes...\n", mark);
    }

}
