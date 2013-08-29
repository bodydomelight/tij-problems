package inner.classes.pkg16;

public class MainClass {
    public static void rideCycle(CycleFactory factory) {
        Cycle c = factory.getCycle();
        System.out.println(c.ride());
    }
    public static void main(String[] args) {
        rideCycle(Unicycle.factory);
        rideCycle(Bicycle.factory);
        rideCycle(Tricycle.factory);
    }
}
