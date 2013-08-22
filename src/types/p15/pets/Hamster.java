//: typeinfo/pets/Hamster.java
package types.p15.pets;

public class Hamster extends Rodent {

    public Hamster(String name) {
        super(name);
    }

    public Hamster() {
        super();
    }

    public static class Factory implements types.p15.pets.Factory<Hamster> {

        @Override
        public Hamster create() {
            return new Hamster();
        }
    }
} ///:~
