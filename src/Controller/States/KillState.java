package Controller.States;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Controller.Controller;
import View.*;
import View.Views.KillMenu;

public class KillState extends State implements KeyListener {
    public KillMenu killMenu;
    public static KillState state;

    public KillState(Controller controller, int width, int height) {
        super(controller);
        killMenu = new KillMenu(width, height);
        state = this;
    }

    public void switchState(States stateNumber) {
        switch(stateNumber) {
            case Menu:
                System.out.println("Main Menu");
                //Add the Load Game state switch here
                setState(MenuState.menu);
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
        killMenu.render(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            killMenu.previous();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            killMenu.next();
        }

        if(e.getKeyCode() == 10) {
            switchState(killMenu.getSelection());
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
