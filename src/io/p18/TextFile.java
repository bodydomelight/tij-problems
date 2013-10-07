package io.p18;

import java.io.*;
import java.util.*;

public class TextFile extends ArrayList<String> {
// Read a file as a single string:

    public static String read(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(
                new File(fileName).getAbsoluteFile()))) {
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
// Write a single file in one method call:

    public static void write(String fileName, String text) throws IOException {
        try (PrintWriter out = new PrintWriter(
                new File(fileName).getAbsoluteFile())) {
            out.print(text);
        }
    }
// Read a file, split by any regular expression:

    public TextFile(String fileName, String splitter) throws IOException {
        super(Arrays.asList(read(fileName).split(splitter)));
        // Regular expression split() often leaves an empty
        // String at the first position:
        if (get(0).equals("")) {
            remove(0);
        }
    }
// Normally read by lines:

    public TextFile(String fileName) throws IOException {
        this(fileName, "\n");
    }

    public void write(String fileName) throws IOException {
        try (PrintWriter out = new PrintWriter(
                new File(fileName).getAbsoluteFile())) {
            for (String item : this) {
                out.println(item);
            }
        }
    }
// Simple test:

    public static void main(String[] args) throws IOException {
        String file = read(".\\src\\io\\p18\\sample.txt");
        write(".\\src\\io\\p18\\test.txt", file);
        TextFile text = new TextFile(".\\src\\io\\p18\\test.txt");
        text.write(".\\src\\io\\p18\\test.txt2");
// Break into unique sorted list of words:
        TreeSet<String> words = new TreeSet<>(
                new TextFile(".\\src\\io\\p18\\sample.txt", "\\W+"));
// Display the capitalized words:
        System.out.println(words.headSet("a"));
    }
}
