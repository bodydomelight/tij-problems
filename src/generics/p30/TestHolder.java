/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generics.p30;

/**
 *
 * @author rage
 */
public class TestHolder {

    public static void main(String[] args) {
        Holder<Integer> iHolder = new Holder<>();
        iHolder.set(2);
        int i = iHolder.get();
        Holder<Long> lHolder = new Holder<>();
        lHolder.set(2L);
        long l = iHolder.get();
        Holder<Float> fHolder = new Holder<>();
        fHolder.set(2F);
        float f = fHolder.get();
        Holder<Double> dHolder = new Holder<>();
        dHolder.set(2D);
        double d = dHolder.get();
        Holder<Boolean> bHolder = new Holder<>();
        bHolder.set(false);
        boolean b = bHolder.get();
        Holder<Character> cHolder = new Holder<>();
        cHolder.set('c');
        char c = cHolder.get();
    }
}
