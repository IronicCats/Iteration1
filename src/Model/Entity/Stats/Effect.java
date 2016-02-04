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
    private int val;
    private StatsEnum stat;

    /*Default Constructor*/
    public Effect(){
        duration = 0;
        description = null;
        val = 0;
    } // end constructor

    /*Used for items*/
    public Effect(int id, String description, long duration){
        this.description = description;
        this.duration = duration;
        val = 0;

        determineEffect(id, duration);
        // calls modify stat from statstructure and adds parameter adjustment to current value of stat
        modification.modifyStat(stat, val);

    } // end

    private void determineEffect(int id, double duration){
        switch(id){
            case(20): stat = StatsEnum.LIFE; // Lowers health by -5 (oneShot)
                      val = -5;
                      break;
        }
    }
}
