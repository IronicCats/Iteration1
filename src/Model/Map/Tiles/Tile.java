package Model.Map.Tiles;

import Model.Location;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by jlkegley on 1/31/2016.
 */
public abstract class Tile {
    //Same as Assets.width, Assets.height
    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;


    private Location location;
    private BufferedImage texture;
    public boolean isWalkable;

    public  Tile(BufferedImage texture, Location location, boolean isWalkable) {
        this.location = location;
        this.texture = texture;
        this.isWalkable = isWalkable;
    }

    public void render(Graphics g,int x, int y) {
        //System.out.println("Render Tile");
        g.drawImage( texture, x , y, TILEWIDTH, TILEHEIGHT, null); //TILEWIDTH and TILEHEIGHT
}


}
