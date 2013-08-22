package types.p03;

import java.util.*;

abstract class Shape {

    void draw() {
        System.out.println(this + ".draw()");
    }

    @Override
    abstract public String toString();
}

class Circle extends Shape {

    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {

    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {

    @Override
    public String toString() {
        return "Triangle";
    }
}

class Rhomboid extends Shape {

    @Override
    public String toString() {
        return "Rhomboid";
    }
}

public class Shapes {

    public static void main(String[] args) {
//    List<Shape> shapeList = Arrays.asList(
//      new Circle(), new Square(), new Triangle()
//    );
//    for(Shape shape : shapeList)
//      shape.draw();
        Shape shape = new Rhomboid();
        Rhomboid rhomb = (Rhomboid) shape;
        Circle circle = (Circle) shape;
    }
}
