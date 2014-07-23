package concurrency.p16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

    private final Lock lock1;
    private final Lock lock2;
    private final Lock lock3;

    public Locked() {
        lock1 = new ReentrantLock();
        lock2 = new ReentrantLock();
        lock3 = new ReentrantLock();
    }

    public void f() {
        lock1.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("f()");
                Thread.yield();
            }
        } finally {
            lock1.unlock();
        }
    }

    public void g() {
        lock2.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        } finally {
            lock2.unlock();
        }
    }

    public void h() {
        lock3.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("h()");
                Thread.yield();
            }
        } finally {
            lock3.unlock();
        }
    }
}
