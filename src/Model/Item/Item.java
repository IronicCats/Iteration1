package Model.Item;

import Model.Location;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Wimberley on 2/2/16.
 */
public abstract class Item {

    //Same as Assets.width, Assets.height
    public static int ITEMWIDTH, ITEMHEIGHT;

    private BufferedImage image;

    /* id used to determine type of item
    0-19 --> takeable
        0-9 --> useable
        10-19 --> equippable
    20-29 --> oneshot
    30-39 --> interactable
    40-49 --> obstacle
     */
    public int id;
    public String name;
    public String description;
    public Location location;

    //Default Constructor
    public Item(){
        this.id = -1;
        this.name = null;
        this.description = null;
        this.location = null;
    }

    //Location and ID constructor
    public Item(int id , Location location){
        this.id = id;
        this.location =  location;
        this.name = null;
        this.description = null;
    }
    public abstract void onInteract(); // Do something

    public void render(Graphics g,int x, int y) { // render image of item
        g.drawImage( image, x , y, ITEMWIDTH, ITEMHEIGHT, null);
    }

}
