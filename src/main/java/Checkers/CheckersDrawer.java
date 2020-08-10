package Checkers;

import Pieces.Piece;
import Pieces.PiecePosition;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.Map;

public class CheckersDrawer {

    private GameState gameState;
    private BorderPane borderPane = new BorderPane();
    private GridPane gridPane = new GridPane();
    private Background background;
    private final Image imageBoard = new Image("board1.jpg");

    public CheckersDrawer(GameState gameState) {
        this.gameState = gameState;

        createBoardBackground();
        createBoardLayout();
        createPieces();

        borderPane.setCenter(gridPane);
    }

    private void createBoardLayout() {
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(58,59,58,56));
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
        //gridPane.setGridLinesVisible(true);
    }

    private void addPiece(PiecePosition position, Piece piece) {
        gridPane.add((new ImageView("white-normal.png")), position.getColumn(), position.getRow());
        gridPane.add((new ImageView("black-normal.png")), position.getColumn(), position.getRow());
    }


    private Background createBoardBackground() {
        BackgroundSize backgroundSize = new BackgroundSize(612, 612, false, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        background = new Background(backgroundImage);
        return background;
    }

    private void createPieces() {
        for(Map.Entry<PiecePosition, Piece> pieces : gameState.getGameState().entrySet()){
            addPiece(pieces.getKey(), pieces.getValue());
        }
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

}
