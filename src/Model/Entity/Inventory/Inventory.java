package Model.Entity.Inventory;

import Controller.Controller;
import Model.Entity.Entity;
import Model.Entity.Inventory.Equipment.Equipment;
import Model.Item.Equippable;
import Model.Item.Item;
import Model.Item.Takeable;
import Model.Item.*;
import View.Graphics.Assets;

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
        saveFile.add(Integer.toString(pack.getSize())+"\n");
        saveFile.add(pack);
        //saveFile.add(equipment); //fixme

    }

    public void loadInventory(ArrayList<Object> saveFile, int count){
        //count should be at 23, 23 should have the pack size

        Pack p = pack;
        int packSize = (int)saveFile.get(count);


        for(int i=0; i <= packSize;i++)
        {
            count++;
            Item a = InventoryList.checkItem((String)saveFile.get(count));
            p.add(a);
        }

        count++;



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
        if(i < pack.cap&&pack.items[i]!=null) {
            Takeable itemToDrop = pack.items[i];
            System.out.println(controller.getPlayer().getLocation());
            itemToDrop.setLocation(controller.getPlayer().getLocation());
            controller.getTiles(controller.getPlayer().getLocation()).addItem(itemToDrop);
            pack.items[i] = null;
            pack.size--;
        }
        else {
            System.out.println("Trying to drop item at index greater than pack capacity");
        }
    }
    public void interact(int i){
        if(pack.items[i].getType() == ItemsEnum.WEAPON ||(pack.items[i].getType() == ItemsEnum.ARMOR)){
            this.equip(i);
        }
        else if(pack.items[i].getType() == ItemsEnum.USEABLE) {
            this.use(i);
        }
    }
    public void use(int i){
        if( i < pack.cap&&pack.items[i]!=null) {
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
        if(pack.items[i].getType() == ItemsEnum.WEAPON&&pack.items[i]!=null) {
            equipment.getWeapon().equipWeapon((Weapon)pack.items[i]);
        }
        else if(pack.items[i].getType() == ItemsEnum.ARMOR&&pack.items[i]!=null){
            equipment.getArmor().equipArmor((Armor)pack.items[i]);
        }
        else {
            System.out.println("Error: Trying to equip non-armor/weapon");
        }
    }
    public void unequip(int i){
        Equippable unequipped = equipment.unEquip(i);
        if(unequipped!=null)add(unequipped);
    }



    public void tick() {

    }

    public void render(int index,Graphics g,int x, int y, boolean s) {
        //if(pack.items[index]==null){
        if(s)g.drawImage(Assets.emptyInvSelect,x,y,64,64,null);
        else g.drawImage(Assets.emptyInv,x,y,64,64,null);
            //System.out.print(index);
        //}
        //else{
        if(pack.items[index]!=null) {
            g.drawImage(pack.items[index].getImage(),x,y,64,64,null);
        }
    }

    public void getInput() {

    }

} // end class Inventory

