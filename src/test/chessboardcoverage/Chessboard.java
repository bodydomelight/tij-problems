package test.chessboardcoverage;

public class Chessboard {

    private int x;
    private int y;
    private static final char[] ROW = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    private static final char[] COLUMN = {'1', '2', '3', '4', '5', '6', '7', '8'};

    public Chessboard(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getWidth() {
        return x;
    }

    public int getHeight() {
        return y;
    }

    public char getWidthName(int index) {
        return ROW[index];
    }

    public char getHeightName(int index) {
        return COLUMN[index];
    }
}
