//: typeinfo/pets/ForNameCreator.java
package types.p15.pets;
import java.util.*;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types =
    new ArrayList<Class<? extends Pet>>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "p11.pets.Mutt",
    "p11.pets.Pug",
    "p11.pets.EgyptianMau",
    "p11.pets.Manx",
    "p11.pets.Cymric",
    "p11.pets.Rat",
    "p11.pets.Mouse",
    "p11.pets.Hamster",
    "p11.pets.Gerbil"
  };	
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add(
          (Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }
  public List<Class<? extends Pet>> types() {return types;}
} ///:~
