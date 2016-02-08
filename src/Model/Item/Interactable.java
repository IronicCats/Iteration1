package Model.Item;

import Model.Entity.Inventory.Inventory;
import Model.Entity.Inventory.Pack;
import Model.Entity.Player;
import Model.Entity.Stats.Effect;
import Model.Item.Takeable.Takeable;
import Model.Location;
import Model.Requirements;
import jdk.nashorn.internal.runtime.UserAccessorProperty;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Wimberley on 2/3/16.
 */
public class Interactable extends Item {

    int ITEMHEIGHT = 64; // Guesstimates
    int ITEMWIDTH = 64;

    public Interactable(BufferedImage image, Location location, ItemsEnum type, String name, String description, Effect[] effects, Requirements requirements) {
        super(image, location, type, name, description, effects, requirements);
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
        if(this.requirements.meetsRequirements(player)) {
            System.out.println("requirement met");
            ArrayList<Item> chestItems = new ArrayList<>();
            chestItems.add(InventoryList.createHealthPotion(player.getLocation()));
            chestItems.add(InventoryList.createHealthPotion(player.getLocation()));
            chestItems.add(InventoryList.createHealthPotion(player.getLocation()));
            int index = player.getInventory().getPack().indexOf(requirements.getItemRequirement());
            if(index != -1)
                player.getInventory().drop(index);
            player.getInventory().store(chestItems);
        } else {
            System.out.println("requirement not met");
        }
    }

}
