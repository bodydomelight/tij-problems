package enums.p11;

public class Dime extends Input {

    @Override
    public int amount() {
        return 10;
    }

    @Override
    public Category category() {
        return Category.MONEY;
    }
}
