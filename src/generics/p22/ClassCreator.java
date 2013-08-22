package generics.p22;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassCreator {

    public static Object createObject(Class<?> c) {
        System.out.println("\n*****Starting creation of an object of class: " + c.getName());
        Constructor[] constructors = c.getConstructors();
        if (constructors.length == 0) {
            System.out.println("No public constructors found for: " + c.getName()
                    + "; returning null;");
            return null;
        }
        for (Constructor con : constructors) {
            if (con.getParameterTypes().length == 0) {
                System.out.println("Found no-args constructor for: " + c.getName()
                        + "; using it;");
                try {
                    return con.newInstance();
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        Class<?>[] parameterTypes;
        List<Object> parameters;
        Object parameter;
        boolean completeParameters;
        for (Constructor constructor : constructors) {
            System.out.println("Constructing array of parameters;");
            completeParameters = true;
            parameterTypes = constructor.getParameterTypes();
            System.out.println("The following parameter types are needed: " + getParameterNames(parameterTypes));
            parameters = new ArrayList<>();

            for (Class parameterType : parameterTypes) {
                parameter = createObject(parameterType);
                if (parameter == null) {
                    completeParameters = false;
                    break;
                }
                parameters.add(parameter);
            }
            if (completeParameters) {
                try {
                    System.out.println("Constructor with " + parameters.size()
                            + " parameter(s): [" + getParameterNames(parameterTypes) + "] are used for constructing " + c.getName());
                    return constructor.newInstance(parameters.toArray());
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    System.out.println("Exception caught: ");
                    ex.printStackTrace(System.out);
                    System.out.println("\nCouldn't instantiate a class, returning null.");
                    return null;
                }
            }
        }
        System.out.println("Couldn't instantiate a class, returning null.");
        return null;
    }

    public static String getParameterNames(Class<?>[] cl) {
        StringBuilder sb = new StringBuilder();
        for (Class c : cl) {
            sb.append(c.getName());
            sb.append("; ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    public static void main(String[] args) {
        Test01 t1 = (Test01) createObject(Test01.class);
        Test02 t2 = (Test02) createObject(Test02.class);
        String s = (String) createObject(String.class);
        Test03 t3 = (Test03) createObject(Test03.class);
        Test04 t4 = (Test04) createObject(Test04.class);
        Test05 t5 = (Test05) createObject(Test05.class);
        Test06 t6 = (Test06) createObject(Test06.class);
        Integer i = (Integer) createObject(Integer.class);
        Boolean b = (Boolean) createObject(Boolean.class);
    }
}

class Test01 {

    private Test01() {
    }
}

class Test02 {

    public Test02() {
    }
}

class Test03 {

    public Test03(String str) {
    }
}

class Test04 {

    public Test04(Random random, String str) {
    }
}

class Subclass {

    public Subclass(Random r) {
    }
}

class Test05 {

    public Test05(Subclass s) {
    }
}

class Test06 {

    public Test06(Integer i) {
    }
}
