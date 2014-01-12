package enums.p11;

public class AbortTransaction extends Input {

    @Override
    public int amount() {
        throw new RuntimeException("ABORT.amount()");
    }

    @Override
    public Category category() {
        return Category.QUIT_TRANSACTION;
    }
}
