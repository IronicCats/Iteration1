package Model.Entity.Stats;


import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by broskj on 1/31/16.
 *
 * This is a class intended to be used to handle stat modifications and initial settings.
 */
public class StatStructure {
    private Map<StatsEnum, Integer> map;

    StatStructure() {
        map = new EnumMap<>(StatsEnum.class);
    } // end default constructor

    StatStructure(StatsEnum stat, int val) {
        map = new EnumMap<>(StatsEnum.class);
        map.put(stat, val);
    } // end single constructor

    StatStructure(StatsEnum[] stats, int[] vals){
        map = new EnumMap<>(StatsEnum.class);

        try{
            if(stats.length != vals.length)
                throw new IllegalArgumentException();
            for(int i = 0; i < stats.length; i++) {
                map.put(stats[i], vals[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // end multi constructor

    public void modifyStat(StatsEnum stat, int val) {
        map.put(stat, val);
    } // end modifyStat

    public void removeStat(StatsEnum stat) {
        map.remove(stat);
    } // end removeStat

    public int getStat(StatsEnum stat) {
        return map.get(stat);
    } // end getStat

    public Set<StatsEnum> getKeySet() { return map.keySet(); } // end getKeyset

    public int getSize() { return map.size(); }
} // end class StatStructure