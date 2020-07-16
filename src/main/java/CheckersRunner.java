import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CheckersRunner extends Application {

    private final Image imageBoard = new Image("board1.jpg");
    private final Image imageWhitePiece = new Image("white-normal.png");
    private final Image imageBlackPiece = new Image("black-normal.png");

    private FlowPane pieces = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BackgroundSize backgroundSize = new BackgroundSize(612, 612, false, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        //grid.setHgap(5.5);
        //grid.setVgap(5.5);
        grid.setBackground(background);

        ImageView img = new ImageView(imageWhitePiece);
        pieces.getChildren().add(img);

        ImageView img2 = new ImageView(imageBlackPiece);
        pieces.getChildren().add(img2);

        grid.add(pieces, 20, 50, 3, 1);

        Scene scene = new Scene(grid, 585, 612, Color.BLACK);
        primaryStage.setTitle("Checkers Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
