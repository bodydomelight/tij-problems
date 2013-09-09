package containers.p17;

import containers.p15.*;
import java.util.*;
import net.mindview.util.*;

public class SlowMap<K, V> extends AbstractMap<K, V> {

    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public V put(K key, V value) {
        V oldValue = get(key); // The old value or null
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) { // key is type Object, not K
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    @Override
    public V remove(Object key) {
        V oldValue = get(key);
        if (keys.contains(key)) {
            values.remove(keys.indexOf(key));
            keys.remove(key);
        }
        return oldValue;
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {
                Iterator<K> ki = keys.iterator();
                K currentKey;

                @Override
                public boolean hasNext() {
                    return ki.hasNext();
                }

                @Override
                public Entry<K, V> next() {
                    if (!ki.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    currentKey = ki.next();
                    return new MapEntry<>(currentKey, values.get(keys.indexOf(currentKey)));
                }

                @Override
                public void remove() {
                    if (currentKey == null) {
                        throw new IllegalStateException();
                    }
                    values.remove(keys.indexOf(currentKey));
                    ki.remove();
                    currentKey = null;
                }
            };
        }

        @Override
        public int size() {
            return keys.size();
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