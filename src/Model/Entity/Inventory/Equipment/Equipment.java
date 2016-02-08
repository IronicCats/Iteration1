package Model.Entity.Inventory.Equipment;

import Model.Entity.EquipmentStats;
import Model.Item.Equippable;
import Model.Item.Weapon;
import View.Graphics.Assets;

import java.awt.*;

/**
 * Created by broskj on 2/1/16.
 */
public class Equipment {
    private EquippedWeapon weapon;
    private EquippedArmor armor;
    private EquipmentStats equipmentStats;
    public Equipment() {
        weapon = new EquippedWeapon();
        armor = new EquippedArmor();
        equipmentStats = new EquipmentStats(this, armor.getTotalDefense(),weapon.getDamage(),null);
    }

    public Equippable unEquip(int i) {
        if(i !=3 ) {
            return armor.unequipArmor(i);
        } else if(i == 3) {
            return weapon.unequipWeapon();
        }
        else return null;
    }

    public EquippedWeapon getWeapon() {
        return weapon;
    }

    public EquippedArmor getArmor() {
        return armor;
    }

    public EquipmentStats getEquipmentStats() {
        return equipmentStats;
    }

    public void render(int index, Graphics g, int x, int y, boolean s){
        if(s)g.drawImage(Assets.emptyInvSelect,x,y,64,64,null);
        else g.drawImage(Assets.emptyInv,x,y,64,64,null);
        //System.out.print(index);
        if(index!=3&&armor.rReturn(index)!=null) g.drawImage(armor.rReturn(index).getImage(),x,y,64,64,null);
        else if(index==3&&weapon.getWeapon()!=null) g.drawImage(weapon.getWeapon().getImage(),x,y,64,64,null);
    }

    public String toString()
    {
        String s = "";
        if(getWeapon().isEquipped())
        {
            s = s + weapon.toString();
        }
        if(armor.getHead() != null)
         s = s + armor.getHead().toString();
        if(armor.getChest() != null)
            s = s + armor.getChest().toString();
        if(armor.getHead() != null)
            s = s + armor.getPants().toString();
        if(armor.getBoots() != null)
        s = s + armor.getBoots().toString();
        if(armor.getGloves() != null)
        s = s + armor.getGloves().toString();
        if(armor.getAccessory1() != null)
        s = s + armor.getAccessory1().toString();
        if(armor.getAccessory2() != null)
        s = s + armor.getAccessory2().toString();
        return s;
    }



    // end constructor
} // end class Equipment
