package Model.Entity.Inventory.Equipment;

import Model.Entity.EquipmentStats;
import Model.Item.Equippable;

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
        if(i < 8) {
            return armor.unequipArmor(i);
        } else if(i == 8) {
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



    // end constructor
} // end class Equipment
