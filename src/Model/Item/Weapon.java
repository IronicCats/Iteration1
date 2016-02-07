package Model.Item;

import Model.Entity.Player;
import Model.Entity.Stats.Effect;
import Model.Location;
import Model.Requirements;

import java.awt.image.BufferedImage;

/**
 * Created by Wimberley on 2/4/16.
 */
public class Weapon extends Equippable {

    private WeaponEnum weaponType;

    public Weapon(BufferedImage image, Location location, ItemsEnum type, String name, String description, Effect[] effects, Requirements requirements, int stat, WeaponEnum weaponType) {
        super(image, location, type, name, description, effects, requirements, stat);
        this.weaponType = weaponType;
    }

    public Weapon(Weapon old){
        super(old);
        this.weaponType = old.getWeaponType();
    }

    public WeaponEnum getWeaponType() {
        return weaponType;
    }

    @Override
    public void onInteract(Player player) {
        // swing weapon?
    }

    public String toString(){
        String string;

        string = (this.getName() + "\n");

        return string;

    }
}
