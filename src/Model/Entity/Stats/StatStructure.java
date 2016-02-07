package Model.Entity.Stats;


import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by broskj on 1/31/16.
 *
 * This is a class intended to be used to handle stat modifications and initial settings.
 *
 * In general, a StatStructure contains a mapping of a skill to a value.  You can use this to:
 *      initialize an entity's stats
 *      create an effect to apply on an entity (i.e. a stat boost, damage, grant experience, ...)
 *      create an array of effects to apply on an entity
 * A StatStructure mapping looks like:
 *      {StatsEnum.STAT, (int)value}
 *  where STAT is the stat you wish to modify (either Primary or Derived) and value is an integer modifier to apply on
 *  that stat.  Value can be negative (in the case of taking damage -> subtracting amount from health)
 *
 * Use a StatStructure when you want to:
 *      create a player
 *      damage/heal an entity
 *      apply an Effect on an entity:
 *          restore health, mana
 *          increase stat (Strength, Agility, ...)
 *      apply an AreaEffect:
 *          kill player
 *          level the player up
 *          apply damage-over-time
 *      modify an entity's stats in any other way
 *
 * To create a StatStructure:
 *      initialize an empty StatStructure and use modifyStat() to add/replace modifier
 *      initialize a StatStructure with a single modifier (can add/replace/remove later)
 *      initialize a StatStructure with an array of modifiers (each of which can be replaced/removed and you can still
 *       add new ones)
 */
public class StatStructure {
    private Map<StatsEnum, Integer> map;

    public StatStructure() {
        map = new EnumMap<>(StatsEnum.class);
    } // end default constructor

    public StatStructure(StatsEnum stat, int val) {
        /*
        constructor for single stat modifier
         */
        map = new EnumMap<>(StatsEnum.class);
        map.put(stat, val);
    } // end single constructor

    public StatStructure(StatsEnum[] stats, int[] vals){
        /*
        constructor for multiple stat modifiers
         */
        map = new EnumMap<>(StatsEnum.class);
        for(int i = 0; i < stats.length; i++) {
            map.put(stats[i], vals[i]);
        }
    } // end multi constructor

    public void modifyStat(StatsEnum stat, int val) {
        /*
        add or replace existing stat modifier
         */
        map.put(stat, val);
    } // end modifyStat

    public void removeStat(StatsEnum stat) {
        /*
        remove stat modifier with key=stat
         */
        map.remove(stat);
    } // end removeStat

    public int getStat(StatsEnum stat) {
        /*
        return value associated with key=stat
         */
        return map.get(stat);
    } // end getStat

    public Set<StatsEnum> getKeySet() { return map.keySet(); } // end getKeyset

    public int getSize() { return map.size(); }
} // end class StatStructure