package Controller;

import Model.Game;

import javax.naming.ldap.Control;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class Controller {

    private Game game;

    public Controller(Game game) {

    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }


}
