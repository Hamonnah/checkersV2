package Checkers;

import Controllers.EndGame;
import Controllers.Ranking;
import Moves.*;
import Pieces.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GameState {
    
    private CheckersDrawer checkersDrawer;

    private Map<PiecePosition, PieceColour> board = new HashMap<>();
    private Set<PiecePosition> possiblePromote = new HashSet<>();

    private BlackPiece blackPieces = new BlackPiece();
    private WhitePiece whitePieces = new WhitePiece();

    private MovesMaker movesMaker = new MovesMaker(this);

    private QueenMoves queenMoves = new QueenMoves(this);
    private NormalKicks normalKicks = new NormalKicks(this);
    private QueenKicks queenKicks = new QueenKicks(this);

    private KickScanner kickScanner;
    private QueenKickScanner queenKickScanner;
    private Computer computer;

    private Ranking ranking = new Ranking();
    private EndGame endGame = new EndGame(this);

    private boolean isTurn = true;
    private boolean isKick = false;

    private PiecePosition pickedPosition;

    public void setCheckersDrawer(CheckersDrawer checkersDrawer) {
        this.checkersDrawer = checkersDrawer;
    }

    public GameState() {
        putAllPieces();

        this.kickScanner = new KickScanner(this);
        this.queenKickScanner = new QueenKickScanner(this);
        this.computer = new Computer(this);
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

    private void chooseNewPosition(PiecePosition position, PiecePosition actualPosition, boolean light) {
        PieceColour pieceOnNewPosition = getPiece(position);
        PieceColour pieceOnActualPosition = getPiece(actualPosition);

        if (actualPosition != null) {
            checkersDrawer.removePiece(actualPosition);
            checkersDrawer.addPiece(actualPosition, pieceOnActualPosition, !light);
        }

        checkersDrawer.removePiece(actualPosition);
        checkersDrawer.addPiece(actualPosition, pieceOnActualPosition, !light);
    }

    public void movePiece(PiecePosition newPosition, PiecePosition actualPosition) {
        PieceColour pieceColour = getPiece(actualPosition);
        checkersDrawer.addPiece(newPosition, pieceColour, false);
        checkersDrawer.removePiece(actualPosition);

        movePieceOnBoard(newPosition, actualPosition, pieceColour);
    }

    public void movePieceOnBoard(PiecePosition newPosition, PiecePosition actualPosition, PieceColour pieceColour) {
        removePieceFromBoard(actualPosition);
        addPieceToBoard(newPosition, pieceColour);
    }

    private void kickPiece(PiecePosition newPosition, PiecePosition actualPosition) {
        PieceColour pieceColour = getPiece(actualPosition);

        PiecePosition kickPosition = findPosition(newPosition, normalKicks.getPossibleKicks(), queenKicks.getPossibleKicks());

        checkersDrawer.addPiece(newPosition, pieceColour, false);
        checkersDrawer.removePiece(actualPosition);
        checkersDrawer.removePiece(kickPosition);

        kickPieceFromBoard(newPosition, actualPosition, kickPosition, pieceColour);

        normalKicks.kickMovesCalculator(newPosition);
        queenKicks.calculateAllPossibleQueenKicks(newPosition);

        if (!normalKicks.getPossibleKickMoves().isEmpty() && pieceColour.getPieceType().isNormal()) {
            normalKicks.getPossibleKickMoves().forEach(this::addLightMove);

            checkersDrawer.removePiece(actualPosition);
            checkersDrawer.addPiece(newPosition, pieceColour, true);
        }

        if (!queenKicks.getPossibleKickMoves().isEmpty() && pieceColour.getPieceType().isQueen()) {
            queenKicks.getPossibleKickMoves().forEach(this::addLightMove);

            checkersDrawer.removePiece(actualPosition);
            checkersDrawer.addPiece(newPosition, pieceColour, true);
        }
    }

    public void kickPieceFromBoard(PiecePosition newPosition, PiecePosition oldPosition, PiecePosition kickPositon, PieceColour pieceColour) {
        addPieceToBoard(newPosition, pieceColour);
        removePieceFromBoard(oldPosition);
        removePieceFromBoard(kickPositon);
    }

    private void addLightMove(PiecePosition position) {
        checkersDrawer.setLight(position);
    }

    private void unLight(PiecePosition position) {
        checkersDrawer.removePiece(position);
    }


    public PiecePosition findPosition(PiecePosition position, Set<PiecePosition> normalPosition, Set<PiecePosition> queenPosition) {
        PiecePosition upLeft = new PiecePosition(position.getColumn() - 1, position.getRow() - 1);

        if (normalPosition.contains(upLeft) || queenPosition.contains(upLeft)) {
            return upLeft;
        }

        PiecePosition downLeft = new PiecePosition(position.getColumn() - 1, position.getRow() + 1);

        if (normalPosition.contains(downLeft) || queenPosition.contains(downLeft)) {
            return downLeft;
        }

        PiecePosition upRight = new PiecePosition(position.getColumn() + 1, position.getRow() - 1);

        if (normalPosition.contains(upRight) || queenPosition.contains(upRight)) {
            return upRight;
        }

        PiecePosition downRight = new PiecePosition(position.getColumn() + 1, position.getRow() + 1);

        if (normalPosition.contains(downRight) || queenPosition.contains(downRight)) {
            return downRight;
        }

        return null;
    }

    private void promote() {
        possiblePromote.clear();
        calculatePromote(board.keySet());

        for (PiecePosition position : possiblePromote) {
            PieceColour pieceColour = getPiece(position);

            if (pieceColour.getPieceColour().isWhite() && pieceColour.getPieceType().isNormal()) {
                checkersDrawer.removePiece(position);
                checkersDrawer.addPiece(position, new PieceColour(pieceColour.getPieceColour(), PieceColour.Type.QUEEN), false);

                promoteOnBoard(position, pieceColour);
            }

            if (pieceColour.getPieceColour().isBlack() && pieceColour.getPieceType().isNormal()) {
                checkersDrawer.removePiece(position);
                checkersDrawer.addPiece(position, new PieceColour(pieceColour.getPieceColour(), PieceColour.Type.QUEEN), false);

                promoteOnBoard(position, pieceColour);
            }
        }
    }

    public void promoteOnBoard(PiecePosition position, PieceColour pieceColour) {
        removePieceFromBoard(position);
        addPieceToBoard(position, new PieceColour(pieceColour.getPieceColour(), PieceColour.Type.QUEEN));
    }

    public void calculatePromote(Set<PiecePosition> positions) {

        Set<PiecePosition> whites = positions.stream()
                .filter(position -> position.getRow() == 0)
                .filter(position -> getPiece(position).getPieceColour() == PieceColour.Colour.WHITE)
                .collect(Collectors.toSet());

        Set<PiecePosition> blacks = positions.stream()
                .filter(position -> position.getRow() == 7)
                .filter(position -> getPiece(position).getPieceColour() == PieceColour.Colour.BLACK)
                .collect(Collectors.toSet());

        possiblePromote.addAll(whites);
        possiblePromote.addAll(blacks);
    }

    public void handleMove(PiecePosition position) {

        if (isTurn) {

            kickScanner.calculateAllPossibleWhiteKicks();
            queenKickScanner.calculateAllPossibleWhiteQueenKicks();

            if (!kickScanner.getAllPossibleKicks().isEmpty() || !queenKickScanner.getAllPossibleQueenKicks().isEmpty()) {

                if ((kickScanner.getAllPiecesWhithPossibleKicks().contains(position)
                        || queenKickScanner.getAllQueenPiecesWhichKick().contains(position))
                        && getPiece(position).getPieceColour().isWhite()
                        && !isKick) {

                    chooseNewPosition(position, pickedPosition, true);
                    pickedPosition = position;

                    normalKicks.getPossibleKickMoves().forEach(this::unLight);
                    queenKicks.getPossibleKickMoves().forEach(this::unLight);

                    if (getPiece(position).getPieceType().isNormal()) {

                        queenKicks.clear();

                        normalKicks.kickMovesCalculator(position);
                        normalKicks.getPossibleKickMoves().forEach(this::addLightMove);

                    } else {

                        normalKicks.clearNormalKicks();

                        queenKicks.calculateAllPossibleQueenKicks(position);
                        queenKicks.getPossibleKickMoves().forEach(this::addLightMove);

                    }

                } else {

                    if (normalKicks.getPossibleKickMoves().contains(position)
                            && getPiece(pickedPosition).getPieceType().isNormal()) {

                        normalKicks.getPossibleKickMoves().forEach(this::unLight);

                        kickPiece(position, pickedPosition);
                        pickedPosition = position;

                        if (normalKicks.getPossibleKickMoves().isEmpty()) {

                            isTurn = false;

                            isKick = false;

                            endKick();

                        } else {

                            isKick = true;

                        }

                    } else if (queenKicks.getPossibleKickMoves().contains(position)
                            && getPiece(pickedPosition).getPieceType().isQueen()) {

                        queenKicks.getPossibleKickMoves().forEach(this::unLight);

                        kickPiece(position, pickedPosition);
                        pickedPosition = position;

                        if (queenKicks.getPossibleKickMoves().isEmpty()) {

                            isTurn = false;

                            isKick = false;

                            endKick();

                        } else {

                            isKick = true;

                        }
                    }
                }

            } else {

                if (!isFieldEmpty(position)
                        && getPiece(position).getPieceColour() == PieceColour.Colour.WHITE) {

                    chooseNewPosition(position, pickedPosition, true);
                    pickedPosition = position;

                    movesMaker.getPossibleMoves().forEach(this::unLight);
                    queenMoves.getPossibleQueenMoves().forEach(this::unLight);

                    movesMaker.clearMovesMaker();

                    if (getPiece(position).getPieceType().isNormal()) {

                        movesMaker.normalMoveCalculator(position, true);
                        movesMaker.getPossibleMoves().forEach(this::addLightMove);

                    } else {

                        queenMoves.normalQueenMoveCalculator(position);
                        queenMoves.getPossibleQueenMoves().forEach(this::addLightMove);

                    }

                } else if (movesMaker.getPossibleMoves().contains(position)
                        && pickedPosition != null) {

                    movesMaker.getPossibleMoves().forEach(this::unLight);

                    movePiece(position, pickedPosition);

                    isTurn = false;

                    endTurn();

                } else if (queenMoves.getPossibleQueenMoves().contains(position)
                        && pickedPosition != null) {

                    queenMoves.getPossibleQueenMoves().forEach(this::unLight);

                    movePiece(position, pickedPosition);

                    isTurn = false;

                    endTurn();
                }
            }
        }

        if (!isTurn) {

            computerMove();

        }
    }

    private void computerMove() {

        do {

            if (computer.checkBlacksEnd(endGame.getNumberOfBlacksLeftOnBoard())) {
                break;
            }

            kickScanner.calculateAllPossibleBlackKicks();
            queenKickScanner.calculateAllPossibleBlackQueenKicks();

            if (!kickScanner.getAllPossibleKicks().isEmpty() || !queenKickScanner.getAllPossibleQueenKicks().isEmpty()) {

                Set<PiecePosition> allBlacks = new HashSet<>();

                allBlacks.addAll(kickScanner.getAllPiecesWhithPossibleKicks());
                allBlacks.addAll(queenKickScanner.getAllQueenPiecesWhichKick());

                PiecePosition computerKick = computer.selectPosition(allBlacks);

                pickedPosition = computerKick;

                chooseNewPosition(computerKick, pickedPosition, true);

                if (getPiece(pickedPosition).getPieceType().isNormal()) {

                    queenKicks.clear();

                    normalKicks.kickMovesCalculator(pickedPosition);

                    if (!normalKicks.getPossibleKickMoves().isEmpty()) {

                        computerKick = computer.selectPosition(normalKicks.getPossibleKickMoves());

                        kickPiece(computerKick, pickedPosition);

                        if (normalKicks.getPossibleKickMoves().isEmpty()) {

                            endKick();

                            setTurn(true);
                        }
                    }

                } else {

                    normalKicks.clearNormalKicks();

                    queenKicks.calculateAllPossibleQueenKicks(pickedPosition);

                    if (!queenKicks.getPossibleKickMoves().isEmpty()) {

                        computerKick = computer.selectPosition(queenKicks.getPossibleKickMoves());

                        kickPiece(computerKick, pickedPosition);

                        if (queenKicks.getPossibleKickMoves().isEmpty()) {

                            endKick();

                            setTurn(true);
                        }
                    }
                }

            } else {

                if (movesMaker.getAllPossibleBlack().isEmpty()) {

                    movesMaker.allPossibleBlackMoves();
                }

                PiecePosition computerMove = computer.selectPosition(movesMaker.getAllPossibleBlack());

                pickedPosition = computerMove;

                if (getPiece(computerMove).getPieceType().isNormal()) {

                    movesMaker.clearMovesMaker();

                    movesMaker.normalMoveCalculator(computerMove, false);

                    computerMove = computer.selectPosition(movesMaker.getPossibleMoves());

                    movePiece(computerMove, pickedPosition);

                    setTurn(true);

                    endTurn();

                } else {

                    queenMoves.normalQueenMoveCalculator(computerMove);

                    computerMove = computer.selectPosition(queenMoves.getPossibleQueenMoves());

                    movePiece(computerMove, pickedPosition);

                    setTurn(true);

                    endTurn();
                }
            }

        } while (!isTurn);

    }

    private void endTurn() {
        pickedPosition = null;

        promote();
        endGame.checkEndGame(getBoard().keySet());

        movesMaker.clearMovesMaker();
        normalKicks.clearNormalKicks();
        queenMoves.getPossibleQueenMoves().clear();
        queenKicks.clear();
        kickScanner.clearKickScanner();
        queenKickScanner.clearQueenKicks();
    }

    private void endKick() {
        pickedPosition = null;

        promote();
        endGame.checkEndGame(getBoard().keySet());

        normalKicks.clearNormalKicks();
        queenKicks.clear();
        kickScanner.clearKickScanner();
        queenKickScanner.clearQueenKicks();
    }

    public Ranking getRanking() {
        return ranking;
    }

    public Computer getComputer() {
        return computer;
    }

    public Set<PiecePosition> getPossiblePromote() {
        return possiblePromote;
    }

    public Map<PiecePosition, PieceColour> getBoard() {
        return board;
    }

    public void setBoard(Map<PiecePosition, PieceColour> board) {
        this.board = board;
    }

    protected void setTurn(boolean turn) {
        this.isTurn = turn;
    }

}

