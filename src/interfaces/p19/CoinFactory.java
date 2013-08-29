/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.p19;

/**
 *
 * @author aamelin
 */
public class CoinFactory implements TossableFactory{
    @Override
    public Tossable getTossable() {
        return new Coin();
    }
}
