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
    static Useable healthPotion;
    static Useable manaPotion;
    static Armor helmet;
    static Armor chestPiece;
    static Armor boots;
    static Armor gauntlets;
    static Weapon sword;
    static Armor accessoryA;
    static Armor accessoryB;
    static Armor pants;
    static Location loc;



    public static void init()
    {
        healthPotion = null;
        manaPotion = null;
    }
    public static Item checkItem(String itemname)
    {
        Item a = null;
        if(itemname == healthPotion.getName())
        {a = healthPotion;}
        else if(itemname == manaPotion.getName()){a = manaPotion;}
        else if(itemname == sword.getName()){a=sword;}
        else if(itemname == helmet.getName()){a=helmet;}
        else if(itemname == chestPiece.getName()){a=chestPiece;}
        else if(itemname == boots.getName()){a=boots;}
        else if(itemname == gauntlets.getName()){a=gauntlets;}
        else if(itemname == accessoryA.getName()){a=accessoryA;}
        else if(itemname == accessoryB.getName()){a=accessoryB;}
        else if(itemname == pants.getName()){a=pants;}

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
        chestPiece= new Armor(Assets.chestArmor,l,ItemsEnum.ARMOR,"Chest Piece",description,null,null,6,ArmorEnum.CHEST);
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
        accessoryA = new Armor(Assets.accessory1,l,ItemsEnum.ARMOR,"Accessory A",description,null,null,2,ArmorEnum.ACCESSORY1);
        return accessoryA;
    }
    public static Armor createAccessoryB(Location l)
    {
        String description = "Accessory: +2 armor rating";
        accessoryB = new Armor(Assets.accessory2,l,ItemsEnum.ARMOR,"Accessory B",description,null,null,2,ArmorEnum.ACCESSORY2);
        return accessoryB;
    }
    public static Armor createPants(Location l)
    {
        String description = "Pants: +4 armor rating";
        pants = new Armor(Assets.pants,l,ItemsEnum.ARMOR,"Pants",description,null,null,4,ArmorEnum.PANTS);
        return pants;
    }
}
