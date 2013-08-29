package holding.p23;

import java.util.HashMap;
import java.util.Map;

public class OccurenceWatcher {

    private int numberOfTries;
    private Statistics stat = new Statistics();
    private int mostFrequentNumber;
    Map<Integer, Integer> data = new HashMap<Integer, Integer>();

    public Map<Integer, Integer> getData(Integer numberOfTries) {
        this.numberOfTries = numberOfTries;
        for (int i = 0; i < numberOfTries; i++) {
            mostFrequentNumber = stat.getMostOftenOccurence();
            if (data.containsKey(mostFrequentNumber)) {
                data.put(mostFrequentNumber, (data.get(mostFrequentNumber) + 1));
            } else {
                data.put(mostFrequentNumber, 1);
            }
        }
        this.displayMostFrequentNumber();
        return data;
    }

    private Integer displayMostFrequentNumber() {
        int key = 0;
        System.out.println(data.keySet());
        for (int currentKey : data.keySet()) {
//            System.out.println(data.get("Current value " + data.get(key)));
            if (data.get(key) == null || data.get(key) < data.get(currentKey)) {
                key = currentKey;
            }
        }
        System.out.println("Most frequent number after " + numberOfTries
                + " tries is " + key + " — " + data.get(key) + " times it had the highest number of appearances.");
        System.out.println("DEBUG: The whole map is " + data);
        return key;
    }
    
    public static void main(String[] args) {
        OccurenceWatcher ow = new OccurenceWatcher();
        ow.getData(10000);
    }
}
