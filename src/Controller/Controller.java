package Controller;

import Model.Game;

import javax.naming.ldap.Control;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class Controller {

    private Game game;
    private InputManager inputManager;


    public Controller(Game game, InputManager inputManager) {
        this.game = game;
        this.inputManager = inputManager;
    }

    public InputManager getInputManager() {
        return inputManager;
    }

    public void setInputManager(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }


}
