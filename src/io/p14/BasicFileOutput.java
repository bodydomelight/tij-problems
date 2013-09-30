package io.p14;

import io.p13.*;
import java.io.*;

public class BasicFileOutput {

    static String file = ".\\build\\classes\\io\\p14\\BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        BufferedReader in = new BufferedReader(new StringReader(
                BufferedInputFile.read(".\\src\\io\\p14\\BasicFileOutput.java")));
        try (PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter(file)))) {
            String s;
            int lineNumber = 1;
            while ((s = in.readLine()) != null) {
                out.println(lineNumber++ + ": " + s);
            }
        }
        System.out.println("  buffered: " + (System.nanoTime() - start));
        start = System.nanoTime();
        FileReader in2 = new FileReader(".\\src\\io\\p14\\BasicFileOutput.java");
        try (PrintWriter out = new PrintWriter(
                new FileWriter(file))) {
            int s;
            while ((s = in2.read()) != -1) {
                out.println((char) s);
            }
        }
        System.out.println("unbuffered: " + (System.nanoTime() - start));
// Show the stored file:
//        System.out.println(BufferedInputFile.read(file));
    }
}
