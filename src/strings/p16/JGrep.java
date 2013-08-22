package strings.p16;

import java.io.File;
import java.util.regex.*;
import net.mindview.util.*;

public class JGrep {

    public static void main(String[] args) throws Exception {
//        System.out.println(args[0] + "\n" + args[1]);
        if (args.length < 2 || args.length > 3) {
            System.out.println("P16 - Usage: java JGrep file regex");

            System.exit(0);
        }
//        Pattern p = Pattern.compile("\\b[Ssct]\\w+");
//        System.out.println(args[1].equals("\\b[Ssct]\\w+"));
//        System.out.println(args[1]);
        Pattern p = Pattern.compile(args[1]);
// Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher("");
        File inputFilePath = new File(args[0]);
        File[] files = null;
        if (inputFilePath.isDirectory()) {
            files = new File(inputFilePath.getAbsolutePath()).listFiles();
        }
        if (inputFilePath.isFile()) {
            files = new File[1];
            files[0] = inputFilePath;
        }
        for (File file : files) {
            for (String line : new TextFile(file.getAbsolutePath())) {
//            System.out.println(line);
                m.reset(line);
                while (m.find()) {
                    System.out.println(index++ + ": " + m.group() + ": " + m.start());
                }
            }
        }
    }
}
