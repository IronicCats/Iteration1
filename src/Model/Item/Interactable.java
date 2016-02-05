package Model.Item;

import Model.Entity.Player;
import Model.Entity.Stats.Effect;
import Model.Location;

import java.awt.image.BufferedImage;

/**
 * Created by Wimberley on 2/3/16.
 */
public class Interactable extends Item {

    int ITEMHEIGHT = 64; // Guesstimates
    int ITEMWIDTH = 64;

    // constructor in Item
    public Interactable(BufferedImage image, int id, Location location, ItemsEnum type, String name, String description, Effect[] effects) {
        super(image, id, location, type, name, description, effects);
    }    // needs access to player stats for requirements check

    public void onInteract(Player player){}

}
