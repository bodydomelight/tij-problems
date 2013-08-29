//: typeinfo/pets/Cat.java
package types.p15.pets;

public class Cat extends Pet {

    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super();
    }

    public static class Factory implements types.p15.pets.Factory<Cat> {

        @Override
        public Cat create() {
            return new Cat();
        }
    }
} ///:~
