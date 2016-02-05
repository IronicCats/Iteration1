package Model.Item;

import Model.Entity.Player;
import Model.Entity.Stats.Effect;
import Model.Location;
import Model.Entity.Player;

import java.awt.image.BufferedImage;

/**
 * Created by Wimberley on 2/4/16.
 */
public class Weapon extends Equippable {

    // constructor in Item
    public Weapon(BufferedImage image, int id, Location location, ItemsEnum type, String name, String description, Effect[] effects) {
        super(image, id, location, type, name, description, effects);
    }

    @Override
    public void onInteract(Player player) {
        // swing weapon?
    }
}
