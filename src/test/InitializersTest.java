package test;

public class InitializersTest {

    public static void main(String[] args) {
        Child ch = new Child();
    }
}

class Parent {

    Parent() {
        print();
    }

    void print() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    Child() {
        print();
    }
    private int i = 3;
    @Override
    void print() {
        System.out.println("Child " + i);
    }
}
