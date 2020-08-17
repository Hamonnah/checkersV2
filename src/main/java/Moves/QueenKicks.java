package Moves;

import Checkers.GameState;
import Pieces.PiecePosition;

import java.util.HashSet;
import java.util.Set;

public class QueenKicks {

    private GameState gameState;

    private Set<PiecePosition> possibleKickMoves = new HashSet<>();
    private Set<PiecePosition> possibleKicks = new HashSet<>();

    public QueenKicks(GameState gameState) {
        this.gameState = gameState;
    }

    public void calculateAllPossibleQueenKicks(PiecePosition position) {
        possibleKickMoves.clear();
        possibleKicks.clear();

        for(int i = 1; i < 8; i++) {

            PiecePosition upLeft = new PiecePosition(position.getColumn() - i, position.getRow() - i);

            if(calculatePossibleKick(position, upLeft, -1, -1)) {
                break;
            }
        }

        for(int i = 1; i < 8; i++) {

            PiecePosition downLeft = new PiecePosition(position.getColumn() - i, position.getRow() + i);

            if(calculatePossibleKick(position, downLeft, -1, +1)) {
                break;
            }
        }

        for(int i = 1; i < 8; i++) {

            PiecePosition upRight = new PiecePosition(position.getColumn() + i, position.getRow() - i);

            if(calculatePossibleKick(position, upRight, +1, -1)) {
                break;
            }
        }

        for(int i = 1; i < 8; i++) {

            PiecePosition downRight = new PiecePosition(position.getColumn() + i, position.getRow() + i);

            if(calculatePossibleKick(position, downRight, +1, +1)) {
                break;

            }
        }
    }

    private boolean calculatePossibleKick(PiecePosition actualPosition, PiecePosition checkPosition, int col, int row) {
        if(!checkPosition.isValidPosition()
                || !new PiecePosition(checkPosition.getColumn() + col, checkPosition.getRow() + row).isValidPosition()) {
            return true;
        }

        if(!gameState.isFieldEmpty(checkPosition)) {
            if(gameState.getPiece(actualPosition).getPieceColour() != gameState.getPiece(checkPosition).getPieceColour()
                    && gameState.isFieldEmpty(new PiecePosition(checkPosition.getColumn() + col, checkPosition.getRow() + row))) {
                possibleKickMoves.add(new PiecePosition(checkPosition.getColumn() + col, checkPosition.getRow() + row));
                possibleKicks.add(checkPosition);
            }
            return true;
        } else {
            return false;
        }
    }

    public Set<PiecePosition> getPossibleKickMoves() {
        return possibleKickMoves;
    }

    public Set<PiecePosition> getPossibleKicks() {
        return possibleKicks;
    }

    public void clear() {
        possibleKickMoves.clear();
        possibleKicks.clear();
    }
}
