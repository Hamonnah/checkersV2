package Pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Piece extends ImageView {

    private final Image imageBlackPiece = new Image("black-normal.png");
    private final Image imageWhitePiece = new Image("white-normal.png");

    public Image getImageBlackPiece() {
        return imageBlackPiece;
    }

    public Image getImageWhitePiece() {
        return imageWhitePiece;
    }

}
