package Model.Map.Decal;

import Model.Location;
import Model.Map.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by mazumderm on 2/6/2016.
 */
public class Decal {
    public static int ITEMWIDTH = 28, ITEMHEIGHT = 28; // default height of decals
    private BufferedImage image; // image of decal
    protected Location location; // location of decal
    private String name;
    private String description;
    private DecalEnum type;

    //constructor
    public Decal(BufferedImage image, Model.Location location, DecalEnum type )
    {
        this.image = image;
        this.location = location;
        this.type = type;
    }

    //accessor methods

    public DecalEnum getType() {return type;}

    public Location getLocation() {return location;}

    public int getWidth() {
        return ITEMWIDTH;
    }

    public int getHeight() {
        return ITEMHEIGHT;
    }

    //render methods
    public void render(Graphics g, int x, int y) { // render decal image
        render(g, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT, ITEMHEIGHT, ITEMWIDTH);
    }

    public void render(Graphics g, int xLoc, int yLoc, int tileWidth, int tileHeight, int itemHeight, int itemWidth) {
        g.drawImage(image, xLoc + tileWidth/2 - itemWidth/2 , yLoc + tileHeight/2 - itemHeight/2, itemWidth, itemHeight, null);
    }
}
