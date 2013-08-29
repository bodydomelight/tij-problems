package error.p28;

public class MyException extends RuntimeException{
    private String string;
    
    public MyException(String message) {
        string = message;
    }
    public String getMessageString() {
        return string;
    }
    
}
