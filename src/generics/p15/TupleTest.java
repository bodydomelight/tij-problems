package generics.p15;
import java.util.ArrayList;
import java.util.List;
import static generics.p15.Tuple.*;

public class TupleTest {

    static TwoTuple<String, Integer> f() {
        return tuple("hi", 47);
    }

    static TwoTuple f2() {
        return tuple("hi", 47);
    }

    static ThreeTuple<ArrayList, String, Integer> g() {
        return tuple(new ArrayList(), "hi", 47);
    }

    static FourTuple<ArrayList, Object, String, Integer> h() {
        return tuple(new ArrayList(), new Object(), "hi", 47);
    }

    static FiveTuple<ArrayList, Object, String, Integer, Double> k() {
        return tuple(new ArrayList(), new Object(),
                "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        TwoTuple<String, Integer> ttsi2 = f2();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
System.out.println(h());
        System.out.println(k());
    }
}