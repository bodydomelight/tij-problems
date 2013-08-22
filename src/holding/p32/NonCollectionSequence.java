package holding.p32;

import java.util.*;
import holding.p30.InterfaceVsIterator;
import holding.p30.Pet;
import holding.p30.Pets;

class PetSequence {

    protected Pet[] pets = Pets.createArray(8);
}

public class NonCollectionSequence extends PetSequence implements Iterable<Pet> {

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public void remove() { // Not implemented 
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterable<Pet> reversed() {
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                return new Iterator<Pet>() {
                    private int current = pets.length - 1;

                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public Pet next() {
                        return pets[current--];
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<Pet> shuffled() {
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                List<Pet> shuffled = new ArrayList<Pet>(Arrays.asList(pets));
                Collections.shuffle(shuffled, new Random());
                return shuffled.iterator();
            }
        };

    }

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        
        for (Pet pet : nc) {
            System.out.print(pet.id());
        }
        System.out.println();
        for (Pet pet : nc.reversed()) {
            System.out.print(pet.id());
        }
        System.out.println();
        for (Pet pet : nc.shuffled()) {
            System.out.print(pet.id());
        }
    }
}
