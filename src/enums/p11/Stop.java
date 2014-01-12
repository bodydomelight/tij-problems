package enums.p11;

public class Stop extends Input {

    @Override
    public int amount() {
        throw new RuntimeException("SHUT_DOWN.amount()");
    }

    @Override
    public Category category() {
        return Category.SHUT_DOWN;
    }
}
