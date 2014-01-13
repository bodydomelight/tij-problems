package test;

public class SingleDispatch {
    public static void main(String[] args) {
        Ship s0 = new Ship();
        Ship s1 = new BiggerShip();
        Cargo c0 = new Cargo();
        Cargo c1 = new BigCargo();

        c0.printC(s0);
        c0.printC(s1);
        c1.printC(s0);
        c1.printC(s1);
    }
}

class Ship {
    public void print(Cargo c) {
        System.out.println("Ship + Cargo");
    }
    public void print(BigCargo c) {
        System.out.println("Ship + BigCargo");
    }
}

class BiggerShip extends Ship {
    @Override
    public void print(Cargo c) {
        System.out.println("BiggerShip + Cargo");
    }
    @Override
    public void print(BigCargo c) {
        System.out.println("BiggerShip + BigCargo");
    }
}

class Cargo {
    void printC(Ship s) {
        s.print(this);
    }
}

class BigCargo extends Cargo {
    @Override
    void printC(Ship s) {
        s.print(this);
    }
}