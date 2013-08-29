package holding.p26;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Runner {

    public static void main(String[] args) {
        MyFileReader fileReader = new MyFileReader();
        TextCounter textCounter = new TextCounter();
        Map<String, ArrayList<Integer>> resultingMap;
        resultingMap = textCounter.getMapOfWords(fileReader.getListOfWords("C:\\Users\\aamelin\\Desktop\\wordsTest.txt"));
        Map<Integer, String> restoredText = new LinkedHashMap<Integer, String>();

//        System.out.println("Resulting Map: " + resultingMap);
//        System.out.println("Key set: " + resultingMap.keySet());

        List<Integer> positions;

        for (String str : resultingMap.keySet()) {
            positions = resultingMap.get(str);
//            System.out.println("Current word \"" + str + "\", positions are: " + 
//                    positions + ".");
            for (Integer i : positions) {
//                System.out.println("Putting word: \"" + str + "\" on position " + 
//                        i + ".");
                restoredText.put(i, str);
//                System.out.println("Fetching word \"" + str + "\" from position " + 
//                        i + ": " + restoredText.get(i) + ".");
            }
        }
        Set<Integer> orderOfWords = new TreeSet<Integer>(restoredText.keySet());

        for (Integer i : orderOfWords) {
            System.out.print(restoredText.get(i) + " ");
        }

    }
}
