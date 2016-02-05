package Controller.States;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

import Controller.Controller;
import View.*;
import View.Views.MainMenu;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class MenuState extends State implements KeyListener {
    MainMenu menu;
    public MenuState(Controller controller, int width, int height) {

        super(controller);
        View.view.addKeyListener(this);
        menu = new MainMenu(width, height);
    }

    public void switchState(int stateNumber) {
        switch(menu.getSelection()) {
            case 0:
                System.out.println("Create Game");
                setState(GameState.game);
                break;
            case 1:
                System.out.println("Load Game");
                break;
        }
    }

    public void tick() {

    }


    public void render(Graphics g) {
        menu.render(g);
        //RENDER THIS INTERFACE (NOT GAME INTERFACE
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            menu.previous();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            menu.next();
        }

        if(e.getKeyCode() == 10) {
            switchState(menu.getSelection());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
