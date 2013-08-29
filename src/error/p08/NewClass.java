package error.p08;

import error.p04.MyException;

public class NewClass {

    public void myMethod() throws MyException {
        throw new MyException("");
    }

    public static void main(String[] args) {
        NewClass nc = new NewClass();
        try {
            nc.myMethod();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
