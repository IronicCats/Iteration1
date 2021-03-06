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
        /*
        initialize stats
         */
        primaryStats = ps;
        level = 1;
        equipmentStats = null;
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

    public void kill() {
        /*
        kills the player; resets life and mana
         */
        life = baseLife;
        mana = baseMana;
    } // end kill

    public void update() {
        /*
        method to be called with each stat update
        recomputes derived stats
         */
        baseLife = primaryStats.getHardiness() + level;
        baseMana = primaryStats.getIntellect() + level;
        offensiveRating = equipmentStats.getWeaponStats() + primaryStats.getBaseStr() + level;
        defensiveRating = primaryStats.getAgility() + level;
        armorRating = equipmentStats.getArmorStats() + primaryStats.getBaseHard();
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
    public void setEquipmentStats(EquipmentStats equipmentStats) { this.equipmentStats = equipmentStats; }

    public void modifyLevel(int level) { this.level += level; }
    public void modifyLife(int life) { this.life += life; }
    public void modifyMane(int mana) { this.mana += mana; }
    public void modifyOffensiveRating(int offensiveRating) { this.offensiveRating += offensiveRating; }
    public void modifyDefensiveRating(int defensiveRating) { this.defensiveRating += defensiveRating; }
    public void modifyArmorRating(int armorRating) { this.armorRating += armorRating; }

} // end class DerivedStats