package types.p26;

public class Runner {

    public static void main(String[] args) {
        Instrument[] instr = {new Drum(), new Horn()};
        for (Instrument i : instr) {
            i.readTheName();
            i.play();
            if (i instanceof Wind) {
                ((Wind)i).clearSpitValve();
            }
        }
    }
}
