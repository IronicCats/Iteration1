package Model.Item;

import Model.Entity.Inventory.Inventory;
import Model.Entity.Inventory.Pack;
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

    public Interactable(BufferedImage image, Location location, ItemsEnum type, String name, String description, Effect[] effects, Requirements requirements) {
        super(image, location, type, name, description, effects, requirements);
        System.out.println("interactable created -> name: " + name + ", requirements: " + requirements);
    }

    // constructor in Item

    public String toString()
    {
        String string;
        string = name + "\n";
        return string;
    }


    // needs access to player stats for requirements check
    public void onInteract(Player player) {
        System.out.println("requirements are " + this.requirements);
        System.out.println("interactable -> interact called");
        if(this.requirements.meetsRequirements(player)) {
            System.out.println("requirement met");
        }
        System.out.println("requirement not met");
    }

}
