import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.Map;

public class CheckersDrawer {

    private GridPane gridPane = new GridPane();
    private PiecePosition piecePosition;
    private Background background;
    private Image imageBoard = new Image("board1.jpg");

    public CheckersDrawer(Image piecePosition) {
        this.piecePosition = piecePosition;

        createBoardBackground();
        createBoardLayout();

        //createPieces();

    }

    private void createPieces() {
    }

    private Background createBoardBackground() {
        BackgroundSize backgroundSize = new BackgroundSize(612, 612, false, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        background = new Background(backgroundImage);
        return background;
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
        gridPane.setGridLinesVisible(true);
    }


}
