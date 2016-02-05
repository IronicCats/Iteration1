package Controller.States;

import java.awt.*;
import Controller.Controller;
import Model.Entity.Entity;
import Model.Entity.Player;
import Model.Location;
import Model.Map.Map;
import Model.Map.Tiles.Tile;
import View.Graphics.Camera;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class GameState extends State {

    private Map map;
    private Camera camera;
    private Player player;

    public GameState(Controller controller) {
        super(controller);
        map = new Map(controller);
        controller.setMap(map);
        camera = new Camera(controller.getGame().getWidth(), controller.getGame().getHeight(),map);
        controller.setCamera(camera);
        player = new Player(controller,1 * (Tile.TILEWIDTH ),1 * (Tile.TILEHEIGHT));

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


