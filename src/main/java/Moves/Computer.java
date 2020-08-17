package Moves;

import Checkers.GameState;
import Pieces.PiecePosition;

import java.util.Random;
import java.util.Set;

public class Computer {

    private Random random = new Random();
    private GameState gameState;


    public Computer(GameState gameState) {
        this.gameState = gameState;
    }

    public PiecePosition selectPosition(Set<PiecePosition> positions) {
        Object[] object = positions.toArray();
        return (PiecePosition) object[random.nextInt(object.length)];
    }

    public boolean checkBlacksEnd(Set<PiecePosition> restOfBlacks) {
        return restOfBlacks.size() == 0;
    }

}
