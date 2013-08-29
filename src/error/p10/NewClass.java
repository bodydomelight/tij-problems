package error.p10;

class FirstException extends Exception {}

class SecondException extends Exception {}

public class NewClass {
    public void f() throws FirstException {
        throw new FirstException();
    }
    public void g() throws SecondException {
        try {
            this.f();
        } catch(FirstException e) {
            System.out.println("FirstException caught.");
            e.printStackTrace();
            throw new SecondException();
        }
    }
    public static void main(String[] args) {
        NewClass nc = new NewClass();
        try {
            nc.g();
        } catch(SecondException e) {
            System.out.println("SecondException caught.");
//            e.printStackTrace();
        }
    }
}
