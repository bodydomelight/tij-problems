package error.p21;

class MyException extends Exception {
}

class Class {

    Class() throws MyException {
        throw new MyException();
    }
}

public class NewClass extends Class {

    NewClass() throws MyException {
            super();
        }
    
    public static void main(String[] args) {
        try {
            NewClass nc = new NewClass();
        } catch(MyException e) {
            System.out.println("MyException caught");
        }
        System.out.println("Out of try-catch");
    }
}
