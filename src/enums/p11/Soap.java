package enums.p11;

public class Soap extends Input {

    @Override
    public int amount() {
        return 50;
    }

    @Override
    public Category category() {
        return Category.ITEM_SELECTION;
    }
}
