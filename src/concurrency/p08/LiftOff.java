package concurrency.p08;

public class LiftOff implements Runnable {

    protected int countDown = 10; // Default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("\n" + Thread.currentThread() + " interrupted!");
                return;
            }
            System.out.print(status());
            Thread.yield();
        }
    }
}
