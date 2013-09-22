package test.chessboardcoverage;

public class Position {

    private static char[] row = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    private static char[] column = {'1', '2', '3', '4', '5', '6', '7', '8'};
    private final int x;
    private final int y;

    public Position(int x, int y) {
        if (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            this.x = x;
            this.y = y;
        } else {
            throw new IllegalArgumentException("Coordinates are beyond the chessboard");
        }
    }
    public Position(char x, int y) {
        this ((int)x - 97, y - 1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.valueOf(row[x]) + String.valueOf(column[y]);
    }
}
