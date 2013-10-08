package io.p21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CapitalizeInput {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in))) {
            String s;
            while((s = br.readLine()) != null) {
                System.out.println(s.toUpperCase());
            }
        }
    }
}
