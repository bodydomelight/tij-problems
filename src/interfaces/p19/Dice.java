/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.p19;
import java.util.*;
/**
 *
 * @author aamelin
 */
public class Dice implements Tossable{
    private static final String[] sides = { "one", "two", "three", "four",
                                            "five", "six"};
    @Override
    public String toss() {
        Random rand = new Random();
        int i = rand.nextInt(6);
        return "Dice is tossed: " + sides[i];
    }
}
