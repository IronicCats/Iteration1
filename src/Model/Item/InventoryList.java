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
    static Armor pants;
    


    public static void init()
    {
        createHealthPotion(healthPotion);
        createManaPotion(manaPotion);
        createSword(sword);
        createHelmet(helmet);
        createChestPiece(chestPiece);
        createBoots(boots);
        createGauntlets(gauntlets);
        createAccessoryA(accessoryA);
        createAccessoryB(accessoryB);
        createPants(pants);
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

    public static Useable createHealthPotion(Useable a)
    {
        //image, location, type, name, description, effects, requirements
        //need to create effect
        Location l = new Location(-1,-1,0);
        a = new Useable(Assets.potion,l, ItemsEnum.USEABLE,"Potion","This heals 3 health",null);
        return a;
    }
    public static Useable createManaPotion(Useable a)
    {
        //need to create effect
        Location l = new Location(-1,-1,0);
        a = new Useable(Assets.potion,l, ItemsEnum.USEABLE,"Potion","This heals 3 health",null);
        return a;
    }
    public static Weapon createSword(Weapon a)
    {
        //(image, location, type, name, description, effects, requirements, stat)
        Location l = new Location(-1,-1,0);
        a = new Weapon(Assets.sword,l,ItemsEnum.WEAPON,"Sword","Sword with 5 attack",null,null,5);
        return a;

    }
    public static Armor createHelmet(Armor a)
    {
        //(image, location, type, name, description, effects, requirements, stat);
        Location l = new Location(-1,-1,0);
        a = new Armor(Assets.helmet,l,ItemsEnum.ARMOR,"Helmet","Helmet with 4 defense",null,null,4);
        return a;

    }
    public static Armor createChestPiece(Armor a)
    {
        Location l = new Location(-1,-1,0);
        a = new Armor(Assets.chestPiece,l,ItemsEnum.ARMOR,"Chest Piece","Chest Piece with 6 defense",null,null,6);
        return a;
    }
    public static Armor createBoots(Armor a)
    {
        Location l = new Location(-1,-1,0);
        a = new Armor(Assets.boots,l,ItemsEnum.ARMOR,"Boots","Boots with 3 defense",null,null,3);
        return a;
    }
    public static Armor createGauntlets(Armor a)
    {
        Location l = new Location(-1,-1,0);
        a = new Armor(Assets.gauntlets,l,ItemsEnum.ARMOR,"Gauntlets","Gauntlets with 4 defense",null,null,4);
        return a;

    }
    public static Armor createAccessoryA(Armor a)
    {
        Location l = new Location(-1,-1,0);
        a = new Armor(Assets.accessoryA,l,ItemsEnum.ARMOR,"Accessory A","Accessory with 2 defense",null,null,2);
        return a;
    }
    public static Armor createAccessoryB(Armor a)
    {
        Location l = new Location(-1,-1,0);
        a = new Armor(Assets.accessoryB,l,ItemsEnum.ARMOR,"Accessory B","Accessory with 3 defense",null,null,3);
        return a;
    }
    public static Armor createPants(Armor a)
    {
        Location l = new Location(-1,-1,0);
        a = new Armor(Assets.pants,l,ItemsEnum.ARMOR,"Pants","Pants with 3 defense",null,null,3);
        return a;
    }





}
