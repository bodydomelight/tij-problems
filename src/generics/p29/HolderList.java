/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generics.p29;

import java.util.ArrayList;
import java.util.List;

public class HolderList {

    public static void f1(Holder<List<?>> holder) {
        holder.set(new ArrayList());
        holder.set(new ArrayList<String>());
        List<?> list = holder.get();
        //list.add(new Object());
        //list.add(2);
    }
    public static void f2(List<Holder<?>> list) {
        list.add(new Holder());
        list.add(new Holder<Object>());
        Holder<?> holder = list.get(0);
        //holder.set(new Object());
        //holder.set(2);
    }
    
    public static void main(String[] args) {
        f1(new Holder<List<?>>());
        f2(new ArrayList<Holder<?>>());
    }
}
