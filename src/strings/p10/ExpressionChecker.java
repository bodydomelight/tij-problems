package strings.p10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionChecker {

    public static void main(String[] args) {
        String str = "Java now has regular expressions";
        String[] expressions = {"^Java", "\\Breg.*", "n.w\\s+h(a|i)s", "s?",
            "s*", "s+", "s{2}", "S{1}", "s{0,3}"};
        for (String expression : expressions) {
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(str);
            System.out.println("Regular expression: " + expression + "");
            while (matcher.find()) {
                System.out.println("Match at positions " + matcher.start()
                        + " - " + (matcher.end() - 1));
            }
        }
    }
}
