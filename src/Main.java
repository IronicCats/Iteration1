/**
 * Created by jlkegley on 1/31/2016.
 */

import Controller.InputManager;
import Model.Game;
import View.View;

public class Main {



    public static void main(String args[]) {
        System.out.println("Hello World");

        InputManager inputManager = new InputManager();
        int width = 800;
        int height = 600;
        View gameView = new View("Ironic Cats", width, height);
        gameView.addKeyListener(inputManager);

        Game game = new Game(inputManager, width, height);


        gameView.setVisible(true);
        //Starting the View and Game clocks/threads
        gameView.start();
        game.start();

    }

}