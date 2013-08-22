package strings.p05;

//%[argument_index$][flags][width][.precision]conversion

import java.math.BigInteger;
import java.util.Formatter;

public class ComplexConversions {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);
        
        char c = 'a';
        f.format("char: %-5.1s\n", c);
        
        int i = 213;
        f.format("int: %-5d\n", i);
        
        BigInteger bi = new BigInteger("50000000000000");
        f.format("bigint: %-15d\n", bi);
        
        double d = 312.4456789653;
        f.format("double: %5.2f\n", d);
        
        
    }
}
