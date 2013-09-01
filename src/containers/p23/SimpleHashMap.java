package containers.p23;

import containers.p15.MapEntry;
import java.util.*;
import net.mindview.util.*;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
// Choose a prime number for the hash table
// size, to achieve a uniform distribution:

    static final int SIZE = 997;
// You can’t have a physical array of generics,
// but you can upcast to one:
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = getIndex((K) key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();

            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair); // Replace old with new
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = getIndex((K) key);
        if (buckets[index] == null) {
            return null;
        }
        for (MapEntry<K, V> iPair : buckets[index]) {
            if (iPair.getKey().equals(key)) {
                return iPair.getValue();
            }
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        V oldValue = null;
        List<MapEntry<K, V>> bucket = buckets[getIndex((K) key)];
        if (bucket != null) {
            for (MapEntry<K, V> iPair : bucket) {
                if (iPair.getKey().equals(key)) {
                    oldValue = iPair.getValue();
                    bucket.remove(iPair);
                    break;
                }
            }
        }
        return oldValue;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            for (MapEntry<K, V> mpair : bucket) {
                set.add(mpair);
            }
        }
        return set;
    }

    @Override
    public void clear() {
        buckets = new LinkedList[SIZE];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<>();
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println("m.size() : " + m.size());
        m.remove("CHAD");
        m.remove("CHAD");
        m.remove("KENYA");
        System.out.println("m.get(\"KENYA\") = " + m.get("KENYA"));
        System.out.println(m);
        m.clear();
        System.out.println("m.size() : " + m.size());
        System.out.println(m);
        System.out.println("m.isEmpty() : " + m.isEmpty());
        m.putAll(Countries.capitals(25));
        System.out.println("m.containsKey(\"KENYA\") : " + m.containsKey("KENYA"));
        System.out.println("m.containsValue(\"Nairobi\") : " + m.containsValue("Nairobi"));
        System.out.println(m.entrySet());
        SimpleHashMap<String, String> m2 = new SimpleHashMap<>();
        m2.putAll(Countries.capitals(25));
        System.out.println("m.equals(m2) : " + m.equals(m2));
        System.out.println("m.hashCode() : " + m.hashCode());
        System.out.println("m.keySet() : " + m.keySet());
        System.out.println("m.values() : " + m.values());
    }
}
