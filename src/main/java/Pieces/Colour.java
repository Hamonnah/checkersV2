package Pieces;

public enum Colour {

    WHITE, BLACK;

    public Colour oponnent() {
        return this == WHITE ? BLACK : WHITE;
    }
}
