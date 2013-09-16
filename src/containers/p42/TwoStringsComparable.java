package containers.p42;

import java.util.Objects;

public class TwoStringsComparable implements Comparable<TwoStringsComparable> {

    private String a;
    private String b;

    public TwoStringsComparable(String str1, String str2) {
        a = str1;
        b = str2;
    }

    public String getFirstString() {
        return a;
    }

    public String getSecondString() {
        return b;
    }

    @Override
    public int compareTo(TwoStringsComparable o) {
        return a.compareToIgnoreCase(o.getFirstString());
    }

    @Override
    public String toString() {
        return "[1:" + a + "; 2:" + b + "]";
    }
    @Override
    public int hashCode() {
        return a.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TwoStringsComparable other = (TwoStringsComparable) obj;
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        return true;
    }
}
