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
}
