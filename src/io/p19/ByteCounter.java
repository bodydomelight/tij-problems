package io.p19;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import net.mindview.util.BinaryFile;

public class ByteCounter {

    public static Map<Byte, Integer> countBytes(File file) throws IOException {
        byte[] bytes = BinaryFile.read(file);
        Map<Byte, Integer> map = new TreeMap<>();
        Integer value;
        for (byte b : bytes) {
            map.put(b, (value = map.get(b)) == null ? 1 : ++value);
        }
        return map;
    }

    public static Map<Byte, Integer> countBytes(String path) throws IOException {
        return countBytes(new File(path));
    }

    public static void main(String[] args) throws IOException {
        System.out.println(countBytes(".\\src\\io\\p19\\sample.txt"));
    }
}
