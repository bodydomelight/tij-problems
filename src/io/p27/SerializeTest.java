package io.p27;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeTest {

    public static void main(String[] args) throws FileNotFoundException,
            IOException, ClassNotFoundException {
        String path = ".\\src\\io\\p27\\obj.dat";
        File objDat = new File(path);
        if (objDat.exists()) {
            System.out.println("Deleting obj.dat");
            objDat.delete();
        }
        ObjectTwo o2 = new ObjectTwo("Object Two", new ObjectOne("Object One"));
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(path))) {
            out.writeObject(o2);
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            ObjectTwo o2_2 = (ObjectTwo) in.readObject();
            ObjectOne o1_2 = o2_2.getObjectOne();
            System.out.println(o1_2 + ", " + o2_2);
        }
    }
}

class ObjectOne implements Serializable {

    private final String name;

    public ObjectOne(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class ObjectTwo implements Serializable {

    private final ObjectOne objOne;
    private final String name;

    public ObjectTwo(String name, ObjectOne obj) {
        this.name = name;
        objOne = obj;
    }

    public ObjectOne getObjectOne() {
        return objOne;
    }

    @Override
    public String toString() {
        return name;
    }
}