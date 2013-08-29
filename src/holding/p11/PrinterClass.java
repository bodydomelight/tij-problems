/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package holding.p11;

import java.util.*;
/**
 *
 * @author aamelin
 */
public class PrinterClass {
    public static void printCollection(Collection c) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 5, 6));
        LinkedList<Character> ll = new LinkedList<Character>(Arrays.asList('a', 'b', 'c', 'c', 'd'));
        TreeSet<String> ts = new TreeSet<String>(Arrays.asList("zero", "one", "two",  "three", "three", "four"));
        HashSet<Double> hs = new HashSet<Double>(Arrays.asList(0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 5.0, 6.0));
        LinkedHashSet<Float> lhs = new LinkedHashSet<Float>(Arrays.asList(0f, 1f, 2f, 3f, 4f, 5f, 5f, 6f));
        printCollection(al);
        printCollection(ll);
        printCollection(ts);
        printCollection(hs);
        printCollection(lhs);
    }
}
