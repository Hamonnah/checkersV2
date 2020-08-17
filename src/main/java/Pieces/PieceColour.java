package Pieces;

public class PieceColour {

    private Colour pieceColour;
    private Type pieceType;

    public PieceColour(Colour pieceColour, Type pieceType) {
        this.pieceColour = pieceColour;
        this.pieceType = pieceType;
    }

    public Colour getPieceColour() {
        return pieceColour;
    }

    public Type getPieceType() {
        return pieceType;
    }


    public enum Colour {
        BLACK, WHITE;

        public boolean isWhite() {
            return this == WHITE;
        }

        public boolean isBlack() {
            return this == BLACK;
        }
    }

    public enum Type {
        NORMAL, QUEEN;

        public boolean isNormal() {
            return this == NORMAL;
        }

        public boolean isQueen() {
            return this == QUEEN;
        }
    }


}
