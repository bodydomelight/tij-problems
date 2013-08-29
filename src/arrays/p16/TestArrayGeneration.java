package arrays.p16;

import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

public class TestArrayGeneration {

    public static void main(String[] args) {
        int size = 6;
        int delta = 100;
        boolean[] a1 = ConvertTo.primitive(Generated.array(
                Boolean.class, new SkipGenerator.Boolean(1), size));
        print("boolean: a1 = " + Arrays.toString(a1));
        byte[] a2 = ConvertTo.primitive(Generated.array(
                Byte.class, new SkipGenerator.Byte(delta), size));
        print("   byte: a2 = " + Arrays.toString(a2));
        char[] a3 = ConvertTo.primitive(Generated.array(
                Character.class,
                new SkipGenerator.Character(delta), size));
        print("   char: a3 = " + Arrays.toString(a3));
        short[] a4 = ConvertTo.primitive(Generated.array(
                Short.class, new SkipGenerator.Short(delta), size));
        print("  short: a4 = " + Arrays.toString(a4));
        int[] a5 = ConvertTo.primitive(Generated.array(
                Integer.class, new SkipGenerator.Integer(delta), size));
        print("    int: a5 = " + Arrays.toString(a5));
        long[] a6 = ConvertTo.primitive(Generated.array(
                Long.class, new SkipGenerator.Long(delta), size));
        print("   long: a6 = " + Arrays.toString(a6));
        float[] a7 = ConvertTo.primitive(Generated.array(
                Float.class, new SkipGenerator.Float(delta), size));
        print("  float: a7 = " + Arrays.toString(a7));
        double[] a8 = ConvertTo.primitive(Generated.array(
                Double.class, new SkipGenerator.Double(delta), size));
        print(" double: a8 = " + Arrays.toString(a8));
    }
}
