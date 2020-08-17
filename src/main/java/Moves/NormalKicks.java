package Moves;

import Checkers.GameState;
import Pieces.PiecePosition;

import java.util.HashSet;
import java.util.Set;

public class NormalKicks {

    private GameState gameState;

    private Set<PiecePosition> possibleKickMoves = new HashSet<>();
    private Set<PiecePosition> possibleKicks = new HashSet<>();

    public NormalKicks(GameState gameState) {
        this.gameState = gameState;
    }

    public void kickMovesCalculator(PiecePosition position) {
        possibleKickMoves.clear();
        possibleKicks.clear();

        if(kickMove(position, 1, 1)) {
            possibleKickMoves.add(new PiecePosition(position.getColumn() + 2, position.getRow() + 2));
            possibleKicks.add(new PiecePosition(position.getColumn() + 1, position.getRow() + 1));
        }

        if(kickMove(position, - 1, - 1)) {
            possibleKickMoves.add(new PiecePosition(position.getColumn() - 2, position.getRow() - 2));
            possibleKicks.add(new PiecePosition(position.getColumn() - 1, position.getRow() - 1));
        }

        if(kickMove(position, 1, - 1)) {
            possibleKickMoves.add(new PiecePosition(position.getColumn() + 2, position.getRow() - 2));
            possibleKicks.add(new PiecePosition(position.getColumn() + 1, position.getRow() - 1));
        }

        if(kickMove(position, - 1, 1)) {
            possibleKickMoves.add(new PiecePosition(position.getColumn() - 2, position.getRow() + 2));
            possibleKicks.add(new PiecePosition(position.getColumn() - 1, position.getRow() + 1));
        }
    }

    private boolean kickMove(PiecePosition actualPosition, int col, int row) {
        return new PiecePosition(actualPosition.getColumn() + col, actualPosition.getRow() + row).isValidPosition() &&
                !gameState.isFieldEmpty(new PiecePosition(actualPosition.getColumn() + col, actualPosition.getRow() + row))
                && new PiecePosition(actualPosition.getColumn() + (col * 2), actualPosition.getRow() + (row * 2)).isValidPosition()
                && gameState.isFieldEmpty(new PiecePosition(actualPosition.getColumn() + (col * 2), actualPosition.getRow() + (row * 2)))
                && (gameState.getPiece(actualPosition).getPieceColour() != gameState.getPiece(
                new PiecePosition(actualPosition.getColumn() + col, actualPosition.getRow() + row)).getPieceColour());
    }

    public Set<PiecePosition> getPossibleKickMoves() {
        return possibleKickMoves;
    }

    public Set<PiecePosition> getPossibleKicks() {
        return possibleKicks;
    }

    public void clearNormalKicks() {
        possibleKickMoves.clear();
        possibleKicks.clear();
    }

}
