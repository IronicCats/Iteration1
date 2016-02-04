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

} // end class Stats
