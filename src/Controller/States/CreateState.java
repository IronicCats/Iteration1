package Controller.States;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Controller.States.GameState;
import Model.Entity.Inventory.Inventory;
import Model.Entity.Inventory.Pack;
import Model.Entity.Occupation.*;
import Controller.Controller;
import Model.Entity.Player;
import Model.Entity.Stats.Stats;
import Model.Location;
import View.*;
import View.Graphics.Camera;
import View.Views.MainMenu;
import View.Views.CreateMenu;
import Model.Map.Map;
import View.Views.MapView;

/**
 * Created by Peter Camejo on 2/7/2016.
 */


public class CreateState extends State implements KeyListener {
    //State Variables
    public CreateMenu createView;
    public static CreateState createState;

    //Charcter Variables
    private Pack pack;
    private Inventory inventory;
    private Occupation occupation;
    private Stats stats;
    private Player player;

    //Map/Camera Variabes
    private Map map;
    private Camera camera;

    //Constructor
    public CreateState(Controller controller, int width, int height) {
        super(controller);
        createState = this;
        createView = new CreateMenu(width, height);

        //Creating player
        pack = new Pack(10);
        inventory = new Inventory(controller);
        map = new Map(controller);
        camera = new Camera(controller.getGame().getWidth(), controller.getGame().getHeight(),map);
    }

    //Assigns occupation, creates players, init's gamestate.
    public void assignOccupation(int selected){
        switch(selected){
            case 0:  //Summoner
                System.out.println("Summoner Occupation Chosen");
                occupation = new Summoner();
                break;
            case 1: // Smasher
                System.out.println("Smasher Occupation Chosen");
                occupation = new Smasher();
                break;
            case 2: // Sneak
                System.out.println("Sneak Occupation Chosen.");
                occupation = new Sneak();
                break;
            case 3: // Go back
                return;
        }

        //Create player with appropriate stats
        stats = new Stats(occupation.getInitialStats(),controller);
        player = new Player(controller,new Location(map.getSpawn().getX(), map.getSpawn().getY(),map.getSpawn().getDir()),inventory, occupation, stats);

        //Controller updates
        controller.setPlayer(player);
        controller.setMap(map);
        controller.setCamera(camera);

        //Make sure GameState updates.
        GameState.game.init();


        return;
    }


    public void switchState(States stateNumber) {
        switch(stateNumber) {
            case Game:
                System.out.println("Class Selected, Starting Game");
                setState(GameState.game);
                break;
            case Menu:
                System.out.println("Back to Main Menu");
                setState(MenuState.menu);
                break;
        }
    }

    public void tick() {
    }


    public void render(Graphics g) {
        createView.render(g);
        //RENDER THIS INTERFACE (NOT GAME INTERFACE
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            createView.previous();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            createView.next();
        }

        if(e.getKeyCode() == 10) {

            assignOccupation(createView.getOccSelection());  //Get selected occ, make a player
            switchState(createView.getSelection());          //Start game

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
