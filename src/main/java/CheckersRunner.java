import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CheckersRunner extends Application {

    private final Image imageBoard = new Image("board1.jpg");
    private final Image imageWhitePiece = new Image("white-normal.png");
    private final Image imageBlackPiece = new Image("black-normal.png");

    private FlowPane pieceWhite1 = new FlowPane(Orientation.VERTICAL);
    private FlowPane pieceWhite2 = new FlowPane(Orientation.VERTICAL);
    private FlowPane pieceWhite3 = new FlowPane(Orientation.VERTICAL);
    private FlowPane pieceWhite4 = new FlowPane(Orientation.VERTICAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BackgroundSize backgroundSize = new BackgroundSize(612, 612, false, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        //GridPane grid = new GridPane();
        FlowPane flowPane = new FlowPane();


        flowPane.setPadding(new Insets(75, 0, 75, 75));
        flowPane.setHgap(85);
        //grid.setVgap(5.5);
        flowPane.setBackground(background);

        ImageView img = new ImageView(imageWhitePiece);
        ImageView img1 = new ImageView(imageWhitePiece);
        ImageView img2 = new ImageView(imageWhitePiece);
        ImageView img3 = new ImageView(imageWhitePiece);

        pieceWhite1.getChildren().add(img);
        pieceWhite2.getChildren().add(img1);
        pieceWhite3.getChildren().add(img2);
        pieceWhite4.getChildren().add(img3);

       /* GridPane gridpane = new GridPane();
        for (int i = 0; i < 100; i++) {
            RowConstraints row = new RowConstraints(100);
            gridpane.getRowConstraints().add(row);
            ColumnConstraints column = new ColumnConstraints(100);
            gridpane.getColumnConstraints().add(column);
        }*/
        //grid.add(pieceBlack1,3, 4, 1, 2);
        //grid.add(pieceBlack2,0, 1, 1, 2);
        //grid.add(pieceWhite1,1, 3, 1, 2);
        //grid.add(pieceWhite2,1, 4, 1, 2);
        flowPane.getChildren().add(pieceWhite1);
        flowPane.getChildren().add(pieceWhite2);
        flowPane.getChildren().add(pieceWhite3);
        flowPane.getChildren().add(pieceWhite4);

        //grid.add(img2, 50, 50);

        //grid.add(img, 0, 20, 5, 5);
        //grid.add(img2,0,2, 5, 5);
        //grid.setAlignment(Pos.TOP_LEFT);
        //grid.addRow(10, img, img2);
        //grid.setHgap(20);


        Scene scene = new Scene(flowPane, 700, 700, Color.BLACK);
        primaryStage.setTitle("Checkers Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    private void newGame() {
        System.out.println("blah");
    }
    }
