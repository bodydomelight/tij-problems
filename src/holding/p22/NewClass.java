package holding.p22;

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

    private Set<WordStat> setOfWordStat;
    private List<String> words;
    private FileReader fileReader;
    private BufferedReader reader;
    private String line;
    private boolean wordIsPresentInSet;

    public NewClass() {
        setOfWordStat = new HashSet<WordStat>();
    }

    //takes a path to a file, returns an ArrayList of words in it
    public List<String> getWords(String path) {
        try {
            fileReader = new FileReader(path);
            reader = new BufferedReader(fileReader);
            words = new ArrayList<String>();


            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                Collections.addAll(words, line.split("([.,!?*:;/\"-<>=\\{\\}]|\\s)+"));
            }
            //System.out.println(words);
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
        return words;
    }

    //takes List<String> and add words in it to the Set
    public void addWordsToSet(List<String> words) {
        Set<String> setOfWords = new HashSet<String>(words);

        for (String word : setOfWords) {
            setOfWordStat.add(new WordStat(word));
        }
        for (String word : words) {
            for (WordStat ws : setOfWordStat) {
                ws.addWord(word);
            }
        }
    }

    public static void main(String[] args) {
        NewClass nc = new NewClass();
        nc.getWords("C:\\Users\\aamelin\\Documents\\Google Drive\\Study\\Java\\"
                + "TIJ-code 4th ed\\holding\\UniqueWords.java");
        nc.addWordsToSet(nc.words);
        System.out.println(nc.words);
        for (WordStat ws : nc.setOfWordStat) {
            System.out.println(ws);
        }

    }
}
