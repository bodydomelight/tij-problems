package test;

class A1 {

    public static void print() {
        System.out.println("A1");
    }
}

class A2 extends A1 {

    public static void print() {
        System.out.println("A2");
    }
}

public class DynamicTypeBinding {

    public static void main(String[] args) {
        A1 a1 = new A2();
        A2 a2 = new A2();
        A1.print();
        A2.print();
    }
}
