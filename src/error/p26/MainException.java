package error.p26;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainException {
// Pass all exceptions to the console:

    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream("MainException.java");
            file.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
