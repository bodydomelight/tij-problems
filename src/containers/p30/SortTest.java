/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package containers.p30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author rage
 */
public class SortTest {
    public static <V extends Comparable<V>> void test(List<? extends List<V>> lists, String message) {
        System.out.println(message);
        long time1 = System.nanoTime();
        for (List<V> a : lists) {
            Collections.sort(a);
        }
        long time2 = System.nanoTime();
        System.out.println("Resulting time is: " + (time2 - time1)/1000);
    }
    
    public static void main(String[] args) {
        List<ArrayList<Integer>> al = new ArrayList<>();
        List<LinkedList<Integer>> ll = new ArrayList<>();
        Random rand = new Random();
        Integer in;
        for (int i = 0; i < 1000; i++) {
            al.add(new ArrayList<Integer>());
            ll.add(new LinkedList<Integer>());
            for (int j = 0; j < 1000; j++) {
                in = rand.nextInt();
                al.get(i).add(in);
                ll.get(i).add(in);
            }
        }
        test(al, "ArrayList");
        test(ll, "LinkedList");
    }
}
