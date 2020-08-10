package Pieces;

import java.util.Objects;

public class PiecePosition {

    private int row;
    private int column;

    public PiecePosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PiecePosition)) return false;
        PiecePosition that = (PiecePosition) o;
        return getRow() == that.getRow() &&
                getColumn() == that.getColumn();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getColumn());
    }

    public boolean isValidPosition() {
        return column >= 0 && column <= 7 && row >= 0 && row <= 7;
    }
}
