package Pieces;

import java.util.HashMap;
import java.util.Map;

public class BlackPiece implements PiecesInterface {

    //private final Image imageBlackPiece = new Image("black-normal.png");
    private final Map<PiecePosition, Piece> blackPiecesMap = new HashMap<>();

    @Override
    public Map<PiecePosition, Piece> setUpPieces() {
        blackPiecesMap.put(new PiecePosition(0,0),(new Piece()));
        blackPiecesMap.put(new PiecePosition(0,2),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(0,4),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(0,6),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(1,1),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(1,3),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(1,5),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(1,7),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(2,0),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(2,2),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(2,4),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(2,6),(blackPiecesMap.get(0)));

        return blackPiecesMap;
    }

}
