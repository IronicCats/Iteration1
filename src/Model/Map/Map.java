package Model.Map;


import Model.Item.Item;
import Model.Location;
import Model.Map.Tiles.Grass;
import Model.Map.Tiles.Mountain;
import Model.Map.Tiles.Tile;
import Model.Map.Tiles.Water;
import Model.Item.PopulateItems;
import View.Graphics.Assets;

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
    private int width;
    private int height;
    private Controller controller;
    private PopulateItems populateItems;
    private Item[] items;
    private Location spawn;
    private AreaEffect[] areaEffects;
    private Location[] areaEffectLocation;
    private int spawnX;
    private int spawnY;

    public Map(Controller controller) {
        //System.out.println(items[0].getLocation().getY());
        this.controller = controller;
        populateItems = new PopulateItems();
        items = populateItems.getItems();
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
        System.out.println(parseInt(tokens[2]));
        spawn = new Location(parseInt(tokens[2]), parseInt(tokens[3]), 2);
        spawnX = parseInt(tokens[2]);
        spawnY = parseInt(tokens[3]);
        tiles = new Tile[width][height];
        for(int y = 0; y < height; ++y) {
            for(int x = 0; x < width; ++x){
                Tile tile;
                switch (parseInt(tokens[(x + y * width) + 4])) {
                    case 0:
                        tile = new Grass(Assets.grass.get(0), new Location(x, y, 0));
                        break;
                    case 1:
                        tile = new Grass(Assets.grass.get(1), new Location(x, y, 0));
                        break;
                    case 2:
                        tile = new Grass(Assets.grass.get(2), new Location(x, y, 0));
                        break;
                    case 3:
                        tile = new Grass(Assets.grass.get(3), new Location(x, y, 0));
                        break;
                    case 4:
                        tile = new Grass(Assets.grass.get(4), new Location(x, y, 0));
                        break;
                    case 5:
                        tile = new Grass(Assets.grass.get(5), new Location(x, y, 0));
                        break;
                    case 6:
                        tile = new Grass(Assets.grass.get(6), new Location(x, y, 0));
                        break;
                    case 7:
                        tile = new Grass(Assets.grass.get(7), new Location(x, y, 0));
                        break;
                    case 8:
                        tile = new Grass(Assets.grass.get(8), new Location(x, y, 0));
                        break;

                    case 10:
                        tile = new Mountain(Assets.mountain.get(0),new Location(x, y, 0));
                        break;
                    case 11:
                        tile = new Mountain(Assets.mountain.get(1), new Location(x, y, 0));
                        break;
                    case 12:
                        tile = new Mountain(Assets.mountain.get(2), new Location(x, y, 0));
                        break;
                    case 13:
                        tile = new Mountain(Assets.mountain.get(3), new Location(x, y, 0));
                        break;
                    case 14:
                        tile = new Mountain(Assets.mountain.get(4), new Location(x, y, 0));
                        break;
                    case 15:
                        tile = new Mountain(Assets.mountain.get(5), new Location(x, y, 0));
                        break;
                    case 16:
                        tile = new Mountain(Assets.mountain.get(6), new Location(x, y, 0));
                        break;
                    case 17:
                        tile = new Mountain(Assets.mountain.get(7), new Location(x, y, 0));
                        break;
                    case 18:
                        tile = new Mountain(Assets.mountain.get(8), new Location(x, y, 0));
                        break;

                    case 20:
                        tile = new Water(Assets.water.get(0),new Location(x, y, 0));
                        break;
                    case 21:
                        tile = new Water(Assets.water.get(1),new Location(x, y, 0));
                        break;
                    case 22:
                        tile = new Water(Assets.water.get(2),new Location(x, y, 0));
                        break;
                    case 23:
                        tile = new Water(Assets.water.get(3),new Location(x, y, 0));
                        break;
                    case 24:
                        tile = new Water(Assets.water.get(4),new Location(x, y, 0));
                        break;
                    case 25:
                        tile = new Water(Assets.water.get(5),new Location(x, y, 0));
                        break;
                    case 26:
                        tile = new Water(Assets.water.get(6),new Location(x, y, 0));
                        break;
                    case 27:
                        tile = new Water(Assets.water.get(7),new Location(x, y, 0));
                        break;
                    case 28:
                        tile = new Water(Assets.water.get(8),new Location(x, y, 0));
                        break;
                    default:
                        tile = new Mountain(Assets.mountain.get(0), new Location(x, y, 0));
                        break;
                }
                tiles[x][y] = tile;
                for(int i = 0; i < items.length; i++) {
                    if(tile.getLocation().getX() == items[i].getLocation().getX() && tile.getLocation().getY() == items[i].getLocation().getY() && !tile.isUnWalkable){
                        tile.addItem(items[i]);
                        System.out.println(items[i].getType().toString());
                    }
                }
            }
        }

        AreaEffect one = new AreaEffect("Damaged", "You lose health", AreaEffectEnum.DAMAGE);
        this.getTile(6, 10).addAreaEffect(one);

        AreaEffect two = new AreaEffect("Healed", "You gain health", AreaEffectEnum.HEAL);
        this.getTile(9, 6).addAreaEffect(two);

        AreaEffect three = new AreaEffect("Death", "You die", AreaEffectEnum.DEATH);
        this.getTile(3, 5).addAreaEffect(three);

        AreaEffect four =  new AreaEffect("Level Up", "You get a level", AreaEffectEnum.LEVELUP);
        this.getTile(12, 2).addAreaEffect(four);

        /**
        areaEffects[0] = new AreaEffect("Damaged", "You lose health", AreaEffectEnum.DAMAGE);
        areaEffects[1] = new AreaEffect("Healed", "You gain health", AreaEffectEnum.HEAL);
        areaEffects[2] = new AreaEffect("Death", "You die", AreaEffectEnum.DEATH);
        areaEffects[3] = new AreaEffect("Level Up", "You get a level", AreaEffectEnum.LEVELUP);
        areaEffects[4] = new AreaEffect("Damaged", "You lose health", AreaEffectEnum.DAMAGE);
        areaEffects[5] = new AreaEffect("Healed", "You gain health", AreaEffectEnum.HEAL);
        areaEffects[6] = new AreaEffect("Death", "You die", AreaEffectEnum.DEATH);

        for(int j = 0; j < areaEffects.length; ++j)
        {
            areaEffectLocation[j] = new Location(j, 2 * j + 1, 0);
        }


        for(int i = 0; i < areaEffects.length; ++i)
        {
            this.getTile(areaEffectLocation[i].getX(), areaEffectLocation[i].getY() * 2).addAreaEffect(areaEffects[i]);
        }
         **/


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
        if(x < 0 || y < 0 || x >= width  || y >= height){
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

    public Location getSpawn(){
        return spawn;
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
