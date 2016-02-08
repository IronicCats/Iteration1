package Controller.States;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;

import Controller.Controller;
import Model.Entity.Inventory.Inventory;
import Model.Entity.Inventory.Pack;
import Model.Entity.Occupation.Occupation;
import Model.Entity.Occupation.Smasher;
import Model.Entity.Occupation.Summoner;
import Model.Entity.Player;
import Model.Entity.Stats.Stats;
import Model.Location;
import Model.Map.Map;
import View.Graphics.Camera;
import View.Views.LoadMenu;

/**
 * Created by Andy on 2/4/2016.
 */
public class LoadState extends State {
    public LoadMenu loadMenu;
    public static LoadState load;

    //Charcter Variables
    private Pack pack;
    private Inventory inventory;
    private Occupation occupation;
    private Stats stats;
    private Player player;

    //Map/Camera Variabes
    private Map map;
    private Camera camera;

    private ArrayList<Object> loadedfile = new ArrayList<Object>();
   //private  static Player player;


    public LoadState(Controller controller, int width, int height) {
        super(controller);
        load = this;
        loadMenu = new LoadMenu(width,height);

        // Create Player
        inventory = new Inventory(controller);
        map = new Map(controller);
        camera = new Camera(controller.getGame().getWidth(), controller.getGame().getHeight(),map);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        loadMenu.render(g);
    }

    public void loadFile(String filepath) {

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
            controller.getPlayer().loadPlayer(loadedfile,a);//TEMPORARY COMMENT, NEEDED
            loadedfile = new ArrayList<>();
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
                if(this.getPreviousState() == States.Menu)
                {
                    setState(MenuState.menu);
                }
                else if(this.getPreviousState() == States.Pause)
                {
                    setState(PauseState.pause);
                }
            }
            else {
                System.out.println(loadMenu.getSelectionString());
                loadGame();
            }
        }
    }

    private void loadGame() {
        // Create new dummy versions of everything.
        occupation = new Summoner();
        stats = new Stats(occupation.getInitialStats(),controller);

        player = new Player(controller, new Location(0,0,0), inventory, occupation, stats);

        //Controller updates
        controller.setPlayer(player);
        controller.setMap(map);
        controller.setCamera(camera);

        System.out.println("Trying to load game.");
        loadFile(getLoadFilePath(loadMenu.getSelectionString()));
        System.out.println("Game Loaded.");

        //later when load method is actually done call load.loadFile(player,loadMenu.getSelection)
        GameState.game.init();
        State.setState(GameState.game);
    }

    public String getLoadFilePath(String saveFileName) {
        return (System.getProperty("user.dir") + File.separatorChar + "res" + File.separatorChar + "saveFiles" + File.separatorChar + saveFileName);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

