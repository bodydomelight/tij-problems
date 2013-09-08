/*
 * Create a FastTraversalLinkedList that internally uses a LinkedList
 * for rapid insertions and removals, and an ArrayList for rapid traversals and get( )
 * operations. Test it by modifying ListPerformance.java
 */
package containers.p33;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class FastTravelLinkedList<V> extends AbstractList<V> {

    InnerArrayList a;
    InnerLinkedList l;

    public FastTravelLinkedList() {
        a = new InnerArrayList();
        l = new InnerLinkedList();
        a.addCompanion(l);
        l.addCompanion(a);
    }

    private class InnerArrayList {

        private List<V> list = new ArrayList<>();
        private InnerLinkedList companion;
        boolean changed = false;

        public void addCompanion(InnerLinkedList other) {
            companion = other;
        }

        private int size() {
            synchronize();
            return list.size();
        }

        private V get(int index) {
            synchronize();
            return list.get(index);
        }

        private boolean remove(Object o) {
            synchronize();
            changed = true;
            return list.remove(o);
        }

        private V remove(int index) {
            synchronize();
            changed = true;
            return list.remove(index);
        }

        @Override
        public String toString() {
            synchronize();
            return list.toString();
        }

        private void clear() {
            list.clear();
        }

        private void synchronize() {
            if (companion.changed) {
                list = new ArrayList<>(l.list);
                companion.changed = false;
            }
        }
    }

    private class InnerLinkedList {

        private List<V> list = new LinkedList<>();
        private InnerArrayList companion;
        boolean changed = false;

        public void addCompanion(InnerArrayList other) {
            companion = other;
        }

        private boolean add(V element) {
            synchronize();
            changed = true;
            return list.add(element);
        }

        private void add(int index, V element) {
            synchronize();
            changed = true;
            list.add(index, element);
        }

        private V set(int index, V element) {
            synchronize();
            changed = true;
            return list.set(index, element);
        }

        private Iterator<V> iterator() {
            synchronize();
            return list.iterator();
        }

        private ListIterator<V> listIterator() {
            return listIterator(0);
        }

        private ListIterator<V> listIterator(final int index) {
            synchronize();
            return list.listIterator(index);
        }

        private void clear() {
            list.clear();
        }

        private void synchronize() {
            if (companion.changed) {
                list = new LinkedList<>(a.list);
                companion.changed = false;
            }
        }
    }

    @Override
    public boolean add(V element) {
        return l.add(element);
    }

    @Override
    public void add(int index, V element) {
        l.add(index, element);
    }

    @Override
    public V get(int index) {
        return a.get(index);
    }

    @Override
    public V set(int index, V element) {
        return l.set(index, element);
    }

    @Override
    public boolean remove(Object o) {
        return a.remove(o);
    }

    @Override
    public V remove(int index) {
        return a.remove(index);
    }

    @Override
    public ListIterator<V> listIterator() {
        return l.listIterator();
    }

    @Override
    public ListIterator<V> listIterator(int index) {
        return l.listIterator();
    }

    @Override
    public Iterator<V> iterator() {
        return l.iterator();
    }

    @Override
    public void clear() {
        a.clear();
        l.clear();
    }

    @Override
    public int size() {
        return a.size();
    }

    @Override
    public String toString() {
        return a.toString();
    }

    public static void main(String[] args) {
        FastTravelLinkedList<String> f = new FastTravelLinkedList<>();
        for (int i = 0; i < 10; i++) {
            f.add(i + "");
        }

        System.out.println("f: " + f);
        f.add("Z");
        System.out.println("f.add(\"Z\"): " + f);
        f.add(5, "X");
        System.out.println("f.add(5, \"X\"): " + f);
        System.out.println("f.get(9): " + f.get(9));
        f.remove("0");
        System.out.println("f.remove(\"0\"): " + f);
        f.set(3, "Y");
        System.out.println("f.set(3, \"Y\"): " + f);
        System.out.println("f.size(): " + f.size());
        Iterator<String> it = f.iterator();
        System.out.print("it.next(): ");
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
        System.out.println();
        System.out.println("it.previous() + it.remove()");
//        while (it.hasPrevious()) {
//            System.out.print(it.previous() + ", ");
//            it.remove();
//        }
        System.out.println();
        System.out.println("f: " + f);
        it = f.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        System.out.println();
        System.out.println("after loop f: " + f);
        f.add("A");
        it = f.iterator();
//        System.out.println("it.next(): " + it.next());
        f.add("X");
        try {
            System.out.println("it.next(): " + it.next());
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException caught.");
        }

    }
}
