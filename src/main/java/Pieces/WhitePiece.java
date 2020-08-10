package Pieces;

import java.util.HashMap;
import java.util.Map;

public class WhitePiece implements PiecesInterface {

    private final Map<PiecePosition, PieceColour> whitePiecesMap = new HashMap<>();

    @Override
    public Map<PiecePosition, PieceColour> setUpPieces() {
        whitePiecesMap.put(new PiecePosition(5, 0), new PieceColour(PieceColour.Colour.WHITE, PieceColour.Type.NORMAL));
        whitePiecesMap.put(new PiecePosition(5, 2), new PieceColour(PieceColour.Colour.WHITE, PieceColour.Type.NORMAL));
        whitePiecesMap.put(new PiecePosition(5, 4), new PieceColour(PieceColour.Colour.WHITE, PieceColour.Type.NORMAL));
        whitePiecesMap.put(new PiecePosition(5, 6), new PieceColour(PieceColour.Colour.WHITE, PieceColour.Type.NORMAL));
        whitePiecesMap.put(new PiecePosition(6, 1), new PieceColour(PieceColour.Colour.WHITE, PieceColour.Type.NORMAL));
        whitePiecesMap.put(new PiecePosition(6, 3), new PieceColour(PieceColour.Colour.WHITE, PieceColour.Type.NORMAL));
        whitePiecesMap.put(new PiecePosition(6, 5), new PieceColour(PieceColour.Colour.WHITE, PieceColour.Type.NORMAL));
        whitePiecesMap.put(new PiecePosition(6, 7), new PieceColour(PieceColour.Colour.WHITE, PieceColour.Type.NORMAL));
        whitePiecesMap.put(new PiecePosition(7, 0), new PieceColour(PieceColour.Colour.WHITE, PieceColour.Type.NORMAL));
        whitePiecesMap.put(new PiecePosition(7, 2), new PieceColour(PieceColour.Colour.WHITE, PieceColour.Type.NORMAL));
        whitePiecesMap.put(new PiecePosition(7, 4), new PieceColour(PieceColour.Colour.WHITE, PieceColour.Type.NORMAL));
        whitePiecesMap.put(new PiecePosition(7, 6), new PieceColour(PieceColour.Colour.WHITE, PieceColour.Type.NORMAL));

        return whitePiecesMap;
    }

}
