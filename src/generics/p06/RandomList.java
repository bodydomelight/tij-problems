package generics.p06;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomList<T> {
    private List<T> list = new ArrayList<>();
    private Random rand = new Random();
    
    public void add(T element) {
        list.add(element);
    }
    public T select() {
        return list.get(rand.nextInt(list.size()));
    }
    public void print() {
        for (int i = 0; i < 11; i++) {
            System.out.print(this.select() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        RandomList<String> rl = new RandomList<>();
        for(String str : "A little white fox ran away from big grey dogs".split(" ")) {
            rl.add(str);
        }
        rl.print();
        RandomList<Integer> rl2 = new RandomList<>();
        for (int i = 1000; i < 1100; i+=10) {
            rl2.add(i);
        }
        rl2.print();
        RandomList<Float> rl3 = new RandomList<>();
        for (float f = 32.5f; f < 100; f+= 7.6) {
            rl3.add(f);
        }
        rl3.print();
    }
}
