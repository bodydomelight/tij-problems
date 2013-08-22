package strings.p17;

import java.io.File;
import java.util.regex.*;
import net.mindview.util.*;

public class JGrep {

    public static void main(String[] args) throws Exception {
//        System.out.println(args[0] + "\n" + args[1]);
        if (args.length != 1) {
            System.out.println("P17 - Usage: java JGrep file");
            System.exit(0);
        }
        Pattern p = Pattern.compile("(//.*)|(/\\*.*\\*/)");
// Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher(""); /* comment */

        for (String line : new TextFile(args[0])) {
//            System.out.println(line);
            m.reset(line);
            while (m.find()) {
                System.out.println(index++ + ": " + m.group());
            }
        }
    }
}
