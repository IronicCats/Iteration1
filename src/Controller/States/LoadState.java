package Controller.States;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
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
            String s = inputFile.toString();



            //TEST//
            LineNumberReader lnr = new LineNumberReader(new FileReader(filepath));
            lnr.skip(Long.MAX_VALUE);
            int lineNum = lnr.getLineNumber(); //Add 1 because line index starts at 0
            // Finally, the LineNumberReader object should be closed to prevent resource leak
            lnr.close();
            //TEST//

            for(int i = 0; i <= lineNum-1; i++)
            {
                loadedfile.add(Integer.parseInt(inputReader.readLine()));
               //System.out.println(loadedfile.get(i) + " " + i);
            }





            //String fileText = inputReader.readLine();
            //System.out.println(loadedfile.get(0));

           player.loadPlayer(loadedfile);//TEMPORARY COMMENT, NEEDED




            inputReader.close();

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

