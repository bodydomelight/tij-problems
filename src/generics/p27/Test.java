/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generics.p27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author rage
 */
public class Test {
    public static void main(String[] args) {
        
        List<Number> nlist = new ArrayList<Number>();
        nlist.add(new Integer(5));
        Number n = nlist.get(0);
        System.out.println(n);
    }
}
