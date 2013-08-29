package inner.classes.pkg13;

public class NewClass {
    private String name;
    
    {   // initializes name
        name = "nil";
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public NewInterface getNewInterface() {
        return new NewInterface() {
            @Override
            public String getNameI() {
                return name;
            }
        };
    }
    public static void main(String[] args) {
        NewClass nc = new NewClass();
        nc.setName("Maple");
        NewInterface ni = nc.getNewInterface();
        System.out.println(ni.getNameI());
    }
}
