package Model.Item;

import Model.Entity.Stats.Effect;
import Model.Location;

import java.awt.image.BufferedImage;
import Model.Entity.Player;

/**
 * Created by Wimberley on 2/4/16.
 */
public abstract class Equippable extends Takeable {

    public boolean isEquipped;

    public Equippable(BufferedImage image, int id, Location location, ItemsEnum type, String name, String description, Effect[] effects) {
        super(image, id, location, type, name, description, effects);
    }

    public void equipItem(Player player){
        // equip
    }
}
