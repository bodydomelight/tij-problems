package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamsTest {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in))) {
            String s1, s2;
            while ((s1 = br1.readLine()) != null) {
                if (s1.equals("break")) {
                    s2 = s1;
                    break;
                }
                System.out.println("br1: " + s1);
            }
            while ((s2 = br2.readLine()) != null) {
                System.out.println("br2: " + s2);
            }
        }
    }
}
