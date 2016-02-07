package Model.Item;

import Model.Entity.Stats.Effect;
import Model.Entity.Stats.StatStructure;
import Model.Entity.Stats.StatsEnum;
import Model.Location;
import View.Graphics.Assets;

/**
 * Created by Andy on 2/6/2016.
 */
public class InventoryList {
    static Useable healthPotion =null;
    static Useable manaPotion = null;
    static Armor helmet = null;
    static Armor chestPiece = null;
    static Armor boots = null;
    static Armor gauntlets = null;
    static Weapon sword = null;
    static Armor accessoryA = null;
    static Armor accessoryB = null;
    static Armor pants = null;
    static Location loc = null;



    public static void init()
    {
        loc = new Location(-1,-1,0);
        createHealthPotion(loc);
        createManaPotion(loc);
        createHelmet(loc);
        createChestPiece(loc);
        createBoots(loc);
        createGauntlets(loc);
        createSword(loc);
        createAccessoryA(loc);
        createAccessoryB(loc);
        createPants(loc);
        System.out.println("This should be initialized.");
    }
    public static Item checkItem(String itemname)
    {
        //System.out.println("Do i get here? 1 " + itemname);
        //System.out.println(healthPotion.getName());
        Item a = null;
        if(itemname.equalsIgnoreCase(healthPotion.getName())) {a = healthPotion;}
        else if(itemname.equalsIgnoreCase(manaPotion.getName())){a = manaPotion;}
        else if(itemname.equalsIgnoreCase(sword.getName())){a=sword;}
        else if(itemname.equalsIgnoreCase(helmet.getName())){a=helmet;}
        else if(itemname.equalsIgnoreCase(chestPiece.getName())){a=chestPiece;}
        else if(itemname.equalsIgnoreCase(boots.getName())){a=boots;}
        else if(itemname.equalsIgnoreCase(gauntlets.getName())){a=gauntlets;}
        else if(itemname.equalsIgnoreCase(accessoryA.getName())){a=accessoryA;}
        else if(itemname.equalsIgnoreCase(accessoryB.getName())){a=accessoryB;}
        else if(itemname.equalsIgnoreCase(pants.getName())){a=pants;}

        return a;
    }

    public static Useable createHealthPotion(Location l)
    {
        //image, location, type, name, description, effects, requirements
        //need to create effect
        String description = "This potion heals 5 health";
        Effect[] e = {new Effect(new StatStructure(StatsEnum.LIFE,5),0,description)};
        healthPotion = new Useable(Assets.potion,l, ItemsEnum.USEABLE,"Health",description,e,null);
        return healthPotion;
    }
    public static Useable createManaPotion(Location l)
    {
        //need to create effect
        String description = "This potion restores 3 mana";
        Effect[] e = {new Effect(new StatStructure(StatsEnum.MANA,3),0,description)};
        manaPotion = new Useable(Assets.manapotion,l, ItemsEnum.USEABLE,"Mana",description,e,null);
        return manaPotion;
    }
    public static Weapon createSword(Location l)
    {
        //(image, location, type, name, description, effects, requirements, stat)
        String description = "Sword: +5 weapon rating";
        sword = new Weapon(Assets.sword,l,ItemsEnum.WEAPON,"Sword",description,null,null,5,WeaponEnum.SWORD);
        return sword;

    }
    public static Armor createHelmet(Location l)
    {
        //(image, location, type, name, description, effects, requirements, stat);
        String description = "Helmet: +4 armor rating";
        helmet = new Armor(Assets.helmet,l,ItemsEnum.ARMOR,"Helmet",description,null,null,4,ArmorEnum.HEAD);
        return helmet;

    }
    public static Armor createChestPiece(Location l)
    {
        String description = "Chest piece: +4 armor rating";
        chestPiece= new Armor(Assets.chestArmor,l,ItemsEnum.ARMOR,"Chest",description,null,null,6,ArmorEnum.CHEST);
        return chestPiece;
    }
    public static Armor createBoots(Location l)
    {
        String description = "Boots: +3 armor rating";
        boots = new Armor(Assets.boots,l,ItemsEnum.ARMOR,"Boots",description,null,null,3,ArmorEnum.BOOTS);
        return boots;
    }
    public static Armor createGauntlets(Location l)
    {
        String description = "Gauntlets: +3 armor rating";
        gauntlets = new Armor(Assets.glove,l,ItemsEnum.ARMOR,"Gauntlets",description,null,null,3,ArmorEnum.GLOVES);
        return gauntlets;

    }
    public static Armor createAccessoryA(Location l)
    {
        String description = "Accessory: +2 armor rating";
        accessoryA = new Armor(Assets.accessory1,l,ItemsEnum.ARMOR,"AccessoryA",description,null,null,2,ArmorEnum.ACCESSORY1);
        return accessoryA;
    }
    public static Armor createAccessoryB(Location l)
    {
        String description = "Accessory: +2 armor rating";
        accessoryB = new Armor(Assets.accessory2,l,ItemsEnum.ARMOR,"AccessoryB",description,null,null,2,ArmorEnum.ACCESSORY2);
        return accessoryB;
    }
    public static Armor createPants(Location l)
    {
        String description = "Pants: +4 armor rating";
        pants = new Armor(Assets.pants,l,ItemsEnum.ARMOR,"Pants",description,null,null,4,ArmorEnum.PANTS);
        return pants;
    }
}
