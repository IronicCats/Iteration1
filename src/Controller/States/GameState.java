package Controller.States;

import java.awt.*;
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

/**
 * Created by jlkegley on 1/31/2016.
 */
public class GameState extends State {

    private Map map;
    private Camera camera;
    private Player player;
    private Useable potion;
    private Location location;
    private Inventory inventory;
    private Pack pack;

    public GameState(Controller controller) {
        super(controller);
        map = new Map(controller);
        controller.setMap(map);
        camera = new Camera(controller.getGame().getWidth(), controller.getGame().getHeight(),map);
        controller.setCamera(camera);
        pack = new Pack(10);
        inventory = new Inventory(pack,null);
        player = new Player(controller,1 * (Tile.TILEWIDTH ),1 * (Tile.TILEHEIGHT),inventory);
        location = new Location(5,5,0);
        potion = new Useable(Assets.potion,1,location, ItemsEnum.USEABLE,"Potion","heals",null);
        map.getTile(5,5).addItem(potion);

    }

    public void tick() {
        player.tick();

    }
    public void render (Graphics g){
        camera.centerOnPlayer(player);
        map.render(g);
        player.render(g);

    }
}


