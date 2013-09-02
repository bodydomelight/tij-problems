package containers.p28;

import java.util.Objects;

public class Tuple {

    public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<>(a, b);
    }

    public static <A, B, C> ThreeTuple<A, B, C> tuple(A a, B b, C c) {
        return new ThreeTuple<>(a, b, c);
    }

    public static <A, B, C, D> FourTuple<A, B, C, D> tuple(A a, B b, C c, D d) {
        return new FourTuple<>(a, b, c, d);
    }

    public static <A, B, C, D, E> FiveTuple<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
        return new FiveTuple<>(a, b, c, d, e);
    }

    private static class TwoTuple<A, B> implements Comparable<TwoTuple<A, B>> {

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

        @Override
        public int compareTo(TwoTuple<A, B> o) {
            return first.hashCode() > o.first.hashCode() ? 1
                    : (first.hashCode() < o.first.hashCode() ? -1
                    : (second.hashCode() > o.second.hashCode() ? 1
                    : (second.hashCode() < o.second.hashCode() ? -1 : 0)));
        }

        @Override
        public int hashCode() {
            int result = 17;
            if (first != null) {
                result = result * 37 + first.hashCode();
            }
            if (second != null) {
                result = result * 37 + second.hashCode();
            }
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final TwoTuple<A, B> other = (TwoTuple<A, B>) obj;
            if (!Objects.equals(this.first, other.first)) {
                return false;
            }
            if (!Objects.equals(this.second, other.second)) {
                return false;
            }
            return true;
        }
    }

    private static class ThreeTuple<A, B, C> implements Comparable<ThreeTuple<A, B, C>> {

        public final C third;
        public final TwoTuple<A, B> twoTuple;

        public ThreeTuple(A a, B b, C c) {
            twoTuple = tuple(a, b);
            third = c;
        }

        @Override
        public String toString() {
            return "(" + twoTuple.first + ", " + twoTuple.second + ", " + third + ")";
        }

        @Override
        public int hashCode() {
            int result = 17 * 37 + twoTuple.hashCode();
            if (third != null) {
                result = result * 37 + third.hashCode();
            }
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ThreeTuple<A, B, C> other = (ThreeTuple<A, B, C>) obj;
            if (!Objects.equals(this.third, other.third)) {
                return false;
            }
            if (!Objects.equals(this.twoTuple, other.twoTuple)) {
                return false;
            }
            return true;
        }

        @Override
        public int compareTo(ThreeTuple<A, B, C> o) {
            int result = twoTuple.compareTo(o.twoTuple);
            if (result == 0) {
                result = third.hashCode() > o.third.hashCode() ? 1
                        : (third.hashCode() < o.third.hashCode() ? -1 : 0);
            }
            return result;
        }
    }

    private static class FourTuple<A, B, C, D> implements Comparable<FourTuple<A, B, C, D>> {

        public final D fourth;
        public final ThreeTuple<A, B, C> threeTuple;

        public FourTuple(A a, B b, C c, D d) {
            threeTuple = tuple(a, b, c);
            fourth = d;
        }

        @Override
        public String toString() {
            return "(" + threeTuple.twoTuple.first + ", " + threeTuple.twoTuple.second + ", "
                    + threeTuple.third + ", " + fourth + ")";
        }

        @Override
        public int hashCode() {
            int result = 17 * 37 + threeTuple.hashCode();
            if (fourth != null) {
                result = result * 37 + fourth.hashCode();
            }
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final FourTuple<A, B, C, D> other = (FourTuple<A, B, C, D>) obj;
            if (!Objects.equals(this.fourth, other.fourth)) {
                return false;
            }
            if (!Objects.equals(this.threeTuple, other.threeTuple)) {
                return false;
            }
            return true;
        }

        @Override
        public int compareTo(FourTuple<A, B, C, D> o) {
            int result = threeTuple.compareTo(o.threeTuple);
            if (result == 0) {
                result = fourth.hashCode() > o.fourth.hashCode() ? 1
                        : (fourth.hashCode() < o.fourth.hashCode() ? -1 : 0);
            }
            return result;
        }
    }

    private static class FiveTuple<A, B, C, D, E> implements Comparable<FiveTuple<A, B, C, D, E>> {

        public final E fifth;
        public final FourTuple<A, B, C, D> fourTuple;

        public FiveTuple(A a, B b, C c, D d, E e) {
            fourTuple = tuple(a, b, c, d);
            fifth = e;
        }

        @Override
        public String toString() {
            return "(" + fourTuple.threeTuple.twoTuple.first + ", "
                    + fourTuple.threeTuple.twoTuple.second + ", "
                    + fourTuple.threeTuple.third + ", " + fourTuple.fourth
                    + ", " + fifth + ")";
        }

        @Override
        public int hashCode() {
            int result = 17 * 37 + fourTuple.hashCode();
            if (fifth != null) {
                result = result * 37 + fifth.hashCode();
            }
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final FiveTuple<A, B, C, D, E> other = (FiveTuple<A, B, C, D, E>) obj;
            if (!Objects.equals(this.fifth, other.fifth)) {
                return false;
            }
            if (!Objects.equals(this.fourTuple, other.fourTuple)) {
                return false;
            }
            return true;
        }

        @Override
        public int compareTo(FiveTuple<A, B, C, D, E> o) {
            int result = fourTuple.compareTo(o.fourTuple);
            if (result == 0) {
                result = fifth.hashCode() > o.fifth.hashCode() ? 1
                        : (fifth.hashCode() < o.fifth.hashCode() ? -1 : 0);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        FiveTuple<Integer, String, Boolean, Float, Long> t1 = tuple(1, "A", false, 14f, 8L);
        FiveTuple<Integer, String, Boolean, Float, Long> t2 = tuple(1, "A", true, 14f, 8L);
        System.out.println("t1 : " + t1);
        System.out.println("t2 : " + t2);
        System.out.println("t1.equals(t1) : " + t1.equals(t1));
        System.out.println("t1.equals(t2) : " + t1.equals(t2));
        System.out.println("t1.compareTo(t1) : " + t1.compareTo(t1));
        System.out.println("t1.compareTo(t2) : " + t1.compareTo(t2));
    }
}
