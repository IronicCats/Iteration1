package Model.Entity.Stats;

/**
 * Created by broskj on 1/31/16.
 */
public class Stats {
    private PrimaryStats primaryStats;
    private DerivedStats derivedStats;

    Stats(StatStructure ss) {
        primaryStats = new PrimaryStats(ss);
        derivedStats = new DerivedStats(primaryStats);
    } // end constructor

    public void levelUp() {
        primaryStats.levelUp();
        derivedStats.levelUp();
    }

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
    public int getEquipmentStats() { return primaryStats.getEquipmentStats(); }
    public  int getLevel() { return derivedStats.getLevel(); }
    public int getLife() { return derivedStats.getLife(); }
    public int getBaseLife() { return derivedStats.getBaseLife(); }
    public int getMana() { return derivedStats.getMana(); }
    public int getBaseMana() { return derivedStats.getBaseMana(); }
    public int getOffensiveRating() { return derivedStats.getOffensiveRating(); }
    public int getDefensiveRating() { return derivedStats.getDefensiveRating(); }
    public int getArmorRating() { return derivedStats.getArmorRating(); }

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
        statString = statString + Integer.toString(getEquipmentStats()) + " ";
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
