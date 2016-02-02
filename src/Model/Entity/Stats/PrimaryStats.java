package Model.Entity.Stats;

/**
 * Created by broskj on 1/31/16.
 */
public class PrimaryStats {
    private int livesLeft,
            strength,
            agility,
            intellect,
            hardiness,
            experience,
            movement,
            equipmentStats;
    private int baseLives,
            baseStr,
            baseAgi,
            baseIntel,
            baseHard,
            baseMovement;
    private int xpThreshhold;
    private double xpMultiplier,
            statMultiplier;

    PrimaryStats (StatStructure ss) {
        baseLives = ss.getStat(StatsEnum.LIVES_LEFT);
        baseStr = ss.getStat(StatsEnum.STRENGTH);
        baseAgi = ss.getStat(StatsEnum.AGILITY);
        baseIntel = ss.getStat(StatsEnum.INTELLECT);
        baseHard = ss.getStat(StatsEnum.HARDINESS);
        baseMovement = ss.getStat(StatsEnum.MOVEMENT);

        livesLeft = baseLives;
        strength = baseStr;
        agility = baseAgi;
        intellect = baseIntel;
        hardiness = baseHard;
        experience = ss.getStat(StatsEnum.EXPERIENCE);
        movement = baseMovement;
        //equipmentStats = ;

        xpThreshhold = 10;
        xpMultiplier = 1.5;
        statMultiplier = 1.2;
    } // end constructor

    public void levelUp() {
        /*
        reset experience, modify xp threshhold, reset lives remaining
         */
        experience = 0;
        xpThreshhold *= xpMultiplier;
        livesLeft = baseLives;

        strength *= statMultiplier;
        agility *= statMultiplier;
        intellect *= statMultiplier;
        hardiness *= statMultiplier;
    }

    public int getXpThreshhold() { return xpThreshhold; }
    public double getXpMultiplier() { return xpMultiplier; }
    public int getLivesLeft() { return livesLeft; }
    public int getBaseLives() { return baseLives; }
    public int getStrength() { return strength; }
    public int getBaseStr() { return baseStr; }
    public int getAgility() { return agility; }
    public int getBaseAgi() { return baseAgi; }
    public int getIntellect() { return intellect; }
    public int getBaseIntel() { return baseIntel; }
    public int getHardiness() { return hardiness; }
    public int getBaseHard() { return baseHard; }
    public int getExperience() { return experience; }
    public int getMovement() { return movement; }
    public int getBaseMovement() { return baseMovement; }
    public int getEquipmentStats() { return equipmentStats; }

} // end class PrimaryStats
