/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package holding.p07;
import java.util.*;

public class MyClass {

    public static MyClass[] createArray(int j) {
        MyClass[] m = new MyClass[j];
        for (int i = 0; i < j; i++) {
            m[i] = new MyClass();
        }
        return m;
    }
    
    public static void main(String[] args) {
        MyClass[] myclass = createArray(10);
        List<MyClass> mcList = new LinkedList<MyClass>();
        Collections.addAll(mcList, myclass);
        System.out.println(mcList);
        List<MyClass> subset = new ArrayList<MyClass>(mcList.subList(2, 6));
        System.out.println(subset);
        mcList.removeAll(subset);
        System.out.println(mcList);
    }
}
