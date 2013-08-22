package inner.classes.pkg15;

public class SecondClass {

    FirstClass getFirstClass(final String nme) {
        return new FirstClass(nme) {
            {System.out.println(name);}
        };
    }
    
    public static void main(String[] args) {
        SecondClass sc = new SecondClass();
        sc.getFirstClass("Mole");
    }
}
