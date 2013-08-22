package error.p19;

class BaseException extends Exception {
    
}

class InheritedException extends Exception {
    
}

class BaseClass {
    public void toPrint() throws BaseException{
        System.out.println("Base class");
    }
}

class InheritedClass extends BaseClass {
    @Override
    public void toPrint(){
        System.out.println("Inherited class");
    }
}

public class InheritanceTest {
    public static void main(String[] args) {
        InheritedClass c = new InheritedClass();
        c.toPrint();
    }
}
