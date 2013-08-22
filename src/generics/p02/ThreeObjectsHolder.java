package generics.p02;

public class ThreeObjectsHolder<T> {
    private T first, second, third;
    public ThreeObjectsHolder(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public void setSecond(T second) {
        this.second = second;
    }
    public void setThird(T third) {
        this.third = third;
    }
    public T getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }
    public T getThird() {
        return third;
    }
    
}
