//: typeinfo/pets/Pug.java
package types.p15.pets;

public class Pug extends Dog {

    public Pug(String name) {
        super(name);
    }

    public Pug() {
        super();
    }

    public static class Factory implements types.p15.pets.Factory<Pug> {

        @Override
        public Pug create() {
            return new Pug();
        }
    }
} ///:~
