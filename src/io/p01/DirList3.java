package io.p01;

import java.util.regex.*;
import java.io.*;
import java.util.*;
import net.mindview.util.TextFile;

public class DirList3 {

    public static FilenameFilter filter(final String regexp) {
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regexp);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        String[] newArgs = {"Str.*"};
        File path = new File(".\\src\\net\\mindview\\util\\");
        String[] list = path.list();
        System.out.println(Arrays.deepToString(list));
        for (String dirItem : list) {
            TextFile tf = new TextFile(path.getAbsolutePath() + "\\" + dirItem, "\\W");
            for (String arg : newArgs) {
                if (tf.contains(arg)) {
                    System.out.println(dirItem);
                    break;
                }
            }
        }
    }
}
