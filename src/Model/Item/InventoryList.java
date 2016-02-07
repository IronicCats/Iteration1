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
    public static Item createSword(Item a)
    {

    }
    public static Item createHelmet(Item a)
    {

    }
    public static Item createArmor(Item a)
    {

    }
    public static Item createBoots(Item a)
    {

    }
    public static Item createGauntlets(Item a)
    {

    }
    public static Item createAccessoryA(Item a)
    {

    }
    public static Item createAccessoryB(Item b)
    {

    }





}
