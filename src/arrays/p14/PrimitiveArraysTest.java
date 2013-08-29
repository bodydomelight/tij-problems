package arrays.p14;

import java.lang.reflect.Array;
import java.util.Arrays;
import arrays.p12.CountingGenerator;
import arrays.p12.Generator;

class Fill {

    public static void primitive(Object array, Generator<?> gen) {
        int size = Array.getLength(array);
        Class<?> type = array.getClass().getComponentType();
        for (int i = 0; i < size; i++) {
            if (type == Boolean.TYPE) {
                Array.setBoolean(array, i, (Boolean)gen.next());
            } else if (type == Byte.TYPE) {
                Array.setByte(array, i, (Byte)gen.next());
            } else if (type == Character.TYPE) {
                Array.setChar(array, i, (Character)gen.next());
            } else if (type == Double.TYPE) {
                Array.setDouble(array, i, (Double)gen.next());
            } else if (type == Float.TYPE) {
                Array.setFloat(array, i, (Float)gen.next());
            } else if (type == Integer.TYPE) {
                Array.setInt(array, i, (Integer)gen.next());
            } else if (type == Long.TYPE) {
                Array.setLong(array, i, (Long)gen.next());
            } else if (type == Short.TYPE) {
                Array.setShort(array, i, (Short)gen.next());
            } 
        }
    }
}

public class PrimitiveArraysTest {

    public static void main(String[] args) {
        int size = 10;
        boolean[] b = new boolean[size];
        byte[] by = new byte[size];
        char[] c = new char[size];
        double[] d = new double[size];
        float[] f = new float[size];
        int[] i = new int[size];
        long[] l = new long[size];
        short[] s = new short[size];
        
        Fill.primitive(b, new CountingGenerator.Boolean());
        System.out.println(Arrays.toString(b));
        Fill.primitive(by, new CountingGenerator.Byte());
        System.out.println(Arrays.toString(by));
        Fill.primitive(c, new CountingGenerator.Character());
        System.out.println(Arrays.toString(c));
        Fill.primitive(d, new CountingGenerator.Double());
        System.out.println(Arrays.toString(d));
        Fill.primitive(f, new CountingGenerator.Float());
        System.out.println(Arrays.toString(f));
        Fill.primitive(i, new CountingGenerator.Integer());
        System.out.println(Arrays.toString(i));
        Fill.primitive(l, new CountingGenerator.Long());
        System.out.println(Arrays.toString(l));
        Fill.primitive(s, new CountingGenerator.Short());
        System.out.println(Arrays.toString(s));
    }
}
