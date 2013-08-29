package containers.p13;

import net.mindview.util.TextFile;

public class AssociativeArray<K, V> {

    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        boolean keyFound = false;;
        for (int i = 0; i < pairs.length; i++) {
            if (key.equals(pairs[i][0])) {
                keyFound = true;
                pairs[i][1] = value;
                return;
            }
        }
        if (index >= pairs.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (!keyFound) {
            pairs[index++] = new Object[]{key, value};
        }
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0])) {
                return (V) pairs[i][1];
            }
        }
        return null; // Did not find key
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append("'");
            result.append(pairs[i][0].toString());
            result.append("'");
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if (i < index - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        TextFile tf = new TextFile(".\\src\\containers\\p13\\test.txt", "\\W+");
        AssociativeArray<String, Integer> aa = new AssociativeArray<>(160);
        for (String str : tf) {
            str = str.toLowerCase();
            if (aa.get(str) == null) {
                aa.put(str, 1);
            } else {
                aa.put(str, (aa.get(str) + 1));
            }
        }
        System.out.println(aa);
    }
}
