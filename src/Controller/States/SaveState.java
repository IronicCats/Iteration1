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
import View.Views.SaveScreen;

public class SaveState extends State {
    public SaveScreen saveScreen;
    public static SaveState save;

    private ArrayList<Object> saveFile;
    private BufferedWriter outputWriter;
    private StringBuilder saveGameName = new StringBuilder();

    public SaveState(Controller controller, int width, int height) {
        super(controller);
        save = this;
        saveScreen = new SaveScreen(width, height);
        saveGameName.append("gameName");
        saveScreen.setCurrentSaveGameName(saveGameName.toString());
        this.saveFile = new ArrayList<Object>();
        //INITALIZE CANVAS TO HAVE BUTTONS init();
    }

    public void tick() {

    }

    public void render(Graphics g) {
        saveScreen.render(g);
    }


    public void writeFile(Player player, String filepath) {
        saveFile = new ArrayList<Object>();
        File outputFile;
        FileWriter fileWrite;
        //BufferedWriter outputWriter;

        try {
            outputFile = new File(filepath);
            fileWrite = new FileWriter(outputFile, false);
            outputWriter = new BufferedWriter(fileWrite);

            //okay so now it should call the Player's save method
            
            player.savePlayer(saveFile);
            //then Location object
            //then Stats object
            //then pack, pack should save individual items
            //then equipment
            //also current map status??
            for (int i = 0; i < saveFile.size(); i++) {
                outputWriter.write(Objects.toString(saveFile.get(i)));
            }

            fileWrite.flush();
            outputWriter.flush();
            outputWriter.close();
            fileWrite.close();


            //so I need a Tostring for Location, a ToString for Stats, a toString for pack(maybe individually for items), and to string for equipment
            //outputWriter.write(Objects.toString(saveFile));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public String getSaveFilePath(String saveFileName) {
        return (System.getProperty("user.dir") + File.separatorChar + "res" + File.separatorChar + "saveFiles" + File.separatorChar + saveFileName + ".sav");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() >= KeyEvent.VK_A && e.getKeyCode() <= KeyEvent.VK_Z) {
            saveGameName = saveGameName.append(e.getKeyChar());
            saveScreen.setCurrentSaveGameName(saveGameName.toString());
        }
        else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if(saveGameName.length() > 0) {
                saveGameName.deleteCharAt(saveGameName.length() - 1);
            }
            saveScreen.setCurrentSaveGameName(saveGameName.toString());
        }
        else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("Saving game to '" + getSaveFilePath(saveGameName.toString()));
            writeFile(controller.getPlayer(), getSaveFilePath(saveGameName.toString()));
            System.out.println("Saving Done.");
            State.setState(GameState.game);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


