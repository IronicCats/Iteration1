package Model.Entity.Inventory;

import Controller.Controller;
import Model.Entity.Entity;
import Model.Entity.Inventory.Equipment.Equipment;
import Model.Item.Item;
import Model.Item.Takeable;

/**
 * Created by broskj on 2/1/16.
 */
public class Inventory {
    private Pack pack;
    private Equipment equipment;



    private Controller controller;

    public Inventory(Controller controller, Pack pack, Equipment equipment) {
        this.pack = pack;
        this.equipment = equipment;
        this.controller = controller;
    }

    public void store(Item item) {
        if (pack.size != pack.cap) {
            pack.items[pack.size] = item;
            pack.size = pack.size + 1;
        }
    }

    public Item drop() {                    //Takes in argument of takeable item
        int i = 0;
        /*while(i < pack.size){              //<------ real code!!!
            if(item == pack.items[i]){
                Item temp = pack.items[i];
                pack.items[i] = null;
                return temp;
            }
            i++;
        }*/
        if(pack.size != 0){
            Item temp = pack.items[i];
            pack.items[i] = null;
            pack.size = pack.size - 1;
            return temp;
        }
        return null;
    }


   // public void store(Item item){


   // }
    public void drop(int offset){
    //controller.getTile
    }
    public void use(){

    }
    public void equip(int offset){
        if(offset>=8){
            equipment.getWeapon().equipWeapon(pack.items[offset]);
        }
        else{
            equipment.getArmor().equipArmor(pack.items[offset]);
        }
    }
    public void unequip(int offset){
        if(offset>=8){
            equipment.getWeapon().unequipWeapon();
        }
        else{
            equipment.getArmor().unequipArmor(offset);
        }
    }

     public Pack getPack() {
        return pack;
    }

    public Equipment getEquipment() {
        return equipment;
    } /*
    public void use(Takeable item) {

    } // end use

    public void equipItem(Equippable item) {

    } // end equipItem*/
} // end class Inventory

