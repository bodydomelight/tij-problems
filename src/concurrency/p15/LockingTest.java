package concurrency.p15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockingTest {

    public static void main(String[] args) {
        Locked l = new Locked();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new LockedRunner1(l));
        exec.execute(new LockedRunner2(l));
        exec.execute(new LockedRunner3(l));
        exec.shutdown();
    }
}

class LockedRunner1 implements Runnable {

    private final Locked locked;

    public LockedRunner1(Locked l) {
        this.locked = l;
    }

    @Override
    public void run() {
        locked.f();
    }

}

class LockedRunner2 implements Runnable {

    private final Locked locked;

    public LockedRunner2(Locked l) {
        this.locked = l;
    }

    @Override
    public void run() {
        locked.g();
    }

}

class LockedRunner3 implements Runnable {

    private final Locked locked;

    public LockedRunner3(Locked l) {
        this.locked = l;
    }

    @Override
    public void run() {
        locked.h();
    }

}

class Locked {

    private final Object lock1;
    private final Object lock2;
    private final Object lock3;

    public Locked() {
        lock1 = new Object();
        lock2 = new Object();
        lock3 = new Object();
    }

    public void f() {
        synchronized (lock1) {
            for (int i = 0; i < 5; i++) {
                System.out.println("f()");
                Thread.yield();
            }
        }
    }

    public void g() {
        synchronized (lock2) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }

    public void h() {
        synchronized (lock3) {
            for (int i = 0; i < 5; i++) {
                System.out.println("h()");
                Thread.yield();
            }
        }
    }
}
