package error.p04;

public class MyException extends Exception{
    private String string;
    
    public MyException(String message) {
        string = message;
    }
    public String getMessageString() {
        return string;
    }
    
}
