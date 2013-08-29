/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generics.p26;

import java.math.BigDecimal;


/**
 *
 * @author rage
 */
public class Test {
    public static void main(String[] args) {
        Number[] numbers = new Integer[10];
        numbers[0] = 1;
        numbers[1] = 1.0F;
        numbers[2] = new BigDecimal(100L);
    }
}

class Fruit{}
class Apple extends Fruit{}
class Orange extends Fruit{}