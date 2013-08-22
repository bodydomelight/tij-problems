package types.p26;

public class Horn extends Instrument implements Wind{

    @Override
    public void play() {
        System.out.println("Horn's played");
    }

    @Override
    public void prepareInstrument() {
        System.out.println("Horn's prepared");
    }

    @Override
    public void blow() {
        System.out.println("Horn's blown");
    }
    
    @Override
    public void clearSpitValve() {
        System.out.println("Spit valve's cleared");
    }

    @Override
    public void readTheName() {
        System.out.println("This is a Horn");
    }
    
}
