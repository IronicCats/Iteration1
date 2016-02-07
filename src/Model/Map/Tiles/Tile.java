package Model.Map.Tiles;

import Model.Entity.Player;

import Model.Item.Item;
import Model.Location;
import Model.Map.AreaEffect;
import Model.Map.AreaEffectEnum;
import View.Graphics.Assets;
import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;
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
    public boolean HasItem;
    public boolean HasAreaEffect;

    private ArrayList<Item> items = new ArrayList<>();
    private AreaEffect tileAreaEffect;

    public  Tile(BufferedImage texture, Location location, boolean isUnWalkable) {
        this.location = location;
        this.texture = texture;
        this.isUnWalkable = isUnWalkable;
        //this.items = items;
        HasItem = false;
        HasAreaEffect = false;
        this.items = new ArrayList<>();

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
            g.drawImage(Assets.sack, x , y, Item.ITEMWIDTH, Item.ITEMHEIGHT, null);
        }

        if (HasAreaEffect) {
            tileAreaEffect.render(g,x,y);
        }


    }

    public void addPlayer(Player player){
        this.hasPlayer = true;
        this.player = player;
        if(this.HasAreaEffect)
        {
            System.out.println(this.location.getX() + " " + this.location.getY());
            player.getStats().applyEffect(tileAreaEffect.getEffect());
        }
    }

    public void removePlayer(Player player){
        this.hasPlayer = false;
        this.player = null;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean hasItem() {
        return (items.size() > 0);

    }

    public void addAreaEffect(AreaEffect effect)
    {
        HasAreaEffect = true;
        tileAreaEffect = effect;
    }

}
