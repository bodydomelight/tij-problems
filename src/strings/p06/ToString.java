package strings.p06;

public class ToString {
    int integerField;
    long longField;
    float floatField;
    double doubleField;
    
    ToString(int i, long lo, float f, double d) {
        integerField = 1;
        longField = lo;
        floatField = f;
        doubleField = d;
    }
    
    @Override
    public String toString() {
        return String.format("Integer: %5d\nLong: %5d\nFloat: %5.2f\nDouble: %5.3f",
                integerField, longField, floatField, doubleField);
    }
    
    public static void main(String[] args) {
        ToString ts = new ToString(4, 999999999999999999l, 34.1234567890f, 42.42424242424242424);
        System.out.println(ts);
    }
}
