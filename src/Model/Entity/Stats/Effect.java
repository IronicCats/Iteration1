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
    public StatStructure modification;
    public long duration;
    public String description;

    /*Default Constructor*/
    public Effect(){
        duration = 0;
        description = null;
        modification = new StatStructure();
    }

    /*Constructor*/
    public Effect(StatStructure modification , long duration , String description){
        this.modification = modification;
        this.duration = duration;
        this.description = description;
    }
}
