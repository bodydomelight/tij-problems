package containers.p03;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import net.mindview.util.Countries;

public class SetsTests {
    public static void addToSet(Set<String> set) {
        set.addAll(Countries.names());
        System.out.println("Testng with " + set.getClass().getSimpleName());
        System.out.println("Initial size = " + set.size());
        for (int i = 0; i < 3; i++) {
            set.addAll(Countries.names());
            System.out.println("Size after " + (i + 1) + " add = " + set.size());
        }
        System.out.println();
    }
    public static void main(String[] args) {
        addToSet(new HashSet<String>());
        addToSet(new LinkedHashSet<String>());
        addToSet(new TreeSet<String>());
    }
}
