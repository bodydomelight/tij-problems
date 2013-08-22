/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package strings.p07;

/**
 *
 * @author aamelin
 */
public class Runner {
    public static void main(String[] args) {
        SentenceCheck sc = new SentenceCheck();
        
        sc.compare("A compiled representation of a regular expression.");
        sc.compare("A regular expression, specified as a string, must first be compiled into an instance of this class.");
        sc.compare("A typical invocation sequence is thus ");
        sc.compare("Boolean b = Pattern.matches(\"a*b\", \"aaaaab\").");
        sc.compare(" boolean b = Pattern.matches(\"a*b\", \"aaaaab\")");
    }
}
