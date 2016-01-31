package Controller.States;

import java.awt.*;
import Controller.Controller;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class GameState extends State {

    //Need Entity Avatar, World


    public GameState(Controller controller) {
        super(controller);
    }

    public void tick() {
        System.out.println("Tick GameState");
        //tick world
        //tick entity
    }

    public void render(Graphics g) {
        System.out.println("Render GameState");

        //render world
        //render entity
    }

}
