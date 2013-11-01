package io.p32;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import net.mindview.util.TextFile;
import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

public class WordCalc {

    private Map<String, Integer> processText(String path) {
        TextFile text = new TextFile(path, "\\W+");
        Map<String, Integer> words = new HashMap<>();
        Integer freq;
        for (String word : text) {
            word = word.toLowerCase();
            freq = words.get(word);
            words.put(word, freq == null ? 1 : freq + 1);
        }
        return words;
    }
    private Element getXML(String path) {
        Map<String, Integer> words = processText(path);
        Element root = new Element("words");
        Set<String> keys = new TreeSet(words.keySet());
        for (String word : keys) {
            Element wordNode = new Element("word");
            wordNode.addAttribute(new Attribute("value", word));
            wordNode.addAttribute(new Attribute("quantity", words.get(word).toString()));
            root.appendChild(wordNode);
        }
        return root;
    }

    public void createXML(String path, String xmlFilePath) throws IOException{
        Serializer serializer = new Serializer(new BufferedOutputStream(
                new FileOutputStream(xmlFilePath)), "UTF-8");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(new Document(getXML(path)));
    }

    public static void main(String[] args) throws IOException {
        new WordCalc().createXML(".\\src\\io\\p32\\test.txt",
                ".\\src\\io\\p32\\test.xml");
    }
}
