package containers.p32;

import containers.p29.TestParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Container {

    int[] array;
    int index;

    public Container(int i) {
        array = new int[i];
        index = 0;
    }

    public Container() {
        this(50);
    }

    public void add(int str) {
        if (index >= array.length) {
            int[] tempArray = Arrays.copyOf(array, array.length + 200);
            array = tempArray;
        }
        array[index++] = str;
    }

    public int get(int position) {
        return array[position];
    }

    public void set(int ind, int value) {
//        System.out.println("array.size :" + array.length + " index : " + ind);
        array[ind] = value;
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
    static List<Test<ArrayList<Integer>>> tests2 = new ArrayList<>();
    final static int LOOPS = 10000;

    static {
        tests1.add(new Test<Container>("addget") {
            @Override
            int test(Container container, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    container.add(i);
                    container.set(i, container.get(i) + 1);
                }
                return LOOPS;
            }
        });
        tests2.add(new Test<ArrayList<Integer>>("addget") {
            @Override
            int test(ArrayList<Integer> container, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    container.add(Integer.valueOf(i));
                    container.set(i, container.get(i) + 1);
                }
                return LOOPS;
            }
        });
    }

    public static void main(String[] args) {
        Tester.defaultParams = TestParam.array(LOOPS, 1);
        Tester.run(new Container(), tests1);
        Tester.run(new ArrayList<Integer>(), tests2);
    }
}