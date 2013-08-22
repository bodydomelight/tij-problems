//: generics/coffee/Cappuccino.java
package types.p16.coffee;

public class Cappuccino extends Coffee {

    public static class Factory implements types.p16.Factory<Cappuccino> {

        @Override
        public Cappuccino create() {
            return new Cappuccino();
        }
    }
} ///:~
