package holding.p08;

import java.util.*;

public class NewClass {
    public static void main(String[] args) {
        List<Gerbil> a = new ArrayList<Gerbil>();
        for (int i = 0; i < 10; i++) {
            a.add(new Gerbil());
        }
        Iterator<Gerbil> it = a.iterator();
        while (it.hasNext()) {
            it.next().hop();
        }
    }
}
