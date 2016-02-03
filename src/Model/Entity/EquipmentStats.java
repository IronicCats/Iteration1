package Model.Entity;

import Model.Entity.Stats.Stats;
import Model.Entity.Inventory.Equipment.Equipment;

/**
 * Created by broskj on 2/1/16.
 */
public class EquipmentStats {
    private Equipment equipment;
    private Stats stats;
    private int armorStats;
    private int weaponStats;

    EquipmentStats(Equipment equipment, int armorStats, int weaponStats, Stats stats) {
        this.equipment = equipment;
        this.armorStats = armorStats;
        this.weaponStats = weaponStats;
        this.stats = stats;
    } // end constructor

    public Equipment getEquipment() { return equipment; }
    public Stats getStats() { return stats; }
    public int getArmorStats() { return armorStats; }
    public int getWeaponStats() { return weaponStats; }
    public void setEquipment(Equipment equipment) { this.equipment = equipment; }
    public void setStats(Stats stats) { this.stats = stats; }
    public void setArmorStats(int armorStats) { this.armorStats = armorStats; }
    public void setWeaponStats(int weaponStats) { this.weaponStats = weaponStats; }

} // end class EquipmentStats
