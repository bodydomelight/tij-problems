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
public class Coin implements Tossable {
   private static final String[] sides = { "head", "tail"};
   
    @Override
    public String toss() {
        Random rand = new Random();
        int i = rand.nextInt(2);
        return "Coin is tossed: " + sides[i];
    }
}
