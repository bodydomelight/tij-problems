package io.p16;

import java.io.*;

public class UsingRandomAccessFile {

    static String file = ".\\src\\io\\p16\\rtest.dat";

    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        System.out.println(rf.readBoolean());
        System.out.println(rf.readByte());
        System.out.println(rf.readChar());
        System.out.println(rf.readDouble());
        System.out.println(rf.readFloat());
        System.out.println(rf.readInt());
        System.out.println(rf.readLong());
        System.out.println(rf.readShort());
        System.out.println(rf.readUTF());
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        rf.writeBoolean(true);
        rf.writeByte((byte) 12);
        rf.writeChar('x');
        rf.writeDouble(1.45);
        rf.writeFloat(1.9F);
        rf.writeInt(4);
        rf.writeLong(8);
        rf.writeShort(2);
        rf.writeUTF("EOF");
        rf.close();
        display();
        rf = new RandomAccessFile(file, "rw");
        rf.seek(2);
        rf.writeChar('Y');
        rf.close();
        display();
    }
}
