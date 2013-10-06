package test;

import java.io.*;
import java.util.Date;

public class Echo {

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in));
        String s;
        while ((s = stdin.readLine()) != null && s.length() != 0) {
            System.out.println(new Date() + ": " + s);
        }
// An empty line or Ctrl-Z terminates the program
    }
}
