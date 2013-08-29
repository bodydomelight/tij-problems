package strings.p20;

import java.util.Scanner;

class TestClass {
    private int i;
    private long l;
    private float f;
    private double d;
    private String str;
    
    TestClass(String line) {
        Scanner scanner = new Scanner(line);
        i = scanner.nextInt();
        l = scanner.nextLong();
        f = scanner.nextFloat();
        d = scanner.nextDouble();
        str = scanner.next();
    }
    @Override
    public String toString() {
        return "int i = " + i + ";\n" + 
                "long l = " + l + ";\n" +
                "float f = " + f + ";\n" + 
                "double d = " + d + ";\n" +
                "String str = " + str + ".";
    }
}

public class ScannerClass {
    public static void main(String[] args) {
        TestClass tc = new TestClass("1 2 3.5 4.5 Banana");
        System.out.println(tc);
    }
}