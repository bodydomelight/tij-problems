package types.p10;

public class PrimitiveOrObject {
    public static void main(String[] args) {
        char[] chr = {'a', 'b', 'c'};
        System.out.println(chr.getClass().isPrimitive());
        System.out.println(chr.getClass());
        System.out.println(chr.getClass().getSuperclass());
    }
}
