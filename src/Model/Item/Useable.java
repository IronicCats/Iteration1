package Model.Item;

import Model.Entity.Player;
import Model.Entity.Stats.Effect;
import Model.Location;
import Model.Requirements;;

import java.awt.image.BufferedImage;

/**
 * Created by Wimberley on 2/3/16.
 */
public class Useable extends Takeable{

    public Useable(BufferedImage image, Location location, ItemsEnum type, String name, String description, Effect[] effects, Requirements requirements) {
        super(image, location, type, name, description, effects, requirements);
    }


    public void onInteract(Player player){
        player.getStats().applyEffect(this.getEffects());
        location = null;
    }

    public String toString()
    {
        String string;
        string = (this.getName() + "\n");

        return string;
    }
}
