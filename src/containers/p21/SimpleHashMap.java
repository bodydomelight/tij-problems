package containers.p21;

import containers.p15.MapEntry;
import java.util.*;
import net.mindview.util.*;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
// Choose a prime number for the hash table
// size, to achieve a uniform distribution:

    static final int SIZE = 3;
// You can’t have a physical array of generics,
// but you can upcast to one:
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] != null) {
//            System.out.println("Collision for key:" + key);
        }
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
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        }
        int probe = 0;
        for (MapEntry<K, V> iPair : buckets[index]) {
            probe++;
            if (iPair.getKey().equals(key)) {
                System.out.println("Number of probes is: " + probe
                        + " entry is: " + iPair.getKey() + " : " + iPair.getValue());
                return iPair.getValue();
            }
        }
        return null;
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

    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<>();
        m.putAll(Countries.capitals(25));
        for (String str : m.keySet()) {
            m.get(str);
        }
        System.out.println(m);

    }
}
