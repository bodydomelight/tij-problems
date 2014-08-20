package concurrency.p20;

import concurrency.p08.LiftOff;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(exec.submit(new LiftOff(10_000)));
        }
        list.stream().forEach((future) -> {
            future.cancel(true);
        });
        exec.shutdown();
    }
}
