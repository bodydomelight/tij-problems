package generics.p38;

class Coffee{}

class CoffeeDecorator extends Coffee{
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class SteamedMilk extends CoffeeDecorator {
    public SteamedMilk(Coffee coffee) {
        super(coffee);
    }
}

class Foam extends CoffeeDecorator {
    public Foam(Coffee coffee) {
        super(coffee);
    }
}

class Chocolate extends CoffeeDecorator {
    public Chocolate(Coffee coffee) {
        super(coffee);
    }
}

class Caramel extends CoffeeDecorator {
    public Caramel(Coffee coffee) {
        super(coffee);
    }
}

class WhippedCream extends CoffeeDecorator {
    public WhippedCream(Coffee coffee) {
        super(coffee);
    }
}

public class DecoratorTest {
    
}
