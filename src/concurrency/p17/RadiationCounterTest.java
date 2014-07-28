package concurrency.p17;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RadiationCounterTest {

    public static void main(String[] args) {
        RadiationCounter counter = new RadiationCounter();
        for (int i = 0; i < 10; i++) {
            counter.addSensor(new RadiationSensor());
        }
        counter.stop();
    }
}

class RadiationCounter {

    private final ExecutorService exec = Executors.newCachedThreadPool();

    public void addSensor(RadiationSensor sensor) {
        exec.execute(new SensorService(sensor));
    }
    public void stop() {
        exec.shutdown();
    }
}

class SensorService implements Runnable {

    private final RadiationSensor sensor;

    public SensorService(RadiationSensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public void run() {
        long timeout = System.currentTimeMillis() + 5_000;
        while (System.currentTimeMillis() < timeout) {
            System.out.println(sensor.getRadiationLevel());
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException ex) {
            }
        }
    }

}

class RadiationSensor {

    private final long serial;
    private static volatile long counter = 0;
    private Random rand = new Random();

    public RadiationSensor() {
        serial = counter++;
    }

    public String getRadiationLevel() {
        return toString() + ", rad. level:" + rand.nextInt(9);
    }

    @Override
    public String toString() {
        return "Sensor #" + serial;
    }
}
