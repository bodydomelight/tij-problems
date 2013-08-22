package generics.p19;

import java.util.ArrayList;
import static utils.Generators.*;

public class Box extends ArrayList<Good> {

    public Box(int numberOfGoods) {
        fill(this, Good.generator, numberOfGoods);
    }
}
