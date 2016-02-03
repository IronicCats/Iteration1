package Controller.States;

import java.awt.*;
import Controller.Controller;
import Model.Entity.Entity;
import Model.Entity.Player;
import Model.Location;
import Model.Map.Map;
import View.Graphics.Camera;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class GameState extends State {

    //Need Entity Avatar, World

    private Map map;
    private Camera camera;
    private Player player;

    public GameState(Controller controller) {
        super(controller);
        camera = new Camera(controller.getGame().getWidth(), controller.getGame().getHeight());
        controller.setCamera(camera);

        map = new Map(controller);
        player = new Player(controller,0,0);

    }

    public void tick() {
        player.tick();
        camera.centerOnPlayer(player);
        //camera.centerOnPlayer(player.getLocation());

        //System.out.println("Tick GameState");
        //tick world
        //tick entity
    }
        public void render (Graphics g){
            //System.out.println("Render GameState");

            map.render(g);
            player.render(g);
            //render entity
        }
    }


