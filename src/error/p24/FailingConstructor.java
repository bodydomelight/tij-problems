package error.p24;

import java.util.Random;

class SomeException extends Exception {
}

class MemberClass {

    String name;

    MemberClass(String str) {
        name = str;
    }

    public void dispose() {
        System.out.println(name + " disposed.");
    }

    public void printState() {
        System.out.println(name);
    }

    public void changeState(String str) {
        name = str;
    }
}

public class FailingConstructor {

    MemberClass mc1, mc2;

    FailingConstructor() throws SomeException {
        mc1 = new MemberClass("mc1");

        Random rand = new Random();
        int i = rand.nextInt(2);
        if (i == 0) {
            throw new SomeException();
        }

        mc2 = new MemberClass("mc2");
    }
    
    public void dispose() {
        System.out.println("FailingConstructor disposed.");
    }

    public static void main(String[] args) {
        try {
            FailingConstructor fc = new FailingConstructor();
            try {
                
            } finally {
                fc.mc2.dispose();
                fc.mc1.dispose();
                fc.dispose();
            }
        }catch(SomeException e) {
            System.out.println("Construction failed");
        }

    }
}
