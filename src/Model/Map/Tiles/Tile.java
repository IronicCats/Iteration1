package Model.Map.Tiles;

import Model.Entity.Player;

import Model.Item.Item;
import Model.Location;
import View.Graphics.Assets;
import com.sun.org.apache.xpath.internal.operations.Mod;
import sun.awt.image.BufferedImageDevice;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


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

    private ArrayList<Item> items = new ArrayList<>();

    public  Tile(BufferedImage texture, Location location, boolean isUnWalkable) {
        this.location = location;
        this.texture = texture;
        this.isUnWalkable = isUnWalkable;
    }

    public void render(Graphics g,int x, int y) {

        if(items.size() == 0) {
            g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null); //TILEWIDTH and TILEHEIGHT
        }
        else if(items.size() == 1) {
            g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null); //TILEWIDTH and TILEHEIGHT
            items.get(0).render(g, x, y);
        }
        else {
            g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
            g.drawImage(Assets.sack, x + Tile.TILEWIDTH/2 - Item.ITEMWIDTH/2 , y + Tile.TILEHEIGHT/2 - Item.ITEMHEIGHT/2, Item.ITEMWIDTH, Item.ITEMHEIGHT, null);
        }
    }

    public void addPlayer(Player player){
        this.hasPlayer = true;
        this.player = player;
    }

    public void removePlayer(Player player){
        this.hasPlayer = false;
        this.player = null;
    }

    public void addItem(Item item) {
        System.out.println("Test");
        items.add(item);
        System.out.println(items.size());
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Location getLocation() {
        return location;
    }

    public boolean hasItem() {
        return (items.size() > 0);

    }
}
