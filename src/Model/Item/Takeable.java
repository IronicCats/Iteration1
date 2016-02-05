package Model.Item;

import Model.Entity.Stats.Effect;
import Model.Location;

import java.awt.image.BufferedImage;

/**
 * Created by Wimberley on 2/3/16.
 */

public abstract class Takeable extends Item{

    private Location location;

    // constructor in Item
    public Takeable(BufferedImage image, int id, Location location, ItemsEnum type, String name, String description, Effect[] effects) {
        super(image, id, location, type, name, description, effects);
    }


    // Used when added to inventory, dropped, or used by player
    public void setLocation(Location location) {
        this.location = location;
    }

    public void moveToInventory(){
        // move

    }
    public abstract String toString();
}
