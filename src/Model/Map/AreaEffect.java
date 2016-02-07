package Model.Map;

import Model.Entity.Stats.Effect;
import Model.Entity.Stats.StatStructure;
import Model.Entity.Stats.StatsEnum;
import Model.Location;
import Model.Map.Decal.Decal;

/**
 * Created by mazumderm on 2/6/2016.
 */
public class AreaEffect {
    String name;
    String description;
    Effect effect;
    //animation?
    Decal decal;
    Location location;
    AreaEffectEnum areaEffect;

    public AreaEffect(String name, String description, AreaEffectEnum areaEffect, Location location)
    {
       this.name = name;
       this.description = description;
       this.areaEffect = areaEffect;
       this.location = location;
       if(areaEffect == AreaEffectEnum.DAMAGE)// if its damaging area effect
       {
           StatStructure modification = new StatStructure(StatsEnum.LIFE, -5);
           effect = new Effect(modification,0, this.description);
       }
       else if(areaEffect == AreaEffectEnum.HEAL)// if its healing area effect
       {
           StatStructure modification = new StatStructure(StatsEnum.LIFE, 5);
           effect = new Effect(modification,0, this.description);
       }
       else if(areaEffect == AreaEffectEnum.DEATH)// if its a death effect
       {

       }
       else if(areaEffect == AreaEffectEnum.LEVELUP)// if its healing area effect
       {

       }
    }

    public void render()
    {

    }

}
