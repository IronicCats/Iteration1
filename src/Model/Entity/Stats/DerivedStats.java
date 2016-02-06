package Model.Entity.Stats;

import Model.Entity.EquipmentStats;

/**
 * Created by broskj on 1/31/16.
 */
public class DerivedStats {
    private PrimaryStats primaryStats;
    private EquipmentStats equipmentStats;
    private int level;
    private int life;
    private int mana;
    private int offensiveRating;
    private int defensiveRating;
    private int armorRating;
    private int baseLife,
            baseMana;

    DerivedStats (PrimaryStats ps) {
        primaryStats = ps;
        double calculationLevel = Math.log10(ps.getXpThreshhold() / 10) / Math.log10(ps.getXpMultiplier());
        level = (int) calculationLevel;
        //equipmentStats = ss.equipmentStats;
        baseLife = ps.getHardiness() + level;
        baseMana = ps.getIntellect() + level;



        life = baseLife;
        mana = baseMana;
        //offensiveRating = equipmentStats.getWeaponStats() + primaryStats.strength + level;
        defensiveRating = ps.getAgility() + level;
        //armorRating = equipmentStats.getArmorStats() + primaryStats.hardiness;
    } // end constructor

    public void levelUp() {
        /*
        increase level and reset health and mana
         */
        level++;
        update();
        life = baseLife;
        mana = baseMana;
    } // end levelUp

    public void update() {
        /*
        method to be called with each stat update
        recomputes derived stats
         */
        baseLife = primaryStats.getHardiness() + level;
        baseMana = primaryStats.getIntellect() + level;
        level = Integer.parseInt(Double.toString(Math.log10(primaryStats.getXpThreshhold()/10) /
                Math.log10(primaryStats.getXpMultiplier())));
        //offensiveRating = equipmentStats.getWeaponStats() + primaryStats.strength + level;
        defensiveRating = primaryStats.getAgility() + level;
        //armorRating = equipmentStats.getArmorStats() + primaryStats.hardiness;
    } // end update

    public int getLevel() { return level; }
    public int getLife() { return life; }
    public int getBaseLife() { return baseLife; }
    public int getMana() { return mana; }
    public int getBaseMana() { return baseMana; }
    public int getOffensiveRating() { return offensiveRating; }
    public int getDefensiveRating() { return defensiveRating; }
    public int getArmorRating() { return armorRating; }

    public void setLevel(int level) { this.level = level; }
    public void setLife(int life) { this.life = life; }
    public void setMana(int mana) { this.mana = mana; }
    public void setOffensiveRating(int offensiveRating) { this.offensiveRating = offensiveRating; }
    public void setDefensiveRating(int defensiveRating) { this.defensiveRating = defensiveRating; }
    public void setArmorRating(int armorRating) { this.armorRating = armorRating; }
    public void setBaseLife(int life){this.life = life;}
    public void setBaseMana(int mana){this.mana = mana;}

    public void modifyLevel(int level) { this.level += level; }
    public void modifyLife(int life) { this.life += life; }
    public void modifyMane(int mana) { this.mana += mana; }
    public void modifyOffensiveRating(int offensiveRating) { this.offensiveRating += offensiveRating; }
    public void modifyDefensiveRating(int defensiveRating) { this.defensiveRating += defensiveRating; }
    public void modifyArmorRating(int armorRating) { this.armorRating += armorRating; }

} // end class DerivedStats