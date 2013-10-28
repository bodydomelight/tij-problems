package io.p28;

import java.io.*;
import static net.mindview.util.Print.*;

class Blip1 implements Externalizable {

    public Blip1() {
        print("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException {
        print("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        print("Blip1.readExternal");
    }
}

public class BlipCheck implements Externalizable {

//    BlipCheck() {
//        print("Blip2 Constructor");
//    }

    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException {
        print("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        print("Blip2.readExternal");
    }
}

class Blips {

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        final String path = ".\\src\\io\\p28\\Blips.out";
        File blips = new File(path);
        if (blips.exists()) {
            blips.delete();
        }
        print("Constructing objects:");
        Blip1 b1 = new Blip1();
        BlipCheck b2 = new BlipCheck();
        try (ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream(path))) {
            print("Saving objects:");
            o.writeObject(b1);
            o.writeObject(b2);
        }
// Now get them back:
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(path));
        print("Recovering b1:");
        b1 = (Blip1) in.readObject();
// OOPS! Throws an exception:
        print("Recovering b2:");
        b2 = (BlipCheck) in.readObject();
    }
}
