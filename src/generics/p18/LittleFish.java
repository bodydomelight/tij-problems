package generics.p18;

import utils.Generator;

public class LittleFish {

    private final long id = counter++;
    private static long counter = 1;

    private LittleFish() {
    }

    @Override
    public String toString() {
        return "LittleFish: " + id;
    }

    public static Generator<LittleFish> generator() {
        return new Generator<LittleFish>() {
            @Override
            public LittleFish next() {
                return new LittleFish();
            }
        };
    }
}
