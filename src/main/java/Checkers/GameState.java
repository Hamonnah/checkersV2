package Checkers;

import Pieces.BlackPiece;
import Pieces.Piece;
import Pieces.PiecePosition;
import Pieces.WhitePiece;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameState {

    private Map<PiecePosition, Piece> gameState = new HashMap<>();

    private BlackPiece blackPieces = new BlackPiece();
    private WhitePiece whitePieces = new WhitePiece();

    public GameState() {
        putAllPieces();
    }

    public void putAllPieces() {
        gameState.putAll(whitePieces.setUpPieces());
        gameState.putAll(blackPieces.setUpPieces());
    }

    public Map<PiecePosition, Piece> getGameState() {
        return gameState;
    }

}
