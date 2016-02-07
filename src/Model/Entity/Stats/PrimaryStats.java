package Model.Entity.Stats;

import Model.Entity.EquipmentStats;

/**
 * Created by broskj on 1/31/16.
 */
public class PrimaryStats {
    private int livesLeft;
    private int strength;
    private int agility;
    private int intellect;
    private int hardiness;
    private int experience;
    private int movement;
    private EquipmentStats equipmentStats;
    private int baseLives,
            baseStr,
            baseAgi,
            baseIntel,
            baseHard,
            baseMovement;
    private int xpThreshhold;
    private double xpMultiplier,
            statMultiplier;

    PrimaryStats() {
        this.livesLeft = 0;
        this.strength = 0;
        this.agility = 0;
        this.intellect = 0;
        this.hardiness = 0;

    } // end constructor

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
        System.out.println("EXP: " + experience + "XPT: " + xpThreshhold);

        experience = experience - xpThreshhold;
        xpThreshhold *= xpMultiplier;
        livesLeft = baseLives;

        strength *= statMultiplier;
        agility *= statMultiplier;
        intellect *= statMultiplier;
        hardiness *= statMultiplier;
    } // end levelUp

    public void kill() {
        livesLeft--;

        strength = baseStr;
        agility = baseAgi;
        intellect = baseIntel;
        hardiness = baseHard;
        movement = baseMovement;
    } // end kill

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
    public EquipmentStats getEquipmentStats() { return equipmentStats; }

    public void setLivesLeft(int livesLeft) { this.livesLeft = livesLeft; }
    public void setStrength(int strength) { this.strength = strength; }
    public void setAgility(int agility) { this.agility = agility; }
    public void setIntellect(int intellect) { this.intellect = intellect; }
    public void setHardiness(int hardiness) { this.hardiness = hardiness; }
    public void setExperience(int experience) { this.experience = experience; }
    public void setMovement(int movement) { this.movement = movement; }

    public void modifyLivesLeft(int livesLeft) {
        this.livesLeft += livesLeft;
        if(livesLeft > baseLives)
            livesLeft = baseLives;
    }
    public void modifyStrength(int strength) { this.strength += strength; }
    public void modifyAgility(int agility) { this.agility += agility; }
    public void modifyIntellect(int intellect) { this.intellect += intellect; }
    public void modifyHardiness(int hardiness) { this.hardiness += hardiness; }
    public void modifyExperience(int experience) { this.experience += experience; }
    public void modifyMovement(int movement) { this.movement += movement; }

} // end class PrimaryStats