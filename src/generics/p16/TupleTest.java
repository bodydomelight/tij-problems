package generics.p16;

import java.util.ArrayList;
import generics.p15.FiveTuple;
import generics.p15.FourTuple;
import generics.p15.ThreeTuple;
import static generics.p16.Tuple.*;
import generics.p15.TwoTuple;

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

    static SixTuple<ArrayList, Object, String, Integer, Double, Float> j() {
        return tuple(new ArrayList(), new Object(), "hi", 47, 11.1, 8.8f);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
        System.out.println(j());
    }
}