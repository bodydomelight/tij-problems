package containers.p40;

import java.util.Comparator;

public class TwoStringsSecondFieldComparator implements Comparator<TwoStringsComparable>{

    @Override
    public int compare(TwoStringsComparable o1, TwoStringsComparable o2) {
        return o1.getSecondString().compareTo(o2.getSecondString());
    }
}
