package test.chessboardcoverage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CoverageFinder {

    private List<String> paths = new ArrayList<>();
    private PieceStrategy piece;
    private boolean[][] chessboard;
    private StringBuilder path = new StringBuilder();
    private long numberFound = 0;

    public CoverageFinder(PieceStrategy p) {
        piece = p;
        chessboard = new boolean[p.getBoard().getWidth()][p.getBoard().getHeight()];
    }

    private boolean noEmptySquares() {
        for (boolean[] row : chessboard) {
            for (boolean square : row) {
                if (!square) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasBeenVisited(Position p) {
        return chessboard[p.getX()][p.getY()];
    }

    private List<Position> getNextValidMoves(Position p) {
        List<Position> validMoves = piece.getPositions(p);
        Iterator<Position> it = validMoves.iterator();
        Position pos;
        while (it.hasNext()) {
            pos = it.next();
            if (hasBeenVisited(pos)) {
                it.remove();
            }
        }
        return validMoves;
    }

    private void findPath(Position p) {
        chessboard[p.getX()][p.getY()] = true;
        path.append(p.toString()).append("-");
        List<Position> nextPositions = getNextValidMoves(p);
        if (nextPositions.isEmpty()) {
            if (noEmptySquares()) {
                System.out.println("path " + (++numberFound) + ": "
                        + path.substring(0, path.length() - 1));
                paths.add(path.toString());
            }
        } else {
            for (Position pos : nextPositions) {
                findPath(pos);
            }
        }
        chessboard[p.getX()][p.getY()] = false;
        path.delete(path.length() - 3, path.length());
    }

    public List<String> getPaths(Position start) {
        findPath(start);
        return paths;
    }

    public static void main(String[] args) { //test
        Chessboard b = new Chessboard(6, 6);
        CoverageFinder cf = new CoverageFinder(new Horse(b));
        List<String> list = cf.getPaths(new Position(b, 'a', 3));
        System.out.println("list " + list.size());
    }
}
