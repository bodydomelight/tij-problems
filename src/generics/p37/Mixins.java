/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generics.p37;
//: generics/Mixins.java
import java.util.*;

interface TimeStamped {

    long getStamp();
}

class TimeStampedImp implements TimeStamped {

    private final long timeStamp;

    public TimeStampedImp() {
        timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered {

    long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {

    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Colored {

    String getColor();

    void setColor(String colour);
}

class ColoredImpl implements Colored {

    private String color;

    ColoredImpl(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }
}

interface Basic {

    public void set(String val);

    public String get();
}

class BasicImp implements Basic {

    private String value;

    @Override
    public void set(String val) {
        value = val;
    }

    @Override
    public String get() {
        return value;
    }
}

class Mixin extends BasicImp
        implements TimeStamped, SerialNumbered, Colored {

    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();
    private Colored color = new ColoredImpl("black");

    @Override
    public void setColor(String color) {
        this.color.setColor(color);
    }
    @Override
    public String getColor() {
        return color.getColor();
    }

    @Override
    public long getStamp() {
        return timeStamp.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }
}

public class Mixins {

    public static void main(String[] args) {
        Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get() + " "
                + mixin1.getStamp() + " " + mixin1.getSerialNumber() + " " + 
                mixin1.getColor());
        System.out.println(mixin2.get() + " "
                + mixin2.getStamp() + " " + mixin2.getSerialNumber() + " " + 
                mixin2.getColor());
    }
}