package holding.p20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NewClass {

    public static void main(String[] args) {

        Map<Character, Integer> vowels;
        vowels = new HashMap<Character, Integer>();
        vowels.put('a', 0);
        vowels.put('e', 0);
        vowels.put('i', 0);
        vowels.put('o', 0);
        vowels.put('u', 0);
        vowels.put('y', 0);

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
        char[] wordCh;
        int vowelsInWord;
        int counter;
        for (String word : words) {
            vowelsInWord = 0;
            wordCh = word.toLowerCase().toCharArray();
            for (Character vowel : vowels.keySet()) {
                for (int j = 0; j < wordCh.length; j++) {
                    if (wordCh[j] == vowel) {
                        vowelsInWord++;
                        vowelsInText++;
                        counter = vowels.get(vowel);
                        counter++;
                        vowels.put(vowel, counter);
                    }
                }
            }
            System.out.println("\"" + word + "\" has " + vowelsInWord + 
                    " vowels.");

        }
        for (Character vowel : vowels.keySet()) {
            System.out.println("Number of occurences of vowel \"" + vowel
                    + "\" is: " + vowels.get(vowel) + ".");
        }
        System.out.println("The text has " + vowelsInText + " vowels.");
    }
}