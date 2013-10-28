package io.p29;

import java.io.*;
import static net.mindview.util.Print.*;

public class Blip3 implements Externalizable {

    private int i;
    private String s; // No initialization

    public Blip3() {
        print("Blip3 Constructor");
// s, i not initialized
    }

    public Blip3(String x, int a) {
        print("Blip3(String x, int a)");
        s = x;
        i = a;
// s & i initialized only in non-default constructor.
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
// You must do this:
//        out.writeObject(s);
//        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip3.readExternal");
// You must do this:
//        s = (String) in.readObject();
//        i = in.readInt();
    }

    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        final String path = ".\\src\\io\\p29\\Blip3.out";
        print("Constructing objects:");
        Blip3 b3 = new Blip3("A String ", 47);
        print(b3);
        try (ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream(path))) {
            print("Saving object:");
            o.writeObject(b3);
        }
// Now get it back:
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(path));
        print("Recovering b3:");
        b3 = (Blip3) in.readObject();
        print(b3);
    }
}
