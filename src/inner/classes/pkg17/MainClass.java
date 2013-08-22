/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inner.classes.pkg17;

public class MainClass {
    public static void toss(TossableFactory factory) {
        Tossable t = factory.getTossable();
        System.out.println(t.toss());
    }
    public static void main(String[] args) {
        toss(Coin.factory);
        toss(Dice.factory);
    }
}
