package holding.p31;

public class Runner {

    public static void main(String[] args) {
        RandomShapeGenerator generator = new RandomShapeGenerator(12);
        for (Shape shape : generator) {
            shape.draw();
            shape.erase();
        }
    }
}
