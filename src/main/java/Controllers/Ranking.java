package Controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.Date;

public class Ranking {

    private ArrayList<Integer> ranking = new java.util.ArrayList<>();
    private ArrayList<Integer> rankingTemp = new ArrayList<>();
    private Date date = new Date();

    private int whiteWins = 0;
    private int blackWins = 0;
    private int draws = 0;
    private String dateLastGame = "";

    public void showRanking() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Ranking");
        alert.setContentText("White Player Wins: " + whiteWins +
                "\nBlack Player Wins: " + blackWins +
                "\nDraws: " + draws +
                "\n\nLast game: " + dateLastGame);

        ButtonType ok = new ButtonType("OK");
        ButtonType clear = new ButtonType("Clear");

        alert.getButtonTypes().setAll(clear, ok);

        if(alert.showAndWait().get() == clear) {
            whiteWins = 0;
            blackWins = 0;
            draws = 0;
        }
    }

    public void setWhiteWins() {
        whiteWins++;
    }

    public void setBlackWins() {
        blackWins++;
    }

    public void setDraws() {
        draws++;
    }

}
