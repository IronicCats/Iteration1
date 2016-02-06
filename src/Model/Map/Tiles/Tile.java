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
    private int NumberofItems; // should be private

    private ArrayList<Item> items = new ArrayList<Item>();



    public  Tile(BufferedImage texture, Location location, boolean isUnWalkable, Item[] items) {
        this.location = location;
        this.texture = texture;
        this.isUnWalkable = isUnWalkable;
        //this.items = items;
    }

    public void render(Graphics g,int x, int y) {

        if(items.size() == 0) {
            g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null); //TILEWIDTH and TILEHEIGHT
        }
        else if (items.size() == 1) {
            g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null); //TILEWIDTH and TILEHEIGHT
            items.get(items.size() -1).render(g, x, y);
        }
        else{
            g.drawImage(texture,x,y,TILEWIDTH,TILEHEIGHT,null);
            //bag.render(g,x,y);
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
        items.add(item);
    }

  /*  public Item removeItem(){
            if(items.size() > 0) {
                System.out.println(NumberofItems);
                Item temp = items[NumberofItems - 1];
                items[NumberofItems] = null;
                NumberofItems--;
                if (NumberofItems == 0) {
                    HasItem = false;
                }
                return temp;
            }
        return null;
    }*/

    public boolean HasItem(){
        return items.size() > 0;
    }
    

}
