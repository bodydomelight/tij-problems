package test.chessboardcoverage;

import java.util.List;

public interface PieceStrategy {

    List<Position> getPositions(Position p);
    Chessboard getBoard();
}
