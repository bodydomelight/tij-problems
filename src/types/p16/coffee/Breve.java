//: generics/coffee/Breve.java
package types.p16.coffee;

public class Breve extends Coffee {

    public static class Factory implements types.p16.Factory<Breve> {

        @Override
        public Breve create() {
            return new Breve();
        }
    }
} ///:~
