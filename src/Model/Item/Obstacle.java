package Model.Item;

import Model.Location;

import javax.swing.*;

/**
 * Created by Peter Camejo on 2/3/16.
 */
public class Obstacle extends Item {

    private int id;   //Valid inputs 40-49
    private Location location;
    private String message;

    //Defualt Constructor
    public Obstacle() {
        id = 0;
        location = null;
        message = null;
    }

    //Default Message Constructor
    public Obstacle(int id, Location location){
        this.id = id;
        this.location = location;
        message = "An obstacle blocks your path.";
    }

    //Full Constructor
    public Obstacle(int id , Location location , String message){
        this.id = id;
        this.location = location;
        this.message = message;
    }

    public void onInteract(){
        javax.swing.JOptionPane.showMessageDialog(null , message);
        return;

    }
    public String toString()
    {
        String string;
        string = (this.id + " " + this.location.getX() + " " + this.location.getY() + "\n");
        return string;
    }
}