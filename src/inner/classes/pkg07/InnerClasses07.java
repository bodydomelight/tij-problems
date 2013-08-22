package inner.classes.pkg07;

public class InnerClasses07 {

    private String name;
    
    InnerClasses07() {
        this.name = "null";
    }
    
    private void setName(String name) {
        this.name = name;
    }
    
    private void displayName() {
        System.out.println("Input string is " + name + " and the name is set to "
                            + this.name + ". setAndDisplayMethod.");
    }
    
    void createAndUseInnerObject(String name) {
        Inner inner = this.new Inner();
        inner.setName(name);
        this.displayName();
    }
    
    class Inner {
        void setName(String name) {
            InnerClasses07.this.name = name;
            System.out.println("Inner class. Name is set to " + 
                                InnerClasses07.this.name + ". setName.");
            InnerClasses07.this.displayName();
            System.out.println("Called from Inner class");
        } 
    }
    
    public static void main(String[] args) {
        InnerClasses07 ic07 = new InnerClasses07();
        ic07.displayName();
        InnerClasses07.Inner i07 = ic07.new Inner();
        ic07.createAndUseInnerObject("Ladybug");
    }
}
