package arrays.p24;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class TestClass {

    private int field;

    public TestClass(int i) {
        field = i;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TestClass && field == ((TestClass) obj).field) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.field;
        return hash;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":" + field;
    }
}

class TestClassComparator implements Comparator<TestClass> {

    Field field;

    public TestClassComparator() {
        try {
            field = TestClass.class.getDeclaredField("field");
            field.setAccessible(true);
        } catch (NoSuchFieldException | SecurityException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int compare(TestClass o1, TestClass o2) {
        try {
            return (field.getInt(o1) < field.getInt(o2) ? -1 : (field.getInt(o1) == field.getInt(o2) ? 0 : 1));
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
}

public class SearchTest {

    public static void main(String[] args) {
        Random r = new Random();
        TestClass[] et = {new TestClass(r.nextInt(100)), new TestClass(r.nextInt(100)),
            new TestClass(r.nextInt(100)), new TestClass(88), new TestClass(r.nextInt(100)),
            new TestClass(r.nextInt(100)), new TestClass(r.nextInt(100)), new TestClass(r.nextInt(100))};
        System.out.println("Before sort:" + Arrays.toString(et));
        Arrays.sort(et, new TestClassComparator());
        System.out.println("After sort:" + Arrays.toString(et));
        System.out.println("" + Arrays.binarySearch(et, new TestClass(88), new TestClassComparator()));
    }
}
