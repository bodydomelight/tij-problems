package io.p26;

//: strings/JGrep.java
// A very simple version of the "grep" program.
// {Args: JGrep.java "\\b[Ssct]\\w+"}
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

public class JGrep {

    public static List<String> getLines(String path) throws
            FileNotFoundException, IOException {
        MappedByteBuffer buffer = new FileInputStream(path).getChannel()
                .map(FileChannel.MapMode.READ_ONLY, 0, new File(path).length());
        String[] lines = Charset.forName("UTF-8").decode(buffer)
                .toString().split("\n");
        return Arrays.asList(lines);
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile(args[1]);
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher("");
        for (String line : getLines(args[0])) {
//            System.out.println(line);
            m.reset(line);
            while (m.find()) {
                System.out.println(index++ + ": " + m.group() + ": " + m.start());
            }
        }
    }
} /* Output: (Sample)
 0: strings: 4
 1: simple: 10
 2: the: 28
 3: Ssct: 26
 4: class: 7
 5: static: 9
 6: String: 26
 7: throws: 41
 8: System: 6
 9: System: 6
 10: compile: 24
 11: through: 15
 12: the: 23
 13: the: 36
 14: String: 8
 15: System: 8
 16: start: 31
 *///:~