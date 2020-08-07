package Controllers;

import Checkers.GameState;
import Pieces.PiecePosition;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseController {

    private GameState gameState;

    public MouseController(GameState gameState) {
        this.gameState = gameState;
    }

    private EventHandler<MouseEvent> mouseClick = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {
            PiecePosition clickPosition = new PiecePosition((int) ((event.getX() - 59) / 62), (int) ((event.getY() - 58) / 62));

            if(!clickPosition.isValidPosition()) {
                return;
            }

            gameState.handleMove(clickPosition);
        }
    };

    public EventHandler<MouseEvent> getMouseClick() {
        return mouseClick;
    }

}
