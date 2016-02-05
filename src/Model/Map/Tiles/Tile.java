package Model.Map.Tiles;

import Model.Item.Item;
import Model.Location;
import com.sun.org.apache.xpath.internal.operations.Mod;
import sun.awt.image.BufferedImageDevice;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by jlkegley on 1/31/2016.
 */
public abstract class Tile {
    //Same as Assets.width, Assets.height
    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

    private Item items[] = new Item[10];
    private Location location;
    private BufferedImage texture;
    public boolean isUnWalkable;

    //Constructor
    public Tile(BufferedImage texture, Location location , boolean isUnWalkable){
        this.location = location;
        this.texture = texture;
        this.isUnWalkable = isUnWalkable;
    }
    //Constructor with items[] added
    public  Tile(BufferedImage texture, Location location, boolean isUnWalkable, Model.Item.Item[] items) {
        this.location = location;
        this.texture = texture;
        this.isUnWalkable = isUnWalkable;
        this.items = items;
    }

    public void render(Graphics g,int x, int y) {
        g.drawImage( texture, x , y, TILEWIDTH, TILEHEIGHT, null); //TILEWIDTH and TILEHEIGHT
    }

    
}
