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

    public boolean isEquipped;
    private int stat;



    ArmorEnum armorType;

    public Equippable(BufferedImage image, int id, Location location, ItemsEnum type, String name, String description, Effect[] effects, Requirements requirements, int stat) {
        super(image, id, location, type, name, description, effects, requirements);
        this.stat=stat;
    }
    public Equippable(Equippable old){
        super(old.getImage(), old.getId(), old.getLocation(), old.getType(), old.getName(), old.getDescription(), old.getEffects(), old.getRequirements());
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
