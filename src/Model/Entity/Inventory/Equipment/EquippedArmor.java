package Model.Entity.Inventory.Equipment;

import Model.Item.Armor;
import Model.Item.Item;

/**
 * Created by broskj on 2/1/16.
 */
public class EquippedArmor {
    private Armor head,
                chest,
                pants,
                boots,
                gloves,
                accessory1,
                accessory2;
    private int totalDefense;

    EquippedArmor () {
        head = null;//new Armor();
        chest = null;//new Armor();
        pants = null;//new Armor();
        boots = null;//new Armor();
        gloves = null;//new Armor();
        accessory1 = null;//new Armor();
        accessory2 = null;//new Armor();
        totalDefense = 0;
    } // end constructor

    public void equipArmor(Item armor) {
        switch(armor.getArmorType()) {
            case HEAD:
                head=armor;
                break;
            case CHEST:
                chest=armor;
                break;
            case PANTS:
                pants=armor;
                break;
            case BOOTS:
                boots=armor;
                break;
            case GLOVES:
                gloves=armor;
                break;
            case ACCESSORY1:
                accessory1=armor;
                break;
            case ACCESSORY2:
                accessory2=armor;
                break;
            default:
                break;
        }
        totalDefense+=armor.getStat();
    }
    public Armor unequipArmor(int offset){
        Armor temp=null;
        switch(offset) {
            case 0:
                if(head==null)break;
                temp=new Armor(head);
                totalDefense -= head.getStat();
                head=null;
                break;
            case 1:
                if(head==null)break;
                temp=new Armor(chest);
                totalDefense -= chest.getStat();
                chest=null;
                break;
            case 2:
                if(head==null)break;
                temp=new Armor(pants);
                totalDefense -= pants.getStat();
                pants=null;
                break;
            case 3:
                if(head==null)break;
                temp=new Armor(boots);
                totalDefense -= boots.getStat();
                boots=null;
                break;
            case 4:
                if(head==null)break;
                temp=new Armor(gloves);
                totalDefense -= gloves.getStat();
                gloves=null;
                break;
            case 5:
                if(head==null)break;
                temp=new Armor(accessory1);
                totalDefense -=  accessory1.getStat();
                accessory1=null;
                break;
            case 6:
                if(head==null)break;
                temp=new Armor(accessory2);
                totalDefense -=  accessory2.getStat();
                accessory2=null;
                break;
            default:

                break;
        }
        return temp;
    }
    public int getTotalDefense() {
        return totalDefense; }
} // end class EquippedArmor
