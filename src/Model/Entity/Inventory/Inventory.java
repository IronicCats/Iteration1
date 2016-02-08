package Model.Entity.Inventory;

import Controller.Controller;
import Model.Entity.Inventory.Equipment.Equipment;
import Model.Item.Equippable;
import Model.Item.Item;
import Model.Item.Takeable.Takeable;
import Model.Item.*;
import Model.Location;
import View.Graphics.Assets;

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

        saveFile.add(equipment); //fixme

    }

    public void loadInventory(ArrayList<Object> saveFile, int count){
        //count should be at 23, 23 should have the pack size

        Pack p = pack;
        Inventory b = new Inventory(pack,equipment);
        //System.out.print(saveFile.get(count) + "THIS IS WHAT IS AT 23");
        int packSize = (int)saveFile.get(count);
        //System.out.println(packSize +  " HEY THERE IS THIS MAN");


        for(int i=0; i <= packSize-1;i++)
        {
            count++;
            Item a = InventoryList.checkItem((String)saveFile.get(count));
            //System.out.println(a.getName() +" This is what is at " + count);
           // p.;
            b.add((Takeable)a);
        }

        count++;

        for(int j = count; j <= saveFile.size()-1; j++)
        {
            //saveFile.size();
            Item a = InventoryList.checkItem((String)saveFile.get(count));
            if(a.getType() == ItemsEnum.WEAPON) {
                b.equipment.getWeapon().equipWeapon((Weapon)a);
                count++;
            }
            else if(a.getType() == ItemsEnum.ARMOR)
            {
                System.out.println("YOU SHOULD BE EQUIPING");
                b.equipment.getArmor().equipArmor((Armor)a);
                count++;

            }
        }




    }



    public void store(ArrayList<Item> tileItems) {
        for(int i = tileItems.size()-1; i >=0; --i) {
            ItemsEnum itemType = tileItems.get(i).getType();
            if(itemType == ItemsEnum.USEABLE || itemType == ItemsEnum.ARMOR || itemType == ItemsEnum.WEAPON || itemType == ItemsEnum.PICKUPABLE) {
                if(add((Takeable) tileItems.get(i))){
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
                    takeableItem.setLocation(new Location(-1,-1,0));
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
            int x = controller.getPlayer().getLocation().getX();
            int y = controller.getPlayer().getLocation().getY();
            itemToDrop.setLocation(controller.getPlayer().getLocation());
            controller.getTiles(x,y).addItem(itemToDrop);
            pack.items[i] = null;
            pack.size--;
        }
        else {
            System.out.println("Trying to drop item at index greater than pack capacity");
        }
    }

    public void dropAll(){
        for(int i = 0; i < pack.cap; i++){
            if(pack.items[i]!=null){
                Takeable itemToDrop = pack.items[i];
                int x = controller.getPlayer().getLocation().getX();
                int y = controller.getPlayer().getLocation().getY();
                itemToDrop.setLocation(controller.getPlayer().getLocation());
                controller.getTiles(x,y).addItem(itemToDrop);
                pack.items[i] = null;
                pack.size--;
            }
        }
    }

    public void interact(int i){
        if(pack.items[i]==null)return;
        if(pack.items[i].getType() == ItemsEnum.WEAPON ||(pack.items[i].getType() == ItemsEnum.ARMOR)){
            this.equip(i);
        }
        else if(pack.items[i].getType() == ItemsEnum.USEABLE || pack.items[i].getType() == ItemsEnum.PICKUPABLE) {
            this.use(i);
        }
    }
    public void use(int i){
        if( i < pack.cap&&pack.items[i]!=null) {
            if(pack.items[i].getType() == ItemsEnum.USEABLE) {
                pack.items[i].onInteract(controller.getPlayer());
                //controller.getPlayer().getStats().applyEffect(pack.items[i].getEffects());
                pack.items[i] = null;
                pack.size--;
            } else if(pack.items[i].getType() == ItemsEnum.PICKUPABLE) {
                pack.items[i].onInteract(controller.getPlayer());
            }
            else {
                System.out.println("Cannot use item of type not USABLE");
            }
        }
    }

    public boolean contains(Takeable takeable) {
        for (int i = 0; i < pack.size; i++) {
            if(pack.items[i] != null)
                if(pack.items[i].getName().equals(takeable.getName()))
                    return true;
        }
        System.out.println("Inventory does not contain " + takeable);
        return false;
    } // end contains


    public void equip(int i){
        if(pack.items[i].getType() == ItemsEnum.WEAPON&&pack.items[i]!=null) {
            //System.out.println("This was a weapon");
            equipment.getWeapon().equipWeapon((Weapon)pack.items[i]);
            pack.items[i]=null;
            pack.size--;


        }
        else if(pack.items[i].getType() == ItemsEnum.ARMOR&&pack.items[i]!=null){
            //System.out.println("This was a an armor");
            equipment.getArmor().equipArmor((Armor)pack.items[i]);
            pack.items[i]=null;
            pack.size--;

            //System.out.println("this was a armor");
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

    public void render(int index,Graphics g,int x, int y, boolean s,int width,int height) {
        //if(pack.items[index]==null){
        if(s)g.drawImage(Assets.emptyInvSelect,x,y,64,64,null);
        else g.drawImage(Assets.emptyInv,x,y,64,64,null);
            //System.out.print(index);
        //}
        //else{
        if(pack.items[index]!=null) {
            g.drawImage(pack.items[index].getImage(),x,y,64,64,null);
        }
        if(s) {
            if (pack.items[index] != null && (pack.items[index].getType() == ItemsEnum.WEAPON || pack.items[index].getType() == ItemsEnum.ARMOR))
                g.drawString("*PRESS Q TO EQUIP", width / 2, 9 * height / 12 + 10);
            else if (pack.items[index] != null && (pack.items[index].getType() == ItemsEnum.USEABLE))
                g.drawString("*PRESS Q TO USE", width / 2, 9 * height / 12 + 10);
            if (pack.items[index] != null) g.drawString("*PRESS D TO DROP", width / 2, 9 * height / 12 + 35);
        }
        g.drawString("*PRESS SHIFT TO VIEW GEAR",width/2,9*height/12+60);
        g.drawString("*PRESS I OR ESCAPE TO EXIT",width/2,9*height/12+85);
    }

    public void getInput() {

    }

} // end class Inventory

