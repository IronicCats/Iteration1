package Model.Map.Tiles;

import Model.Location;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by jlkegley on 1/31/2016.
 */
public abstract class Tile {
    //Same as Assets.width, Assets.height
    public static final int TILEWIDTH = 32, TILEHEIGHT = 32;


    private Location location;
    private BufferedImage texture;
    public boolean isWalkable;

    public  Tile(BufferedImage texture, Location location, boolean isWalkable) {
        this.location = location;
        this.texture = texture;
        this.isWalkable = isWalkable;
    }

    public void render(Graphics g) {
        System.out.println("Render Tile");
        g.drawImage( texture, this.location.getX() * TILEWIDTH, this.location.getY() * TILEHEIGHT, TILEWIDTH, TILEHEIGHT, null);
    }


}
