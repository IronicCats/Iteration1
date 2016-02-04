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
    public double duration;
    public String description;

    /*Default Constructor*/
    Effect(){
        modification = null;
        duration = 0;
        description = null;
    }

    /*Instant Effect Constructor*/
    Effect(StatStructure modification , String description){
        this.modification = modification;
        this.description = description;
        duration = 0;
    }

    /*Constructor*/
    Effect(StatStructure modification , double duration , String description){
        this.modification = modification;
        this.duration = duration;
        this.description = description;
    }


}
