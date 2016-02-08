package Model.Map.Tiles;
import Model.Entity.Player;



import Model.Entity.Player;

import Model.Entity.Stats.StatsEnum;
import Model.Item.Item;
import Model.Item.ItemsEnum;
import Model.Location;
import Model.Map.AreaEffect;
import View.Graphics.Assets;
import com.sun.org.apache.xpath.internal.operations.Mod;
import sun.awt.image.BufferedImageDevice;

import Model.Entity.Stats.Effect;

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
    private AreaEffect tileAreaEffect;
    private boolean HasAreaEffect;

    private Effect []oneShot;
    private boolean hasOneShot;

    public  Tile(BufferedImage texture, Location location, boolean isUnWalkable) {
        this.location = location;
        HasAreaEffect = false;
        this.texture = texture;
        this.isUnWalkable = isUnWalkable;
        this.items = new ArrayList<>();

    }

    public void render(Graphics g,int x, int y) {
        renderTile(g, x, y, TILEWIDTH, TILEHEIGHT);
        if(items.size() > 0) {
            renderItem(g, x, y, TILEWIDTH, TILEHEIGHT,Item.ITEMWIDTH, Item.ITEMHEIGHT);
        }
        if(HasAreaEffect) {
            renderAreaAffect(g, x, y, TILEWIDTH, TILEHEIGHT, tileAreaEffect.getDecal().getWidth(), tileAreaEffect.getDecal().getHeight());
        }

    }

    public void renderTile(Graphics g, int xLocation, int yLocation, int tileWidth, int tileHeight) {
        g.drawImage(texture, xLocation, yLocation, tileWidth, tileHeight, null); //TILEWIDTH and TILEHEIGHT
    }

    public void renderAreaAffect(Graphics g, int xLocation, int yLocation, int tileWidth, int tileHeight, int decalWidth, int decalHeight) {
        tileAreaEffect.render(g, xLocation, yLocation,tileWidth, tileHeight, decalWidth, decalHeight);
    }

    public void renderItem(Graphics g, int xLocation, int yLocation, int tileWidth, int tileHeight, int itemWidth, int itemHeight) {
        if(items.size() == 1) {
            items.get(0).render(g, xLocation, yLocation);
        }
        else {
            g.drawImage(Assets.sack, xLocation + tileWidth/2 - itemWidth/2 , yLocation + tileHeight/2 - itemHeight/2, itemWidth, itemHeight, null);
        }
    }

    public void addPlayer(Player player){
        this.player = player;
        if(HasAreaEffect)
        {
            player.getStats().applyEffect(tileAreaEffect.getEffect());
        }
        for(int i = 0; i < items.size(); i++){ // loops through array of items to apply instant effects
            if(items.get(i).getType() == ItemsEnum.ONESHOT){
                player.getStats().applyEffect(items.get(i).getEffects());
                items.remove(i);
            }
        }
    }

    public void removePlayer(){
        this.player = null;
    }

    public void addItem(Item item) {
        if(item.getType() == ItemsEnum.OBSTACLE){
            isUnWalkable = true;
        }
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean hasItem() {
        return (items.size() > 0);

    }

    public Location getLocation() {
        return location;
    }

    public boolean isUnWalkable() {
        return isUnWalkable;
    }

    public void addAreaEffect(AreaEffect effect)
    {
        HasAreaEffect = true;
        tileAreaEffect = effect;
    }
}

