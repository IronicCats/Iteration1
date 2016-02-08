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
    public Armor armorReturn(int i){
        if(i==1&&head!=null) return head;
        else if(i==4&&chest!=null) return chest;
        else if(i==5&&gloves!=null) return gloves;
        else if(i==7&&pants!=null) return pants;
        else if(i==9&&accessory1!=null) return accessory1;
        else if(i==10&&boots!=null) return boots;
        else if(i==11&&accessory2!=null) return accessory2;
        else return null;
    }
    public void equipArmor(Armor old) {
        Armor armor=new Armor(old);
        switch(armor.getArmorType()) {
            case HEAD:
                head=armor;
                System.out.println("this was head");
                break;
            case CHEST:
                chest=armor;
                System.out.println("this was chest");
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
    public Armor unequipArmor(int index){
        Armor temp=null;
        switch(index) {
            case 1:
                if(head==null)break;
                temp=new Armor(head);
                totalDefense -= head.getStat();
                head=null;
                break;
            case 4:
                if(chest==null)break;
                temp=new Armor(chest);
                totalDefense -= chest.getStat();
                chest=null;
                break;
            case 7:
                if(pants==null)break;
                temp=new Armor(pants);
                totalDefense -= pants.getStat();
                pants=null;
                break;
            case 10:
                if(boots==null)break;
                temp=new Armor(boots);
                totalDefense -= boots.getStat();
                boots=null;
                break;
            case 5:
                if(gloves==null)break;
                temp=new Armor(gloves);
                totalDefense -= gloves.getStat();
                gloves=null;
                break;
            case 9:
                if(accessory1==null)break;
                temp=new Armor(accessory1);
                totalDefense -=  accessory1.getStat();
                accessory1=null;
                break;
            case 11:
                if(accessory2==null)break;
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
