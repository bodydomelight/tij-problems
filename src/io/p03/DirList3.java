package io.p03;

import java.util.regex.*;
import java.io.*;
import java.util.*;
import net.mindview.util.TextFile;

public class DirList3 {

    public static FilenameFilter filter(final String[] regexps) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                TextFile tf = new TextFile(dir + "\\" + name, "\\W");
                Pattern pattern;
                for (String arg : regexps) {
                    pattern = Pattern.compile(arg);
                    for (String word : tf) {
                        if (pattern.matcher(word).matches()) {
                            return true;
                        }
                    }
                }
                return false;
            }
        };
    }

    public static long getTotalSize(File[] files) {
        long totalSize = 0;
        for (File file : files) {
            if (file.isFile()) {
                totalSize += file.length();
            }
        }
        return totalSize;
    }

    public static void main(String[] args) {
        String[] newArgs = {""};
        File path = new File(".\\src\\net\\mindview\\util\\");
        File[] list = path.listFiles(filter(newArgs));
        System.out.println(list.length);
        System.out.println(Arrays.deepToString(list));
        System.out.println("Total files size is: " + getTotalSize(list) + " bytes.");
    }
}
