package Controller;

import Model.Game;
import View.Graphics.Camera;
import View.View;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class Controller {

    private Game game;
    private InputManager inputManager;
    private Camera camera;


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

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }
}
