package Controller.States;

import java.awt.*;
import Controller.Controller;
import View.Views.MainMenu;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class MenuState extends State {
    MainMenu menu;
    public MenuState(Controller controller, int width, int height) {

        super(controller);
        menu = new MainMenu(width, height);

    }

    public void tick() {

    }

    public void render(Graphics g) {
        menu.render(g);
        //RENDER THIS INTERFACE (NOT GAME INTERFACE
    }

}
