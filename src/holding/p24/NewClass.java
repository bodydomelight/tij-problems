/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package holding.p24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author aamelin
 */
public class NewClass {
    Map<String, String> map = new LinkedHashMap<String, String>();
    public static void main(String[] args) {
        NewClass nc = new NewClass();
        nc.map.put("dog", "first");
        nc.map.put("Cat", "second");
        nc.map.put("squirrel", "third");
        nc.map.put("Cow", "fourth");
        List<String> list = new ArrayList<String>(nc.map.keySet());
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Sorted list: " + list);
        Map<String, String> newMap = new LinkedHashMap<String, String>();
        for (String str : list) {
            newMap.put(str, nc.map.get(str));
        }
        System.out.println("resulting map: " + newMap);
    }
}
