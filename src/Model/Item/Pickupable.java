package Model.Item;

import Model.Entity.Player;
import Model.Item.Takeable.Takeable;
import Model.Location;
import Model.Requirements;

import java.awt.image.BufferedImage;

/**
 * Created by broskj on 2/7/16.
 */
public class Pickupable extends Takeable {

    public Pickupable(BufferedImage image, Location location, ItemsEnum type, String name, String description, Requirements requirements) {
        super(image, location, type, name, description, null, requirements);
    }

    @Override
    public void onInteract(Player player) {

    }

    @Override
    public String toString() {
        String string;
        string = (this.getName() + "\n");

        return string;
    }
}
