package Model.Entity.Inventory.Equipment;

/**
 * Created by broskj on 2/1/16.
 */
public class EquippedArmor {
    private Armor head,
                chest,
                pants,
                boots,
                gloves,
                accessory1,
                accessory2;
    private int totalDefense;

    EquippedArmor () {
        head = new Armor();
        chest = new Armor();
        pants = new Armor();
        boots = new Armor();
        gloves = new Armor();
        accessory1 = new Armor();
        accessory2 = new Armor();
        totalDefense = 0;
    } // end constructor

    public void equipArmor(Armor armor) {
        switch(armor.getType()) {
            case 0:
                break;
            default:
                break;
        }
    } // end equipArmor

    public int getTotalDefense() { return totalDefense; }
} // end class EquippedArmor
