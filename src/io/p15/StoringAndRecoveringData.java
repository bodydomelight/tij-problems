package io.p15;

import java.io.*;

public class StoringAndRecoveringData {

    public static void main(String[] args)
            throws IOException {
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream(".\\src\\io\\p15\\Data.dat")))) {
            out.writeBoolean(true);
            out.writeByte((byte) 127);
            out.writeByte((byte) 128);
            out.writeChar('x');
            out.writeDouble(3.14159);
            out.writeFloat(2.17F);
            out.writeInt(13);
            out.writeLong(14L);
            out.writeShort((short) 30000);
            out.writeShort((short) 65535);
            out.writeDouble(1.41413);
            out.writeUTF("Square root of 2");
        }
        DataInputStream in = new DataInputStream(new BufferedInputStream(
                new FileInputStream(".\\src\\io\\p15\\Data.dat")));
        System.out.println(in.readBoolean());
        System.out.println(in.readByte());
        System.out.println(in.readUnsignedByte());
        System.out.println(in.readChar());
        System.out.println(in.readDouble());
// Only readUTF() will recover the
// Java-UTF String properly:
        System.out.println(in.readFloat());
        System.out.println(in.readInt());
        System.out.println(in.readLong());
        System.out.println(in.readShort());
        System.out.println(in.readUnsignedShort());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
