package Pieces;

import java.util.HashMap;
import java.util.Map;

public class BlackPiece implements PiecesInterface {

    //private final Image imageBlackPiece = new Image("black-normal.png");
    private final Map<PiecePosition, PieceColour> blackPiecesMap = new HashMap<>();

    @Override
    public Map<PiecePosition, PieceColour> setUpPieces() {
        blackPiecesMap.put(new PiecePosition(0,1),(new PieceColour(PieceColour.Colour.BLACK, PieceColour.Type.NORMAL)));
        blackPiecesMap.put(new PiecePosition(0,3),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(0,5),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(0,7),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(1,0),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(1,2),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(1,4),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(1,6),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(2,1),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(2,3),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(2,5),(blackPiecesMap.get(0)));
        blackPiecesMap.put(new PiecePosition(2,7),(blackPiecesMap.get(0)));

        return blackPiecesMap;
    }

}
