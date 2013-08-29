package types.p26;

public class Drum extends Instrument implements Percussion{

    @Override
    public void play() {
        System.out.println("Drum's playing");
    }

    @Override
    public void prepareInstrument() {
        System.out.println("Drum's prepared");
    }
    
    @Override
    public void kick() {
        System.out.println("Drum's kicked");
    } 

    @Override
    public void readTheName() {
        System.out.println("This is Drum");
    }
    
}
