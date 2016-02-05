package Model.Item;

import java.util.Scanner;
import java.io.File;

/**
 * Created by Wimberley on 2/5/16.
 */
public class populateItems {

    private Scanner items;
    private String []stat = new String[5]; // holds stat enum to be adjusted. 5 effects max
    private int []mod = new int[5]; // holds value to apply in effect

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
                int i = 0;
                while(!items.hasNext("EA")){
                    stat[i] = items.next(); // assign string # i in arrray box to stat enum array
                    mod[i] = items.nextInt(); // assigns the corresponding value adjustment to mod array
                    System.out.println(stat[i] + "\n" + mod[i++] + "\n");
                }
                items.next();
                continue; // return to beginning of while loop
            }
            String a = items.next();
            System.out.println(a + "\n");
        }
    }

    public void closeFile(){
        items.close();
    }
}
