package inner.classes.pkg17;

import java.util.*;

public class Coin implements Tossable {
    private static final String[] sides = { "head", "tail"};
    @Override
    public String toss() {
        Random rand = new Random();
        int i = rand.nextInt(2);
        return "Coin is tossed: " + sides[i];
    }
    public static TossableFactory factory = new TossableFactory() {

        @Override
        public Tossable getTossable() {
            return new Coin();
        }
    };
}
