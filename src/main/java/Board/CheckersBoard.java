package Board;

import javafx.scene.image.Image;
import javafx.scene.layout.*;


public class CheckersBoard {

    private BorderPane borderPane = new BorderPane();
    private final Image imageBoard = new Image("file:resources/board1.jpg");

    public CheckersBoard() {
        borderPane.setBackground(createBoardBackground());
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    private Background createBoardBackground() {
        BackgroundSize backgroundSize = new BackgroundSize(612, 612, false, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        return background;
    }

}