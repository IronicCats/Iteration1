package Model.Entity.Stats;

/**
 * Created by Peter Camejo on 2/2/2016.
 *
 * Class is intended to act as a way to pass stat information changes to the Stats class.
 *
 * TODO: Change duration type from double to Seconds
 */
public class Effect {

    /*Variables*/
    private StatStructure stats; // Structure containing map with stat, value pair
    private long duration; // duration of effect
    private String description; // description of effect (not required)
    private int modification;
    private StatsEnum stat;


}
