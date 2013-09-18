package io.p02;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class SortedDirList {

    private File dir;
    private String[] sortedList;

    public SortedDirList(File dir) {
        this.dir = dir;
    }

    public String[] list() {
        sortedList = dir.list();
        Arrays.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
        return sortedList;
    }

    public String[] list(final String regexp) {
        if (regexp == null) {
            return list();
        }
        sortedList = dir.list(new FilenameFilter() {
            Pattern pattern = Pattern.compile(regexp);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
        return sortedList;
    }

    public static void main(String[] args) {
        File f = new File(".\\src\\net\\mindview\\util\\");
        System.out.println(Arrays.deepToString(new SortedDirList(f).list()));
        System.out.println(Arrays.deepToString(new SortedDirList(f).list("B.*")));
        System.out.println(Arrays.deepToString(new SortedDirList(f).list(".*\\..*")));
    }
}
