package io.p17;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import net.mindview.util.TextFile;

public class CharacterOccurence {

    public static void main(String[] args) {
        String file = ".\\src\\io\\p17\\sample.txt";
        char[] text = TextFile.read(file).toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        Integer currentNumber;
        for (char c : text) {
                currentNumber = map.get(c);
                map.put(c, currentNumber == null ? 1 : currentNumber + 1);
        }
        System.out.println(text);
        System.out.println(map);
    }
}
