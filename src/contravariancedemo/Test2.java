package contravariancedemo;

import java.util.*;

public class Test2 {

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());
    
    static class FruitReader {
        <T> T readFruit(List<? extends T> list) {
            return list.get(0);
        }
    }
    
    static void f1() {
        FruitReader fr = new FruitReader();
        fr.readFruit(apples);
        fr.readFruit(fruit);
    }
    
    public static void main(String[] args) {
        f1();
    }
}

class Fruit {
}

class Apple extends Fruit {
}