package Model.Entity.Inventory.Equipment;

import Model.Entity.EquipmentStats;
import Model.Item.Equippable;
import Model.Item.ItemsEnum;
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
        equipmentStats = new EquipmentStats(this, armor.getTotalDefense(), weapon.getDamage(), null);
    }

    public Equippable unEquip(int i) {
        if (i != 3) {
            return armor.unequipArmor(i);
        } else if (i == 3) {
            return weapon.unequipWeapon();
        } else return null;
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

    public void render(int index, Graphics g, int x, int y, boolean s, int width, int height) {
        if (s) g.drawImage(Assets.emptyInvSelect, x, y, 64, 64, null);
        else g.drawImage(Assets.emptyInv, x, y, 64, 64, null);
        //System.out.print(index);

        if (index != 3 && armor.armorReturn(index) != null)
            g.drawImage(armor.armorReturn(index).getImage(), x, y, 64, 64, null);
        else if (index == 3 && weapon.getWeapon() != null)
            g.drawImage(weapon.getWeapon().getImage(), x, y, 64, 64, null);
        g.setFont(new Font("Arial", Font.BOLD, 20));
         if(s){
             int startY=3*height/4-10;int size=3*height/24+10;
             if(index==3&&weapon.isEquipped()){
                 g.drawString("*PRESS Q TO UNEQUIP", width / 2, 9 * height / 12 + 35);
                 g.setColor(Color.DARK_GRAY);
                 g.fillRect(100,startY,width/2-125,size);
                 //int startY=3*height/4-10;int size=3*height/24+10;
                 g.setColor(Color.WHITE);
                 g.setFont(new Font("Arial", Font.BOLD, 15));
                 g.drawString("Weapon Name: "+weapon.getWeapon().getName(),100,startY+size/6);
                 g.drawString("Damage: "+ weapon.getDamage(),100,startY+size/2);
                 g.drawString("Description: "+weapon.getWeapon().getDescription(),100,startY+5*size/6);
             }
            else if(armor.armorReturn(index)!=null) {
                 g.drawString("*PRESS Q TO UNEQUIP", width / 2, 9 * height / 12 + 35);
                 g.setColor(Color.DARK_GRAY);
                 g.fillRect(100,startY,width/2-125,size);
                 //int startY=3*height/4-10;int size=3*height/24+10;
                 g.setColor(Color.WHITE);
                 g.setFont(new Font("Arial", Font.BOLD, 15));
                 g.drawString("Armor Name: "+armor.armorReturn(index).getName(),100,startY+size/6);
                 g.drawString("Defence: "+armor.armorReturn(index).getStat(),100,startY+size/2);
                 g.drawString("Description: "+armor.armorReturn(index).getDescription(),100,startY+5*size/6);
            }
             g.setFont(new Font("Arial", Font.BOLD, 20));
        }
        g.drawString("*PRESS SHIFT TO VIEW INV",width/2,9*height/12+60);
        g.drawString("*PRESS G OR ESCAPE TO EXIT",width/2,9*height/12+85);
    }

    public String toString()
    {
        String s = null;
        if(getWeapon().isEquipped())
        {
            s = s + getWeapon().toString();
        }
        s = s + armor.getHead().toString();
        s = s + armor.getChest().toString();
        s = s + armor.getPants().toString();
        s = s + armor.getBoots().toString();
        s = s + armor.getGloves().toString();
        s = s + armor.getAccessory1().toString();
        s = s + armor.getAccessory2().toString();
        return s;
    }





    // end constructor
} // end class Equipment
