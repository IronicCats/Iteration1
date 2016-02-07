package Model.Item;

import Model.Location;
import View.Graphics.Assets;

/**
 * Created by Andy on 2/6/2016.
 */
public class InventoryList {
    static Useable healthPotion;
    static Useable manaPotion;
    static Armor helmet;
    static Armor chestPiece;
    static Armor boots;
    static Armor gauntlets;
    static Weapon sword;
    static Armor accessoryA;
    static Armor accessoryB;
    //static Item otherPotion;


    public static void init()
    {
        createHealthPotion(healthPotion);
        createManaPotion(manaPotion);
    }
    public static Item checkItem(String itemname)
    {
        Item a = null;
        if(itemname == healthPotion.getName())
        {a = healthPotion;}
        else if(itemname == manaPotion.getName()){a = manaPotion;}

        return a;
    }

    public static Useable createHealthPotion(Useable a)
    {
        //image, location, type, name, description, effects, requirements
        Location l = new Location(-1,-1,0);
        a = new Useable(Assets.potion,l, ItemsEnum.USEABLE,"Potion","This heals 3 health",null,null);
        return a;
    }
    public static Useable createManaPotion(Useable a)
    {
        Location l = new Location(-1,-1,0);
        a = new Useable(Assets.potion,l, ItemsEnum.USEABLE,"Potion","This heals 3 health",null,null);
        return a;
    }
    public static Weapon createSword(Weapon a)
    {

    }
    public static Armor createHelmet(Armor a)
    {

    }
    public static Armor createArmor(Armor a)
    {

    }
    public static Armor createBoots(Armor a)
    {

    }
    public static Armor createGauntlets(Armor a)
    {

    }
    public static Armor createAccessoryA(Armor a)
    {

    }
    public static Armor createAccessoryB(Armor b)
    {

    }





}
