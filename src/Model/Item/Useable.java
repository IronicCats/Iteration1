package Model.Item;

import Model.Entity.Player;
import Model.Entity.Stats.Effect;
import Model.Location;;

import java.awt.image.BufferedImage;

/**
 * Created by Wimberley on 2/3/16.
 */
public class Useable extends Takeable{

    // constructor in Item
    public Useable(BufferedImage image, int id, Location location, ItemsEnum type, String name, String description, Effect[] effects) {
        super(image, id, location, type, name, description, effects);
    }

    public void onInteract(Player player){
        player.getStats().applyEffect(this.getEffects());
        location = null;
    }
}
