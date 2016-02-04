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
    public StatStructure stats; // Structure containing map with stat, value pair
    public double duration; // duration of effect
    private String description; // description of effect (not required)
    private int modification;
    StatsEnum stat;

    /*Default Constructor*/
    public Effect(){
        stats = null;
        duration = 0;
        description = null;
    }

    /*Used for items*/
    public Effect(int id, String description, double duration){
        this.description = description;
        this.duration = duration;

        determineEffect(id, duration);
        // calls modify stat from statstructure and adds parameter adjustment to current value of stat
        stats.modifyStat(stat, stats.getStat(stat) +  modification);
    }

    /*Constructor*/
    public Effect(StatsEnum stat, String description, int adjustment, double duration ){
        this.stat = stat;
        this.duration = duration;
        this.description = description;
    }

    private void determineEffect(int id, double duration){
        switch(id){
            case(20): stat = StatsEnum.LIFE; // Lowers health by -5 (oneShot)
                      modification = -5;
                      break;
        }
    }
}
