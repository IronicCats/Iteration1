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
         if(s&&(index==3&&weapon.isEquipped()||armor.armorReturn(index)!=null)){
            g.drawString("*PRESS Q TO UNEQUIP", width / 2, 9 * height / 12 + 35);
        }
        g.drawString("*PRESS SHIFT TO VIEW INV",width/2,9*height/12+60);
        g.drawString("*PRESS G OR ESCAPE TO EXIT",width/2,9*height/12+85);
    }

    // end constructor
} // end class Equipment
