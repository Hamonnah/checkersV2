package Checkers;

import Controllers.EndGame;
import Controllers.Ranking;
import Moves.MovesMaker;
import Pieces.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameState {

    private Map<PiecePosition, PieceColour> board = new HashMap<>();
    private Set<PiecePosition> possiblePromote = new HashSet<>();

    private BlackPiece blackPieces = new BlackPiece();
    private WhitePiece whitePieces = new WhitePiece();

    private MovesMaker movesMaker = new MovesMaker(this);

    //private QueenMoves queenMoves = new QueenMoves(this);
    //private NormalKicks normalKicks = new NormalKicks(this);
    //private QueenKicks queenKicks = new QueenKicks(this);

    //private KickScanner kickScanner;
    //private QueenKickScanner queenKickScanner;
    //private Computer computer;

    private Ranking ranking = new Ranking();
    private EndGame endGame = new EndGame(this);

    private boolean isTurn = true;
    private boolean isKick = false;

    private PiecePosition pickedPosition;

    public GameState() {
        putAllPieces();

        //this.kickScanner = new KickScanner(this);
        //this.queenKickScanner = new QueenKickScanner(this);
        //this.computer = new Computer(this);
    }

    public void putAllPieces() {
        board.putAll(whitePieces.setUpPieces());
        board.putAll(blackPieces.setUpPieces());
    }

    public void addPieceToBoard(PiecePosition position, PieceColour pieceColour) {
        board.put(position, pieceColour);
    }

    public void removePieceFromBoard(PiecePosition position) {
        board.remove(position);
    }

    public PieceColour getPiece(PiecePosition position) {
        return board.get(position);
    }

    public boolean isFieldEmpty(PiecePosition position) {
        return board.get(position) == null;
    }

    private void choseNewPosition(PiecePosition position, PiecePosition actualPosition, boolean light) {
        PieceColour pieceOnNewPosition = getPiece(position);
        PieceColour pieceOnActualPosition = getPiece(actualPosition);

        if (actualPosition != null) {
            CheckersDrawer.removePiece(actualPosition);
            CheckersDrawer.addPiece(actualPosition, pieceOnActualPosition, !light);
        }
    }

    public void movePieceOnBoard(PiecePosition newPosition, PiecePosition oldPosition, PieceColour pieceColour) {
        removePieceFromBoard(oldPosition);
        addPieceToBoard(newPosition, pieceColour);
    }

    public Map<PiecePosition, PieceColour> getBoard() {
        return board;
    }

    public void handleMove(PiecePosition position) {
    }

    public Ranking getRanking() {
        return ranking;
    }



}
