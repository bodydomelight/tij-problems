package containers.p39;

import containers.p25.*;
import java.util.*;
import net.mindview.util.*;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    private int SIZE = 32;
    private int size = 0;
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        //rehash();
        V oldValue = null;
        int index = getIndex((K) key);
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
            buckets[index].add(pair);
        } else {
            LinkedList<MapEntry<K, V>> bucket = buckets[index];

            boolean found = false;
            MapEntry<K, V> currentEntry = bucket.getFirst();
            while (currentEntry.getNextEntry() != null) {
                MapEntry<K, V> iPair = currentEntry.getNextEntry();

                if (iPair.getKey().equals(key)) {
                    oldValue = iPair.getValue();
                    currentEntry.setNextEntry(pair);
                    pair.setNextEntry(iPair.getNextEntry());
                    bucket.set(bucket.indexOf(iPair), pair); // Replace old with new
                    found = true;
                    break;
                }
            }
            if (!found) {
                buckets[index].getLast().setNextEntry(pair);
                buckets[index].add(pair);
                size++;
            }
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
                    size--;
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
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void rehash() {
        if ((float) size / (float) SIZE > 0.75) {
//            System.out.println("rehashing");
//            System.out.println("SIZE: " + SIZE);
            SIZE = PrimeNumber.getNextPrimeNumberAfter(SIZE * 2);
//            System.out.println("new SIZE: " + SIZE);
            LinkedList<MapEntry<K, V>>[] oldBuckets = buckets;
            buckets = new LinkedList[SIZE];
            for (LinkedList<MapEntry<K, V>> bucket : oldBuckets) {
                for (MapEntry<K, V> entry : bucket) {
                    put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<>();
        m.putAll(Countries.capitals(3));
        System.out.println(m);
        System.out.println("m.size() : " + m.size());
        m.remove("ALGERIA");
        m.remove("ALGERIA");
        m.remove("BENIN");
        System.out.println("m.get(\"BENIN\") = " + m.get("BENIN"));
        System.out.println(m);
        m.clear();
        System.out.println("m.size() : " + m.size());
        System.out.println(m);
        System.out.println("m.isEmpty() : " + m.isEmpty());
        m.putAll(Countries.capitals(25));
        System.out.println("m.containsKey(\"BENIN\") : " + m.containsKey("BENIN"));
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
