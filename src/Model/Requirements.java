package Model;

import Model.Entity.Player;
import Model.Item.Takeable.Takeable;

/**
 * Created by Wimberley on 2/4/16.
 */
public class Requirements {

    private int requiredLevel;
    private Takeable requiredItem;

    // default constructor
    public Requirements(){
    }

    // constructor if Item is needed
    public Requirements(Takeable requiredItem){
        this.requiredItem = requiredItem;
        this.requiredLevel = -1;
    }

    // constructor if certain level is needed
    public Requirements(int requiredLevel){

        this.requiredLevel = requiredLevel;
        this.requiredItem = null;
    }

    // constructor if level and item is required
    public Requirements(int requiredLevel, Takeable requiredItem){

        this.requiredLevel = requiredLevel;
        this.requiredItem = requiredItem;
    }

    public boolean meetsRequirements(Player player) {
        if(requiredItem != null && requiredLevel != -1) {
            /*
            needs both level and item requirement
             */
            if(meetsLevel(player) && hasItem(player))
                return true;
        } else if (requiredItem != null) {
            /*
            needs only item requirement
             */
            if(hasItem(player))
                return true;
        } else if (requiredLevel != -1) {
            /*
            needs only level requirement
             */
            if(meetsLevel(player))
                return true;
        }
        return false;
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
        if(player.getInventory().contains(requiredItem))
            return true;
        return false;
    }

    public String toString() {
        String s;
        if(requiredLevel== -1)
            s = requiredItem.toString();
        else
            s = Integer.toString(requiredLevel);
        return s;
    } // end toString

    public int getLevelRequirement() {
        return requiredLevel;
    }

    public String getItemRequirement() {
        return requiredItem.getName();
    }
}
