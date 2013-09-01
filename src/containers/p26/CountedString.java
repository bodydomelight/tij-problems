package containers.p26;

import java.util.*;
import static net.mindview.util.Print.*;

public class CountedString {

    private static List<String> created = new ArrayList<>();
    private String s;
    char c;
    private int id = 0;

    public CountedString(String str, char c) {
        s = str;
        this.c = c;
        created.add(s);
// id is the total number of instances
// of this string in use by CountedString:
        for (String s2 : created) {
            if (s2.equals(s)) {
                id++;
            }
        }
    }

    @Override
    public String toString() {
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode() + 
                " char: " + c;
    }

    @Override
    public int hashCode() {
// The very simple approach:
// return s.hashCode() * id;
// Using Joshua Bloch’s recipe:
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + (int) c;
        result = 37 * result + id;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CountedString
                && s.equals(((CountedString) o).s)
                && c == ((CountedString) o).c
                && id == ((CountedString) o).id;
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi", 'x');
            map.put(cs[i], i); // Autobox int -> Integer
        }
        print(map);
        for (CountedString cstring : cs) {
            print("Looking up " + cstring);
            print(map.get(cstring));
        }
    }
}
