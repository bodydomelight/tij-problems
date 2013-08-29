/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package containers.p09;

import java.util.Set;
import java.util.TreeSet;
import net.mindview.util.CollectionData;
import net.mindview.util.RandomGenerator;

/**
 *
 * @author rage
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Set<String> ts = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        ts.addAll(CollectionData.list(new RandomGenerator.String(), 20));
        System.out.println(ts);
    }
}
