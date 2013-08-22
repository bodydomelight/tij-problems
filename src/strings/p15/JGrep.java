package strings.p15;

import java.util.regex.*;
import net.mindview.util.*;

public class JGrep {

    public static void main(String[] args) throws Exception {
//        System.out.println(args[0] + "\n" + args[1]);
        if (args.length < 2 || args.length > 3) {
            System.out.println("Usage: java JGrep file regex");

            System.exit(0);
        }
//        Pattern p = Pattern.compile("\\b[Ssct]\\w+");
//        System.out.println(args[1].equals("\\b[Ssct]\\w+"));
//        System.out.println(args[1]);
        Pattern p = null;
        if (args.length == 2) {
            p = Pattern.compile(args[1]);
        }
        if (args.length == 3) {
            int flag;
            switch (args[2]) {
                case "Pattern.CANON_EQ":
                    flag = Pattern.CANON_EQ;
                    break;
                case "Pattern.CASE_INSENSITIVE":
                    flag = Pattern.CASE_INSENSITIVE;
                    break;
                case "Pattern.COMMENTS":
                    flag = Pattern.COMMENTS;
                    break;
                case "Pattern.DOTALL":
                    flag = Pattern.DOTALL;
                    break;
                case "Pattern.LITERAL":
                    flag = Pattern.LITERAL;
                    break;
                case "Pattern.MULTILINE":
                    flag = Pattern.MULTILINE;
                    break;
                case "":
                    flag = Pattern.UNICODE_CASE;
                    break;
                case "Pattern.UNIX_LINES":
                    flag = Pattern.UNIX_LINES;
                    break;
                default: flag = 0;
            }
            p = Pattern.compile(args[1]);
        }
// Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher("");
        for (String line : new TextFile(args[0])) {
            m.reset(line);
            while (m.find()) {
                System.out.println(index++ + ": " + m.group() + ": " + m.start());
            }
        }
    }
}
