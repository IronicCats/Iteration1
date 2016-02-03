package View.Graphics;

import Model.Entity.Player;
import Model.Location;

/**
 * Created by jlkegley on 2/1/2016.
 */
public class Camera {

    private int gameWidth, gameHeight;
    private float xOffset, yOffset;

    public Camera(int gameWidth, int gameHeight) {
        this.gameHeight = gameHeight;
        this.gameWidth = gameWidth;
        yOffset = 100;
        xOffset = 100;
    }

    public void move(int x, int y) {
        xOffset += x;
        yOffset += y;
    }

    public void centerOnPlayer(Player player) {
        xOffset = player.getLocation().getX() - gameWidth / 2 + player.getWidth() / 2;
        yOffset = player.getLocation().getY() - gameHeight / 2 + player.getHeight() / 2;
    }


    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
