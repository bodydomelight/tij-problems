package generics.p08;

public class Character {
    public static int counter = 0;
    public final int id = counter++;
    @Override
    public String toString() {
        return (this.getClass().getSimpleName() + " " + id);
    }
}

class GoodGuy1 extends Character {}
class GoodGuy2 extends Character {}
class BadGuy1 extends Character {}
class BadGuy2 extends Character {}

