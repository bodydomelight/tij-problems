package io.p13;

import java.io.*;

public class BufferedInputFile {
// Throw exceptions to console:

    public static String read(String filename) throws IOException {
        StringBuilder sb;
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String s;
            sb = new StringBuilder();
            while ((s = in.readLine()) != null) {
                sb.append(s).append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.print(read(".\\src\\io\\p13\\BufferedInputFile.java"));
    }
}
