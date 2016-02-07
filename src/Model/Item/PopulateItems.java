package Model.Item;

import java.util.Scanner;
import java.io.File;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Model.Entity.Stats.StatStructure;
import Model.Entity.Stats.StatsEnum;
import Model.Item.Item;
import Model.Item.ItemsEnum;
import Model.Item.OneShot;
import View.Graphics.Assets;
import Model.Entity.Stats.Effect;
import Model.Location;
import Model.Requirements;

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
    private Requirements requirements = new Requirements(0); // test requirements

    private String name;
    private String description = "";
    int x;
    int y;

    public PopulateItems(){
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

            x = scan.nextInt();
            y = scan.nextInt();

            name = scan.next();

            if (scan.hasNext("BD")) {
                while (!scan.hasNext("ED")) {
                    description.concat(scan.next() + "");
                }
                scan.next(); // move out of description
            }

            if (scan.hasNext("SA")) { // start of array containing StatStructure code
                scan.next(); // move to first string in array
                setStatStruc(scan); // method to store array in txt file to statStruc
                continue;
            }
        }
        scan.close(); // close scanner
    }

    private void setStatStruc(Scanner items){ // called to iterate through array of effect
        while(!items.hasNext("EA")){ // if not reached end of array
            convertEnum(items.next()); // assign string # i in stats (statEnum array) and assigns image
            mod[stats.size()] = items.nextInt(); // assigns the corresponding value adjustment to mod array
        }
        items.next(); // move past end of array
        statStruc = new StatStructure(stats.toArray(new StatsEnum[stats.size()]), mod); // create new statStructure used to create effects array
        stats.clear();
        generateEffects();
        effects.clear(); // empty effects array for next item
        generateItems();
    }

    private void convertEnum(String Enum){ // assigns statEnum and image based on effect
        if(stats.size() >= 1){
            // apply image for item with multiple effects
        }
        else { // apply image for for item with just one effect
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
                default:
                    break;
            }
        }
    }

    private void generateEffects(){
        effects.add(new Effect(statStruc, 0, "Description")); // create effects for 1 item. 5 max
    }

    private void generateItems(){ // create items
        location = new Location(x,y,0);
        items.add(new Useable(image, location, ItemsEnum.USEABLE, name, description, effects.toArray(new Effect[effects.size()]), requirements));
    }

    public Item[] getItems(){
        return items.toArray(new Item[items.size()]);
    } // return items to map
}
