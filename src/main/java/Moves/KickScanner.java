package Moves;

import Checkers.GameState;
import Pieces.PieceColour;
import Pieces.PiecePosition;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KickScanner {

    private GameState gameState;

    private Set<PiecePosition> allPossibleKicks = new HashSet<>();
    private Set<PiecePosition> allPiecesWhithPossibleKicks = new HashSet<>();

    public KickScanner(GameState gameState) {
        this.gameState = gameState;
    }

    public void calculateAllPossibleWhiteKicks() {
        allPossibleKicks.clear();
        allPiecesWhithPossibleKicks.clear();

        for (Map.Entry<PiecePosition, PieceColour> whitePiece : gameState.getBoard().entrySet()) {
            if (whitePiece.getValue().getPieceColour().isWhite() && whitePiece.getValue().getPieceType().isNormal()) {
                int column = whitePiece.getKey().getColumn();
                int row = whitePiece.getKey().getRow();

                calculateAllPossibleKicks(whitePiece.getKey(), column, row + 1, row + 2, row - 1, row -2);
            }
        }
    }

    public void calculateAllPossibleBlackKicks() {
        allPossibleKicks.clear();
        allPiecesWhithPossibleKicks.clear();

        for (Map.Entry<PiecePosition, PieceColour> blackPiece : gameState.getBoard().entrySet()) {
            if(blackPiece.getValue().getPieceColour().isBlack() && blackPiece.getValue().getPieceType().isNormal()){
                PiecePosition key = blackPiece.getKey();
                int col = key.getColumn();
                int row = key.getRow();

                calculateAllPossibleKicks(key, col, row + 1, row + 2, row - 1, row - 2);
            }
        }

    }

    private void calculateAllPossibleKicks(PiecePosition key, int col, int nextRow, int secondNextRow, int backRow, int secondBackRow) {
        calculatePossibleKicks(key, nextRow, secondNextRow, col - 1, col - 2, col + 1, col + 2);
        calculatePossibleKicks(key, backRow, secondBackRow, col - 1, col - 2, col + 1, col + 2);
    }

    private void calculatePossibleKicks(PiecePosition key, int nextRow, int secondNextRow, int leftCol, int secondLeftCol, int rightCol, int secondRightCol) {
        calculatePossibleKick(key, nextRow, secondNextRow, leftCol, secondLeftCol);
        calculatePossibleKick(key, nextRow, secondNextRow, rightCol, secondRightCol);
    }

    private void calculatePossibleKick(PiecePosition key, int nextRow, int secondNextRow, int rightCol, int secondRightCol) {
        if (new PiecePosition(rightCol, nextRow).isValidPosition()
                && !gameState.isFieldEmpty(new PiecePosition(rightCol, nextRow))
                && gameState.isFieldEmpty(new PiecePosition(secondRightCol, secondNextRow))
                && new PiecePosition(secondRightCol, secondNextRow).isValidPosition()
                && gameState.getPiece(new PiecePosition(rightCol, nextRow)).getPieceColour() != gameState.getPiece(key).getPieceColour()) {

            allPossibleKicks.add(new PiecePosition(rightCol, nextRow));
            allPiecesWhithPossibleKicks.add(key);
        }
    }

    public void clearKickScanner() {
        allPossibleKicks.clear();
        allPiecesWhithPossibleKicks.clear();
    }

    public Set<PiecePosition> getAllPossibleKicks() {
        return allPossibleKicks;
    }

    public Set<PiecePosition> getAllPiecesWhithPossibleKicks() {
        return allPiecesWhithPossibleKicks;
    }

}
