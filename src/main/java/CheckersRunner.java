import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class CheckersRunner extends Application {

    private final Image imageBoard = new Image("board1.jpg");
    private final Image imageWhitePiece = new Image("white-normal.png");
    private final Image imageBlackPiece = new Image("black-normal.png");
    private GridPane grid = new GridPane();
    CheckersDrawer checkersDrawer = new CheckersDrawer(imageBlackPiece);



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BackgroundSize backgroundSize = new BackgroundSize(612, 612, false, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);



        grid.setPadding(new Insets(75, 0, 75, 75));
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setBackground(background);



       /* GridPane gridpane = new GridPane();
        for (int i = 0; i < 100; i++) {
            RowConstraints row = new RowConstraints(100);
            gridpane.getRowConstraints().add(row);
            ColumnConstraints column = new ColumnConstraints(100);
            gridpane.getColumnConstraints().add(column);
        }*/




        VBox box = new VBox();
        Button startButton = new Button("Start Game");
        box.getChildren().add(startButton);
        box.getChildren().add(grid);

        Label nameLable = new Label("Username:");
        GridPane.setConstraints(nameLable, 5, 5);


        Scene scene = new Scene(, 700, 700, Color.BLACK);
        primaryStage.setTitle("Checkers Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void newGame() {
        System.out.println("blah");
    }

    private void updateViev() {

        List<ImageView> imageWhitePieces = new ArrayList<>();
        List<ImageView> imageBlackPieces = new ArrayList<>();
        for(int n = 0; n < 12; n++) {
            imageWhitePieces.add(new ImageView(imageWhitePiece));
        }
        for(int n = 0; n < 12; n++) {
            imageBlackPieces.add(new ImageView(imageBlackPiece));
        }

        grid.add(imageWhitePieces.get(0), 0, 0, 1, 1);
        grid.add(imageWhitePieces.get(1), 2, 0, 1, 1);
        grid.add(imageWhitePieces.get(2), 4, 0, 1, 1);
        grid.add(imageWhitePieces.get(3), 6, 0, 1, 1);
        grid.add(imageWhitePieces.get(4), 1, 1, 1, 1);
        grid.add(imageWhitePieces.get(5), 3, 1, 1, 1);
        grid.add(imageWhitePieces.get(6), 5, 1, 1, 1);
        grid.add(imageWhitePieces.get(7), 7, 1, 1, 1);
        grid.add(imageWhitePieces.get(8), 0, 2, 1, 1);
        grid.add(imageWhitePieces.get(9), 2, 2, 1, 1);
        grid.add(imageWhitePieces.get(10), 4, 2, 1, 1);
        grid.add(imageWhitePieces.get(11), 6, 2, 1, 1);
        grid.add(imageBlackPieces.get(0), 1, 15, 1, 1);
        grid.add(imageBlackPieces.get(1), 3, 15, 1, 1);
        grid.add(imageBlackPieces.get(2), 5, 15, 1, 1);
        grid.add(imageBlackPieces.get(3), 7, 15, 1, 1);
        grid.add(imageBlackPieces.get(4), 0, 14, 1, 1);
        grid.add(imageBlackPieces.get(5), 2, 14, 1, 1);
        grid.add(imageBlackPieces.get(6), 4, 14, 1, 1);
        grid.add(imageBlackPieces.get(7), 6, 14, 1, 1);
        grid.add(imageBlackPieces.get(8), 1, 13, 1, 1);
        grid.add(imageBlackPieces.get(9), 3, 13, 1, 1);
        grid.add(imageBlackPieces.get(10), 5, 13, 1, 1);
        grid.add(imageBlackPieces.get(11), 7, 13, 1, 1);

    }

}
