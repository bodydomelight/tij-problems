package holding.p23;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Statistics {

    private Random rand = new Random(47);
    private int currentKey;
    
    public Map<Integer, Integer> getResult(Map<Integer, Integer> m) {
        for (int i = 0; i < 10000; i++) {
            // Produce a number between 0 and 20: 
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1);
        }
        return m;
    }
    
    public Integer getMostOftenOccurence() {
        int biggestKey = 0;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        this.getResult(m);
        Iterator it = m.keySet().iterator();
        //doesn't consider situation when several numbers
        //have been generated equal times
        while (it.hasNext()) {
            currentKey = (Integer)it.next();
            if (m.get(biggestKey) < m.get(currentKey)) {
                biggestKey = currentKey;
            }
        }
        //System.out.println("STATISTICS: Biggest key is:" + biggestKey + "\nSTATISTICS: " + m);
        return biggestKey;
    }
}