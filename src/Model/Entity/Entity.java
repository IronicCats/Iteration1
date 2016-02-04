package Model.Entity;

import Controller.Controller;
import Model.Game;
import Model.Location;
import Model.Map.Tiles.Tile;

import java.awt.*;

/**
 * Created by broskj on 1/31/16.
 */



public abstract class Entity {

    protected float speed;
    protected float xVelocity, yVelocity;
    protected Controller controller;
    protected int width, height;
    protected Location location;
    protected Rectangle bounds;

    public Entity(Controller controller, float x, float y, int width, int height){
        location = new Location((int)x, (int)y, 0);
        this.controller = controller;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0, 0, width , height);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public float getX() {
        return location.getX();
    }

    public void setX(float x) {
        location.setX((int) x);
    }

    public float getY() {
        return location.getY();
    }

    public void setY(float y) {
        location.setY((int) y);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }




    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
