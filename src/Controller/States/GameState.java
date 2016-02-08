package Controller.States;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.management.ManagementFactory;

import Controller.Controller;
import Model.Entity.Entity;
import Model.Entity.Inventory.Equipment.Equipment;
import Model.Entity.Inventory.Inventory;
import Model.Entity.Inventory.Pack;
import Model.Entity.Occupation.Occupation;
import Model.Entity.Occupation.Smasher;
import Model.Entity.Player;
import Model.Entity.Stats.Effect;
import Model.Entity.Stats.StatStructure;
import Model.Entity.Stats.Stats;
import Model.Entity.Stats.StatsEnum;
import Model.Item.Item;
import Model.Item.ItemsEnum;
import Model.Item.Useable;
import Model.Location;

import Model.Map.AreaEffect;
import Model.Map.AreaEffectEnum;
import Model.Map.Map;
import Model.Map.Tiles.Tile;
import View.Graphics.Assets;
import View.Graphics.Camera;
import View.View;
import View.Views.CreateMenu;
import View.Views.PauseMenu;
import View.Views.StatusView;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class GameState extends State {

    public static GameState game;
    private Map map;
    private Camera camera;
    private Useable potion;
    private Location location;
    private Player player;
    private StatusView statusView;
    private AreaEffect areaEffect;



    public GameState(Controller controller) {
        super(controller);
        game = this;
        statusView = new StatusView(controller);

    }

    public void switchState(States stateNumber) {
        switch(stateNumber) {
            case Game:
                System.out.println("Resume Game");
                setState(GameState.game);
                break;
            case Inventory:
                System.out.println("Inventory Selection");
                setState(InventoryState.inventory);
                break;
            case Gear:
                System.out.println("Gear selection");
                setState(GearState.gear);
                break;
            case Pause:
                System.out.println("Pause Game");
                //Add the Load Game state switch here
                setState(PauseState.pause);
                break;
            case Exit:
                System.out.println("Exit Game");
                System.exit(0);
                break;
        }

    }

    public void tick() {

        player.tick();
    }
    public void render (Graphics g){
        camera.centerOnPlayer(player);
        map.render(g);
        player.render(g);
        statusView.render(g);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            switchState(States.Pause);
        }

        if(e.getKeyCode() == KeyEvent.VK_I) {
            switchState(States.Inventory);
        }

        if(e.getKeyCode() == KeyEvent.VK_G) {
            switchState(States.Gear);
        }

        if(e.getKeyCode() == KeyEvent.VK_Q){
            controller.getPlayer().PickUpItem();
            SaveState.writeFile(player,"Player test.txt");
        }

        if((e.getKeyCode() == KeyEvent.VK_NUMPAD8 || e.getKeyCode() == KeyEvent.VK_UP)){
            controller.getPlayer().move(0);
        }
        if((e.getKeyCode() == KeyEvent.VK_NUMPAD6 || e.getKeyCode() == KeyEvent.VK_RIGHT)){
            controller.getPlayer().move(1);

        }
        if((e.getKeyCode() == KeyEvent.VK_NUMPAD2 || e.getKeyCode() == KeyEvent.VK_DOWN)){
            controller.getPlayer().move(2);

        }
        if((e.getKeyCode() == KeyEvent.VK_NUMPAD4 || e.getKeyCode() == KeyEvent.VK_LEFT)){
            controller.getPlayer().move(3);

        }

        if(e.getKeyCode() == KeyEvent.VK_NUMPAD9){
            controller.getPlayer().move(4);

        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD3){
            controller.getPlayer().move(5);

        }
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD1){
            controller.getPlayer().move(6);

        }
       if(e.getKeyCode() == KeyEvent.VK_NUMPAD7){
            controller.getPlayer().move(7);

        }

        if(e.getKeyCode() == KeyEvent.VK_K) {
            player.getStats().applyEffect(new Effect(new StatStructure(StatsEnum.LIFE, -1), 0, "Take Damage"));
        }
        if(e.getKeyCode() == KeyEvent.VK_L) {
            player.getStats().applyEffect(new Effect(new StatStructure(StatsEnum.EXPERIENCE, 1), 0, "At 1 EXP "));
        }

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    //the game state needs to be able to save the player, the camera
    //The player needs to be able to save it's stats and inventory
    //items need to be able to save charge
    //needs to be able to pass the current saved game state to the save state


    //Initializes game state with Player/Map/Camera data from Create or Load states.
    //Can't have this stuff in the Constructor since every State object made at same time.
    public void init(){
        player = controller.getPlayer();
        camera = controller.getCamera();
        map = controller.getMap();


        return;
    }
}
