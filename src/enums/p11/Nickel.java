package enums.p11;

public class Nickel extends Input {

    @Override
    public int amount() {
        return 5;
    }

    @Override
    public Category category() {
        return Category.MONEY;
    }
}
