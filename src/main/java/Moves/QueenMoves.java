package Moves;

import Checkers.GameState;
import Pieces.PiecePosition;

import java.util.HashSet;
import java.util.Set;

public class QueenMoves {

    private GameState gameState;

    private Set<PiecePosition> possibleQueenMoves = new HashSet<>();

    public QueenMoves(GameState gameState) {
        this.gameState = gameState;
    }

    public void normalQueenMoveCalculator(PiecePosition position) {

        possibleQueenMoves.clear();

        for (int n = 1; n < 8; n++) {
            PiecePosition upLeft = new PiecePosition(position.getRow() - n, position.getColumn() - n);

            if (queenNormalMove(upLeft)) {
                possibleQueenMoves.add(upLeft);
            } else {
                break;
            }
        }

        for (int n = 1; n < 8; n++) {
            PiecePosition downLeft = new PiecePosition(position.getRow() - n, position.getColumn() - n);

            if (queenNormalMove(downLeft)) {
                possibleQueenMoves.add(downLeft);
            } else {
                break;
            }
        }

        for (int n = 1; n < 8; n++) {
            PiecePosition upRight = new PiecePosition(position.getRow() - n, position.getColumn() + n);

            if (queenNormalMove(upRight)) {
                possibleQueenMoves.add(upRight);
            } else {
                break;
            }
        }

        for (int n = 1; n < 8; n++) {
            PiecePosition downRight = new PiecePosition(position.getRow() + n, position.getColumn() + n);

            if (queenNormalMove(downRight)) {
                possibleQueenMoves.add(downRight);
            } else {
                break;
            }
        }
    }

    private boolean queenNormalMove(PiecePosition position) {
        return position.isValidPosition() && gameState.isFieldEmpty(position);
    }

    public Set<PiecePosition> getPossibleQueenMoves() {
        return possibleQueenMoves;
    }

}
