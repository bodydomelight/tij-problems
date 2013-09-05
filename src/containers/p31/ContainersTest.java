/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package containers.p31;

import containers.p29.TestParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Container {

    String[] array;
    int index;

    public Container(int i) {
        array = new String[i];
        index = -1;
    }

    public Container() {
        this(50);
    }

    public void add(String str) {
        index++;
        if (index >= array.length) {
            String[] tempArray = Arrays.copyOf(array, array.length + 200);
            array = tempArray;
        }
        array[index] = str;
    }

    public String get(int position) {
        return array[position];
    }

    public int size() {
        return array.length;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()).append("]");
        return sb.toString();
    }
}

public class ContainersTest {

    static List<Test<Container>> tests1 = new ArrayList<>();
    static List<Test<ArrayList<String>>> tests2 = new ArrayList<>();
    final static int LOOPS = 10000;

    static {
        tests1.add(new Test<Container>("addget") {
            @Override
            int test(Container container, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    container.add(i + "");
                    container.get(i);
                }
                return LOOPS;
            }
        });
        tests2.add(new Test<ArrayList<String>>("addget") {
            @Override
            int test(ArrayList<String> container, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    container.add(i + "");
                    container.get(i);
                }
                return LOOPS;
            }
        });
    }

    public static void main(String[] args) {
        Tester.defaultParams = TestParam.array(LOOPS, 1);
        Tester.run(new Container(), tests1);
        Tester.run(new ArrayList<String>(), tests2);
    }
}