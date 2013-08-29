package generics.p24;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

interface Factory<T> {

    T create();
}

class FactoryClass<T> implements Factory {

    Class<T> typeClass;

    public FactoryClass(Class<T> typeClass) {
        this.typeClass = typeClass;
    }

    @Override
    public T create() {
        try {
            return typeClass.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }
}

public class ClassTypeCapture {

    Map<String, Factory<?>> kinds;

    public ClassTypeCapture() {
        kinds = new HashMap<>();
    }

    public void addType(String typename, Class<?> kind) {
        kinds.put(typename, new FactoryClass<>(kind));
    }

    public Object createNew(String typename) {
        Factory<?> f = kinds.get(typename);
        try {
            return f.create();
        } catch (NullPointerException e) {
            System.out.println("No such type: " + typename);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public static void main(String[] args) {
        ClassTypeCapture ctt = new ClassTypeCapture();
        ctt.addType("string", String.class);
        ctt.addType("random", Random.class);
        ctt.addType("object", Object.class);
        ctt.addType("int", Integer.class);
        System.out.println(ctt.createNew("string").getClass().getName() + "\n"
                + ctt.createNew("random").getClass().getName() + "\n"
                + ctt.createNew("object").getClass().getName());
        ctt.createNew("map");
        ctt.createNew("int");

    }
}