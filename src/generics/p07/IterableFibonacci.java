package generics.p07;

import java.util.Iterator;

public class IterableFibonacci implements Iterable<Integer> {

    private Fibonacci f;
    private int count;

    public IterableFibonacci(int n) {
        f = new Fibonacci();
        count = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public Integer next() {
                count--;
                return f.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18)) {
            System.out.print(i + " ");
        }
    }
}
