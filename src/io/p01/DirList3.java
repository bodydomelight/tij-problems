package io.p01;

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

    public static void main(String[] args) {
        String[] newArgs = {"A", "B", "C"};
        File path = new File(".\\src\\net\\mindview\\util\\");
        String[] list = path.list(filter(newArgs));
        System.out.println(list.length);
        System.out.println(Arrays.deepToString(list));
    }
}
