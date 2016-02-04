package View.Graphics;

import Model.Entity.Player;
import Model.Location;
import Model.Map.Map;
import Model.Map.Tiles.Tile;

/**
 * Created by jlkegley on 2/1/2016.
 */
public class Camera {

    private int gameWidth, gameHeight;
    private float xOffset, yOffset;
    private Map map;

    public Camera(int gameWidth, int gameHeight, Map map) {
        this.gameHeight = gameHeight;
        this.gameWidth = gameWidth;
        this.map = map;
        yOffset = 100;
        xOffset = 100;
    }

    public void move(int x, int y) {
        xOffset += x;
        yOffset += y;
        keepCameraonMap();
    }

    public void keepCameraonMap(){
        if(xOffset < 0){
            setxOffset(0);
        }
        else if(getxOffset() > (map.getWidth() * (Tile.TILEWIDTH/2) - gameWidth) ) {
            setxOffset(map.getWidth() * (Tile.TILEWIDTH/2) - gameWidth);
        }
        if(getyOffset() < 0){
            setyOffset(0);
        }
        else if(getyOffset() > (map.getHeight() * Tile.TILEHEIGHT/2) - gameHeight){
            setyOffset((map.getHeight() * Tile.TILEWIDTH/2) - gameHeight);
        }
    }

    public void centerOnPlayer(Player player) {
        xOffset = player.getLocation().getX() - gameWidth / 2 + player.getWidth() / 2;
        yOffset = player.getLocation().getY() - gameHeight / 2 + player.getHeight() / 2;
        keepCameraonMap();
    }


    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
        keepCameraonMap();
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
