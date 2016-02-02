package Controller.States;

import java.awt.*;
import Controller.Controller;
import Model.Entity.Entity;
import Model.Entity.Player;
import Model.Map.Map;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class GameState extends State {

    //Need Entity Avatar, World

    private Map map;
    private Player player;

    public GameState(Controller controller) {
        super(controller);
        map = new Map();
        player = new Player(controller,100,100);
    }

    public void tick() {
        player.tick();
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


