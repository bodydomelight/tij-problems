package containers.p33;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;

public class FastTravelLinkedList<V> extends AbstractList<V> {

    FlaggedArrayList<V> a;
    FlaggedLinkedList<V> l;

    private class FlaggedArrayList<V> {

        ArrayList<V> aList;
        public int size() {
            return aList.size();
        }
        public V get(int index) {
            return aList.get(index);
        }
    }

    private class FlaggedLinkedList<V> {

        LinkedList<V> lList;
    }
    private boolean modified;

    @Override
    public V get(int index) {
        return a.get(index);
    }

    @Override
    public int size() {
        return a.size();
    }

    public static void main(String[] args) {
    }
}
