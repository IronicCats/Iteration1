package Model;

import Model.Entity.Player;
import Model.Item.Interactable;

/**
 * Created by Wimberley on 2/4/16.
 */
public class Requirements {

    private int requiredLevel;
    private Interactable requiredItem;

    // default constructor
    public Requirements(){
    }

    // constructor if Item is needed
    public Requirements(Interactable requiredItem){
        this.requiredItem = requiredItem;
    }

    // constructor if certain level is needed
    public Requirements(int requiredLevel){
        this.requiredLevel = requiredLevel;
    }

    // constructor if level and item is required
    public Requirements(int requiredLevel, Interactable requiredItem){
        this.requiredLevel = requiredLevel;
        this.requiredItem = requiredItem;
    }

    // check if player's level is high enough
    public boolean meetsLevel(Player player){
        if(requiredLevel >= player.getStats().getLevel()){
            return true;
        }
        else{return false;}
    }

    // check if player has required item
    public boolean hasItem(Player player){
        //if(requiredItem == player.) //TODO: UPDATE BASED ON INVENTORY METHODS
        return false;
    }
}
