package Model.Item;

import java.util.Scanner;
import java.io.File;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Model.Entity.Stats.StatStructure;
import Model.Entity.Stats.StatsEnum;
import View.Graphics.Assets;
import Model.Entity.Stats.Effect;
import Model.Location;
import Model.Requirements;
import com.sun.corba.se.spi.orbutil.fsm.StateEngine;

/**
 * Created by Wimberley on 2/5/16.
 */
public class PopulateItems {

    private Scanner scan; // used to read items.txt
    private StatStructure statStruc; // statStructure that is used to create new effect
    private BufferedImage image; // holds image of item

    // containers used to instantiate new items
    private ArrayList<StatsEnum> stats = new ArrayList<>(); // holds which statsEnum the effect will apply to. Used in creation of statStruc
    private int []mod = new int[10]; // holds associated value to go with effect. Used in creation of statStruc
    private ArrayList<Effect> effects = new ArrayList<>(); // holds all effects an item can have
    private ArrayList<Item> items = new ArrayList<>(); // array holding all items

    private Location location;

    private Requirements requirements; //
    private String reqItem;
    private int reqLevel;

    private String name; // storage variable for name read from file
    private String description; // storage variable for description read from file
    int x, y, type, stat; // used to store position, item type, and stats for armor and weapon

    private WeaponEnum weaponType;
    private ArmorEnum armorType;

    public PopulateItems(){

        InventoryList.init();//added this to initialize all items
        readFile();
    }

    private void readFile(){

        try{
            scan = new Scanner(new File("res/map/items.txt"));
        }
        catch(Exception e){
            System.out.println("could not find file");
        }

        while(scan.hasNext()) { // stops reading if reached end of file
            if (scan.hasNext("Comment:")) {
                while (scan.hasNext("Comment:")) {
                    scan.nextLine(); // skip through comment
                }
            }

            x = scan.nextInt(); // read x postion
            y = scan.nextInt(); // read y postion

            name = scan.next(); // read name

            while(!scan.hasNext("ED")){
                description += " " + scan.next();
            }

            scan.next(); // move out of description

            type = scan.nextInt(); // read in int representing type

            stat = scan.nextInt(); // read in stat associated with armor/weapon

            reqItem = scan.next(); // required Item

            reqLevel = scan.nextInt(); // required level

            //requirements = new Requirements(reqLevel, reqItem);

            if (scan.hasNext("SA")) { // start of array containing StatStructure code
                scan.next(); // move to first string in array
                setStatStruc(scan); // method to store array in txt file to statStruc
                continue;
            }
            else{
                setImage(name);
                generateItems();
            }
        }
        scan.close(); // close scanner
    }

    private void setStatStruc(Scanner items){ // called to iterate through array of effect
        while(!items.hasNext("EA")){ // if not reached end of array
            convertEnum(items.next()); // assign stats (statEnum array) and assigns image
            mod[stats.size() - 1] = items.nextInt(); // assigns the corresponding value adjustment to mod array
        }
        if(stats.size() >= 1){
            if(type == 0){
                image = Assets.oneShot;
            }
            else{
                //image = Assets.somePic;
            }
        }
        items.next(); // move past end of array
        statStruc = new StatStructure(stats.toArray(new StatsEnum[stats.size()]), mod); // create new statStructure used to create effects array
        stats.clear();
        generateEffects();
        generateItems();
        effects.clear(); // empty effects array for next item
    }

    private void convertEnum(String Enum){ // assigns statEnum and image based on effect
        switch (Enum) {
            case ("Life"):
                stats.add(StatsEnum.LIFE);
                image = Assets.potion;
                break;
            case ("Level"):
                stats.add(StatsEnum.LEVEL);
                image = Assets.sack;
                break;
            case ("Movement"):
                stats.add(StatsEnum.MOVEMENT);
                //image = Assets.potion;
                break;
            case ("Experience"):
                stats.add(StatsEnum.EXPERIENCE);
                //image = Assets.potion;
                break;
            case ("Mana"):
                stats.add(StatsEnum.MANA);
                image = Assets.manapotion;
                break;
            default:
                break;
        }
    }

    public void setImage(String equippable) {
        switch (equippable) {
            case ("Sword"):
                weaponType = WeaponEnum.SWORD;
                image = Assets.sword;
                break;
            case ("Axe"):
                weaponType = WeaponEnum.AXE;
                //image = Assets.Axe;
                break;
            case ("Spear"):
                weaponType = WeaponEnum.SPEAR;
                //image = Assets.spear;
                break;
            case ("Hammer"):
                weaponType = WeaponEnum.HAMMER;
                //image = Assets.hammer;
                break;
            case ("Pants"):
                armorType = ArmorEnum.PANTS;
                image = Assets.pants;
                break;
            case ("Head"):
                armorType = ArmorEnum.HEAD;
                //image = Assets.head;
                break;
            case ("Chest"):
                armorType = ArmorEnum.CHEST;
                image = Assets.chestArmor;
                break;
            case ("Boots"):
                armorType = ArmorEnum.BOOTS;
                image = Assets.boots;
                break;
            case ("Gloves"):
                armorType = ArmorEnum.GLOVES;
                image = Assets.glove;
                break;
            case ("AccessoryA"):
                armorType = ArmorEnum.ACCESSORY1;
                image = Assets.accessory1;
                break;
            case ("AccessoryB"):
                armorType = ArmorEnum.ACCESSORY2;
                image = Assets.accessory2;
            case ("Key"):
                image = Assets.key;
                break;
            case ("TreasureChest"):
                image = Assets.chest;
                break;
            case ("House"):
                image = Assets.house;
                break;
            default:
                break;
        }
    }

    private void generateEffects(){
        effects.add(new Effect(statStruc, 0, description)); // create effects for 1 item. 5 max
    }

    private void generateItems(){ // create items
        location = new Location(x,y,0);

        switch(type){
            case 0: items.add(new OneShot(image, location, ItemsEnum.ONESHOT, name, description, effects.toArray(new Effect[effects.size()]), requirements));
                    break;
            case 1: items.add(new Useable(image, location, ItemsEnum.USEABLE, name, description, effects.toArray(new Effect[effects.size()]), requirements));
                    break;
            case 2: items.add(new Obstacle(image, location, ItemsEnum.OBSTACLE, name, description, null, null));
                    break;
            case 3: items.add(new Interactable(image, location, ItemsEnum.INTERACTABLE, name, description, effects.toArray(new Effect[effects.size()]), requirements));
                    break;
            case 4: items.add(new Armor(image, location, ItemsEnum.ARMOR, name, description, null, requirements, stat, armorType));
                    break;
            case 5: items.add(new Weapon(image, location, ItemsEnum.WEAPON, name, description, null, requirements, stat, weaponType));
                    break;
            default:
                    break;
        }
    }

    public Item[] getItems(){

        return items.toArray(new Item[items.size()]);
    } // return items to map
}
