package generics.p19;

import java.util.ArrayList;

public class Shelf extends ArrayList<Box>{
    public Shelf(int numberofShelves, int numberOfGoods) {
        for(int i = 0; i < numberofShelves; i++) {
            add(new Box(numberOfGoods));
        }
    }
}
