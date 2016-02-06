package Controller.States;


import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import Controller.Controller;
import Model.Entity.Player;

/**
 * Created by Andy on 2/4/2016.
 */
public class LoadState extends State {

    static int count = 0;
    static ArrayList<Object> loadedfile = new ArrayList<Object>();
   // private  static Player player;
    public LoadState(Controller controller) {
        super(controller);
       // player = controller.getPlayer();

    }

    public void tick() {

    }

    public void render(Graphics g) {

    }

    public static void loadFile(Player player,String filepath) {
        File inputFile;
        BufferedReader inputReader;


        try {
            inputFile = new File(filepath);
            inputReader = new BufferedReader(new FileReader(inputFile));
            loadedfile.add(Integer.parseInt(inputReader.readLine()));
            loadedfile.add(Integer.parseInt(inputReader.readLine()));
            System.out.println(loadedfile.get(0));
            System.out.println(loadedfile.get(1));
            //String fileText = inputReader.readLine();
            //System.out.println(loadedfile.get(0));
            player.loadPlayer(loadedfile);
           // loadedfile.add(Integer.parseInt(fileText));
           // fileText = inputReader.readLine();
           // loadedfile.add(Integer.parseInt(fileText));
            //System.out.println(fileText);



            inputReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

