package io.p04;

import java.io.File;
import java.util.regex.Pattern;
import net.mindview.util.Directory;

public class FileSizeFinder {
    
    public static long getSizes(String path, String regexp) {
        long size = 0;
        Pattern p = Pattern.compile(regexp);
        for (File file : Directory.walk(path)) {
            if (p.matcher(file.getName()).matches())
                System.out.println(file.getName() + " : " + file.length() + " bytes");
                size += file.length();
        }
        System.out.println("Total size: " + size + " bytes");
        return size;
    }
    public static void main(String[] args) {
//        System.out.println("., .* : " + getSizes(".", ".*"));
//        System.out.println("., T.* : " + getSizes(".", "T.*\\.java"));
        System.out.println(".., T.* : " + getSizes("..", "T.*\\.java"));
    }
}
