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

    private ArmorEnum armorType;

    public Armor(BufferedImage image, Location location, ItemsEnum type, String name, String description, Effect[] effects, Requirements requirements, int stat, ArmorEnum armorType) {
        super(image, location, type, name, description, effects, requirements, stat);
        this.armorType = armorType;
    }

    public Armor(Armor old){
        super(old);
        this.armorType = old.getArmorType();
    }

    @Override
    public void onInteract(Player player) {
        // if armor is hit?
    }

    public ArmorEnum getArmorType() {
        return armorType;
    }

    public String toString(){
        String string;

        string = (name + "\n");

        return string;
    }

}
