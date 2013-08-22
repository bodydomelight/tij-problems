//: typeinfo/pets/Mouse.java
package types.p15.pets;

public class Mouse extends Rodent {

    public Mouse(String name) {
        super(name);
    }

    public Mouse() {
        super();
    }

    public static class Factory implements types.p15.pets.Factory<Mouse> {

        @Override
        public Mouse create() {
            return new Mouse();
        }
    }
} ///:~
