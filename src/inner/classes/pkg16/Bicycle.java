package inner.classes.pkg16;

public class Bicycle implements Cycle {
    @Override
    public String ride() {
        return "Bicycle";
    }
    public static CycleFactory factory = new CycleFactory() {
        @Override
      public Cycle getCycle() {
          return new Bicycle();
      }  
    };
}
