package generics.p08;

import java.util.Iterator;
import java.util.Random;

public class StoryCharactersGenerator implements Generator<Character>, Iterable<Character> {

    private Class[] types = {GoodGuy1.class, GoodGuy2.class,
        BadGuy1.class, BadGuy2.class,};
    private static Random rand = new Random(47);

    public StoryCharactersGenerator() {
    }
// For iteration:
    private int size = 0;

    public StoryCharactersGenerator(int sz) {
        size = sz;
    }

    @Override
    public Character next() {
        try {
            return (Character) types[rand.nextInt(types.length)].newInstance();
// Report programmer errors at run time:
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    class CharacterIterator implements Iterator<Character> {

        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Character next() {
            count--;
            return StoryCharactersGenerator.this.next();
        }

        @Override
        public void remove() { // Not implemented
            throw new UnsupportedOperationException();
        }
    };

    @Override
    public Iterator<Character> iterator() {
        return new CharacterIterator();
    }

    public static void main(String[] args) {
        StoryCharactersGenerator gen = new StoryCharactersGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.print(gen.next() + " ");
        }
        System.out.println();
        for (Character c : new StoryCharactersGenerator(5)) {
            System.out.print(c + " ");
        }
    }
}
