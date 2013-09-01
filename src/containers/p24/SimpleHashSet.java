package containers.p24;

import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import net.mindview.util.Countries;

public class SimpleHashSet<V> extends AbstractSet<V> {

    private final int SIZE = 997;
    private long id = System.nanoTime();
    List<V>[] buckets = new LinkedList[SIZE];

    @Override
    public boolean add(V v) {
        int index = getIndex(v);
        List<V> bucket = buckets[index];
        if (bucket == null) {
            bucket = new LinkedList<>();
            buckets[index] = bucket;
            return bucket.add(v);
        }
        if (!bucket.contains(v)) {
            return bucket.add(v);
        }
        return false;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private long itId = id;
            private int index = -1;
            Iterator<V> bi = getNextBucketIterator();

            @Override
            public boolean hasNext() {
                checkForConcurrentModification();
                if (bi == null) {
                    return false;
                }
                if (bi.hasNext()) {
                    return true;
                } else {
                    bi = getNextBucketIterator();
                    return bi == null ? false : bi.hasNext();
                }
            }

            @Override
            public V next() {
                checkForConcurrentModification();
                if (hasNext()) {
                    return bi.next();
                }
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                checkForConcurrentModification();
                if (bi != null) {
                    bi.remove();
                    id++;
                    itId++;
                } else {
                    throw new IllegalStateException();
                }
            }

            private Iterator<V> getNextBucketIterator() {
                for (++index; index < buckets.length; index++) {
                    if (buckets[index] != null && !buckets[index].isEmpty()) {
                        return buckets[index].iterator();
                    }
                }
                return null;
            }

            private void checkForConcurrentModification() {
                if (id != itId) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    @Override
    public int size() {
        int size = 0;
        for (List<V> bucket : buckets) {
            if (bucket != null) {
                size += bucket.size();
            }
        }
        return size;
    }

    private int getIndex(V v) {
        return Math.abs(v.hashCode()) % SIZE;
    }

    public static void main(String[] args) {
        Set<String> set = new SimpleHashSet<>();
        set.addAll(Countries.names(10));
        System.out.println("set : " + set);
        System.out.println("set.size() : " + set.size());
        set.addAll(Countries.names(10));
        System.out.println("set : " + set);
        System.out.println("set.size() : " + set.size());
        set.remove("CHAD");
        System.out.println("set.remove(\"CHAD\") : " + set);
        System.out.println("set.size() : " + set.size());
        set.remove("CHAD");
        System.out.println("once again set.remove(\"CHAD\") : " + set);
        System.out.println("set.size() : " + set.size());
        try {
            for (String name : set) {
                set.remove(name);
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException caught");
        }
        set.addAll(Countries.names(10));
        System.out.println("set remove all via foreach : " + set);
        System.out.println("set.size() : " + set.size());
        set.addAll(Countries.names(10));
        set.add("TEST");
        System.out.println("set.add(\"TEST\") : " + set);
        System.out.println("set.contains(\"TEST\") : " + set.contains("TEST"));
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next() + "; set.size() : " + set.size());
            it.remove();
        }
        System.out.println("set after delete via iterator : " + set);
        set.addAll(Countries.names(10000));
        System.out.println("set with 10000 duplicating entries : " + set);
        System.out.println("set.size() : " + set.size());
        it = set.iterator();
        try {
            it.next();
            it.remove();
            it.remove();
        } catch(IllegalStateException e) {
            System.out.println("double .remove()");
        }
    }
}
