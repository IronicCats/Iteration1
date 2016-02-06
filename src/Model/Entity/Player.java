package Model.Entity;

import Controller.Controller;
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
    boolean PlayerIsHoldingButton;
    boolean PlayerIsSittingonTile = false;

    public Player(Controller controller,float x, float y, Inventory inventory) {
        super(controller, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
        speed = DEFAULT_SPEED;
        bounds.x = 0;
        bounds.y = 0;
        navigation = new Nav(location,bounds,controller,this);
        bounds.width = DEFAULT_CREATURE_WIDTH;
        bounds.height = DEFAULT_CREATURE_HEIGHT;
        this.inventory = inventory;
        PlayerIsHoldingButton = false;
    }


    @Override
    public void tick() {
        controller.getTiles(location.getX()/64,location.getY()/64).addPlayer(this);
        if(!navigation.isMoving) {
            getMovementInput();
        }else {
            navigation.move();
        }
        if(controller.getTiles(location.getX()/64,location.getY()/64).HasItem && !PlayerIsSittingonTile){
            System.out.println("This tile has an item!");
            inventory.store(controller.getTiles(location.getX()/64,location.getY()/64).removeItem());
            PlayerIsSittingonTile = true;
        }

    }

    public void getMovementInput(){
        if (controller.getInputManager().N) {
            controller.getTiles(location.getX()/64,location.getY()/64).removePlayer(this);
            navigation.move(0);
        } else if (controller.getInputManager().E) {
            controller.getTiles(location.getX()/64,location.getY()/64).removePlayer(this);
            navigation.move(1);

        } else if (controller.getInputManager().S) {
            controller.getTiles(location.getX()/64,location.getY()/64).removePlayer(this);
            navigation.move(2);
        } else if (controller.getInputManager().W) {
            controller.getTiles(location.getX()/64,location.getY()/64).removePlayer(this);
            navigation.move(3);
        }
        else if(controller.getInputManager().NE){
            controller.getTiles(location.getX()/64,location.getY()/64).removePlayer(this);
            navigation.move(4);
        }
        else if(controller.getInputManager().NW){
            controller.getTiles(location.getX()/64,location.getY()/64).removePlayer(this);
            navigation.move(5);
        }
        else if(controller.getInputManager().SW){
            controller.getTiles(location.getX()/64,location.getY()/64).removePlayer(this);
            navigation.move(6);
        }
        else if(controller.getInputManager().SE){
            controller.getTiles(location.getX()/64,location.getY()/64).removePlayer(this);
            navigation.move(7);
        }
        else if(controller.getInputManager().drop) {
            if (!PlayerIsHoldingButton) {
                controller.getTiles(location.getX() / 64, location.getY() / 64).addItem(inventory.drop());
                PlayerIsHoldingButton = true;
            }
        }
        if(!controller.getInputManager().drop && PlayerIsHoldingButton){
            PlayerIsHoldingButton = false;
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
