package Model.Entity.Inventory;

import Model.Entity.Inventory.Equipment.Equipment;
import Model.Item.Item;
import Model.Item.Takeable;

/**
 * Created by broskj on 2/1/16.
 */
public class Inventory {
    private Pack pack;
    private Equipment equipment;

    public Inventory(Pack pack, Equipment equipment) {
        this.pack = pack;
        this.equipment = equipment;
    } // end constructor

    public void store(Item item) {
        if(pack.size != pack.cap){
        pack.items[pack.size] = item;
    } // end store
    /*

    public void drop(Takeable item) {

    } // end drop

    public void use(Takeable item) {

    } // end use

    public void equipItem(Equippable item) {

    } // end equipItem*/
} // end class Inventory
 }
