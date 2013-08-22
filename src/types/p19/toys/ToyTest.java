//: typeinfo/toys/ToyTest.java
// Testing class Class.
package types.p19.toys;

import java.lang.reflect.Constructor;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {

    String name;

    public Toy(String toyName) {
        name = toyName;
    }

    public Toy(Integer i) {
    }

    @Override
    public String toString() {
        return name;
    }
}

class FancyToy extends Toy
        implements HasBatteries, Waterproof, Shoots {

    public FancyToy(String toyName) {
        super(toyName);
    }

    public FancyToy(Integer i) {
        super(i);
    }
}

public class ToyTest {

    public static Toy createToy(String toyName) {
        try {
            Class<?> toyClass = Class.forName(toyName);
            System.out.println("After creating toyClass: " + toyClass);
            System.out.println(toyClass + " constructors: " + toyClass.getConstructors().length);
            for (Constructor<?> toyConstructor : toyClass.getConstructors()) {
                Class<?>[] parms = toyConstructor.getParameterTypes();
                System.out.println(parms);
                if (parms.length == 1 && parms[0] == String.class) {
                    return (Toy) toyConstructor.newInstance(new Object[]{toyName + " object \n"});
                }
            }
        } catch (Exception e) {
            System.out.println("Exception caught");
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(ToyTest.createToy("p19.toys.Toy"));
        System.out.println(ToyTest.createToy("p19.toys.FancyToy"));
    }
} /* Output:
 Class name: typeinfo.toys.FancyToy is interface? [false]
 Simple name: FancyToy
 Canonical name : typeinfo.toys.FancyToy
 Class name: typeinfo.toys.HasBatteries is interface? [true]
 Simple name: HasBatteries
 Canonical name : typeinfo.toys.HasBatteries
 Class name: typeinfo.toys.Waterproof is interface? [true]
 Simple name: Waterproof
 Canonical name : typeinfo.toys.Waterproof
 Class name: typeinfo.toys.Shoots is interface? [true]
 Simple name: Shoots
 Canonical name : typeinfo.toys.Shoots
 Class name: typeinfo.toys.Toy is interface? [false]
 Simple name: Toy
 Canonical name : typeinfo.toys.Toy
 *///:~
