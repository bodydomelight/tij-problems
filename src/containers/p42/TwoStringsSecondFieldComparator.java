package containers.p42;

import java.util.Comparator;

public class TwoStringsSecondFieldComparator implements Comparator<TwoStringsComparable>{

    @Override
    public int compare(TwoStringsComparable o1, TwoStringsComparable o2) {
        return o1.getSecondString().compareToIgnoreCase(o2.getSecondString());
    }
}
