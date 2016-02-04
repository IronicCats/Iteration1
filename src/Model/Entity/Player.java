package Model.Entity;

import Controller.Controller;
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
        super(controller, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
        speed = DEFAULT_SPEED;
        bounds.x = 0;
        bounds.y = 0;
        navigation = new Nav(location,bounds,controller);
        bounds.width = DEFAULT_CREATURE_WIDTH;
        bounds.height = DEFAULT_CREATURE_HEIGHT;
    }


    @Override
    public void tick() {
        getInput();
        navigation.move(navigation.getxVelocity(),navigation.getyVelocity());
    }

    public void getInput(){
        navigation.setyVelocity(0);
        navigation.setxVelocity(0);
        //TODO: Add the numpad movement options
        if(controller.getInputManager().N) {
            navigation.setyVelocity(-(speed));
        }
        if(controller.getInputManager().E) {
            navigation.setxVelocity((speed));

        }
        if(controller.getInputManager().S) {
            navigation.setyVelocity((speed));
        }
        if(controller.getInputManager().W) {
            navigation.setxVelocity(-(speed));
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
        //g.setColor(Color.red);
        //g.fillRect((int)(getX() + bounds.x - controller.getCamera().getxOffset()), (int)(getY() + bounds.y - controller.getCamera().getyOffset()), bounds.width, bounds.height);
    }

}
