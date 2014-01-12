package enums.p11;

public abstract class Input {

    abstract public int amount();

    abstract public Category category();

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Input)) {
            return false;
        }
        return this.getClass().getName().equals(obj.getClass().getName());
    }

    @Override
    public int hashCode() {
        return this.getClass().getName().hashCode();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
