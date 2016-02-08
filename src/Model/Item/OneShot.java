package Model.Item;

import Model.Entity.Player;
import Model.Entity.Stats.Effect;
import Model.Location;
import Model.Requirements;

import java.awt.image.BufferedImage;

/**
 * Created by Wimberley on 2/2/16.
 */
public class OneShot extends Item {


    public OneShot(BufferedImage image, Location location, ItemsEnum type, String name, String description, Effect[] effects, Requirements requirements) {
        super(image, location, type, name, description, effects, requirements);
    }

    public void onInteract(Player player) {
    }

    public String toString() {
        String string;
        string = (this.location.getX() + " " + this.location.getY() + "\n");
        return string;
    }

}
