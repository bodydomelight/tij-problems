package containers.p41;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.mindview.util.RandomGenerator;

public class Tester {

    public static void main(String[] args) {
        RandomGenerator.String rg = new RandomGenerator.String();
        Set<TwoStringsComparable> set = new HashSet<>();
//        for (int i = 0; i < 5; i++) {
//            set.add(new TwoStringsComparable(rg.next(), rg.next()));
//        }
        set.add(new TwoStringsComparable("a", "b"));
        set.add(new TwoStringsComparable("a", "b"));
        System.out.println(set);

        Map<TwoStringsComparable, String> map = new HashMap<>();
        map.put(new TwoStringsComparable("x", "z"), "first");
        System.out.println(map);
        map.put(new TwoStringsComparable("x", "z"), "second");
        System.out.println(map);
    }
}