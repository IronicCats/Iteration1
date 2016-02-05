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
        super(image, id, location, type, name, description, effects, requirements);
    }

    // constructor in Item


    // needs access to player stats for requirements check
    public void onInteract(Player player) {
        if(this.requirements.hasItem(player) || this.requirements.meetsLevel(player)){ //If player has item or meets level
            //apply effect ?
            System.out.println("Player meets requirements to interact with Item");
            return;
        }else{
            System.out.println("Player does not meet Item's requirements");
            return;
        }

    }
}
