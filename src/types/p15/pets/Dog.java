//: typeinfo/pets/Dog.java
package types.p15.pets;

public class Dog extends Pet {

    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super();
    }

    public static class Factory implements types.p15.pets.Factory<Dog> {

        @Override
        public Dog create() {
            return new Dog();
        }
    }
} ///:~
