package enums.p11;

public class Dollar extends Input {

    @Override
    public int amount() {
        return 100;
    }

    @Override
    public Category category() {
        return Category.MONEY;
    }
}
