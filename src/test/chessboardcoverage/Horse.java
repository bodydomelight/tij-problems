package test.chessboardcoverage;

import java.util.ArrayList;
import java.util.List;

public class Horse implements PieceStrategy {

    private Chessboard board;

    public Horse(Chessboard board) {
        if (board == null) {
            throw new NullPointerException("Board is null");
        }
        this.board = board;
    }

    private boolean isWithinBoard(int x, int y) {
        if (x < 0 || x >= board.getWidth() || y < 0 || y >= board.getHeight()) {
            return false;
        }
        return true;
    }

    private void add(int x, int y, List<Position> list) {
        if (isWithinBoard(x, y)) {
            list.add(new Position(board, x, y));
        }
    }
    
    @Override
    public Chessboard getBoard() {
        return board;
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
        Horse h = new Horse(new Chessboard(5, 5));
        Chessboard b = new Chessboard(5, 5);
        System.out.println("a1 : " + h.getPositions(new Position(b, 'a', 1)));
        System.out.println("b7 : " + h.getPositions(new Position(b, 'b', 3)));
        System.out.println("b4 : " + h.getPositions(new Position(b, 'b', 3)));
        System.out.println("b4 : " + h.getPositions(new Position(b, 1, 3)));
        System.out.println(new Position(b, 'a', 5));
        int[] t = new int[1];
        t[0] = 1;
    }
}
