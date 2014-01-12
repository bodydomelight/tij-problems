package enums.p11;

public class Toothpaste extends Input {

    @Override
    public int amount() {
        return 200;
    }

    @Override
    public Category category() {
        return Category.ITEM_SELECTION;
    }
}
