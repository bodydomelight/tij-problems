package concurrency.p01;

public class RunnableTest {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new MyRunnable()).start();
        }
    }
}
