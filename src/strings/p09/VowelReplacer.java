package strings.p09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelReplacer {

    private Pattern pattern = Pattern.compile("^[A-Z].*[\\.]$");
    private Matcher matcher;
    private boolean b;

    public boolean compare(String sentence) {
        matcher = pattern.matcher(sentence);
        b = matcher.matches();
        System.out.println(b + ": \"" + sentence + "\"");
        return b;
    }

    public static void main(String[] args) {
        String knights = "Then, when you have found the shrubbery, you must "
                + "cut down the mightiest tree in the forest... "
                + "with... a herring!";
        String replaceAll = knights.replaceAll("[aeiouyAEIOUY]", "_");
        System.out.println(replaceAll);
        System.out.println("Original knights: " + knights);
    }
}