package Controller.States;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;

import Controller.Controller;
import Model.Entity.Player;
import View.Views.LoadMenu;

/**
 * Created by Andy on 2/4/2016.
 */
public class LoadState extends State {
    public LoadMenu loadMenu;
    public static LoadState load;

    static int count = 0;
    static ArrayList<Object> loadedfile = new ArrayList<Object>();
   //private  static Player player;


    public LoadState(Controller controller, int width, int height) {
        super(controller);
        load = this;
        loadMenu = new LoadMenu(width,height);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        loadMenu.render(g);
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



                if(i <= 23) {

                    loadedfile.add(Integer.parseInt(inputReader.readLine()));
                    //System.out.println("hey before");
                   // System.out.println(loadedfile.get(i).toString() + " "+ i);
                    //System.out.println("Hey after");
                }
                else {
                    loadedfile.add(inputReader.readLine());
                    //System.out.println("hey1 before");
                    //System.out.println(loadedfile.get(i).toString() + " "+ i);
                    //System.out.println("hey1 after");
                }
                //loadedfile.add(Integer.parseInt(inputReader.readLine()));
               //System.out.println(loadedfile.get(i) + " " + i);
            }

            int a = 0;
           player.loadPlayer(loadedfile,a);//TEMPORARY COMMENT, NEEDED


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
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            loadMenu.previous();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            loadMenu.next();
        }

        if(e.getKeyCode() == 10) {
            if(loadMenu.checkSelectionStatus())//checking if back option has been selected
            {
                setState(MenuState.menu);
            }
            else
            {
                System.out.println(loadMenu.getSelectionString());
                //later when load method is actually done call load.loadFile(player,loadMenu.getSelection)
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

