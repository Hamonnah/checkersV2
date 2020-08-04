package Pieces;

import java.util.HashMap;
import java.util.Map;

public class WhitePiece implements PiecesInterface {

    private final Map<PiecePosition, Piece> whitePiecesMap = new HashMap<>();

    @Override
    public Map<PiecePosition, Piece> setUpPieces() {
        whitePiecesMap.put(new PiecePosition(5, 1), (new Piece()));
        whitePiecesMap.put(new PiecePosition(5, 3), (new Piece()));
        whitePiecesMap.put(new PiecePosition(5, 5), (new Piece()));
        whitePiecesMap.put(new PiecePosition(5, 7), (new Piece()));
        whitePiecesMap.put(new PiecePosition(6, 0), (new Piece()));
        whitePiecesMap.put(new PiecePosition(6, 2), (new Piece()));
        whitePiecesMap.put(new PiecePosition(6, 4), (new Piece()));
        whitePiecesMap.put(new PiecePosition(6, 6), (new Piece()));
        whitePiecesMap.put(new PiecePosition(7, 1), (new Piece()));
        whitePiecesMap.put(new PiecePosition(7, 3), (new Piece()));
        whitePiecesMap.put(new PiecePosition(7, 5), (new Piece()));
        whitePiecesMap.put(new PiecePosition(7, 7), (new Piece()));

        return whitePiecesMap;
    }

}
