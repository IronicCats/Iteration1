package Model.Entity;

import Controller.Controller;
import Model.Entity.Inventory.Inventory;
import Model.Game;
import Model.Location;
import View.Graphics.Assets;
import com.sun.xml.internal.bind.v2.TODO;
import Model.Entity.Nav;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
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
   /* public void loadPlayer(File input, BufferedReader read)
    {
        /*System.out.print("stuff is here");
        try {
            System.out.println("heeeeey");
            Location l = new Location(Integer.parseInt(read.readLine()),Integer.parseInt(read.readLine()),0);
            //read.close();
            System.out.println("whhhhhhy");
            this.setLocation(l);
            System.out.println("whut up ");
            System.out.print(Float.toString(this.getX()));
            System.out.print(this.getY());


        }catch(Exception e){}

    }*/
    public void loadPlayer(ArrayList<Object> saveFile)
    {
        Location l = new Location((int)saveFile.get(0),(int)saveFile.get(1),0);
        this.setLocation(l);

    }

}
