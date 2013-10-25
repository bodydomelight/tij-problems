package io.p25;

import java.nio.*;

public class IntBufferDemo {

    private static final int BSIZE = 4_000_000;

    public static void main(String[] args) {
        long start = System.nanoTime();
//        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        ByteBuffer bb = ByteBuffer.allocateDirect(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        for (int i = 0; i < 1_000_000; i++) {
//            System.out.println(i);
            ib.put(i);
        }
        ib.flip();
        while (ib.hasRemaining()) {
            ib.get();
        }
        System.out.println((System.nanoTime() - start) / 1e9f + " s.");
    }
}
