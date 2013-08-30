package containers.p18;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SlowSet<E> extends AbstractSet<E> {

    List<E> values = new ArrayList<>();

    @Override
    public Iterator<E> iterator() {
        return values.iterator();
    }

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public boolean add(E element) {
        if (values.contains(element)) {
            return false;
        }
        values.add(element);
        return true;
    }
    
    public static void main(String[] args) {
        SlowSet<String> slowset = new SlowSet<>();
        for (int i = 0; i < 10; i++)
            slowset.add("" + i);
        System.out.println(slowset);
        slowset.add("9");
        System.out.println(slowset);
        slowset.remove("4");
        System.out.println(slowset);
        slowset.clear();
        System.out.println("isEmpty(): " + slowset.isEmpty());
    }
}
