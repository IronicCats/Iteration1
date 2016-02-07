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
    public Decal(BufferedImage image, String name, String description, Model.Location location, DecalEnum type )
    {
        this.image = image;
        this.name = name;
        this.description = description;
        this.location = location;
        this.type = type;
    }

    //accessor methods
    public String getDescription() {return description;}

    public String getName() {return name;}

    public DecalEnum getType() {return type;}

    public void render(Graphics g, int x, int y) { // render decal image
        g.drawImage(image, x + Tile.TILEWIDTH/2 - ITEMWIDTH/2 , y + Tile.TILEHEIGHT/2 - ITEMHEIGHT/2, ITEMWIDTH, ITEMHEIGHT, null);
    }
}
