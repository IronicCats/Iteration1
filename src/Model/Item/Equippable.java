package Model.Item;

import Model.Entity.Stats.Effect;
import Model.Location;

import java.awt.image.BufferedImage;
import Model.Entity.Player;
import Model.Requirements;

/**
 * Created by Wimberley on 2/4/16.
 */
public abstract class Equippable extends Takeable {

    private int stat;
    //ArmorEnum armorType;

    public Equippable(BufferedImage image, Location location, ItemsEnum type, String name, String description, Effect[] effects, Requirements requirements, int stat) {
        super(image, location, type, name, description, effects, requirements);
    }

    public Equippable(Equippable old){
        super(old.getImage(), old.getLocation(), old.getType(), old.getName(), old.getDescription(), old.getEffects(), old.getRequirements());
        this.stat=old.getStat();
        //this.armorType=old.getArmorType();
    }

    public int getStat() {
        return stat;
    }

    public void equipItem(Player player){
        // equip
    }

}
