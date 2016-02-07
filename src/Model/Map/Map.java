package Model.Map;


import Model.Item.Item;
import Model.Location;
import Model.Map.Tiles.Grass;
import Model.Map.Tiles.Mountain;
import Model.Map.Tiles.Tile;
import Model.Map.Tiles.Water;
import Model.Item.PopulateItems;

import Controller.Controller;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by jlkegley on 1/31/2016.
 */
public class Map {

    private Tile[][] tiles;
    private Location spawn;
    private int width;
    private Item potion;
    private int height;
    private Controller controller;
    private PopulateItems populateItems = new PopulateItems();
    private Item[] items = populateItems.getItems();

    public Map(Controller controller) {
        //System.out.println(items[0].getLocation().getY());
        this.controller = controller;
        makeMap();
    }

    public void makeMap() {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader("res/map/map.txt"));
            String line;
            while((line = br.readLine()) != null) {
                builder.append(line + "\n");
            }
        }catch (IOException e) {
            System.out.println(e);

        }

        String[] tokens = builder.toString().split("\\s+");
        width = parseInt(tokens[0]);
        height = parseInt(tokens[1]);
        spawn = new Location(parseInt(tokens[2]), parseInt(tokens[3]), 0);

        tiles = new Tile[width][height];
        for(int y = 0; y < height; ++y) {
            for(int x = 0; x < width; ++x){
                Tile tile;
                switch (parseInt(tokens[(x + y * width) + 4])) {
                    case 0:
                        tile = new Grass(new Location(x, y, 0));
                        break;
                    case 1:
                        tile = new Mountain(new Location(x, y, 0));
                        break;
                    case 2:
                        tile = new Water(new Location(x, y, 0));
                        break;
                    default:
                        tile = new Mountain(new Location(x, y, 0));
                        break;
                }
                tiles[x][y] = tile;
                for(int i = 0; i < items.length; i++) {
                    if(tile.getLocation().getX() == items[i].getLocation().getX() && tile.getLocation().getY() == items[i].getLocation().getY()){
                        tile.addItem(items[i]);
                        System.out.println(items[i].getLocation().getX());
                    }
                }
            }
        }

    }

    private int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        }catch(NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Tile getTile(int x , int y) {
        if(x < 0 || y < 0 || x >= width || y >= height){
            return tiles[2][2];
        }
        return tiles[x][y];
    }

    public Tile getTile(Location location) {
        return getTile(location.getX(), location.getY());
    }


    public void render(Graphics g) {
        int startX = Math.max(0, (int)controller.getCamera().getxOffset() / Tile.TILEWIDTH);
        int startY = Math.max(0, (int)controller.getCamera().getyOffset() / Tile.TILEHEIGHT);
        int endX = Math.min(controller.getGame().getWidth(), (int)controller.getCamera().getxOffset() / Tile.TILEWIDTH);
        int endY = Math.min(controller.getGame().getHeight(), (int)controller.getCamera().getyOffset() / Tile.TILEHEIGHT);

        for(int y = 0; y <  height; ++y){
            for (int x = 0; x < width; ++x) {
                getTile(x, y).render(g,
                        (int)(x * Tile.TILEWIDTH - controller.getCamera().getxOffset()),
                        (int)(y * Tile.TILEHEIGHT - controller.getCamera().getyOffset())
                );
            }
        }
    }

    public int getWidth() {

        return width * 2;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height * 2;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
