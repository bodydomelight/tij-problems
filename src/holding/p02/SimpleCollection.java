package holding.p02;

import java.util.Set;
import java.util.TreeSet;

public class SimpleCollection {
    public static void main(String[] args) {
        Set<Integer> c = new TreeSet<Integer>();
        for(int i = 0; i < 10; i++) 
      c.add(i); // Autoboxing 
    for(Integer i : c) 
      System.out.print(i + ", ");
    }
}
