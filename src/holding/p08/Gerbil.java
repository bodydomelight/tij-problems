package holding.p08;

public class Gerbil {
    
    private final int number;
    private static int count = 1;
    
    public Gerbil() {
        number = count++;
    }
    public void hop() {
        System.out.println("Gerbil number " + number + " is hopping.");
    }
}
