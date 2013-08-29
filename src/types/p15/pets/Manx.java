//: typeinfo/pets/Manx.java
package types.p15.pets;

public class Manx extends Cat {

    public Manx(String name) {
        super(name);
    }

    public Manx() {
        super();
    }

    public static class Factory implements types.p15.pets.Factory<Manx> {

        @Override
        public Manx create() {
            return new Manx();
        }
    }
} ///:~
