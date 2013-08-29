package types.p09;

import java.lang.reflect.Field;

public class RecursivePrint {

    public static void getClassHierarchy(Class clss) {
        System.out.println("Class name: " + clss.getSimpleName());
        if (clss.getDeclaredFields().length != 0) {
            System.out.print("Fields: ");
            for (Field field : clss.getDeclaredFields()) {
                System.out.print("[" + field.getName() + "]" + " ");
            }
            System.out.println();
        } else {
            System.out.println("Fields: this class has no fields");
        }
        System.out.println();
        if (clss.getSuperclass() != null) {
            getClassHierarchy(clss.getSuperclass());
        }
    }

    public static void printObjectClassHierarchy(Object obj) {
        getClassHierarchy(obj.getClass());
    }

    public static void main(String[] args) {
        printObjectClassHierarchy(new String());
    }
}
