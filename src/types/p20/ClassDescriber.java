package types.p20;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassDescriber {

    public void printPublicFields(Class clss) {
        Field[] fields = clss.getFields();
        System.out.println();
        if (fields.length == 0) {
            System.out.println("The class has no public fields");
        } else {
            System.out.println("Class has the following public fields:\n");
            for (Field field : fields) {
                System.out.println(field);
            }
            System.out.println();
        }
    }
    
    public void printPublicMethods(Class clss) {
        Method[] methods = clss.getMethods();
        System.out.println();
        if(methods.length == 0) {
            System.out.println("The class has no public methods");
        } else {
            System.out.println("Class has the following public methods:\n");
            for (Method method : methods) {
                System.out.println(method);
            }
            System.out.println();
        }
    }
    
    public void printPublicConstructors(Class clss) {
        Constructor[] constructors = clss.getConstructors();
        System.out.println();
        if(constructors.length == 0) {
            System.out.println("The class has no public constructors");
        } else {
            System.out.println("Class has the following public constructors:\n");
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("usage: java ClassDescriber %full class name%");
            System.exit(1);
        } else {
            ClassDescriber cd = new ClassDescriber();
            Class inputClass = null;
            try {
                inputClass = Class.forName(args[0]);
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found");
                System.exit(2);
            }
            cd.printPublicFields(inputClass);
            cd.printPublicMethods(inputClass);
            cd.printPublicConstructors(inputClass);
        }

    }
}
