package holding.p27;

public class Command {
    private String string;
    
    public String operation() {
        return string;
    }
    Command(String name) {
        string = name;
    }
}
