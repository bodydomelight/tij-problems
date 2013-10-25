package io.p23;

import java.nio.ByteBuffer;

public class CharBufferPrinterDemo {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(24);
        buffer.asCharBuffer().put("Some text");
        System.out.print(buffer.asCharBuffer());
        System.out.println("|");
        CharBufferPrinter.printCharBuffer(buffer.asCharBuffer(), "|\n");
    }
}
