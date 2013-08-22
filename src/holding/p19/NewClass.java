package holding.p19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class NewClass {
    
    Set<String> hashSet;
    Set<String> linkedHashSet;
    
    public static void main(String[] args) {
        
        NewClass nc = new NewClass();
        nc.hashSet = new HashSet<String>();
        
        nc.hashSet.add("1");
        nc.hashSet.add("2");
        nc.hashSet.add("3");
        nc.hashSet.add("4");
        
        nc.linkedHashSet = new LinkedHashSet<String>
                (new TreeSet<String>(nc.hashSet));
        
        System.out.println(nc.hashSet);
        System.out.println(nc.linkedHashSet);
    }
}
