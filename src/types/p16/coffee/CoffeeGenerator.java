//: generics/coffee/CoffeeGenerator.java
// Generate different types of Coffee:
package types.p16.coffee;

import java.util.*;
import net.mindview.util.*;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    public CoffeeGenerator() {
    }
    // For iteration:
    private int size = 0;

    public CoffeeGenerator(int sz) {
        size = sz;
    }

    @Override
    public Coffee next() {
        return Coffee.createRandom();
    }

    class CoffeeIterator implements Iterator<Coffee> {

        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() { // Not implemented
            throw new UnsupportedOperationException();
        }
    };

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        for (Coffee c : new CoffeeGenerator(10)) {
            System.out.println(c);
        }
    }
} /* Output:
 Americano 0
 Latte 1
 Americano 2
 Mocha 3
 Mocha 4
 Breve 5
 Americano 6
 Latte 7
 Cappuccino 8
 Cappuccino 9
 *///:~
