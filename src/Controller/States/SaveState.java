package Controller.States;


import java.awt.*;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;

import Controller.Controller;
import Model.Entity.Player;

/**
 * Created by Andy on 2/4/2016.
 */
public class SaveState extends State {


    static ArrayList<Object> savefile = new ArrayList<Object>();
    static BufferedWriter outputWriter;
    private Player player;

    public SaveState(Controller controller) {
        super(controller);
        player = controller.getPlayer();
        //INITALIZE CANVAS TO HAVE BUTTONS init();
    }

    public void tick() {

    }

    public void render(Graphics g) {

    }




    public static void writeFile(Player player, String filepath) {
        File outputFile;
        //BufferedWriter outputWriter;



        try {
            outputFile = new File(filepath);
            outputWriter = new BufferedWriter(new FileWriter(outputFile));

            //okay so now it should call the Player's save method
            player.savePlayer(savefile);
            //then Location object
            //then Stats object
            //then pack, pack should save individual items
            //then equipment
            //also current map status??
            for (int i = 0; i < savefile.size(); i++) {
                outputWriter.write(Objects.toString(savefile.get(i)));
            }
            outputWriter.close();
            //so I need a Tostring for Location, a ToString for Stats, a toString for pack(maybe individually for items), and to string for equipment
            //outputWriter.write(Objects.toString(savefile));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


