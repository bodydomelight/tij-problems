/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays.p25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PythonList<T> extends ArrayList<T> {

    public PythonList<T> getReversed() {
        PythonList<T> reversed = new PythonList<>();
        reversed.addAll(this);
        Collections.reverse(reversed);
        return reversed;
    }

    public PythonList(List<T> t) {
        super(t);
    }

    public PythonList() {
    }

    public static void main(String[] args) {
        PythonList<String> pl = new PythonList<>(Arrays.asList("one", "two", "three", "four", "five"));
        System.out.println("Before:" + pl);
        System.out.println("Reversed:" + pl.getReversed());
        System.out.println("Original:" + pl);

    }
}
