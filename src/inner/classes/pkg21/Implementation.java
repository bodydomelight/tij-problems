package inner.classes.pkg21;

public class Implementation implements Interface{
    private String name;
    
    public Implementation(String name) {
        this.name = name;
    }
    @Override
    public void print() {
        System.out.println(name);
    }
    @Override
    public String getName() {
        return name;
    }
}
