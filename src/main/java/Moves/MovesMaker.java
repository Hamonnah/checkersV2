package Moves;

import Checkers.GameState;
import Pieces.PieceColour;
import Pieces.PiecePosition;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MovesMaker {
    private GameState gameState;

    private Set<PiecePosition> possibleMoves = new HashSet<>();
    private Set<PiecePosition> allPossibleMovesBlack = new HashSet<>();

    public MovesMaker(GameState gameState) {
        this.gameState = gameState;
    }

    public void normalMoveCalculator(PiecePosition position, boolean up) {
        normalMove(position, possibleMoves, up);
    }

    private void normalMove(PiecePosition actualPosition, Set<PiecePosition> possibleMoves, boolean up) {
        int direction = up ? - 1 : 1;

        PiecePosition left = new PiecePosition(actualPosition.getColumn() - 1, actualPosition.getRow() + direction);
        PiecePosition right = new PiecePosition(actualPosition.getColumn() + 1, actualPosition.getRow() + direction);

        if (left.isValidPosition() && gameState.isFieldEmpty(left)) {
            possibleMoves.add(left);
        }

        if (right.isValidPosition() && gameState.isFieldEmpty(right)) {
            possibleMoves.add(right);
        }
    }

    public void allPossibleBlackMoves() {
        allPossibleMovesBlack.clear();

        for(Map.Entry<PiecePosition, PieceColour> blacks : gameState.getBoard().entrySet()) {
            if(blacks.getValue().getPieceColour().isWhite()) {
                continue;
            }

            possibleMoves.clear();

            if(blacks.getValue().getPieceType().isNormal()) {
                normalMoveCalculator(blacks.getKey(), false);
                for(PiecePosition position : possibleMoves){
                    if(position != null && position.isValidPosition()) {
                        allPossibleMovesBlack.add(blacks.getKey());
                    }
                }
            } else {
                normalMoveCalculator(blacks.getKey(), true);
                normalMoveCalculator(blacks.getKey(), false);
                for(PiecePosition position : possibleMoves){
                    if(position != null && position.isValidPosition()) {
                        allPossibleMovesBlack.add(blacks.getKey());
                    }
                }
            }
        }
    }

    public void movesDifficultyNormal() {
        allPossibleMovesBlack.clear();

        for(Map.Entry<PiecePosition, PieceColour> blacks : gameState.getBoard().entrySet()) {
            if(blacks.getValue().getPieceColour().isWhite()) {
                continue;
            }

            possibleMoves.clear();

            if(blacks.getValue().getPieceType().isNormal()) {
                normalMoveCalculator(blacks.getKey(), false);
                for(PiecePosition position : possibleMoves){
                    if(position != null && position.isValidPosition() && blacks.getKey().getRow() == 6) {
                        allPossibleMovesBlack.add(blacks.getKey());
                    }
                }
            } else {
                normalMoveCalculator(blacks.getKey(), true);
                normalMoveCalculator(blacks.getKey(), false);
                for(PiecePosition position : possibleMoves){
                    if(position != null && position.isValidPosition()) {
                        allPossibleMovesBlack.add(blacks.getKey());
                    }
                }
            }
        }
    }

    public Set<PiecePosition> getPossibleMoves() {
        return possibleMoves;
    }

    public Set<PiecePosition> getAllPossibleBlack() {
        return allPossibleMovesBlack;
    }

    public void clearMovesMaker() {
        possibleMoves.clear();
        allPossibleMovesBlack.clear();
    }
}
