package Model.Entity.Occupation;

import Model.Entity.Stats.StatStructure;
import Model.Entity.Stats.StatsEnum;

/**
 * Created by mazumderm on 2/3/2016.
 */
public class Occupation {

    private String name;
    private String description;
    private StatStructure initialStats;
    private StatStructure statMultiplier;

    Occupation(String name, String description, int[] val)
    {
        this.name = name;
        this.description = description;
        StatsEnum[] stats = new StatsEnum[]{StatsEnum.LIVES_LEFT, StatsEnum.STRENGTH,StatsEnum.AGILITY,
                                            StatsEnum.INTELLECT, StatsEnum.HARDINESS, StatsEnum.EXPERIENCE, StatsEnum.MOVEMENT};
        initialStats = new StatStructure(stats, val);
    }
}
