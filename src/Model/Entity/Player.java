package Model.Entity;

import Controller.Controller;
import Model.Game;
import View.Graphics.Assets;
import com.sun.xml.internal.bind.v2.TODO;

import java.awt.Graphics;
/**
 * Created by Aidan on 1/31/2016.
 */
public class Player extends Entity {
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64,
            DEFAULT_CREATURE_HEIGHT = 64;


    public Player(Controller controller,float x, float y) {
        super(controller, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
        speed = DEFAULT_SPEED;
    }


    @Override
    public void tick() {
        getInput();
        move();
    }

    public void getInput(){
        yVelocity = 0;
        xVelocity = 0;
        //TODO: Add the numpad movement options
        if(controller.getInputManager().N) {
            yVelocity = -(speed);
        }
        if(controller.getInputManager().E) {
            xVelocity = (speed);

        }
        if(controller.getInputManager().S) {
            yVelocity = (speed);

        }
        if(controller.getInputManager().W) {
            xVelocity = -(speed);

        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.avatar,
                (int) (getX() - controller.getCamera().getxOffset()),
                (int) (getY() - controller.getCamera().getyOffset()),
                width,
                height,
                null
        );
    }

}
