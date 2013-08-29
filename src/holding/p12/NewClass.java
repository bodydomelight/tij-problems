package holding.p12;

import java.util.*;

public class NewClass {
    private static List<Integer> a = new LinkedList<Integer>(Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    private static List<Integer> b = new LinkedList<Integer>();
    
    public static void main(String[] args) {
        ListIterator<Integer> itA = a.listIterator(10);
        while (itA.hasPrevious()) {
            b.add(itA.previous());
        }
        System.out.println("a: " + a + "\n" + "b: " + b);
    }
}
