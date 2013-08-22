/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays.p19;

import java.util.Arrays;

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
}

public class EqualsTest {

    public static void main(String[] args) {
        TestClass[] tc1 = {new TestClass(4), new TestClass(4), new TestClass(4), new TestClass(4)};
        TestClass[] tc2 = {new TestClass(4), new TestClass(4), new TestClass(4), new TestClass(4)};
        TestClass[] tc3 = new TestClass[10];
        TestClass[] tc4 = {new TestClass(1), new TestClass(4), new TestClass(4), new TestClass(4)};

        System.out.println(Arrays.equals(tc1, tc2));
        System.out.println(Arrays.equals(tc1, tc3));
        System.out.println(Arrays.equals(tc1, tc4));
    }
}
