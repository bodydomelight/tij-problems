package strings.p07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceCheck {
    private Pattern pattern = Pattern.compile("^[A-Z].*[\\.]$");
    private Matcher matcher;
    private boolean b;
    public boolean compare(String sentence) {
        matcher = pattern.matcher(sentence);
        b = matcher.matches();
        System.out.println(b + ": \""+ sentence + "\"");
        return b;
    }
}
