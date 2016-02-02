package Model.Entity.Inventory;

import Model.Entity.Inventory.Equipment.Equipment;

/**
 * Created by broskj on 2/1/16.
 */
public class Inventory {
    private Pack pack;
    private Equipment equipment;

    Inventory(Pack pack, Equipment equipment) {
        this.pack = pack;
        this.equipment = equipment;
    } // end constructor

    public void store(Takeable item) {

    } // end store

    public void drop(Takeable item) {

    } // end drop

    public void use(Takeable item) {

    } // end use

    public void equipItem(Equippable item) {

    } // end equipItem
} // end class Inventory
