/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package containers.p01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import net.mindview.util.Countries;

public class CountriesTest {

    public static void populate(List<String> list) {
        list.addAll(Countries.names(10));

    }

    public static <T> void shuffleAndPrint(List<T> list) {
        Collections.shuffle(list);
        System.out.println("Shuffled list:" + list);
    }
    public static void sortAndPrint(List<String> list) {
        Collections.sort(list);
        System.out.println("Sorted list:" + list);
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        populate(list1);
        System.out.println("Origianl list:" + list1);
        sortAndPrint(list1);
        shuffleAndPrint(list1);
        shuffleAndPrint(list1);
        shuffleAndPrint(list1);
        list1 = new LinkedList<>();
        populate(list1);
        System.out.println("Origianl list:" + list1);
        sortAndPrint(list1);
        shuffleAndPrint(list1);
        shuffleAndPrint(list1);
        shuffleAndPrint(list1);
    }
}
