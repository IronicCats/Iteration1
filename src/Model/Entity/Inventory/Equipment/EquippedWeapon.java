package Model.Entity.Inventory.Equipment;

import Model.Item.Item;
import Model.Item.Weapon;

/**
 * Created by broskj on 2/1/16.
 */
public class EquippedWeapon {
    private Weapon weapon;
    private int damage;

    public EquippedWeapon(){
        weapon = null;//new Weapon();
        damage = 0;//weapon.getStat();
    }

    public void equipWeapon(Item weapon) {
        this.weapon = weapon;
        this.damage=weapon.getStat();
    }
    public Weapon unequipWeapon(){
        Weapon temp = new Weapon(weapon);
        weapon=null;
        return temp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getDamage() {
        return damage;
    }
}
