package Model.Entity;

import Controller.Controller;
import Model.Entity.Occupation.Smasher;
import Model.Entity.Inventory.Inventory;
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
    private Inventory inventory;

    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64,
                            DEFAULT_CREATURE_HEIGHT = 64;


    public Player(Controller controller,float x, float y, Inventory inventory) {
        super(controller, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT, new Smasher());
        speed = DEFAULT_SPEED;
        bounds.x = 0;
        bounds.y = 0;
        navigation = new Nav(location,bounds,controller,this);
        bounds.width = DEFAULT_CREATURE_WIDTH;
        bounds.height = DEFAULT_CREATURE_HEIGHT;
        this.inventory = inventory;
    }


    @Override
    public void tick() {
        navigation.move();
    }

    public void PickUpItem(){
        if(controller.getTiles(location.getX()/64,location.getY()/64).HasItem) {
            inventory.store(controller.getTiles(location.getX() / 64, location.getY() / 64).removeItem());
        }
    }

    public void move(int x){
        if (x == 0) {
            controller.getTiles(location.getX()/64,location.getY()/64).removePlayer(this);
            navigation.move(x);
            controller.getTiles(location.getX()/64,location.getY()/64).addPlayer(this);

        } else if (x == 1) {
            controller.getTiles(location.getX()/64,location.getY()/64).removePlayer(this);
            navigation.move(x);
            controller.getTiles(location.getX()/64,location.getY()/64).addPlayer(this);

        } else if (x == 2) {
            controller.getTiles(location.getX()/64,location.getY()/64).removePlayer(this);
            navigation.move(x);
            controller.getTiles(location.getX()/64,location.getY()/64).addPlayer(this);

        } else if (x == 3) {
            controller.getTiles(location.getX()/64,location.getY()/64).removePlayer(this);
            navigation.move(x);
            controller.getTiles(location.getX()/64,location.getY()/64).addPlayer(this);

        }
        else if(x == 4){
            controller.getTiles(location.getX()/64,location.getY()/64).removePlayer(this);
            navigation.move(x);
            controller.getTiles(location.getX()/64,location.getY()/64).addPlayer(this);

        }
        else if(x == 5){
            controller.getTiles(location.getX()/64,location.getY()/64).removePlayer(this);
            navigation.move(x);
            controller.getTiles(location.getX()/64,location.getY()/64).addPlayer(this);

        }
        else if(x == 6){
            controller.getTiles(location.getX()/64,location.getY()/64).removePlayer(this);
            navigation.move(x);
            controller.getTiles(location.getX()/64,location.getY()/64).addPlayer(this);

        }
        else if(x == 7){
            controller.getTiles(location.getX()/64,location.getY()/64).removePlayer(this);
            navigation.move(x);
            controller.getTiles(location.getX()/64,location.getY()/64).addPlayer(this);

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
