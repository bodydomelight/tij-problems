package inner.classes.pkg12;

public class InnerClasses12 {

    private String name = "nil";
    
    private void setName(String name) {
        this.name = name;
    }
    
    private void displayName() {
        System.out.println("Name is " + this.name + ". displayName method.");
    }
    
    void createAndUseInnerObject(String name) {
        Interface inner = this.inner();
        inner.setName(name);
        this.displayName();
    }
    
    public Interface inner() {
        return new Interface() {
            @Override
            public void setName(String name) {
                InnerClasses12.this.name = name;
                System.out.println("Inner class. Name is set to " + 
                        InnerClasses12.this.name + ". setName is called "
                        + "from Inner class");
            } 
        };
    }
    
    public static void main(String[] args) {
        InnerClasses12 ic07 = new InnerClasses12();
        Interface i07 = ic07.inner();
        ic07.displayName();
        i07.setName("Ladybug");
        ic07.displayName();
    }
}
