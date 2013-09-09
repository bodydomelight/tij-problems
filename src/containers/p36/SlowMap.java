package containers.p36;

import containers.p15.*;
import java.util.*;
import net.mindview.util.*;

public class SlowMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    private List<MapEntry<K, V>> entries = new ArrayList<>();
    private final MapEntriesComparator<K, V> comp = new MapEntriesComparator<>();

    @Override
    public V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException();
        }
        MapEntry<K, V> entry = findEntry(key);
        V oldValue = null;
        if (entry != null) {
            oldValue = entry.getValue();
            entry.setValue(value);
            return oldValue;
        }
        entries.add(new MapEntry<>(key, value));
        Collections.sort(entries, comp);
        return oldValue;
    }

    @Override
    public V get(Object key) { // key is type Object, not K
        if (key == null) {
            throw new NullPointerException();
        }
        MapEntry<K, V> entry = findEntry((K) key);
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    @Override
    public V remove(Object key) {
        if (key == null) {
            throw new NullPointerException();
        }
        MapEntry<K, V> entry = findEntry((K) key);
        if (entry != null) {
            V oldValue = entry.getValue();
            entries.remove(entry);
            return oldValue;
        }
        return null;
    }

    @Override
    public void clear() {
        entries.clear();
    }

    private MapEntry<K, V> findEntry(K key) {
        int index = Collections.binarySearch(entries, new MapEntry<K, V>(key, null), comp);
        MapEntry<K, V> entry = null;
        if (index >= 0) {
            entry = entries.get(index);
        }
        return entry;
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {
                Iterator<MapEntry<K, V>> ki = entries.iterator();
                K currentKey;

                @Override
                public boolean hasNext() {
                    return ki.hasNext();
                }

                @Override
                public Entry<K, V> next() {
                    return ki.next();
                }

                @Override
                public void remove() {
                    ki.remove();
                }
            };
        }

        @Override
        public int size() {
            return entries.size();
        }
    }

    public static void main(String[] args) {
        TextFile tf = new TextFile(".\\src\\containers\\p13\\test.txt", "\\W+");
        SlowMap<String, Integer> aa = new SlowMap<>();
        for (String word : tf) {
            word = word.toLowerCase();
            if (aa.get(word) == null) {
                aa.put(word, 1);
            } else {
                aa.put(word, aa.get(word) + 1);
            }
        }
        System.out.println(aa);
    }
}

class MapEntriesComparator<K, V> implements Comparator<MapEntry<K, V>> {

    @Override
    public int compare(MapEntry<K, V> o1, MapEntry<K, V> o2) {
        Comparable<K> k1 = (Comparable<K>)o1.getKey();
        return k1.compareTo(o2.getKey());
    }
}