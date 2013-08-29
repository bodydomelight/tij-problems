package containers.p15;

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
        Set<Map.Entry<K, V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext()) {
            set.add(new MapEntry<>(ki.next(), vi.next()));
        }
        return set;
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