package Model.Item;

import java.util.Scanner;
import java.io.File;

import Model.Entity.Stats.StatStructure;
import Model.Entity.Stats.StatsEnum;

/**
 * Created by Wimberley on 2/5/16.
 */
public class populateItems {

    private Scanner items;
    private int []mod = new int[5]; // holds value to apply in effect
    private StatStructure statStruc;
    private StatsEnum []stats = new StatsEnum[5]; // holds stat enum to be adjusted. 5 effects max

    public void populateItems(){
        readFile();
    }

    public void readFile(){

        try{
            items = new Scanner(new File("items.txt"));
        }
        catch(Exception e){
            System.out.println("could not find file");
        }

        while(items.hasNext()){ // stops reading if reached end of file

            if(items.hasNext("SA")){ // start of array
                items.next(); // move to first string in array
                setStatStruc(items); // method to store array in txt file
                continue; // return to beginning of while loop
            }
            String a = items.next();
        }
    }

    public void setStatStruc(Scanner items){ // called to iterate through array of effects
        int i = 0;
        while(!items.hasNext("EA")){
            convertEnum(items.next(), i); // assign string # i in Stat enum array
            mod[i] = items.nextInt(); // assigns the corresponding value adjustment to mod array
        }
        items.next();
        statStruc = new StatStructure(stats, mod);
    }

    public void convertEnum(String Enum, int i){
        switch(Enum){
            case("Life"): stats[i] = StatsEnum.LIFE;
                break;
            case("Level"): stats[i] = StatsEnum.LEVEL;
                break;
            case("Movement"): stats[i] = StatsEnum.MOVEMENT;
                break;
            case("Experience"): stats[i] = StatsEnum.EXPERIENCE;
                break;
            default:
                break;
        }
    }

    public void closeFile(){
        items.close();
    }
}
