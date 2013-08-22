/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package holding.p22;

/**
 *
 * @author aamelin
 */
public class Test {
    public static void main(String[] args) {
        WordStat ws = new WordStat("a cat");
        WordStat ws2 = ws;
        System.out.println(ws.equals("a cat"));
        System.out.println(ws.equals(ws2));
        System.out.println(ws.equals("a dog"));
        System.out.println(ws.equals(new Object()));
    }
}
