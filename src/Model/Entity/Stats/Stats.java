package Model.Entity.Stats;

import Model.Entity.EquipmentStats;

import java.util.ArrayList;

/**
 * Created by broskj on 1/31/16.
 */
public class Stats {
    private PrimaryStats primaryStats;
    private DerivedStats derivedStats;
    private ArrayList<Effect> effects;
    private ArrayList<Long> finishTimes;

    public Stats() {

    } // end constructor

    Stats(StatStructure ss) {
        primaryStats = new PrimaryStats(ss);
        derivedStats = new DerivedStats(primaryStats);
        effects = new ArrayList<>();
        finishTimes = new ArrayList<>();
    } // end constructor

    public void levelUp() {
        primaryStats.levelUp();
        derivedStats.levelUp();
    }

    public void applyEffect(Effect e) {
        /*
        take in Effect and apply it to character
         */
        effects.add(e);
        finishTimes.add(System.currentTimeMillis() + e.duration);

        for(StatsEnum s : e.modification.getKeySet()) {
            switch (s){
                // primary stats
                case LIVES_LEFT:
                    primaryStats.modifyLivesLeft(e.modification.getStat(s));
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
                    derivedStats.modifyLevel(e.modification.getStat(s));
                    break;
                case LIFE:
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
         */
        for(Effect i : e) {
            applyEffect(i);
        }
    } // end applyEffect

    public void removeEffect(Effect e) {
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
        if(effects.isEmpty())
            return;
        for(int i = 0; i < effects.size(); i++) {
            if(System.currentTimeMillis() >= finishTimes.get(i)) {
                removeEffect(effects.get(i));
                effects.remove(i);
                finishTimes.remove(i);
            }
        }

        //check for level up
        if(primaryStats.getExperience() >= primaryStats.getXpThreshhold())
            levelUp();
    } // end updateEffects

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
        String statString;
        statString = Integer.toString(getLivesLeft()) + " ";
        statString = statString + Integer.toString(getBaseLives()) + " ";
        statString = statString + Integer.toString(getStrength()) + " ";
        statString = statString + Integer.toString(getBaseStr()) + " ";
        statString = statString + Integer.toString(getAgility()) + " ";
        statString = statString + Integer.toString(getBaseAgi()) + " ";
        statString = statString + Integer.toString(getIntellect()) + " ";
        statString = statString + Integer.toString(getBaseIntel()) + " ";
        statString = statString + Integer.toString(getHardiness()) + " ";
        statString = statString + Integer.toString(getBaseHard()) + " ";
        statString = statString + Integer.toString(getExperience()) + " ";
        statString = statString + Integer.toString(getMovement()) + " ";
        statString = statString + Integer.toString(getBaseMovement()) + " ";
        //statString = statString + Integer.toString(getEquipmentStats()) + " ";
        statString = statString + Integer.toString(getLevel()) + " ";
        statString  = statString + Integer.toString(getLife()) + " ";
        statString = statString + Integer.toString(getBaseLife()) + " ";
        statString = statString + Integer.toString(getMana()) + " ";
        statString = statString + Integer.toString(getBaseMana()) + " ";
        statString = statString + Integer.toString(getOffensiveRating()) + " ";
        statString = statString + Integer.toString(getDefensiveRating()) + " ";
        statString = statString + Integer.toString(getArmorRating()) + " \n";

        return statString;
    }

} // end class Stats

