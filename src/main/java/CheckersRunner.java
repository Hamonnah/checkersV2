
import Board.CheckersBoard;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CheckersRunner extends Application {

    private static Stage primaryStage;
    private CheckersBoard checkersBoard= new CheckersBoard();

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Scene scene = new Scene(checkersBoard.getBorderPane(), 585, 612, Color.BLACK);
        primaryStage.setTitle("Checkers Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
