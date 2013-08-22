package generics.p21;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class Building {
}

class House extends Building {
}

public class ClassTypeCapture {

    Map<String,Class<?>> kinds;
    
    public ClassTypeCapture() {
        kinds = new HashMap<>();
    }

    public void addType(String typename, Class<?> kind) {
        kinds.put(typename, kind);
    }
    public Object createNew(String typename){
        Class<?> c = kinds.get(typename);
        try {
            return c.newInstance();
        } catch(NullPointerException e) {
            System.out.println("No such type: " + typename);
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
        
    }
    public static void main(String[] args) {
        ClassTypeCapture ctt = new ClassTypeCapture();
        ctt.addType("string", String.class);
        ctt.addType("random", Random.class);
        ctt.addType("object", Object.class);
        ctt.addType("int", Integer.class);
        System.out.println(ctt.createNew("string").getClass().getName() + "\n" + 
                ctt.createNew("random").getClass().getName() + "\n" +
                ctt.createNew("object").getClass().getName());
        ctt.createNew("map");
        ctt.createNew("int");
        
    }
}
