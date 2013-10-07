package io.p20;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import net.mindview.util.Directory;
import net.mindview.util.BinaryFile;

public class ClassBytesVerifier {

    private static final byte[] CAFEBABE = {
        (byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE};

    private static boolean verifyFileBeginning(byte[] file) {
        if (file.length < CAFEBABE.length) {
            return false;
        }
//        System.out.println("CAFE: " + Arrays.toString(CAFEBABE));
//        System.out.println("FILE: " + Arrays.toString(Arrays.copyOfRange(file, 0, 6)));
        return Arrays.equals(CAFEBABE, Arrays.copyOfRange(file, 0, 4));
    }

    public static boolean checkFiles(String directory) throws IOException {
        System.out.println(Arrays.toString(CAFEBABE) + " : " + "CAFEBABE");
        File[] files = Directory.walk(directory, ".*\\.class").files.
                toArray(new File[0]);
        byte[] fileByteArray;
        for (File f : files) {
            fileByteArray = BinaryFile.read(f);
            System.out.println(Arrays.toString(Arrays.copyOf(fileByteArray, 4))
                    + " : " + f.getName());
            if (!verifyFileBeginning(fileByteArray)) {
                System.out.println(f.getName() + " is corrupted");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        checkFiles(".\\build");
    }
}
