package enums.p11;

public class Chips extends Input {

    @Override
    public int amount() {
        return 75;
    }

    @Override
    public Category category() {
        return Category.ITEM_SELECTION;
    }
}
