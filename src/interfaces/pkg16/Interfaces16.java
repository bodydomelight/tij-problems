/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.pkg16;

/**
 *
 * @author rage
 */
import java.util.*;
import java.nio.*;

public class Interfaces16 implements Readable {
    private static Random rand = new Random(47);
    private static final char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private int count;
    public Interfaces16(int count) {
        this.count = count;
    }
    public char getChar() {
        return chars[rand.nextInt(26)];
    }
    @Override
    public int read(CharBuffer cb) {
        if (count-- == 0)
            return -1;
        String result = Character.toString(getChar()) + " ";
        cb.append(result);
        return result.length();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Interfaces16 i16 = new Interfaces16(25);
        //for (int i = 0; i < 25; i++) {
        //    System.out.print(i16.getChar() + ", ");
        //}
        Scanner s = new Scanner(new Interfaces16(25));
        while(s.hasNextLine())
            System.out.print(s.nextLine() + " ");
    }
}
