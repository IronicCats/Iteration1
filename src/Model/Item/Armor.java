package Model.Item;

import Model.Entity.Player;
import Model.Entity.Stats.Effect;
import Model.Location;
import Model.Requirements;

import java.awt.image.BufferedImage;

/**
 * Created by Wimberley on 2/4/16.
 */
public class Armor extends Equippable{

    //private
    public Armor(BufferedImage image, int id, Location location, ItemsEnum type, String name, String description, Effect[] effects, Requirements requirements, int stat) {
        super(image, id, location, type, name, description, effects, requirements, stat);
    }
    public Armor(Armor old){
        super(old);
    }

    @Override
    public void onInteract(Player player) {
        // if armor is hit?
    }
}
