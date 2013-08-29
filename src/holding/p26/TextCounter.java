package holding.p26;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TextCounter {

    private Map<String, ArrayList<Integer>> wordMap =
            new LinkedHashMap<String, ArrayList<Integer>>();

    public Map<String, ArrayList<Integer>> getMapOfWords(List<String> words) {
        int i = 0;
//        System.out.println("DEBUG: input list of words is:\n" + words);
        for (String word : words) {
            i++;
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, new ArrayList<Integer>());
            }
            wordMap.get(word).add(i);
        }
//        System.out.println("DEBUG: resulting map is:\n" + wordMap);
        return wordMap;
    }
}
