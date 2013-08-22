/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ContainersInDepth.p06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author aamelin
 */
public class Unsupported {
    public static void test(String message, List<String> list) {
        System.out.println(message);
        try {
            list.add(0, "zero");
        } catch (UnsupportedOperationException e) {
            System.out.println("add(int index, E element) isn't supported");
        }
        try {
            list.addAll(0, Arrays.asList("zero", "minus one"));
        } catch (UnsupportedOperationException e) {
            System.out.println("addAll(int index, Collection<? extends E> c) isn't supported");
        }
        try {
            list.set(0, "zero");
        } catch (UnsupportedOperationException e) {
            System.out.println("set(int index, E element) isn't supported");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String[] values = {"one", "two", "three", "four"};
        test("modifiable list", new ArrayList<>(Arrays.asList(values)));        
        test("Arrays.asList() list", Arrays.asList(values));        
        test("Arrays.asList() list", Collections.unmodifiableList(new ArrayList<>(Arrays.asList(values))));        
        
    }
}
//void add(int index, E element)
//boolean addAll(int index, Collection<? extends E> c)
//E set(int index, E element)
