package Model.Map.Decal;

import java.util.Scanner;
import java.io.File;

/**
 * Created by mazumderm on 2/6/2016.
 */
public class populateDecal {
    private Scanner decals;

    public void readFile()
    {
        try{
            decals = new Scanner(new File("decals.txt"));
        }
        catch(Exception e){
            System.out.println("could not find file");
        }

    }
}
