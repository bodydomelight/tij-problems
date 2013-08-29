/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package error.p04;

/**
 *
 * @author aamelin
 */
public class Runner {
    public static void main(String[] args) {
        try {
            throw new MyException("My message");
        } catch(MyException e) {
            System.out.println(e.getMessageString());
        }
    }
}
