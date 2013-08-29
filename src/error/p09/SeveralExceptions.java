package error.p09;

class Exception1 extends Exception {
    
}

class Exception2 extends Exception {
    
}

class Exception3 extends Exception {
    
}

public class SeveralExceptions {
    public static void throwThreeExceptions(int key) throws Exception1, Exception2, Exception3 {
        switch(key) {
            case 1:     throw new Exception1();
            case 2:     throw new Exception2();
            default:    throw new Exception3();
        }
    }
    public static void main(String[] args) {
        try {
            throwThreeExceptions(78);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
