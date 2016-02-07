package Model.Item;

import Model.Entity.Stats.Effect;
import Model.Location;
import Model.Requirements;

import java.awt.image.BufferedImage;

/**
 * Created by Wimberley on 2/3/16.
 */

public abstract class Takeable extends Item{

    protected Location location;

    public Takeable(BufferedImage image, int id, Location location, ItemsEnum type, String name, String description, Effect[] effects, Requirements requirements) {
        super(image, id, location, type, name, description, effects, requirements);
    }


    // Used when added to inventory, dropped, or used by player
    public void setLocation(Location location) {
        this.location = location;
    }

    public abstract String toString();

}
