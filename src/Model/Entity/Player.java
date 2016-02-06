package Model.Entity;

import Controller.Controller;
import Model.Entity.Occupation.Smasher;
import Model.Game;
import View.Graphics.Assets;
import com.sun.xml.internal.bind.v2.TODO;
import Model.Entity.Nav;

import java.awt.*;

/**
 * Created by Aidan on 1/31/2016.
 */
public class Player extends Entity {
    private Nav navigation;

    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64,
                            DEFAULT_CREATURE_HEIGHT = 64;

    public Player(Controller controller,float x, float y) {
        super(controller, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT, new Smasher());
        speed = DEFAULT_SPEED;
        bounds.x = 0;
        bounds.y = 0;
        navigation = new Nav(location,bounds,controller);
        bounds.width = DEFAULT_CREATURE_WIDTH;
        bounds.height = DEFAULT_CREATURE_HEIGHT;
    }


    @Override
    public void tick() {
        if(!navigation.isMoving) {
            getMovementInput();
        }else {
            navigation.move();
        }
        //navigation.move(navigation.getxVelocity(),navigation.getyVelocity());
    }

    public void getMovementInput(){
        //TODO: Add the numpad movement options
        if (controller.getInputManager().N) {
            navigation.move(0);
        } else if (controller.getInputManager().E) {
            navigation.move(1);

        } else if (controller.getInputManager().S) {
            navigation.move(2);
        } else if (controller.getInputManager().W) {
            navigation.move(3);
        }
        else if(controller.getInputManager().NE){
            navigation.move(4);
        }
        else if(controller.getInputManager().NW){
            navigation.move(5);
        }
        else if(controller.getInputManager().SW){
            navigation.move(6);
        }
        else if(controller.getInputManager().SE){
            navigation.move(7);
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
