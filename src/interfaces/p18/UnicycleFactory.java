/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.p18;

/**
 *
 * @author aamelin
 */
public class UnicycleFactory implements CycleFactory{

    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
    
}
