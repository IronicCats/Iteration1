package Controller.States;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Controller.Controller;
import View.*;
import View.Views.MainMenu;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class MenuState extends State implements KeyListener {
    public MainMenu menuView;
    public static MenuState menu;

    public MenuState(Controller controller, int width, int height) {

        super(controller);
        menu = this;
        menuView = new MainMenu(width, height);
    }

    public void switchState(States stateNumber) {
        switch(stateNumber) {
            case Create:
                System.out.println("Create Game");
                setState(CreateState.createState);
                break;
            case Load:
                System.out.println("Load Game");
                //Add the Load Game state switch here
                LoadState.setPreviousState(States.Menu);
                setState(LoadState.load);
                break;
            case Exit:
                System.out.println("Exit Game");
                System.exit(0);
                break;
        }
    }

    public void tick() {
    }


    public void render(Graphics g) {
        menuView.render(g);
        //RENDER THIS INTERFACE (NOT GAME INTERFACE
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            menuView.previous();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            menuView.next();
        }

        if(e.getKeyCode() == 10) {
            switchState(menuView.getSelection());
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
