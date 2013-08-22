package generics.p22;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

class Test {

    public Test(ArrayList list) {
    }
}

class Test2 {

    Test2() {
    }
}

public class NewInstance {

    public Object newInstance(Class c) {
        System.out.println("Creating object for " + c.getCanonicalName());
        Constructor[] constructors = c.getConstructors();
        if (constructors.length == 0) {
            System.out.println("No constructors found for: " + c.getCanonicalName() + 
                    ". Returning null.");
            return null;
        }
        for (Constructor constr : constructors) {
            if (constr.getParameterTypes().length == 0 && Modifier.isPublic(c.getModifiers())) {
                System.out.println("Default constructor found for: " + c.getCanonicalName());
                try {
                    return constr.newInstance();
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    System.out.println(ex);
                }
            } else {
                System.out.println("No default public constructors found for: " + c.getCanonicalName());
            }
        }
        Constructor constructor;
        constructor = constructors[0];
        Class[] parameterTypes = constructor.getParameterTypes();
        List<Object> parameters = new ArrayList<>();
        for (Class p : parameterTypes) {
            parameters.add(this.newInstance(p));
        }
        try {
            return constructor.newInstance(parameters);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static void main(String[] args) {
        NewInstance ni = new NewInstance();
        //Test test = (Test) ni.newInstance(Test.class);
        //Test2 test2 = (Test2) ni.newInstance(Test2.class);
        ArrayList test3 = (ArrayList) ni.newInstance(ArrayList.class);
    }
}
