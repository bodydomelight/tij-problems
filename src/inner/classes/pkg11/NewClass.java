/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inner.classes.pkg11;

public class NewClass {

    private class Inner implements NewInterface {
        
        @Override
        public String getName() {
            return name;
        }
    }
    
    String name = "nil";
    
    public NewInterface getInner() {
        return new Inner();
    }     
}