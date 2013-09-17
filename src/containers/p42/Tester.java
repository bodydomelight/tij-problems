package containers.p42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.mindview.util.RandomGenerator;

public class Tester {

    public static void main(String[] args) {
        RandomGenerator.String rg = new RandomGenerator.String();
        List<TwoStringsComparable> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new TwoStringsComparable(rg.next(), rg.next()));
        }
        System.out.println("Initial list: " + list);
        Collections.sort(list);
        System.out.println("Sorted by first field: " + list);
        Collections.sort(list, new TwoStringsSecondFieldComparator());
        System.out.println("Sorted by second field: " + list);
    }
}