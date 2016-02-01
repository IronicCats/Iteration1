package Model.Map;


import Model.Location;
import Model.Map.Tiles.Grass;
import Model.Map.Tiles.Tile;

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
    private int width, height;

    public Map() {
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
                switch(parseInt(tokens[(x + y * width) + 4])) {
                    case 0:
                        tile = new Grass(new Location(x, y, 0));
                        break;
                    default:
                        tile = new Grass(new Location(x, y, 0));
                        break;
                }
                tiles[x][y] = tile;
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
        return tiles[x][y];
    }


    public void render(Graphics g) {
        System.out.println("Render Map");
        for(int y = 0; y <  height; ++y){
            for (int x = 0; x < width; ++x) {
                getTile(x, y).render(g);
            }
        }
    }

}
