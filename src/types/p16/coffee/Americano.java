//: generics/coffee/Americano.java
package types.p16.coffee;

public class Americano extends Coffee {

    public static class Factory implements types.p16.Factory<Americano> {

        @Override
        public Americano create() {
            return new Americano();
        }
    }
} ///:~
