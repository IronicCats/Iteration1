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

    public void equipWeapon(Weapon old) {
        Weapon newWep=new Weapon(old);
        this.weapon = newWep;
        this.damage+=newWep.getStat();
    }
    public Weapon unequipWeapon(){
        if(weapon==null)return null;
        Weapon temp = new Weapon(weapon);
        damage -= weapon.getStat();
        weapon=null;
        return temp;
    }
    public boolean isEquipped(){
        if(weapon!=null)return true;
        else return false;
    }
    public Weapon getWeapon() {
        return weapon;
    }

    public int getDamage() {
        return damage;
    }

   public String toString()
    {
        String string;

        string = (weapon.getName() + "\n");

        return string;
    }
}
