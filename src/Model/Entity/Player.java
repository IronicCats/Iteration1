package Model.Entity;

import Controller.Controller;
import Model.Entity.Inventory.Inventory;
import Model.Game;
import Model.Location;
import View.Graphics.Assets;
import com.sun.xml.internal.bind.v2.TODO;
import Model.Entity.Nav;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Aidan on 1/31/2016.
 */
public class Player extends Entity {
    private Nav navigation;
    private Inventory inventory;

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
        if(!navigation.isMoving) {
            getMovementInput();
        }else {
            navigation.move();
        }
        //navigation.move(navigation.getxVelocity(),navigation.getyVelocity());
    }

    public void getMovementInput(){
       // navigation.setyVelocity(0);
        //navigation.setxVelocity(0);
        //TODO: Add the numpad movement options
        if (controller.getInputManager().N) {
            //navigation.setyVelocity(-(speed)]]);
            //location.setY(location.getY() - 64);
            navigation.move(0);
        } else if (controller.getInputManager().E) {
            //navigation.setxVelocity((speed));
            //location.setX(location.getX() + 64);
            navigation.move(1);

        } else if (controller.getInputManager().S) {
            //navigation.setyVelocity((speed));
            navigation.move(2);
        } else if (controller.getInputManager().W) {
            //navigation.setxVelocity(-(speed));
            navigation.move(3);
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

    public Inventory getInventory(){return inventory;}

    public void savePlayer(ArrayList<Object> saveFile)
    {

        //saveFile.add(this);         //should add this instance to ArrayList, probably not needed
        //needs to get the stats next
        //needs to get the inventory
        //
        //as a VERY possible possibility i can instead of getting an Object array, just get an array List of ints for location, stats, and maybe inventory
        saveFile.add(this.getLocation());

        saveFile.add(this.getStats()); //okay as a note I should now be able to do getStats().(specific stat)
        //getInventory().saveInventory(saveFile); //fixme


    }

}
