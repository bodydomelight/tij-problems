package test.chessboardcoverage;

import java.util.ArrayList;
import java.util.List;

public class Horse implements PieceStrategy {

    private boolean isWithinBoard(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }
        return true;
    }

    private void add(int x, int y, List<Position> list) {
        if (isWithinBoard(x, y)) {
            list.add(new Position(x, y));
        }
    }

    @Override
    public List<Position> getPositions(Position p) {
        List<Position> availableMoves = new ArrayList<>();
        int x = p.getX();
        int y = p.getY();

        add(x - 2, y - 1, availableMoves);
        add(x - 2, y + 1, availableMoves);
        add(x + 2, y - 1, availableMoves);
        add(x + 2, y + 1, availableMoves);
        add(x - 1, y - 2, availableMoves);
        add(x + 1, y - 2, availableMoves);
        add(x - 1, y + 2, availableMoves);
        add(x + 1, y + 2, availableMoves);
        return availableMoves;
    }

    public static void main(String[] args) {
        Horse h = new Horse();
        System.out.println("a1 : " + h.getPositions(new Position('a', 1)));
        System.out.println("b7 : " + h.getPositions(new Position('b', 7)));
        System.out.println("b4 : " + h.getPositions(new Position('b', 4)));
        System.out.println("b4 : " + h.getPositions(new Position(1, 3)));
        System.out.println(new Position('g', 8));
    }
}
