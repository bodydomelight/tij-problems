package holding.p21;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NewClass {

    public static void main(String[] args) {

        List<String> words = new ArrayList<String>();
        Map<String, Integer> stat = new LinkedHashMap<String, Integer>();

        FileReader fileReader;
        BufferedReader reader = null;
        String path = "C:\\Users\\aamelin\\Documents\\Google Drive\\Study"
                + "\\Java\\TIJ-code 4th ed\\holding\\UniqueWords.java";
        String line;

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
        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
        //System.out.println(words);

        int numberOfWords;
        for (String word : words) {
            if (stat.containsKey(word)) {
                numberOfWords = stat.get(word);
                numberOfWords++;
                stat.put(word, numberOfWords);
            } else {
                stat.put(word, 1);
            }
        }
        System.out.println("Number of occurrence of a word:");
        for (String word : stat.keySet()) {
            System.out.println("\"" + word
                    + "\": " + stat.get(word));

        }
    }
}