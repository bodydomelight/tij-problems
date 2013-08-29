package holding.p01;

import java.util.ArrayList;

public class NewClass {
    public static void main(String[] args) {
        ArrayList<Gerbil> a = new ArrayList<Gerbil>();
        for (int i = 0; i < 10; i++) {
            a.add(new Gerbil());
        }
        for (Gerbil g : a) {
            g.hop();
        }
    }
}
