/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package containers.p02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.mindview.util.Countries;

/**
 *
 * @author rage
 */
public class ACountriesTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        Map<String, String> capitals = Countries.capitals();
        for (String country : capitals.keySet()) {
            if (country.toLowerCase().charAt(0) == 'a') {
                map.put(country, capitals.get(country));
                set.add(country);
            }
        }
        System.out.println("set" + set + " " + set.size() + "\nmap" + map
                + " " + map.size());

    }
}
