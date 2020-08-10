package Pieces;

import Checkers.GameState;
import Moves.MovesMaker;

public abstract class Pieces {

    private final PieceColour colour;
    protected String whitetSymbol;
    protected String blackSymbol;
    protected int value;

    public Pieces(PieceColour colour, String lightSymbol, String blackSymbol, int value) {
        this.colour = colour;
        this.whitetSymbol = lightSymbol;
        this.blackSymbol = blackSymbol;
        this.value = value;
    }

    public abstract boolean isMoveLegal(GameState gameState, MovesMaker movesMaker);
    public abstract void makeMove(GameState gameState, MovesMaker movesMaker);



    public PieceColour getColour() {
        return colour;
    }

    public String getWhiteSymbol() {
        return whitetSymbol;
    }

    public String getBlackSymbol() {
        return blackSymbol;
    }

    public int getValue() {
        return value;
    }
}
