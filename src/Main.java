/**
 * Created by jlkegley on 1/31/2016.
 */

import Model.Game;
import View.View;

public class Main {

    public static void main(String args[]) {
        System.out.println("Hello World");

        int width = 800;
        int height = 600;
        View gameView = new View("Ironic Cats", width, height);

        Game game = new Game(width, height);


        gameView.setVisible(true);
        //Starting the View and Game clocks/threads
        gameView.start();
        game.start();

    }

}