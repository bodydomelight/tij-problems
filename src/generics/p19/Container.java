package generics.p19;

import java.util.ArrayList;

public class Container extends ArrayList<Shelf>{
    public Container(int numberOfShelves, int numberOfBoxes, int numberOfGoods) {
        for(int i =0; i < numberOfShelves; i++) {
            add(new Shelf(numberOfBoxes, numberOfGoods));
        }
    }
}
