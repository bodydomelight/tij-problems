package enums.p07;

import java.util.EnumSet;

public class EnumSetTest {
    enum Test {
        A, B, C
    }
    public static void main(String[] args) {
        EnumSet<Test> es = EnumSet.allOf(Test.class);
    }
}
