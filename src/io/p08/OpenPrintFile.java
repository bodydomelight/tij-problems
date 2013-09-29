package io.p08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class OpenPrintFile {

    public static List<String> readFile(File fileName) throws FileNotFoundException, IOException {
        List<String> list;
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            list = new LinkedList<>();
            String line;
            while ((line = in.readLine()) != null) {
                list.add(line);
            }
        }
        return list;
    }

    public static List<String> readFile(String fileName) throws FileNotFoundException, IOException {
        return readFile(new File(fileName));
    }

    public static void printInReverseOrder(List<String> list) {
        ListIterator<String> it = list.listIterator(list.size());
        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        if (args.length != 1) {
            System.out.println("Usage: java OpenPrintFile fullPathToFile");
        } else {
            printInReverseOrder(readFile(args[0]));
        }
    }
}
