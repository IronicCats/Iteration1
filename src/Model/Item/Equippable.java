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

    public Equippable(BufferedImage image, Location location, ItemsEnum type, String name, String description, Effect[] effects, Requirements requirements) {
        super(image, location, type, name, description, effects, requirements);
    }

    public Equippable(BufferedImage image, Location location, ItemsEnum type, String name, String description, Effect[] effects, Requirements requirements, int stat){
        super(image, location, type, name, description, effects, requirements);
        this.stat = stat;
    }

    public Equippable(Equippable old){
        super(old.getImage(), old.getLocation(), old.getType(), old.getName(), old.getDescription(), old.getEffects(), old.getRequirements());
        this.stat=old.getStat();
    }

    public int getStat() {
        return stat;
    }
}
