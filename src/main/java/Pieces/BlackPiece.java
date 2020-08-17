package Pieces;

import java.util.HashMap;
import java.util.Map;

public class BlackPiece implements PiecesInterface {

    private final Map<PiecePosition, PieceColour> blackPiecesMap = new HashMap<>();

    @Override
    public Map<PiecePosition, PieceColour> setUpPieces() {
        blackPiecesMap.put(new PiecePosition(0,1),(new PieceColour(PieceColour.Colour.BLACK, PieceColour.Type.NORMAL)));
        blackPiecesMap.put(new PiecePosition(0,3),(new PieceColour(PieceColour.Colour.BLACK, PieceColour.Type.NORMAL)));
        blackPiecesMap.put(new PiecePosition(0,5),(new PieceColour(PieceColour.Colour.BLACK, PieceColour.Type.NORMAL)));
        blackPiecesMap.put(new PiecePosition(0,7),(new PieceColour(PieceColour.Colour.BLACK, PieceColour.Type.NORMAL)));
        blackPiecesMap.put(new PiecePosition(1,0),(new PieceColour(PieceColour.Colour.BLACK, PieceColour.Type.NORMAL)));
        blackPiecesMap.put(new PiecePosition(1,2),(new PieceColour(PieceColour.Colour.BLACK, PieceColour.Type.NORMAL)));
        blackPiecesMap.put(new PiecePosition(1,4),(new PieceColour(PieceColour.Colour.BLACK, PieceColour.Type.NORMAL)));
        blackPiecesMap.put(new PiecePosition(1,6),(new PieceColour(PieceColour.Colour.BLACK, PieceColour.Type.NORMAL)));
        blackPiecesMap.put(new PiecePosition(2,1),(new PieceColour(PieceColour.Colour.BLACK, PieceColour.Type.NORMAL)));
        blackPiecesMap.put(new PiecePosition(2,3),(new PieceColour(PieceColour.Colour.BLACK, PieceColour.Type.NORMAL)));
        blackPiecesMap.put(new PiecePosition(2,5),(new PieceColour(PieceColour.Colour.BLACK, PieceColour.Type.NORMAL)));
        blackPiecesMap.put(new PiecePosition(2,7),(new PieceColour(PieceColour.Colour.BLACK, PieceColour.Type.NORMAL)));

        return blackPiecesMap;
    }

}
