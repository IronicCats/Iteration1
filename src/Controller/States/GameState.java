package Controller.States;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.management.ManagementFactory;

import Controller.Controller;
import Model.Entity.Entity;
import Model.Entity.Inventory.Inventory;
import Model.Entity.Inventory.Pack;
import Model.Entity.Player;
import Model.Item.Item;
import Model.Item.ItemsEnum;
import Model.Item.Useable;
import Model.Location;

import Model.Map.Map;
import Model.Map.Tiles.Tile;
import View.Graphics.Assets;
import View.Graphics.Camera;
import View.View;
import View.Views.PauseMenu;

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

    public GameState(Controller controller) {
        super(controller);
        game = this;
        map = new Map(controller);
        controller.setMap(map);
        camera = new Camera(controller.getGame().getWidth(), controller.getGame().getHeight(),map);
        controller.setCamera(camera);
        pack = new Pack(16);
        inventory = new Inventory(controller,pack,null);
        player = new Player(controller,1 * (Tile.TILEWIDTH ),1 * (Tile.TILEHEIGHT),inventory);
        location = new Location(3,3,0);

        potion = new Useable(Assets.potion,1,location, ItemsEnum.USEABLE,"Potion","heals",null);

        map.getTile(5,5).addItem(potion);
        controller.setPlayer(player);

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
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


