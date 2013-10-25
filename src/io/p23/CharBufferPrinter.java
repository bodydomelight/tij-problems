package io.p23;

import java.nio.CharBuffer;

public class CharBufferPrinter {

    public static void printCharBuffer(CharBuffer buffer) {
        printCharBuffer(buffer, "\n");
    }

    public static void printCharBuffer(CharBuffer buffer, String end) {
        System.out.print(getSubsequence(buffer).toString() + end);
    }

    //returns a subsequence of the given buffer without trailing spaces
    private static CharBuffer getSubsequence(CharBuffer buffer) {
        if (buffer.length() > 0) {
            for (int i = buffer.length() - 1; i >= 0; i--) {
                if (buffer.charAt(i) != '\u0000') {
                    //System.out.println(i + ": '" + buffer.charAt(i) + "'");
                    return buffer.subSequence(0, i + 1);
                }
            }
        }
        return buffer;
    }
}
