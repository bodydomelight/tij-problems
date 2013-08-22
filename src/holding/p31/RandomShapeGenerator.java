package holding.p31;

import java.util.*;

public class RandomShapeGenerator implements Iterable<Shape> {

    private Random rand = new Random(47);
    private int numberOfElements;

    public RandomShapeGenerator(int i) {
        numberOfElements = i;
    }
    
    public Shape next() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }

    @Override
    public Iterator<Shape> iterator() {
        return new Iterator<Shape>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                if (index < numberOfElements) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public Shape next() {
                index++;
                return RandomShapeGenerator.this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }
}
