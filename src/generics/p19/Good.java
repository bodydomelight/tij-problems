package generics.p19;

import java.util.Random;
import utils.Generator;

public class Good {
    private final int id;
    private String description;
    public Good(int id, String description) {
        this.id = id;
        this.description = description;
    }
    public static Generator<Good> generator = new Generator<Good>() {
        Random random = new Random();
        @Override
        public Good next() {
            return new Good(random.nextInt(1000), "");
        }
    };
    @Override
    public String toString() {
        return "Good: " + id + " " + description;
    }
}
