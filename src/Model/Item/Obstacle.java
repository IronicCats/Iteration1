package Model.Item;

import Model.Entity.Player;
import Model.Entity.Stats.Effect;
import Model.Location;
import Model.Requirements;

import java.awt.image.BufferedImage;

/**
 * Created by Peter Camejo on 2/3/16.
 */
public class Obstacle extends Item{

    int ITEMHEIGHT = 128; // Guesstimates
    int ITEMWIDTH = 128;



    public Obstacle(BufferedImage image, Location location, ItemsEnum type, String name, String description, Effect[] effects, Requirements requirements) {
        super(image, location, type, name, description, effects, requirements);

    }


    // needs access to player stats for requirements check
    public void onInteract(Player player){

    }

    public String toString()
    {
        String string;
        string = (this.location.getX() + " " + this.location.getY() + "\n");
        return string;
    }
}

