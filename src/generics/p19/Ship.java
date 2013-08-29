package generics.p19;

import java.util.ArrayList;

public class Ship extends ArrayList<Container>{
    int numberOfConatainers;
    public Ship(int containers) {
        numberOfConatainers = containers;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Container c : this) {
            sb.append("\n===========================================\n");
            for (Shelf s : c) {
                sb.append("-------------------------------------------\n");
                for (Box b : s) {
                    for (Good g : b) {
                        sb.append(g);
                    }
                    sb.append("\n");
                }
                sb.append("-------------------------------------------\n");
            }
            sb.append("===========================================\n");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Ship ship = new Ship(3);
        for (int i = 0; i < ship.numberOfConatainers; i++) {
            ship.add(new Container(2, 3, 4));
        }
        System.out.println(ship);
    }
}
