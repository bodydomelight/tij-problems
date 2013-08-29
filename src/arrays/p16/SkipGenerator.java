//: net/mindview/util/CountingGenerator.java
// Simple generator implementations.
package arrays.p16;

import net.mindview.util.*;

public class SkipGenerator {

    public static class Boolean implements Generator<java.lang.Boolean> {

        private boolean value;

        public Boolean(int i) {
            if (i % 2 == 0) {
                value = false;
            } else {
                value = true;
            }
        }

        @Override
        public java.lang.Boolean next() {
            value = !value; // Just flips back and forth
            return value;
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {

        private byte delta;
        private byte value = 0;

        public Byte(int i) {
            delta = (byte) i;
        }

        @Override
        public java.lang.Byte next() {
            value += delta;
            return value;
        }
    }
    static char[] chars = ("abcdefghijklmnopqrstuvwxyz"
            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

    public static class Character implements Generator<java.lang.Character> {

        private int delta;
        int index = -1;

        Character(int i) {
            delta = i;
        }

        @Override
        public java.lang.Character next() {
            index = (index + delta) % chars.length;
            return chars[index];
        }
    }

    public static class String implements Generator<java.lang.String> {

        private int delta;
        private int length = 7;
        Generator<java.lang.Character> cg = new Character(delta);

        public String(int i) {
            this.delta = i;
        }

        public String(int i, int length) {
            this.delta = i;
            this.length = length;
        }

        @Override
        public java.lang.String next() {
            char[] buf = new char[length];
            for (int i = 0; i < length; i++) {
                buf[i] = cg.next();
            }
            return new java.lang.String(buf);
        }
    }

    public static class Short implements Generator<java.lang.Short> {

        private int delta;
        private short value = 0;

        public Short(int i) {
            delta = i;
        }

        @Override
        public java.lang.Short next() {
            value += delta;
            return value;
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {
        private int delta;
        private int value = 0;
        public Integer(int i) {
            delta = i;
        }
        @Override
        public java.lang.Integer next() {
            value += delta;
            return value;
        }
    }

    public static class Long implements Generator<java.lang.Long> {
        private int delta;
        private long value = 0;
        public Long(int i) {
            delta = i;
        }
        @Override
        public java.lang.Long next() {
            value += delta;
            return value;
        }
    }

    public static class Float implements Generator<java.lang.Float> {
        private float delta;
        private float value = 0;
        public Float(float f) {
            delta = f;
        }
        @Override
        public java.lang.Float next() {
            value += delta;
            return value;
        }
    }

    public static class Double implements Generator<java.lang.Double> {
        private double delta;
        private double value = 0.0;
        public Double(double d) {
            delta = d;
        }
        @Override
        public java.lang.Double next() {
            value += delta;
            return value;
        }
    }
} ///:~
