package generics.p40;

import java.lang.reflect.*;
import java.util.*;
import typeinfo.pets.Cat;
import typeinfo.pets.Dog;
import typeinfo.pets.Individual;
import typeinfo.pets.Mouse;
import typeinfo.pets.Mutt;
import typeinfo.pets.Pet;
import typeinfo.pets.Rat;

public class Apply {

    public static <T, S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args) {
        try {
            for (T t : seq) {
                f.invoke(t, args);
            }
        } catch (Exception e) {
// Failures are programmer errors
            throw new RuntimeException(e);
        }
    }
}

class Shape {

    public void rotate() {
        System.out.println(this + " rotate");
    }

    public void resize(int newSize) {
        System.out.println(this + " resize " + newSize);
    }
}

class Square extends Shape {
}

class FilledList<T> extends ArrayList<T> {

    public FilledList(Class<? extends T> type, int size) {
        try {
            for (int i = 0; i < size; i++) // Assumes default constructor:
            {
                add(type.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class ApplyTest {

    public static void main(String[] args) throws Exception {
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            shapes.add(new Shape());
        }
        Apply.apply(shapes, Shape.class.getMethod("rotate"));
        Apply.apply(shapes,
                Shape.class.getMethod("resize", int.class), 5);
        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            squares.add(new Square());
        }
        Apply.apply(squares, Shape.class.getMethod("rotate"));
        Apply.apply(squares,
                Shape.class.getMethod("resize", int.class), 5);
        Apply.apply(new FilledList<>(Shape.class, 10),
                Shape.class.getMethod("rotate"));
        Apply.apply(new FilledList<Shape>(Square.class, 10),
                Shape.class.getMethod("rotate"));
        SimpleQueue<Shape> shapeQ = new SimpleQueue<>();
        for (int i = 0; i < 5; i++) {
            shapeQ.add(new Shape());
            shapeQ.add(new Square());
        }
        Apply.apply(shapeQ, Shape.class.getMethod("rotate"));
        List<Pet> pets = new ArrayList<>(Arrays.asList(new Cat(), new Mouse(),
                new Mutt(), new Rat(), new Dog()));
        Apply.apply(pets, Individual.class.getDeclaredMethod("speak"));
    }
}
