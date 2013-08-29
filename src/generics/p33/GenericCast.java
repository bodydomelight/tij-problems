package generics.p33;

import java.util.ArrayList;
import java.util.List;

class FullStackException extends RuntimeException {
}

class EmptyStackException extends RuntimeException {
}

class FixedSizeStack<T> {

    private int index = 0;
    private final int size;
    private List<T> storage;
    T item;

    public FixedSizeStack(int size) {
        storage = new ArrayList<>(size);
        this.size = size;
    }

    public void push(T item) {
        if (index < size) {
            storage.add(index, item);
            index++;
        } else {
            throw new FullStackException();
        }
    }

//    @SuppressWarnings("unchecked")
    public T pop() {
        if (index > 0) {
            return storage.get(--index);
        }
        throw new EmptyStackException();
    }
}

public class GenericCast {

    public static final int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<>(SIZE);
        for (String s : "A B C D E F G H I J".split(" ")) {
            strings.push(s);
        }
        for (int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : "1 2 3 4 5 6 7 8 9 0".split(" ")) {
            strings.push(s);
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }
}