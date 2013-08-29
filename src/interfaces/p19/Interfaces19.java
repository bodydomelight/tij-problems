/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.p19;

/**
 *
 * @author aamelin
 */
public class Interfaces19 {
    
    public void printResult(TossableFactory factory) {
        Tossable tossable = factory.getTossable();
        System.out.println(tossable.toss());
    }
    
    public static void main(String[] args) {
        Interfaces19 i19 = new Interfaces19();
        i19.printResult(new CoinFactory());
        i19.printResult(new DiceFactory());
    }
}
