//: typeinfo/pets/Rodent.java
package types.p15.pets;

public class Rodent extends Pet {

    public Rodent(String name) {
        super(name);
    }

    public Rodent() {
        super();
    }

    public static class Factory implements types.p15.pets.Factory<Rodent> {

        @Override
        public Rodent create() {
            return new Rodent();
        }
    }
} ///:~
