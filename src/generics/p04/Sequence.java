package generics.p04;

import java.util.ArrayList;
import java.util.List;

interface Selector {

    boolean end();

    Object current();

    void next();
}

public class Sequence<T> {

    private List<T> items;

    public Sequence(int size) {
        items = new ArrayList<>();
    }

    public void add(T x) {
        items.add(x);
    }

    private class SequenceSelector implements Selector {

        private int i = 0;

        @Override
        public boolean end() {
            return i == items.size();
        }

        @Override
        public Object current() {
            return items.get(i);
        }

        @Override
        public void next() {
            if (i < items.size()) {
                i++;
            }
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
