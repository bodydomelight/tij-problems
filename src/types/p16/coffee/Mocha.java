//: generics/coffee/Mocha.java
package types.p16.coffee;

public class Mocha extends Coffee {

    public static class Factory implements types.p16.Factory<Mocha> {

        @Override
        public Mocha create() {
            return new Mocha();
        }
    }
} ///:~
