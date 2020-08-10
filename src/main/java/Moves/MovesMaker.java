package Moves;

import Checkers.CheckersDrawer;
import Checkers.GameState;
import Pieces.PiecePosition;

import java.util.HashSet;
import java.util.Set;

public class MovesMaker {
    private GameState gameState;

    private Set<PiecePosition> possibleMoves = new HashSet<>();
    private Set<PiecePosition> allPossibleMovesBlack = new HashSet<>();

    public MovesMaker(GameState gameState) {
        this.gameState = gameState;
    }

    public void calculateMoves(PiecePosition position, boolean isPossible) {
        makeMove(position, possibleMoves, isPossible);

    }

    private void makeMove(PiecePosition actualPosition, Set<PiecePosition> possibleMoves, boolean goTo) {
        int direction = goTo ? - 1 : 1;

        PiecePosition left = new PiecePosition(actualPosition.getColumn() -1,  actualPosition.getRow() + direction);
        PiecePosition right = new PiecePosition(actualPosition.getColumn() +1,  actualPosition.getRow() + direction);

        if (left.isValidPosition() && gameState.isFieldEmpty(left)) {
            possibleMoves.add(left);
        }

        if (right.isValidPosition() && gameState.isFieldEmpty(right)) {
            possibleMoves.add(right);
        }

    }
}
