package Controller.States;

import Controller.Controller;
import View.View;
import View.Views.MainMenu;
import View.Views.PauseMenu;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by jlkegley on 2/5/2016.
 */
public class PauseState extends State {
    PauseMenu pauseMenu;
    public static PauseState pause;

    public PauseState(Controller controller, int width, int height) {

        super(controller);
        pause = this;
        pauseMenu = new PauseMenu(width, height);
    }

    public void switchState(States stateNumber) {
        switch(stateNumber) {
            case Game:
                System.out.println("Resume Game");
                setState(GameState.game);
                break;
            case Save:
                System.out.println("Save Game");
                setState(SaveState.save);
                break;
            case Load:
                System.out.println("Load Game");
                LoadState.setPreviousState(States.Pause);
                setState(LoadState.load);
                break;
            case Exit:
                System.out.println("Exit Game");
                System.exit(0);
                break;
        }
    }


    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        controller.getCamera().centerOnPlayer(controller.getPlayer());
        controller.getMap().render(g);
        controller.getPlayer().render(g);
        pauseMenu.render(g);


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            pauseMenu.previous();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            pauseMenu.next();
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            switchState(States.Game);
        }
        if(e.getKeyCode() == 10) {
            switchState(pauseMenu.getSelection());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
