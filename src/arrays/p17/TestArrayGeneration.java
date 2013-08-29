package arrays.p17;

import java.math.BigDecimal;
import java.util.*;
import net.mindview.util.*;

public class TestArrayGeneration {

    public static void main(String[] args) {
        int size = 6;
        int delta = 100;
        BigDecimal[] bc = Generated.array(BigDecimal.class, new BigDecimalGenerator(delta), size);
        System.out.println(Arrays.toString(bc));
        bc = Generated.array(new BigDecimal[size], new BigDecimalGenerator(delta));
        System.out.println(Arrays.toString(bc));
    }
}
