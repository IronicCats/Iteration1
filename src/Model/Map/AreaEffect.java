package Model.Map;

import Model.Entity.Stats.Effect;
import Model.Entity.Stats.StatStructure;
import Model.Entity.Stats.StatsEnum;
import Model.Location;
import Model.Map.Decal.Decal;
import Model.Map.Decal.DecalEnum;
import View.Graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by mazumderm on 2/6/2016.
 */
public class AreaEffect {
    String name;
    String description;
    Effect effect;
    //animation?
    Location location;
    AreaEffectEnum areaEffect;
    Decal decal;

    //constructor
    public AreaEffect(String name, String description, AreaEffectEnum areaEffect)
    {
       this.name = name;
       this.description = description;
       this.areaEffect = areaEffect;
       if(areaEffect == AreaEffectEnum.DAMAGE)// if its damaging area effect
       {
           StatStructure modification = new StatStructure(StatsEnum.LIFE, -5);
           effect = new Effect(modification,0, this.description);
           decal = new Decal(Assets.skullAndBones,"Healing point", "You get plus 5 health", this.location, DecalEnum.SKULLANDCROSSBONES);
       }
       else if(areaEffect == AreaEffectEnum.HEAL)// if its healing area effect
       {
           StatStructure modification = new StatStructure(StatsEnum.LIFE, 5);
           effect = new Effect(modification,0, this.description);
           decal = new Decal(Assets.redCross,"Healing point", "You get plus 5 health", this.location, DecalEnum.REDCROSS);
       }
       else if(areaEffect == AreaEffectEnum.DEATH)// if its a death effect
       {
           StatStructure modification = new StatStructure(StatsEnum.LIVES_LEFT, -1);
           effect = new Effect(modification,0, this.description);
           decal = new Decal(Assets.skullAndBones,"Death point", "Die", this.location, DecalEnum.SKULLANDCROSSBONES);
       }
       else if(areaEffect == AreaEffectEnum.LEVELUP)// if its healing area effect
       {
           StatStructure modification = new StatStructure(StatsEnum.LEVEL, 1);
           effect = new Effect(modification,0, this.description);
           decal = new Decal(Assets.goldStar,"Level Up", "You get another level", this.location, DecalEnum.GOLDSTAR);
       }
    }

    //accesor methods
    public String getDescription() {return description;}

    public String getName() {return name;}

    public AreaEffectEnum getAreaEffect() {return areaEffect;}

    public Location getLocation() {return location;}

    public Effect getEffect() {return effect;}

    //render method
    public void render(Graphics g, int x, int y)
    {
        decal.render(g, x, y);
    }

}
