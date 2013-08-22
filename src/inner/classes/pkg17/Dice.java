package inner.classes.pkg17;

import java.util.*;

public class Dice implements Tossable {
    private static final String[] sides = { "one", "two", "three", "four",
                                            "five", "six"};
    @Override
    public String toss() {
        Random rand = new Random();
        int i = rand.nextInt(6);
        return "Dice is tossed: " + sides[i];
    }
    public static TossableFactory factory = new TossableFactory() {
        @Override
        public Tossable getTossable() {
            return new Dice();
        }
    };
}
