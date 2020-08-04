import Checkers.CheckersDrawer;
import Checkers.GameState;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CheckersRunner extends Application {

    private static Stage primaryStage = new Stage();
    private GameState gameState = new GameState();
    private CheckersDrawer checkersDrawer = new CheckersDrawer(gameState);


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;


        Scene scene = new Scene(checkersDrawer.getBorderPane(), 700, 700, Color.BLACK);
        primaryStage.setTitle("Checkers Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
