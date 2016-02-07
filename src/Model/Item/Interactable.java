package Model.Item;

import Model.Entity.Player;
import Model.Entity.Stats.Effect;
import Model.Location;
import Model.Requirements;

import java.awt.image.BufferedImage;

/**
 * Created by Wimberley on 2/3/16.
 */
public class Interactable extends Item {

    int ITEMHEIGHT = 64; // Guesstimates
    int ITEMWIDTH = 64;

    public Interactable(BufferedImage image, int id, Location location, ItemsEnum type, String name, String description, Effect[] effects, Requirements requirements) {
        super(image, location, type, name, description, effects, requirements);
    }

    // constructor in Item



    public String toString()
    {
        String string;
        string = "";
        return string;
    }


    // needs access to player stats for requirements check
    public void onInteract(Player player) {

    }

}
