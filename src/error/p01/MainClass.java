/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package error.p01;

/**
 *
 * @author aamelin
 */
public class MainClass {
    
    
    public static void main(String[] args) {
        try {
            throw new Exception("String value");
        } catch(Exception e){
            e.printStackTrace(System.out);
        } finally {
            System.out.println("Message from finally clause");
        }
    }
}
