package Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class MenuDesigner {

    private MenuBar menuBar = new MenuBar();
    private Menu menu = new Menu("Game");
    private Menu ranking = new Menu("Ranking");
    private MenuItem newGame = new MenuItem("New Game");
    private MenuItem viewRanking = new MenuItem("Ranking...");

    public MenuDesigner() {
        createMenu();
    }

    private void createMenu() {

        menuBar.getMenus().add(menu);
        Menu newGame = new Menu("New Game");
        newGame.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("New Game");
                    alert.setHeaderText(null);
                    alert.setContentText("Do you want to start a new game?");

                    ButtonType yes = new ButtonType("Yes");
                    ButtonType no = new ButtonType("No");

                    alert.getButtonTypes().setAll(yes, no);

                });
        menu.getItems().add(newGame);
        menu.getItems().add(new SeparatorMenuItem());

        MenuItem settings = new MenuItem("Settings..");
        settings.setOnAction(event -> System.out.println("adjusting settings..."));
        settings.setDisable(true);
        menu.getItems().add(settings);
        menu.getItems().add(new SeparatorMenuItem());

        MenuItem exit = new MenuItem("Exit...");
        exit.setOnAction(setOnAction -> closeProgram());
        menu.getItems().add(exit);

        menuBar.getMenus().add(ranking);
        MenuItem viewRanking = new MenuItem("Ranking...");
        ranking.getItems().add(viewRanking);
    }

    private void rankingAction() {
        ranking.setOnAction(event -> new Ranking().showRanking());
    }

    private void closeProgram() {
        System.out.println("Closing program... ");
    }

    public MenuItem getNewGame() {
        return newGame;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }
}
