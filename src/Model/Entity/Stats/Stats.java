package Model.Entity.Stats;

import Controller.States.KillState;
import Controller.Controller;
import Controller.States.MenuState;
import Controller.States.State;
import Model.Entity.EquipmentStats;
import Model.Game;

import java.util.ArrayList;

/**
 * Created by broskj on 1/31/16.
 */
public class Stats {
    private PrimaryStats primaryStats;
    private DerivedStats derivedStats;
    private ArrayList<Effect> effects;
    private ArrayList<Long> finishTimes;
    public Controller controller;


    public Stats() {
        /*
        constructor used for loading
            on load game, need to create an instance of Stats then populate its components separately
         */
        this.primaryStats = new PrimaryStats();
        this.derivedStats = new DerivedStats(primaryStats);
        this.effects = new ArrayList<>();
        this.finishTimes = new ArrayList<>();
    } // end constructor

    public Stats(StatStructure ss, Controller controller) {
        /*
        default constructor used in entity creation - must be initialized with a StatStructure
         */
        primaryStats = new PrimaryStats(ss);
        derivedStats = new DerivedStats(primaryStats);
        effects = new ArrayList<>();
        finishTimes = new ArrayList<>();
        this.controller = controller;
       // this.controller = controller;
    } // end constructor

    public void levelUp() {
        /*
        calls levelup methods of each of its members
         */
        primaryStats.levelUp();
        derivedStats.levelUp();
    } // end levelUp

    public void kill() {
        /*
        kills the player; clears active effects (and finish times), calls kill methods of each of its members, and
         exits game if player is out of lives
         */
        effects.clear();
        finishTimes.clear();
        primaryStats.kill();
        derivedStats.kill();
        if(primaryStats.getLivesLeft() <= 0)
            State.setState(KillState.state);
        else{
            System.out.println("player is dead");
            System.out.println(controller.getMap().getSpawnX());
            System.out.println(controller.getMap().getSpawnY());
            //controller.getPlayer().setPixelX(controller.getPlayer().);
            //controller.getPlayer().setY(controller.getMap().getSpawnY());
            controller.getPlayer().getNavigation().setGoalX(controller.getMap().getSpawn().getPixelX());
            controller.getPlayer().getNavigation().setGoalY(controller.getMap().getSpawn().getPixelY());
        }
    } // end kill

    public void applyEffect(Effect e) {
        /*
        take in Effect and apply it to character

        USAGE:
            This method is passed an Effect (which contains a StatStructure array).  The StatStructure contains a list
             of the skills which are to be modified and by how much.

            The Effect's duration affects what happens when the Effect is applied.  If the duration is 0, then the
             effect is meant to happen instantaneously and not persist.  This is the case for taking damage or using
             mana, for example.  Other Effects with durations greater than zero are added to an ArrayList of Effects
             and its finish time (calculated as System.currentTimeInMillis() + duration) is added to a parallel
             ArrayList of system times.  The finish time is checked each game tick to check for expired Effects, and on
             expiration, the effect is removed by adding its negative value to its respective stat.

            The entire SS array is traversed (though its size is likely to be 1 outside of initial character creation),
             and at each element a switch statement will execute code unique to that stat, i.e. a StatStructure with
             one element containing the pair {Strength, 2} will add 2 to the Strength stat (with BaseStrength being
             retained) for the duration of the effect.

        DESIGNATED VALUES:
            The following StatStructure StatsEnum/Value pairs are unique:
                {StatsEnum.LEVEL, 1} -> Level Up (experience is set to 0)
                {StatsEnum.LIVES_LEFT, -1} -> Kill Player
         */
        if(e.duration > 0) {
            effects.add(e);
            finishTimes.add(System.currentTimeMillis() + e.duration);
        }

        for(StatsEnum s : e.modification.getKeySet()) {
            switch (s){
                // primary stats
                case LIVES_LEFT:
                    for(int i = 0; i < Math.abs(e.modification.getStat(s)); i++)
                        kill();
                    derivedStats.update();
                    break;
                case STRENGTH:
                    primaryStats.modifyStrength(e.modification.getStat(s));
                    derivedStats.update();
                    break;
                case AGILITY:
                    primaryStats.modifyAgility(e.modification.getStat(s));
                    derivedStats.update();
                    break;
                case INTELLECT:
                    primaryStats.modifyIntellect(e.modification.getStat(s));
                    derivedStats.update();
                    break;
                case HARDINESS:
                    primaryStats.modifyHardiness(e.modification.getStat(s));
                    derivedStats.update();
                    break;
                case EXPERIENCE:
                        primaryStats.modifyExperience(e.modification.getStat(s));
                    derivedStats.update();
                    break;
                case MOVEMENT:
                    primaryStats.modifyMovement(e.modification.getStat(s));
                    derivedStats.update();
                    break;
                // derived stats
                case LEVEL:
                    primaryStats.setExperience(0);
                    for(int i = 0; i < e.modification.getStat(s); i++)
                        levelUp();
                    break;
                case LIFE:
                    if(e.modification.getStat(s) + getLife() > getBaseLife())
                        derivedStats.setLife(getBaseLife());
                    else if(e.modification.getStat(s) + derivedStats.getLife() <= 0) {
                        kill();
                    }
                    else
                        derivedStats.modifyLife(e.modification.getStat(s));
                    break;
                case OFFENSIVE_RATING:
                    derivedStats.modifyOffensiveRating(e.modification.getStat(s));
                    break;
                case DEFENSIVE_RATING:
                    derivedStats.modifyDefensiveRating(e.modification.getStat(s));
                    break;
                case ARMOR_RATING:
                    derivedStats.modifyArmorRating(e.modification.getStat(s));
                    break;
                // default
                default:
                    break;
            }
        }
    } // end applyEffect

    public void applyEffect(Effect[] e) {
        /*
        take in Effect(s) and apply them to character
            passes to applyEffect(Effect e) one at a time
         */
        for(Effect i : e) {
            applyEffect(i);
        }
    } // end applyEffect

    public void removeEffect(Effect e) {
        /*
        removes the active effect

        In each game tick when Stats.tick() is called, the ArrayList containing finishTimes is traversed (in reverse)
         to check for expired Effects.  If the finishTime is greater than currentTimeInMillis, the effect is passed
         here to subtract the modification amount from its respective stat(s).
         */
        for(StatsEnum s : e.modification.getKeySet()) {
            switch (s){
                // primary stats
                case LIVES_LEFT:
                    primaryStats.modifyLivesLeft(-1 * e.modification.getStat(s));
                    derivedStats.update();
                    break;
                case STRENGTH:
                    primaryStats.modifyStrength(-1 * e.modification.getStat(s));
                    derivedStats.update();
                    break;
                case AGILITY:
                    primaryStats.modifyAgility(-1 * e.modification.getStat(s));
                    derivedStats.update();
                    break;
                case INTELLECT:
                    primaryStats.modifyIntellect(-1 * e.modification.getStat(s));
                    derivedStats.update();
                    break;
                case HARDINESS:
                    primaryStats.modifyHardiness(-1 * e.modification.getStat(s));
                    derivedStats.update();
                    break;
                case EXPERIENCE:
                    primaryStats.modifyExperience(-1 * e.modification.getStat(s));
                    derivedStats.update();
                    break;
                case MOVEMENT:
                    primaryStats.modifyMovement(-1 * e.modification.getStat(s));
                    derivedStats.update();
                    break;
                // derived stats
                case LEVEL:
                    derivedStats.modifyLevel(-1 * e.modification.getStat(s));
                    break;
                case LIFE:
                    derivedStats.modifyLife(-1 * e.modification.getStat(s));
                    break;
                case OFFENSIVE_RATING:
                    derivedStats.modifyOffensiveRating(-1 * e.modification.getStat(s));
                    break;
                case DEFENSIVE_RATING:
                    derivedStats.modifyDefensiveRating(-1 * e.modification.getStat(s));
                    break;
                case ARMOR_RATING:
                    derivedStats.modifyArmorRating(-1 * e.modification.getStat(s));
                    break;
                // default
                default:
                    break;
            }
        }
    } // end removeEffect

    public void tick() {
        /*
        Stats game tick.

        Each tick, check for expired Effects and check if player's XP is greater than the threshhold to level up
         */
        if (!effects.isEmpty()) {
            for (int i = effects.size()-1; i >= 0; --i) {
                if (System.currentTimeMillis() >= finishTimes.get(i)) {
                    removeEffect(effects.get(i));
                    effects.remove(i);
                    finishTimes.remove(i);
                }
            }
        }
        //check for level up
        if(primaryStats.getExperience() >= primaryStats.getXpThreshhold()) {
            System.out.println("Leveling up");
            levelUp();
        }
    } // end updateEffects

    public PrimaryStats getPrimaryStats(){return primaryStats;}
    public DerivedStats getDerivedStats(){return derivedStats;}

    public int getLivesLeft() { return primaryStats.getLivesLeft(); }
    public int getBaseLives() { return primaryStats.getBaseLives(); }
    public int getStrength() { return primaryStats.getStrength(); }
    public int getBaseStr() { return primaryStats.getBaseStr(); }
    public int getAgility() { return primaryStats.getAgility(); }
    public int getBaseAgi() { return primaryStats.getBaseAgi(); }
    public int getIntellect() { return primaryStats.getIntellect(); }
    public int getBaseIntel() { return primaryStats.getBaseIntel(); }
    public int getHardiness() { return primaryStats.getHardiness(); }
    public int getBaseHard() { return primaryStats.getBaseHard(); }
    public int getExperience() { return primaryStats.getExperience(); }
    public int getXpThreshold() { return primaryStats.getXpThreshhold(); }
    public int getMovement() { return primaryStats.getMovement(); }
    public int getBaseMovement() { return primaryStats.getBaseMovement(); }
    public int getLevel() { return derivedStats.getLevel(); }
    public int getLife() { return derivedStats.getLife(); }
    public int getBaseLife() { return derivedStats.getBaseLife(); }
    public int getMana() { return derivedStats.getMana(); }
    public int getBaseMana() { return derivedStats.getBaseMana(); }
    public int getOffensiveRating() { return derivedStats.getOffensiveRating(); }
    public int getDefensiveRating() { return derivedStats.getDefensiveRating(); }
    public int getArmorRating() { return derivedStats.getArmorRating(); }
    public EquipmentStats getEquipmentStats() { return primaryStats.getEquipmentStats(); }


    public String toString()
    {
        /*
        toString method for saving
         */
        String statString;
        statString = Integer.toString(getLivesLeft()) + "\n";
        statString = statString + Integer.toString(getBaseLives()) + "\n";
        statString = statString + Integer.toString(getStrength()) + "\n";
        statString = statString + Integer.toString(getBaseStr()) + "\n";
        statString = statString + Integer.toString(getAgility()) + "\n";
        statString = statString + Integer.toString(getBaseAgi()) + "\n";
        statString = statString + Integer.toString(getIntellect()) + "\n";
        statString = statString + Integer.toString(getBaseIntel()) + "\n";
        statString = statString + Integer.toString(getHardiness()) + "\n";
        statString = statString + Integer.toString(getBaseHard()) + "\n";
        statString = statString + Integer.toString(getExperience()) + "\n";
        statString = statString + Integer.toString(getMovement()) + "\n";
        statString = statString + Integer.toString(getBaseMovement()) + "\n";
        statString = statString + Integer.toString(getLevel()) + "\n";
        statString  = statString + Integer.toString(getLife()) + "\n";
        statString = statString + Integer.toString(getBaseLife()) + "\n";
        statString = statString + Integer.toString(getMana()) + "\n";
        statString = statString + Integer.toString(getBaseMana()) + "\n";
        statString = statString + Integer.toString(getOffensiveRating()) + "\n";
        statString = statString + Integer.toString(getDefensiveRating()) + "\n";
        statString = statString + Integer.toString(getArmorRating()) + "\n";
        //statString = statString + Integer.toString(getEquipmentStats()) + " ";

        return statString;
    }

} // end class Stats

