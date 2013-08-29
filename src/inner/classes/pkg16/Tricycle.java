package inner.classes.pkg16;

public class Tricycle implements Cycle {
    @Override
    public String ride() {
        return "Tricycle";
    }
    public static CycleFactory factory = new CycleFactory() {
        @Override
      public Cycle getCycle() {
          return new Tricycle();
      }  
    };
}