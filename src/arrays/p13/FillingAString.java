package arrays.p13;
import java.util.Arrays;
import arrays.p12.CountingGenerator;
import arrays.p12.ConvertTo;

public class FillingAString {
    public static void main(String[] args) {
        char[] c = new char[10];
        CountingGenerator.Character gen = new CountingGenerator.Character();
        for (int i = 0; i < c.length; i++)
            c[i] = gen.next();
        String str = new String(c);
        System.out.println(Arrays.toString(c));
        System.out.println(str);
    }
}
