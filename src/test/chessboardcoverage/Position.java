package test.chessboardcoverage;

public class Position {

    private final int x;
    private final int y;
    private final Chessboard board;
    
    public Position(Chessboard board, int x, int y) {
        if (x >= 0 && x < board.getHeight() && y >= 0 && y < board.getHeight()) {
            this.x = x;
            this.y = y;
            this.board = board;
        } else {
            throw new IllegalArgumentException("Coordinates are beyond the chessboard");
        }
    }
    public Position(Chessboard board, char x, int y) {
        this (board, (int)x - 97, y - 1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.valueOf(board.getWidthName(x)) + String.valueOf(board.getHeightName(y));
    }
}
