/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.p18;

/**
 *
 * @author aamelin
 */
public class Interfaces18 {
    Cycle getCycle(CycleFactory factory) {
        return factory.getCycle();
    }
    void printCycleName(CycleFactory factory) {
        Cycle cycle = factory.getCycle();
        System.out.println(cycle.ride());
    }
    
    public static void main(String[] args) {
        Interfaces18 i18 = new Interfaces18();
        i18.printCycleName(new UnicycleFactory());
        i18.printCycleName(new BicycleFactory());
        i18.printCycleName(new TricycleFactory());
    }
}
