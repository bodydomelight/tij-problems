package holding.p25;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyFileReader {

    private List<String> words = new ArrayList<String>();
    private FileReader fileReader;
    private BufferedReader reader = null;
    private String line;


    public List<String> getListOfWords(String path) {
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
        return words;
    }
}
