package Model.Item;

import java.awt.*;
import java.awt.image.BufferedImage;

import Model.Entity.Stats.Effect;
import Model.Location;
import Model.Entity.Player;
import Model.Map.Tiles.Tile;
import Model.Requirements;

/**
 * Created by Wimberley on 2/2/16.
 */
public abstract class Item {

    public static int ITEMWIDTH = 28, ITEMHEIGHT = 28; // default height and width of item

    protected BufferedImage image; // image used for item

    protected ItemsEnum type;
    protected String name;
    protected String description;
    protected Location location;
    protected Effect []effects; // array of effects item can hold
    protected Requirements requirements; // used to tell if player can use/interact with item

    // constructor--> sets all variables except height and width
    public Item(BufferedImage image, Model.Location location, ItemsEnum type, String name, String description, Effect []effects, Requirements requirements){
        this.image = image;
        this.location = location;
        this.type = type;
        this.name = name;
        this.description = description;
        this.effects = effects;
        this.requirements = requirements;
        System.out.println("Requirements Item: " + requirements);
    }

    /* getter functions */
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Location getLocation(){return location;}

    public Effect[] getEffects() {
        return effects;
    }

    public ItemsEnum getType() {
        return type;
    }

    public BufferedImage getImage(){
        return image;
    }

    public Requirements getRequirements(){
        return requirements;
    }
    /* end getter functions */

    public abstract void onInteract(Player player); // OneShot, useable

    public void render(Graphics g,int x, int y) { // render image of item
        g.drawImage(image, x + Tile.TILEWIDTH/2 - ITEMWIDTH/2 , y + Tile.TILEHEIGHT/2 - ITEMHEIGHT/2, ITEMWIDTH, ITEMHEIGHT, null);
    }

    public abstract String toString();
}

