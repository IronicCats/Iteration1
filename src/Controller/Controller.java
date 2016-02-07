package Controller;

import Model.Entity.Player;
import Model.Game;
import Model.Location;
import Model.Map.Map;
import Model.Map.Tiles.Tile;
import View.Graphics.Camera;
import View.View;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class Controller {

    private Game game;
    private InputManager inputManager;
    private Camera camera;
    private Map map;
    private Player player;

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

    public void setPlayer(Player p) {
        this.player = p;
    }

    public Player getPlayer() {
        return player;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Tile getTiles(int x, int y) {
        return map.getTile(x, y);
    }

    public Tile getTiles(Location location) {return map.getTile(location);}

}
