package types.p06;

import java.util.*;

abstract class Shape {

    boolean isHighlighted = false;

    void draw() {
        System.out.println(this + ".draw()");
    }

    void rotate() {
        if (!(this instanceof Circle)) {
            System.out.println(this + ".rotate()");
        } else {
            System.out.println("Can't rotate Circle");
        }
    }

    void highlight() {
        isHighlighted = true;
    }

    void deHighlight() {
        isHighlighted = false;
    }

    @Override
    abstract public String toString();
}

class Circle extends Shape {

    @Override
    public String toString() {
        if (isHighlighted) {
            return "highlighted Circle";
        } else {
            return "Circle";
        }
    }
}

class Square extends Shape {

    @Override
    public String toString() {
        if (isHighlighted) {
            return "highlighted Square";
        } else {
            return "Square";
        }
    }
}

class Triangle extends Shape {

    @Override
    public String toString() {
        if (isHighlighted) {
            return "highlighted Triangle";
        } else {
            return "Triangle";
        }
    }
}

class Rhomboid extends Shape {

    @Override
    public String toString() {
        if (isHighlighted) {
            return "highlighted Rhomboid";
        } else {
            return "Rhomboid";
        }
    }
}

public class Shapes {

    static void highlightShapes(String shapeClass, List<Shape> shapeList) {
        for (Shape shape : shapeList) {
            if (shape.getClass().getSimpleName().equals(shapeClass)) {
                shape.highlight();
            }
            System.out.println(shape);
        }
    }

    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle(), new Rhomboid(),
                new Circle(), new Square(), new Triangle(), new Rhomboid());
        highlightShapes("Triangle", shapeList);
    }
}
