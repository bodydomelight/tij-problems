//: generics/coffee/Coffee.java
package types.p16.coffee;

import types.p16.Factory;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Coffee {

    private static long counter = 0;
    private final long id = counter++;
    private static List<Factory<? extends Coffee>> coffeeFactories =
            Arrays.asList(new Americano.Factory(),
            new Breve.Factory(), new Latte.Factory(),
            new Mocha.Factory());
    private static Random rand = new Random(47);

    public static Coffee createRandom() {
        int n = rand.nextInt(coffeeFactories.size());
        return coffeeFactories.get(n).create();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
} ///:~
