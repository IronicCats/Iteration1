package Model.Entity.Inventory;

import Controller.Controller;
import Model.Entity.Entity;
import Model.Entity.Inventory.Equipment.Equipment;
import Model.Item.Equippable;
import Model.Item.Item;
import Model.Item.Takeable;
import Model.Item.*;
import javax.lang.model.type.NullType;
import java.awt.*;
import java.util.ArrayList;




/**
 * Created by broskj on 2/1/16.
 */
public class Inventory {
    private Pack pack;
    private Equipment equipment;
    private Controller controller;

    public Inventory(Controller controller) {
        this.pack = new Pack(16);
        this.equipment = new Equipment();
        this.controller = controller;
    }

    public Inventory(Pack pack, Equipment equipment) {
        this.pack = pack;
        this.equipment = equipment;

    } // end constructor

    public Pack getPack(){return pack;}
    public Equipment getEquipment(){return equipment;}

    public void saveInventory(ArrayList<Object> saveFile){
        saveFile.add(pack);
        //saveFile.add(equipment); //fixme

    }

    public void loadInventory(ArrayList<Object> saveFile, int count){
        Pack p = pack;
       Item a = InventoryList.checkItem((String)saveFile.get(count));
        //I NEED THE PACK SIZE TO BE SAVED IN SAVE BEFORE THE NAMES START GOING OK
        //THEN FOR LOOP THROUGH IT IN ORDER TO KNOW HOW LONG IT IS GOING
        //ADD IT TO THE PACK IN THE LOOP
        //OKAY

        //this.getPack().
    }



    public void store(ArrayList<Item> tileItems) {
        for(int i = tileItems.size()-1; i >=0; --i) {
            ItemsEnum itemType = tileItems.get(i).getType();
            if(itemType == ItemsEnum.USEABLE || itemType == ItemsEnum.ARMOR || itemType == ItemsEnum.WEAPON) {
                if(add((Takeable)tileItems.get(i))){
                    tileItems.remove(i);
                }
            }
        }
    }

    private boolean add(Takeable takeableItem) {

        if (pack.size != pack.cap) {
            for(int i = 0; i < pack.cap; ++i) {
                if(pack.items[i] == null) {
                    pack.items[i] = takeableItem;
                    pack.size++;
                    return true;
                }
            }
            System.out.println("Pack is not full, couldn't find empty slot.");
        }
        else {
            System.out.println("Pack is full.");
        }
        return false;
    }

    public void drop(int i) {                    //Takes in argument of takeable item
        if(i < pack.cap) {
            Takeable itemToDrop = pack.items[i];
            itemToDrop.setLocation(controller.getPlayer().getLocation());
            controller.getTiles(controller.getPlayer().getLocation()).addItem(itemToDrop);
            pack.items[i] = null;
            pack.size--;
        }
        else {
            System.out.println("Trying to drop item at index greater than pack capacity");
        }
    }

    public void use(int i){
        if( i < pack.cap) {
            if(pack.items[i].getType() == ItemsEnum.USEABLE) {
                controller.getPlayer().getStats().applyEffect(pack.items[i].getEffects());
                pack.items[i] = null;
                pack.size--;
            }
            else {
                System.out.println("Cannot use item of type not USABLE");
            }
        }
    }



    public void equip(int i){
        if(pack.items[i].getType() == ItemsEnum.WEAPON) {
            equipment.getWeapon().equipWeapon((Weapon)pack.items[i]);
        }
        else if(pack.items[i].getType() == ItemsEnum.ARMOR){
            equipment.getArmor().equipArmor((Armor)pack.items[i]);
        }
        else {
            System.out.println("Error: Trying to equip non-armor/weapon");
        }
    }
    public void unequip(int i){
        Equippable unequipped = equipment.unEquip(i);
        add(unequipped);
    }



    public void tick() {

    }

    public void render(Graphics g) {

    }

    public void getInput() {

    }

} // end class Inventory

