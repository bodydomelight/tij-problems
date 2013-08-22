package holding.p16;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewClass {

    public static void main(String[] args) {

        Set<Character> vowels;
        vowels = new HashSet<Character>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u', 'y');
        List<String> words = new ArrayList<String>();

        FileReader fileReader;
        BufferedReader reader = null;
        String path = "C:\\Users\\aamelin\\Documents\\Google Drive\\Study"
                + "\\Java\\TIJ-code 4th ed\\holding\\UniqueWords.java";
        String line;
        int vowelsInText = 0;

        try {
            fileReader = new FileReader(path);
            reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                Collections.addAll(words, line.split("([.,!?*:;/\"-<>=\\{\\}]|\\s)+"));
            }
//            System.out.println(words);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotfoundException: %s%n" + e);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("IOException: " + e);
            }
        }
        for (String word : words) {
            int vowelsInWord = 0;
            char[] wordCh;
            wordCh = word.toLowerCase().toCharArray();
            for (Character vowel : vowels) {
                for (int j = 0; j < wordCh.length; j++) {
                    if (wordCh[j] == vowel) {
                        vowelsInWord++;
                        vowelsInText++;
                    }
                }
            }
            System.out.println("\"" + word + "\" has " + vowelsInWord + " vowels.");
        }
        System.out.println("The text has " + vowelsInText + " vowels.");
    }
}