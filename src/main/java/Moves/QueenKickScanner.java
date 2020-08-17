package Moves;

import Checkers.GameState;
import Pieces.PieceColour;
import Pieces.PiecePosition;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class QueenKickScanner {

    private GameState gameState;

    private Set<PiecePosition> allPossibleQueenKicks = new HashSet<>();
    private Set<PiecePosition> allQueenPiecesWhichKick = new HashSet<>();

    public QueenKickScanner(GameState gameState) {
        this.gameState = gameState;
    }

    public void calculateAllPossibleWhiteQueenKicks() {
        allPossibleQueenKicks.clear();
        allQueenPiecesWhichKick.clear();

        for (Map.Entry<PiecePosition, PieceColour> whitePiece : gameState.getBoard().entrySet()) {
            if(whitePiece.getValue().getPieceColour().isWhite() && whitePiece.getValue().getPieceType().isQueen()) {

                calculateAllPossibleQueenKicks(whitePiece.getKey());
            }
        }
    }

    public void calculateAllPossibleBlackQueenKicks() {
        allPossibleQueenKicks.clear();
        allQueenPiecesWhichKick.clear();

        for (Map.Entry<PiecePosition, PieceColour> blackPiece : gameState.getBoard().entrySet()) {
            if(blackPiece.getValue().getPieceColour().isBlack() && blackPiece.getValue().getPieceType().isQueen()) {

                calculateAllPossibleQueenKicks(blackPiece.getKey());
            }
        }
    }

    private void calculateAllPossibleQueenKicks(PiecePosition position) {
        for(int i = 1; i < 8; i++) {
            PiecePosition upLeft = new PiecePosition(position.getColumn() - i, position.getRow() - i);

            if(calculatePossibleKick(position, upLeft, - 1, - 1)) {
                break;
            }
        }

        for(int i = 1; i < 8; i++) {
            PiecePosition downLeft = new PiecePosition(position.getColumn() - i, position.getRow() + i);

            if(calculatePossibleKick(position, downLeft, - 1, + 1)) {
                break;
            }
        }

        for(int i = 1; i < 8; i++) {
            PiecePosition upRight = new PiecePosition(position.getColumn() + i, position.getRow() - i);

            if(calculatePossibleKick(position, upRight, + 1, - 1)) {
                break;
            }
        }

        for(int i = 1; i < 8; i++) {
            PiecePosition downRight = new PiecePosition(position.getColumn() + i, position.getRow() + i);

            if(calculatePossibleKick(position, downRight, + 1, + 1)) {
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
                allPossibleQueenKicks.add(checkPosition);
                allQueenPiecesWhichKick.add(actualPosition);
            }
            return true;
        } else {
            return false;
        }
    }

    public Set<PiecePosition> getAllPossibleQueenKicks() {
        return allPossibleQueenKicks;
    }

    public Set<PiecePosition> getAllQueenPiecesWhichKick() {
        return allQueenPiecesWhichKick;
    }

    public void clearQueenKicks() {
        allPossibleQueenKicks.clear();
        allQueenPiecesWhichKick.clear();
    }

}
