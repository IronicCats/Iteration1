package Model.Entity.Inventory;

import Controller.Controller;
import Model.Entity.Entity;
import Model.Entity.Inventory.Equipment.Equipment;
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

    public void store(ArrayList<Item> tileItems) {
        for(int i = 0; i < tileItems.size(); ++i) {
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

     public Pack getPack() {
        return pack;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void tick() {

    }

    public void render(Graphics g) {

    }

    public void getInput() {

    }

} // end class Inventory

