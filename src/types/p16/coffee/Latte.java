//: generics/coffee/Latte.java
package types.p16.coffee;

public class Latte extends Coffee {

    public static class Factory implements types.p16.Factory<Latte> {

        @Override
        public Latte create() {
            return new Latte();
        }
    }
} ///:~
