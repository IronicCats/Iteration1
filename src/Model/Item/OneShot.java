package Model.Item;

import Model.Entity.Player;
import Model.Entity.Stats.Effect;
import Model.Location;

import java.awt.image.BufferedImage;

/**
 * Created by Wimberley on 2/2/16.
 */
public class OneShot extends Item {

    int ITEMHEIGHT = 28; // Guesstimates
    int ITEMWIDTH = 28;
    Effect effect;

    private int id;
    private Location location;


    private BufferedImage image;

    // constructor
    public OneShot(int id, Location location, Effect effect){
        this.id = id; // id --> 20-29
        this.location = location;
    }


    public void onInteract(Player player){
        player.getStats().applyEffect(effect);
        location = null;
    }
}
