package inner.classes.pkg16;

public class Unicycle implements Cycle {
    @Override
    public String ride() {
        return "Unicycle";
    }
    public static CycleFactory factory = new CycleFactory() {
        @Override
      public Cycle getCycle() {
          return new Unicycle();
      }  
    };
}