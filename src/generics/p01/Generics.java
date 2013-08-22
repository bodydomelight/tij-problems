package generics.p01;
import typeinfo.pets.*;
public class Generics<T> {
    private T object;
    public Generics(T t) {
        object = t;
    }
    public void set(T t) {
        object = t;
    }
    public T get() {
        return object;
    } 
    public void print() {
        System.out.println(this.get());
    }
    public static void main(String[] args) {
        Generics<Pet> holder = new Generics<>(new Pet());
        holder.print();
        holder.set(new Cat());
        holder.print();
        holder.set(new Mouse());
        holder.print();
    }
}
