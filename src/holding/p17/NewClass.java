package holding.p17;

import java.util.*;

public class NewClass {

    public static void main(String[] args) {
        Map<String, Gerbil> gerbilMap = new HashMap<String, Gerbil>();
        gerbilMap.put("Fuzzy", new Gerbil());
        gerbilMap.put("Fizzy", new Gerbil());
        gerbilMap.put("Spot", new Gerbil());
        
        Gerbil gerbil;
        String gerbilName;
        Iterator<String> iterator = gerbilMap.keySet().iterator();
        while (iterator.hasNext()) {
            gerbilName = iterator.next();
            System.out.println(gerbilName);
            gerbil = gerbilMap.get(gerbilName);
            gerbil.hop();
        }
    }
}