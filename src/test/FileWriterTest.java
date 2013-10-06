package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriterTest {

    public static void main(String[] args) {

        try (BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("f:\\IMG_0001.JPG"));
                BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream("f:\\out.jpg"));) {
            byte b;
            while (in.available() != 0) {
                b = (byte) in.read();
                out.write(b);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}