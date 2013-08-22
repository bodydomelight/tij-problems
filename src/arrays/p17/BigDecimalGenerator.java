/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays.p17;

import java.math.BigDecimal;
import net.mindview.util.Generator;

/**
 *
 * @author rage
 */
public class BigDecimalGenerator implements Generator<BigDecimal>{
    private BigDecimal value = new BigDecimal(0);
    private BigDecimal delta;
    public BigDecimalGenerator(int i) {
        delta = new BigDecimal(i);
    }
    
    @Override
    public BigDecimal next() {
        value = value.add(delta);
        return value;
    }
    
}
