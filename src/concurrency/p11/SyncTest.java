package concurrency.p11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncTest {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        DataHolder dh = new DataHolder();
        for (int i = 0; i < 10; i++) {
            exec.execute(new FieldPrinter(dh, "internationalization!", "localization!"));
        }
        exec.shutdown();
    }
}

class DataHolder {

    private String field01 = "";
    private String field02 = "";

    public synchronized void setFieldsByChar(String field1, String field2) {
        field01 = "";
        field02 = "";
        for (char c : field1.toCharArray()) {
            field01 += c;
        }
        for (char c : field2.toCharArray()) {
            field02 += c;
        }
    }

    public synchronized String getField01() {
        return field01;
    }

    public synchronized String getField02() {
        return field02;
    }
}

class FieldPrinter implements Runnable {

    private String field1;
    private String field2;
    private DataHolder dh;

    public FieldPrinter(DataHolder dh, String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
        this.dh = dh;
    }

    @Override
    public void run() {
//        System.out.println(Thread.currentThread());
        dh.setFieldsByChar(field1, field2);
        Thread.yield();
        System.out.println(Thread.currentThread() + " field01 = " + dh.getField01());
        System.out.println(Thread.currentThread() + " field02 = " + dh.getField02());
    }

}
