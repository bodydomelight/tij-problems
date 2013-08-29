package holding.p09;

import java.util.*;

public class Sequence{

    private List<Object> items = new ArrayList<Object>();

    public Iterator selector() {
        return items.iterator();
    }
    public void add(Object o) {
        items.add(o);
    }
    
    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Iterator<Object> selector = sequence.selector();
        while(selector.hasNext()) {
            System.out.print(selector.next() + " ");
        }
    }
} /* Output:
0 1 2 3 4 5 6 7 8 9
*/