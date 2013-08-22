package generics.p42;

public class ClassB {
    private long num;
    public ClassB() {
        updateNum();
    }
    public ClassB(long num) {
        this.num = num;
    }
    public final void updateNum() {
        num = System.nanoTime();
    }
    public long getNum() {
        return num;
    }
    @Override
    public String toString() {
        return new Long(num).toString();
    }
}