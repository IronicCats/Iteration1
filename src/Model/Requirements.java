package Model;

import Model.Entity.Player;
import Model.Item.Interactable;

/**
 * Created by Wimberley on 2/4/16.
 */
public class Requirements {

    private int requiredLevel;
    private Interactable requiredItem;

    public Requirements(int requiredLevel, Interactable requiredItem){
        this.requiredLevel = requiredLevel;
        this.requiredItem = requiredItem;
    }

    public boolean meetsLevel(Player player){
        if(requiredLevel >= player.getStats().getLevel()){
            return true;
        }
        else{return false;}
    }

    public boolean hasItem(Player player){
        //if(requiredItem == player.) //TODO: UPDATE BASED ON INVENTORY METHODS
        return false;
    }
}
