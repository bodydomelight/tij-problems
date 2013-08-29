//: typeinfo/pets/Rat.java
package types.p15.pets;

public class Rat extends Rodent {

    public Rat(String name) {
        super(name);
    }

    public Rat() {
        super();
    }

    public static class Factory implements types.p15.pets.Factory<Rat> {

        @Override
        public Rat create() {
            return new Rat();
        }
    }
} ///:~
