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
            if(itemType == ItemsEnum.USEABLE || itemType == ItemsEnum.ARMOR || itemType == ItemsEnum.WEAPON) {
                if(add((Takeable)tileItems.get(i))){
                    tileItems.remove(i);
                    //((Takeable) tileItems.get(i)).setLocation(new Location(-1,-1,0));
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


        int xCoord=width/2,yCoord=9*height/12+10;
        FontMetrics fm = g.getFontMetrics();
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        fm = g.getFontMetrics();
        int startY=3*height/4-10;int size=3*height/24+10;
        if(s) {
            if (pack.items[index] != null && (pack.items[index].getType() == ItemsEnum.WEAPON || pack.items[index].getType() == ItemsEnum.ARMOR)){
                g.drawImage(Assets.buttons.get(0), xCoord, yCoord, 64, 64, null);
                g.drawString("Equip", xCoord + 64/2 - fm.stringWidth("Equip")/2, yCoord + 60);
                xCoord += 64;
                g.setColor(Color.DARK_GRAY);
                g.fillRect(100,startY,width/2-125,size);
                //int startY=3*height/4-10;int size=3*height/24+10;
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 15));
                Item temp= pack.items[index];
                if(pack.items[index].getType() == ItemsEnum.ARMOR) {
                    g.setColor(Color.WHITE);
                    g.drawString("Armor Name: " + pack.items[index].getName(), 100, startY + size / 6);
                    g.drawString("Defence: " + ((Armor)temp).getStat(), 100, startY + size / 2);
                    g.drawString("Description: " + pack.items[index].getDescription(), 100, startY + 5 * size / 6);
                }
                else{
                    g.setColor(Color.WHITE);
                    g.drawString("Weapon Name: " + pack.items[index].getName(), 100, startY + size / 6);
                    g.drawString("Damage: " + ((Weapon)temp).getStat(), 100, startY + size / 2);
                    g.drawString("Description: " + pack.items[index].getDescription(), 100, startY + 5 * size / 6);
                }
            }
            else if (pack.items[index] != null && (pack.items[index].getType() == ItemsEnum.USEABLE)) {
                g.drawImage(Assets.buttons.get(0), xCoord, yCoord, 64, 64, null);
                g.drawString("Use", xCoord + 64 / 2 - fm.stringWidth("Use") / 2, yCoord + 60);
                xCoord += 64;
                g.setColor(Color.DARK_GRAY);
                g.fillRect(100,startY,width/2-125,size);
                //int startY=3*height/4-10;int size=3*height/24+10;
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 15));
                g.drawString("Item Name: "+pack.items[index].getName(),100,startY+size/6);
                //g.drawString("Defence: "+pack.items[index].getStat(),100,startY+size/2);
                g.drawString("Description: "+pack.items[index].getDescription(),100,startY+5*size/6);

            }
            if (pack.items[index] != null) {
                g.drawImage(Assets.buttons.get(4), xCoord, yCoord, 64, 64, null);
                g.drawString("Drop", xCoord + 64/2 - fm.stringWidth("Drop")/2, yCoord + 60);
                xCoord += 64;
                //g.setColor(Color.DARK_GRAY);
                //g.fillRect(100,startY,width/2-125,size);
                //int startY=3*height/4-10;int size=3*height/24+10;
                //g.setColor(Color.WHITE);
                //g.setFont(new Font("Arial", Font.BOLD, 15));
                //g.drawString("Armor Name: "+pack.items[index].getName(),100,startY+size/6);
                //g.drawString("Defence: "+pack.items[index].getStat(),100,startY+size/2);
                //g.drawString("Description: "+pack.items[index].getDescription(),100,startY+5*size/6);

            }
            g.setColor(Color.WHITE);
            String[] buttonText = {"","Escape", "Gear","Escape"};
            for(int i=1;i<=3;i++) {
                g.drawImage(Assets.buttons.get(i), xCoord, yCoord, 64, 64, null);
                g.drawString(buttonText[i], xCoord + 64 / 2 - fm.stringWidth(buttonText[i]) / 2, yCoord + 60);
                xCoord += 64;
            }
        }

    }

    public void getInput() {

    }

} // end class Inventory

