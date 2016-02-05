package Model.Item;

import java.awt.*;
import java.awt.image.BufferedImage;
import Model.Entity.Stats.Effect;
import Model.Location;
import Model.Entity.Player;

/**
 * Created by Wimberley on 2/2/16.
 */
public abstract class Item {

    public static int ITEMWIDTH, ITEMHEIGHT = 28; // default height and width of item

    private BufferedImage image; // image used for item

    private ItemsEnum type;
    private static int id;
    private String name;
    private String description;
    protected Location location;
    private Effect [] effects; // array of effects item can hold

    // constructor--> sets all variables except height and width
    public Item(BufferedImage image, int id, Model.Location location, ItemsEnum type, String name, String description, Effect [] effects){
        this.image = image;
        this.id = id;
        this.location = location;
        this.type = type;
        this.name = name;
        this.description = description;
        this.effects = effects;
    }

    /* getter functions */
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Effect[] getEffects() {
        return effects;
    }

    public ItemsEnum getType() {
        return type;
    }
    /* end getter functions */

    public abstract void onInteract(Player player); // OneShot, useable


    public void render(Graphics g,int x, int y) { // render image of item
        g.drawImage( image, x , y, ITEMWIDTH, ITEMHEIGHT, null);
    }

}