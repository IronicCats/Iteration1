package Model.Map.Tiles;

import Model.Entity.Player;
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

    public boolean hasPlayer;
    private Location location;
    private BufferedImage texture;
    public boolean isUnWalkable;
    private Player player;
    public Model.Item.Item[] items = new Model.Item.Item[10];

    public Tile(BufferedImage texture, Location location , boolean isUnWalkable){
        this.location = location;
        this.texture = texture;
        this.isUnWalkable = isUnWalkable;
    }
    public  Tile(BufferedImage texture, Location location, boolean isUnWalkable, Model.Item.Item[] items) {
        this.location = location;
        this.texture = texture;
        this.isUnWalkable = isUnWalkable;
        this.items = items;
    }

    public void render(Graphics g,int x, int y) {
        g.drawImage( texture, x , y, TILEWIDTH, TILEHEIGHT, null); //TILEWIDTH and TILEHEIGHT
    }

    public void addPlayer(Player player){
        hasPlayer = true;
        this.player = player;
    }

    public void removePlayer(Player player){
        hasPlayer = false;
        this.player = null;
    }

}
