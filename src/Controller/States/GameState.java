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
import View.Views.PauseMenu;
import View.Views.StatusView;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class GameState extends State {

    public static GameState game;
    private Map map;
    private Camera camera;
    private Player player;
    private Useable potion;
    private Location location;
    private Inventory inventory;
    private Pack pack;

    private StatusView statusView;
    private Stats stats;
    private Occupation occupation;
    private AreaEffect areaEffect;

    public GameState(Controller controller) {
        super(controller);
        game = this;
        map = new Map(controller);
        controller.setMap(map);
        camera = new Camera(controller.getGame().getWidth(), controller.getGame().getHeight(),map);
        controller.setCamera(camera);



        pack = new Pack(10);
        inventory = new Inventory(controller);
        occupation = new Smasher();
        stats = new Stats(occupation.getInitialStats());
        player = new Player(controller,new Location(1 * (Tile.TILEWIDTH ),1 * (Tile.TILEHEIGHT), 0),inventory, occupation, stats);

        location = new Location(3,3,0);

        areaEffect = new AreaEffect("Damage", "Damage", AreaEffectEnum.HEAL, new Location(7,8,0));
        map.getTile(2,2).addAreaEffect(areaEffect);

        controller.setPlayer(player);
        statusView = new StatusView(controller);

    }

    public void switchState(States stateNumber) {
        switch(stateNumber) {
            case Game:
                System.out.println("Resume Game");
                setState(GameState.game);
                break;
            case Inventory:
                System.out.println("Inventory Selection ");
                break;
            case Pause:
                View.view.removeKeyListener(MenuState.menu);
                View.view.removeKeyListener(this);
                View.view.addKeyListener(PauseState.pause);
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

        if(e.getKeyCode() == KeyEvent.VK_Q){
            controller.getPlayer().PickUpItem();
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
}


