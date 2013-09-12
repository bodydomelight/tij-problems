/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package containers.p40;

public class TwoStringsComparable implements Comparable<TwoStringsComparable> {

    private String a;
    private String b;

    public TwoStringsComparable(String str1, String str2) {
        a = str1;
        b = str2;
    }

    public String getFirstString() {
        return a;
    }

    public String getSecondString() {
        return b;
    }

    @Override
    public int compareTo(TwoStringsComparable o) {
        return a.compareTo(o.getFirstString());
    }

    @Override
    public String toString() {
        return "[1:" + a + "; 2:" + b + "]";
    }
}
