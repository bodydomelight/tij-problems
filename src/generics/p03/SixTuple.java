/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generics.p03;

class TwoTuple<A, B> {

    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

class ThreeTuple<A, B, C> extends TwoTuple<A, B> {

    public final C third;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        third = c;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }
}

class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {

    public final D fourth;

    public FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        fourth = d;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", "
                + third + ", " + fourth + ")";
    }
}

class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {

    public final E fifth;

    public FiveTuple(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        fifth = e;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", "
                + third + ", " + fourth + ", " + fifth + ")";
    }
}

public class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E> {

    public final F sixth;

    SixTuple(A a, B b, C c, D d, E e, F f) {
        super(a, b, c, d, e);
        sixth = f;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", "
                + third + ", " + fourth + ", " + fifth + ", " + sixth + ")";
    }

    public static void main(String[] args) {
        SixTuple<String, Integer, Character, Boolean, Double, Float> sx =
                new SixTuple<>("String", 42, 'f', false, 2.3d, 4.5f);
        System.out.println(sx);
    }
}
