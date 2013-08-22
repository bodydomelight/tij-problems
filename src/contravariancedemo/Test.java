package contravariancedemo;

import java.util.ArrayList;
import java.util.List;


public class Test {

    static List<? extends Parent> ex;
    static List<? super Parent> su;
    
    static <T> void write(List<T> lp, T p) {
        lp.add(p);
    }

    public static void main(String[] args) {
        //ex = new ArrayList<Grandparent>(); //compile error
        ex = new ArrayList<Parent>();
        ex = new ArrayList<Child>();
//        ex.add(new Child());
        ((List<Parent>)ex).add(new Parent());
        su = new ArrayList<Grandparent>();
        su = new ArrayList<Parent>();
        //su = new ArrayList<Child>(); //compile error
        su = new ArrayList<Object>();
        
        List<Parent> lp = new ArrayList<>();
        write(lp, new Child());
    }
}
class Grandparent {
}

class Parent extends Grandparent {
}

class Child extends Parent {
}