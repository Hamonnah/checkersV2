package Controllers;

import Checkers.GameState;
import Pieces.PiecePosition;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EndGame {

    private GameState gameState;
    private Set<PiecePosition> numberOfWhitesLeftOnBoard = new HashSet<>();
    private Set<PiecePosition> numberOfBlacksLeftOnBoard = new HashSet<>();

    public EndGame(GameState gameState) {
        this.gameState = gameState;
    }

    public boolean checkEndGame(Set<PiecePosition> positions) {
        calculatePieces(positions);

        if(numberOfWhitesLeftOnBoard.size() == 0) {
            gameState.getRanking().setBlackWins();
            new EndGameInfo(gameState).blacksWin();
            return true;
        }

        if(numberOfBlacksLeftOnBoard.size() == 0) {
            gameState.getRanking().setWhiteWins();
            new EndGameInfo(gameState).whitesWin();
            return true;
        }

        if(numberOfWhitesLeftOnBoard.size() == 1 && numberOfBlacksLeftOnBoard.size() == 1) {
            gameState.getRanking().setDraws();
            new EndGameInfo(gameState).draw();
            return true;
        }
        return false;
    }

    public void calculatePieces(Set<PiecePosition> positions) {
        numberOfWhitesLeftOnBoard.clear();
        numberOfBlacksLeftOnBoard.clear();

        Set<PiecePosition> whites = positions.stream()
                .filter(position -> gameState.getPiece(position).getPieceColour().isWhite())
                .collect(Collectors.toSet());

        Set<PiecePosition> blacks = positions.stream()
                .filter(position -> gameState.getPiece(position).getPieceColour().isBlack())
                .collect(Collectors.toSet());

        numberOfWhitesLeftOnBoard.addAll(whites);
        numberOfBlacksLeftOnBoard.addAll(blacks);
    }

    public Set<PiecePosition> getNumberOfBlacksLeftOnBoard() {
        return numberOfBlacksLeftOnBoard;
    }

    public Set<PiecePosition> getNumberOfWhitesLeftOnBoard() {
        return numberOfWhitesLeftOnBoard;
    }
}


