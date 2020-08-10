package Checkers;

import Controllers.MenuDesigner;
import Pieces.PieceColour;
import Pieces.PiecePosition;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.Map;
import java.util.Objects;

public class CheckersDrawer {

    private GameState gameState;
    private MenuDesigner menuDesigner = new MenuDesigner();
    private BorderPane borderPane = new BorderPane();
    private static GridPane gridPane = new GridPane();
    private Background background;
    private final Image imageBoard = new Image("board1.jpg");
    private static Image light = new Image(Resources.getPath("light.png"));

    public CheckersDrawer(GameState gameState) {
        this.gameState = gameState;

        createBoardBackground();
        createBoardLayout();
        createPieces();

        borderPane.setCenter(gridPane);
        borderPane.setTop(menuDesigner.getMenuBar());
        //menuDesigner.getNewGame().setOnAction(event -> new NewGame().start(gameState));
    }

    private void createBoardLayout() {
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(30,30,30,30));
        gridPane.setBackground(createBoardBackground());

        for(int i = 0; i < 8; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(496/8);
            columnConstraints.setHalignment(HPos.CENTER);
            gridPane.getColumnConstraints().add(columnConstraints);

            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(496/8);
            rowConstraints.setValignment(VPos.CENTER);
            gridPane.getRowConstraints().add(rowConstraints);
        }
    }

    private Background createBoardBackground() {
        BackgroundSize backgroundSize = new BackgroundSize(612, 612, false, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        background = new Background(backgroundImage);
        return background;
    }

    private void createPieces() {
        for(Map.Entry<PiecePosition, PieceColour> pieces : gameState.getBoard().entrySet()){
            addPiece(pieces.getKey(), pieces.getValue(), false);
        }
    }

    static void addPiece(PiecePosition position, PieceColour pieceColour, boolean light) {
        //gridPane.add(new ImageView(generateImagePath(pieceColour, light)), position.getColumn(), position.getRow());
        gridPane.add((new ImageView("white-normal.png")), position.getColumn(), position.getRow());
        gridPane.add((new ImageView("black-normal.png")), position.getColumn(), position.getRow());
    }

    protected static void removePiece(PiecePosition position) {
        gridPane.getChildren().removeIf(node -> node instanceof ImageView && Objects.equals(GridPane.getColumnIndex(node), position.getColumn())
                && Objects.equals(GridPane.getRowIndex(node), position.getRow()));
    }

    protected static void setLight(PiecePosition position) {
        gridPane.add(new ImageView(light), position.getColumn(), position.getRow());
    }

    private static Image generateImagePath(PieceColour piece, boolean light) {
        if(light) {
            return new Image(Resources.getPath(piece.getPieceColour() + "-" + piece.getPieceType() + "-light.png"));
        } else {
            return new Image(Resources.getPath(piece.getPieceColour() + "-" + piece.getPieceType() + ".png"));
        }
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

}
