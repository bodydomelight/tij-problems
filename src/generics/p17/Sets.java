package generics.p17;

import java.util.*;

public class Sets {

    protected static <T> Set<T> copy(Set<T> a) {
        if (a instanceof EnumSet)
            return ((EnumSet)a).clone();
        return new HashSet<>(a);
    }
    public static <T, E> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = copy(a);
        result.addAll(b);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = copy(a);
        result.retainAll(b);
        return result;
    }
// Subtract subset from superset:

    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = copy(superset);
        result.removeAll(subset);
        return result;
    }
// Reflexive--everything not in the intersection:

    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
}
