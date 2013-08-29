package utils;

import java.util.Collection;

public class Generators {
    public static <T> void  fill(Collection<T> listToFill, Generator<T> generator, int number) {
        for (int i = 0; i < number; i++) {
            listToFill.add(generator.next());
        }
    }
}
