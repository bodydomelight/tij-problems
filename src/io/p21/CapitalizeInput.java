package io.p21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CapitalizeInput {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in))) {
            String s;
            do {
                System.out.print("Enter a string ('quit' to exit): ");
                s = br.readLine();
                if (!s.equalsIgnoreCase("quit")) {
                    System.out.println(s.toUpperCase());
                }
            } while (!s.equalsIgnoreCase("quit"));
        }
    }
}