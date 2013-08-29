package containers.p10;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedSet;

public class NewSortedSet<E> implements SortedSet<E> {

    private List<E> base;
    private Comparator<? super E> comparator;

    public NewSortedSet() {
        this(new NewSortedSet.NaturalComparator<>());
    }

    public NewSortedSet(Comparator<? super E> comparator) {
        base = new LinkedList<>();
        this.comparator = comparator;
    }

    public NewSortedSet(Collection<? extends E> c) {
        this();
        this.addAll(c);
    }

    //methods declared in SortedSet
    @Override
    public Comparator<? super E> comparator() {
        return comparator;
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        NewSortedSet<E> result = new NewSortedSet<>();
        if (fromElement == null || toElement == null)
            throw new NullPointerException("fromElement or toElement is null");
        if (base.contains(fromElement) && base.contains(toElement)) {
            if (base.indexOf(fromElement) > base.indexOf(toElement))
                throw new IllegalArgumentException("fromElement's index is bigger than toElement's one");
            result.base = base.subList(base.indexOf(fromElement), base.indexOf(toElement));
        }
        return result;
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        NewSortedSet<E> result = new NewSortedSet<>();
        if (toElement == null)
            throw new NullPointerException("toElement is null");
        if (base.contains(toElement)) {
            result.base = base.subList(0, base.indexOf(toElement));
        }
        return result;
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        NewSortedSet<E> result = new NewSortedSet<>();
        if (fromElement == null)
            throw new NullPointerException("fromElement is null");
        if (base.contains(fromElement)) {
            result.base = base.subList(base.indexOf(fromElement), base.size());
        }
        return result;
    }

    @Override
    public E first() {
        if (base.isEmpty()) {
            throw new NoSuchElementException();
        }
        return base.get(0);
    }

    @Override
    public E last() {
        if (base.isEmpty()) {
            throw new NoSuchElementException();
        }
        return base.get(base.size() - 1);
    }

    //methods declared in Set
    @Override
    public int size() {
        return base.size();
    }

    @Override
    public boolean isEmpty() {
        return base.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return base.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return base.iterator();
    }

    @Override
    public Object[] toArray() {
        return base.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return base.toArray(a);
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException("Null elements are not allowed");
        }
        int index = Collections.binarySearch(base, e, comparator);
        if (index < 0) {
            base.add(index * (-1) - 1, e);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return base.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return base.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        if (c == null) {
            return false;
        }
        for (E element : c) {
            if (element == null) {
                continue;
            }
            if (add(element)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return base.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return base.removeAll(c);
    }

    @Override
    public void clear() {
        base.clear();
    }
    
    @Override
    public String toString() {
        return base.toString();
    }

    private static class NaturalComparator<E> implements Comparator<E> {

        @Override
        public int compare(E o1, E o2) {
            if (o1 == null || o2 == null) {
                throw new NullPointerException("The element is null");
            }
            if (!(o1 instanceof Comparable) || !(o1 instanceof Comparable)) {
                throw new ClassCastException("One of elements is not Comparable");
            }
            return ((Comparable) o1).compareTo(o2);
        }
    }
}
