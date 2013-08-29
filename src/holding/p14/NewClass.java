package holding.p14;

import java.util.LinkedList;

public class NewClass {
    private static LinkedList<Integer> a = new LinkedList<Integer>();
    public static void addElement(Integer x) {
        a.add(a.size()/2, x);
    }
    public static void main(String[] args) {
        for (int i = 0; i <10; i++) {
            addElement(i);
            System.out.println(a);
        }
        
    }
}
