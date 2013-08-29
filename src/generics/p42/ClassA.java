package generics.p42;

import java.util.Date;

public class ClassA {
    private String date;
    public ClassA() {
        updateDate();
    }
    public ClassA(Date date) {
        this.date = date.toString();
    }
    public final void updateDate() {
        date = new Date().toString();
    }
    public String getDate() {
        return date;
    }
    @Override
    public String toString() {
        return date;
    }
}
