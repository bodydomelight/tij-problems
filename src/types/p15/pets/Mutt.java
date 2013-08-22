//: typeinfo/pets/Mutt.java
package types.p15.pets;

public class Mutt extends Dog {

    public Mutt(String name) {
        super(name);
    }

    public Mutt() {
        super();
    }

    public static class Factory implements types.p15.pets.Factory<Mutt> {

        @Override
        public Mutt create() {
            return new Mutt();
        }
    }
} ///:~
