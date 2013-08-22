//: typeinfo/pets/Cymric.java
package types.p15.pets;

public class Cymric extends Manx {

    public Cymric(String name) {
        super(name);
    }

    public Cymric() {
        super();
    }

    public static class Factory implements types.p15.pets.Factory<Cymric> {

        @Override
        public Cymric create() {
            return new Cymric();
        }
    }
} ///:~
