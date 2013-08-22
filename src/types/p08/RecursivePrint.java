package types.p08;

public class RecursivePrint {

    public static void getClassHierarchy(Class clss) {
        System.out.println(clss.getSimpleName());
        if (clss.getSuperclass() != null) {
            getClassHierarchy(clss.getSuperclass());
        }
    }
    
    public static void printObjectClassHierarchy(Object obj) {
        getClassHierarchy(obj.getClass());
    }

    public static void main(String[] args) {
        printObjectClassHierarchy(new TypeNotPresentException(null, null));
        
    }
}
