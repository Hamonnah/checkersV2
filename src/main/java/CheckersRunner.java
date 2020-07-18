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

    private GridPane pieceWhite1 = new GridPane();
    private GridPane pieceWhite2 = new GridPane();
    private GridPane pieceWhite3 = new GridPane();
    private GridPane pieceWhite4 = new GridPane();
    private GridPane pieceWhite5 = new GridPane();
    private GridPane pieceWhite6 = new GridPane();
    private GridPane pieceWhite7 = new GridPane();
    private GridPane pieceWhite8 = new GridPane();
    private GridPane pieceWhite9 = new GridPane();
    private GridPane pieceWhite10 = new GridPane();
    private GridPane pieceWhite11= new GridPane();
    private GridPane pieceWhite12= new GridPane();

    private GridPane pieceBlack1 = new GridPane();
    private GridPane pieceBlack2 = new GridPane();
    private GridPane pieceBlack3 = new GridPane();
    private GridPane pieceBlack4 = new GridPane();
    private GridPane pieceBlack5 = new GridPane();
    private GridPane pieceBlack6 = new GridPane();
    private GridPane pieceBlack7 = new GridPane();
    private GridPane pieceBlack8 = new GridPane();
    private GridPane pieceBlack9 = new GridPane();
    private GridPane pieceBlack10 = new GridPane();
    private GridPane pieceBlack11= new GridPane();
    private GridPane pieceBlack12= new GridPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BackgroundSize backgroundSize = new BackgroundSize(612, 612, false, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();



        grid.setPadding(new Insets(75, 0, 75, 75));

        grid.setHgap(15);
        grid.setVgap(15);
        grid.setBackground(background);

        ImageView img = new ImageView(imageWhitePiece);
        ImageView img1 = new ImageView(imageWhitePiece);
        ImageView img2 = new ImageView(imageWhitePiece);
        ImageView img3 = new ImageView(imageWhitePiece);
        ImageView img4 = new ImageView(imageWhitePiece);
        ImageView img5 = new ImageView(imageWhitePiece);
        ImageView img6 = new ImageView(imageWhitePiece);
        ImageView img7 = new ImageView(imageWhitePiece);
        ImageView img8 = new ImageView(imageWhitePiece);
        ImageView img9 = new ImageView(imageWhitePiece);
        ImageView img10 = new ImageView(imageWhitePiece);
        ImageView img11 = new ImageView(imageWhitePiece);
        ImageView img12 = new ImageView(imageBlackPiece);
        ImageView img13 = new ImageView(imageBlackPiece);
        ImageView img14 = new ImageView(imageBlackPiece);
        ImageView img15 = new ImageView(imageBlackPiece);
        ImageView img16 = new ImageView(imageBlackPiece);
        ImageView img17 = new ImageView(imageBlackPiece);
        ImageView img18 = new ImageView(imageBlackPiece);
        ImageView img19 = new ImageView(imageBlackPiece);
        ImageView img20 = new ImageView(imageBlackPiece);
        ImageView img21 = new ImageView(imageBlackPiece);
        ImageView img22 = new ImageView(imageBlackPiece);
        ImageView img23 = new ImageView(imageBlackPiece);

        pieceWhite1.getChildren().add(img);
        pieceWhite2.getChildren().add(img1);
        pieceWhite3.getChildren().add(img2);
        pieceWhite4.getChildren().add(img3);
        pieceWhite5.getChildren().add(img4);
        pieceWhite6.getChildren().add(img5);
        pieceWhite7.getChildren().add(img6);
        pieceWhite8.getChildren().add(img7);
        pieceWhite9.getChildren().add(img8);
        pieceWhite10.getChildren().add(img9);
        pieceWhite11.getChildren().add(img10);
        pieceWhite12.getChildren().add(img11);

        pieceBlack1.getChildren().add(img12);
        pieceBlack2.getChildren().add(img13);
        pieceBlack3.getChildren().add(img14);
        pieceBlack4.getChildren().add(img15);
        pieceBlack5.getChildren().add(img16);
        pieceBlack6.getChildren().add(img17);
        pieceBlack7.getChildren().add(img18);
        pieceBlack8.getChildren().add(img19);
        pieceBlack9.getChildren().add(img20);
        pieceBlack10.getChildren().add(img21);
        pieceBlack11.getChildren().add(img22);
        pieceBlack12.getChildren().add(img23);

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
        grid.add(pieceWhite1, 0, 0, 1, 1);
        grid.add(pieceWhite2, 2, 0, 1, 1);
        grid.add(pieceWhite3, 4, 0, 1, 1);
        grid.add(pieceWhite4, 6, 0, 1, 1);
        grid.add(pieceWhite5, 1, 1, 1, 1);
        grid.add(pieceWhite6, 3, 1, 1, 1);
        grid.add(pieceWhite7, 5, 1, 1, 1);
        grid.add(pieceWhite8, 7, 1, 1, 1);
        grid.add(pieceWhite9, 0, 2, 1, 1);
        grid.add(pieceWhite10, 2, 2, 1, 1);
        grid.add(pieceWhite11, 4, 2, 1, 1);
        grid.add(pieceWhite12, 6, 2, 1, 1);
        grid.add(pieceBlack1, 1, 15, 1, 1);
        grid.add(pieceBlack2, 3, 15, 1, 1);
        grid.add(pieceBlack3, 5, 15, 1, 1);
        grid.add(pieceBlack4, 7, 15, 1, 1);
        grid.add(pieceBlack5, 0, 14, 1, 1);
        grid.add(pieceBlack6, 2, 14, 1, 1);
        grid.add(pieceBlack7, 4, 14, 1, 1);
        grid.add(pieceBlack8, 6, 14, 1, 1);
        grid.add(pieceBlack9, 1, 13, 1, 1);
        grid.add(pieceBlack10, 3, 13, 1, 1);
        grid.add(pieceBlack11, 5, 13, 1, 1);
        grid.add(pieceBlack12, 7, 13, 1, 1);

        //grid.add(img2, 50, 50);

        //grid.add(img, 0, 20, 5, 5);
        //grid.add(img2,0,2, 5, 5);
        //grid.setAlignment(Pos.TOP_LEFT);
        //grid.addRow(10, img, img2);
        //grid.setHgap(20);


        Scene scene = new Scene(grid, 700, 700, Color.BLACK);
        primaryStage.setTitle("Checkers Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    private void newGame() {
        System.out.println("blah");
    }
    }
