package Model.Item;

import Model.Entity.Player;

import java.awt.image.BufferedImage;

/**
 * Created by Wimberley on 2/3/16.
 */
public class Interactable extends Item {

    int ITEMHEIGHT = 64; // Guesstimates
    int ITEMWIDTH = 64;

    private BufferedImage image;

    // needs access to player stats for requirements check
    public void onInteract(Player player){

    }

}
