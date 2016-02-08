package Model.Item.Takeable;

import Model.Entity.Stats.Effect;
import Model.Item.Item;
import Model.Item.ItemsEnum;
import Model.Location;
import Model.Requirements;

import java.awt.image.BufferedImage;

/**
 * Created by Wimberley on 2/3/16.
 */

public abstract class Takeable extends Item {

    protected int stat;

    public Takeable(BufferedImage image, Location location, ItemsEnum type, String name, String description, Effect[] effects, Requirements requirements) {
        super(image, location, type, name, description, effects, requirements);
    }

    // Used when added to inventory, dropped, or used by player
    public void setLocation(Location location) {
        this.location = location;
    }

    public abstract String toString();

}
