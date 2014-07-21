package concurrency.p14;

import java.util.Timer;
import java.util.TimerTask;

public class TimersTest {

    private static final Timer t = new Timer();

    public static void runTimerTask(int i) {
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.print(i + " ");
            }
        }, 2_000);

    }
    public static void stop() {
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                t.cancel();
            }
        }, 5_000);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 300000; i++) {
            runTimerTask(i);
        }
        System.out.println("after loop");
        stop();
    }
}
