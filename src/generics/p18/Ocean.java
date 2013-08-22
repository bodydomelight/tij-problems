package generics.p18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import static utils.Generators.*;

public class Ocean {
    public static  void eat(BigFish bf, LittleFish lf) {
        System.out.println(bf + " eats " + lf);
    }
            
    public static void main(String[] args) {
        List<BigFish> bigFishList = new ArrayList<>();
        fill(bigFishList, BigFish.generator, 4);
        Queue<LittleFish> littleFishLine = new LinkedList<>();
        fill(littleFishLine, LittleFish.generator(), 15);
        Random random = new Random();
        for (LittleFish lf : littleFishLine) {
            eat(bigFishList.get(random.nextInt(bigFishList.size())), lf);
        }
    }
}
