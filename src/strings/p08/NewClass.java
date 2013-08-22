package strings.p08;

import java.util.Arrays;

public class NewClass {

    public String splitOnWords(String str, String expression) {
       return Arrays.toString(str.split(expression));
    }

    public static void main(String[] args) {
        String expr = "Then, when you have found the shrubbery, you must "
                + "cut down the mightiest tree in the forest... ";
        NewClass nc = new NewClass();
        System.out.println(nc.splitOnWords(expr, "the | you"));
    }
}
