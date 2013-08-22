package generics.p18;

import utils.Generator;

public class BigFish {

    private final long id = counter++;
    private static long counter = 1;

    private BigFish() {
    }

    @Override
    public String toString() {
        return "BigFish: " + id;
    }
    public static Generator<BigFish> generator = new Generator<BigFish>() {
        @Override
        public BigFish next() {
            return new BigFish();
        }
    };
}
