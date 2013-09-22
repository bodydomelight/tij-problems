package test.chessboardcoverage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CoverageFinder {

    private List<String> paths = new ArrayList<>();
    private PieceStrategy piece;
    private boolean[][] chessboard = new boolean[8][8];
    private StringBuilder path = new StringBuilder();

    public CoverageFinder(PieceStrategy p) {
        if (p == null) {
            throw new NullPointerException("Strategy object PieceStrategy is null");
        }
        piece = p;
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
            if (chessboard[pos.getX()][pos.getY()]) {
                it.remove();
            }
        }
        return validMoves;
    }

    private void findPath(Position p) {
        chessboard[p.getX()][p.getY()] = true;
        List<Position> nextPositions = getNextValidMoves(p);
//        System.out.println("path " + path);
        if (nextPositions.isEmpty()) {
            if (noEmptySquares()) {
                System.out.println("path added");
                paths.add(path.toString());
            } else {
                System.out.println("else");
                chessboard[p.getX()][p.getY()] = false;
                System.out.println("path before " + path);
                path.delete(path.length() - 3, path.length());
                System.out.println("path after " + path);
                return;
            }
        }
        for (Position pos : nextPositions) {
            path.append(p.toString()).append("-");
            findPath(pos);
        }
    }

    public List<String> getPaths(Position start) {
        findPath(start);
        return Collections.unmodifiableList(paths);
    }

    public static void main(String[] args) {
        CoverageFinder cf = new CoverageFinder(new Horse());
        List<String> list = cf.getPaths(new Position('a', 1));
        for (String path : list) {
            System.out.println("path, " + (path.length() / 3) + " : " + path);
        }
    }
}
