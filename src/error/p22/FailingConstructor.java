package error.p22;

import java.util.Random;

class SomeException extends Exception {
}

public class FailingConstructor {

    String swtch = "Off";

    FailingConstructor() throws SomeException {
        Random rand = new Random();
        int i = rand.nextInt(2);
        if (i == 0) {
            throw new SomeException();
        }
    }

    public static void main(String[] args) {
        try {
            FailingConstructor fc = new FailingConstructor();
            try {
                fc.swtch = "On!";
                System.out.println(fc.swtch);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                fc.swtch = "Paused";
                System.out.println(fc.swtch);
            }
        } catch (SomeException e) {
            System.out.println("Constructor failed");
            e.printStackTrace();
        }
    }
}
