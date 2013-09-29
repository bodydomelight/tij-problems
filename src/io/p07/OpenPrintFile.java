package io.p07;

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
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<String> list = new LinkedList<>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
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
        printInReverseOrder(readFile(".\\src\\io\\p06\\test.txt"));
    }
}
