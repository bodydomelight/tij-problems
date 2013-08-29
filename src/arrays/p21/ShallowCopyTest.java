package arrays.p21;

import java.lang.reflect.Field;
import arrays.p01.BerylliumSphere;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class BerylliumSphereC extends BerylliumSphere implements Comparable<BerylliumSphere> {

    @Override
    public int compareTo(BerylliumSphere o) {
        Field idField;
        try {
            idField = BerylliumSphere.class.getDeclaredField("id");
        } catch (NoSuchFieldException | SecurityException ex) {
            throw new RuntimeException(ex);
        }
        idField.setAccessible(true);
        try {
            return (idField.getLong(this) < idField.getLong(o) ? -1 : (idField.getLong(this) == idField.getLong(o) ? 0 : 1));
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
}


class BerylliumSphereReverseComparator implements Comparator<BerylliumSphere> {

    @Override
    public int compare(BerylliumSphere o1, BerylliumSphere o2) {
        Field idField;
        try {
            idField = BerylliumSphere.class.getDeclaredField("id");
        } catch (NoSuchFieldException | SecurityException ex) {
            throw new RuntimeException(ex);
        }
        idField.setAccessible(true);
        try {
            return (idField.getLong(o1) > idField.getLong(o2) ? -1 : (idField.getLong(o1) == idField.getLong(o2) ? 0 : 1));
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}

public class ShallowCopyTest {

    public static void main(String[] args) {
        BerylliumSphere[] b1 = new BerylliumSphere[10];

        for (int i = b1.length - 1; i >= 0; i--) {
            b1[i] = new BerylliumSphereC();
        }
        System.out.println("before sort: " + Arrays.toString(b1));
        Arrays.sort(b1);
        System.out.println("before sort: " + Arrays.toString(b1));
        
        BerylliumSphere[] b2 = new BerylliumSphere[10];

        for (int i = 0; i < b2.length; i++) {
            b2[i] = new BerylliumSphere();
        }
        System.out.println("before sort: " + Arrays.toString(b2));
        Arrays.sort(b2, new BerylliumSphereReverseComparator());
        System.out.println("before sort: " + Arrays.toString(b2));
        
    }
}
