package holding.p18;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class NewClass {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<String, String>();
        Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        hashMap.put("1", "first value");
        hashMap.put("2", "second value");
        hashMap.put("3", "third value");
        hashMap.put("4", "fourth value");
        
        Set<String> keys = new TreeSet<String>(hashMap.keySet());
        
        for (String key : keys) {
            linkedHashMap.put(key, hashMap.get(key));
        }
        System.out.println(hashMap);
        System.out.println(linkedHashMap);
    }
}
