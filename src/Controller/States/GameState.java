package Controller.States;

import java.awt.*;
import Controller.Controller;
import Model.Map.Map;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class GameState extends State {

    //Need Entity Avatar, World

    private Map map;

    public GameState(Controller controller) {
        super(controller);
        map = new Map();
    }

    public void tick() {
        System.out.println("Tick GameState");
        //tick world
        //tick entity
    }

    public void render(Graphics g) {
        System.out.println("Render GameState");

        map.render(g);
        //render entity
    }

}
