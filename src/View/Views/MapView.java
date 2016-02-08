package View.Views;

import Controller.Controller;
import Model.Location;
import Model.Map.Map;
import Model.Map.Tiles.Tile;

import java.awt.*;

public class MapView {
    Map map;
    int mapWidth;
    int mapHeight;

    int currentX=0;
    int currentY=0;
    int pxWidth, pxHeight;

    int mapDisplayPxWidth;
    int mapDisplayPxHeight;

    Controller controller;

    public MapView(Controller controller, int pxWidth, int pxHeight){
        this.pxHeight = pxHeight;
        this.pxWidth = pxWidth;
        this.controller=controller;
        this.map = controller.getMap();
        this.mapWidth = map.getWidth();
        this.mapHeight= map.getHeight();
        this.mapDisplayPxWidth = pxWidth - 100;
        this.mapDisplayPxHeight = pxHeight - 100;

    }

    public void setMap(Map map) {
        this.map = map;
        this.mapWidth = map.getWidth();
        this.mapHeight= map.getHeight();
    }

    public void render(Graphics g) {
        g.setColor(new Color(0, 0, 0, 240));
        g.fillRect(40, 40, mapDisplayPxWidth + 20, mapDisplayPxHeight + 20);

        Location playerLocation = controller.getPlayer().getLocation();

//        g.setFont(new Font("Arial", Font.PLAIN, 48));
//        FontMetrics fm = g.getFontMetrics();

        for(int x = 0; x < mapWidth; ++x){
            for (int y = 0; y < mapHeight; ++y) {
                if (x == playerLocation.getX() && y == playerLocation.getY()) {
                    g.setColor(new Color(255, 0,0));
                    g.fillRect(
                            50 + x * (mapDisplayPxWidth / mapWidth),
                            50 + y * (mapDisplayPxHeight / mapHeight),
                            mapDisplayPxWidth / mapWidth,
                            mapDisplayPxHeight / mapHeight
                    );
                } else {
                    map.getTile(x, y).renderTile(g,
                            50 + x * (mapDisplayPxWidth / mapWidth),
                            50 + y * (mapDisplayPxHeight / mapHeight),
                            mapDisplayPxWidth / mapWidth,
                            mapDisplayPxHeight / mapHeight
                    );
                }
            }
        }
    }

    public void up() {
        if(currentX < mapHeight){
            currentX++;
        }
    }
    public void down() {
        if(currentX > 0) {
            currentX--;
        }
    }
    public void left() {
        if(currentY > 0) {
            currentY--;
        }
    }
    public void right() {
        if(currentY < mapHeight){
            currentY++;
        }
    }

}
