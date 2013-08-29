//: typeinfo/pets/EgyptianMau.java
package types.p15.pets;

public class EgyptianMau extends Cat {

    public EgyptianMau(String name) {
        super(name);
    }

    public EgyptianMau() {
        super();
    }

    public static class Factory implements types.p15.pets.Factory<EgyptianMau> {

        @Override
        public EgyptianMau create() {
            return new EgyptianMau();
        }
    }
} ///:~
