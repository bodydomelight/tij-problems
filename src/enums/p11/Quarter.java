package enums.p11;

public class Quarter extends Input {

    @Override
    public int amount() {
        return 25;
    }

    @Override
    public Category category() {
        return Category.MONEY;
    }

}
