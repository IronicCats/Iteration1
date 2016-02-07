package Model.Item;

import Model.Entity.Player;
import Model.Entity.Stats.Effect;
import Model.Location;
import Model.Requirements;

import java.awt.image.BufferedImage;

/**
 * Created by Wimberley on 2/4/16.
 */
public class Armor extends Equippable{


    ArmorEnum armorType;
    //private
    public Armor(BufferedImage image, int id, Location location, ItemsEnum type, String name, String description, Effect[] effects, Requirements requirements, int stat, ArmorEnum ArmorType) {
        super(image, id, location, type, name, description, effects, requirements, stat);
        this.armorType=ArmorType;
    }
    public Armor(Armor old){
        super(old);
        this.armorType=old.getArmorType();
    }

    @Override
    public void onInteract(Player player) {
        // if armor is hit?
    }

    public String toString(){
        String string;
        string = (this.getId() + " " + this.getLocation().getX() + " " + this.getLocation().getY() + "\n");
        return string;

    }
    public ArmorEnum getArmorType() {
        return armorType;
    }
}
