package Model.Map.Tiles;

import Model.Entity.Player;
import Model.Item.Item;
import Model.Location;
import View.Graphics.Assets;
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
    public Item[] items = new Item[10];
    private int NumberofItems;
    public boolean HasItem;


    public  Tile(BufferedImage texture, Location location, boolean isUnWalkable, Item[] items) {
        this.location = location;
        this.texture = texture;
        this.isUnWalkable = isUnWalkable;
        //this.items = items;
        HasItem = false;
    }

    public void render(Graphics g,int x, int y) {
        if(NumberofItems == 0) {
            g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null); //TILEWIDTH and TILEHEIGHT
        }
        if (NumberofItems > 0) {
            items[NumberofItems -1].render(g, x, y);

        }
    }

    public void addPlayer(Player player){
        hasPlayer = true;
        this.player = player;
    }

    public void removePlayer(Player player){
        hasPlayer = false;
        this.player = null;
    }

    public void addItem(Item item){
        HasItem = true;
        items[NumberofItems] = item;
        NumberofItems++;
        System.out.println(NumberofItems);
    }

    public Item removeItem(){
        if(!hasPlayer) {
            if(NumberofItems > 0) {
                Item temp = items[NumberofItems - 1];
                System.out.println("going in");
                items[NumberofItems] = null;
                NumberofItems--;
                if (NumberofItems == 0) {
                    HasItem = false;
                }
                hasPlayer = true;
                return temp;
            }
        }
        return null;

    }
}
