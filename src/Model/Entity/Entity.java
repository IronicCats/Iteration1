package Model.Entity;

import Controller.Controller;
import Model.Entity.Inventory.Inventory;
import Model.Entity.Occupation.Occupation;
import Model.Entity.Occupation.Smasher;
import Model.Entity.Occupation.Sneak;
import Model.Entity.Occupation.Summoner;
import Model.Entity.Stats.Stats;
import Model.Location;
import Model.Map.Tiles.Tile;

import java.awt.*;

/**
 * Created by broskj on 1/31/16.
 */

public abstract class Entity {

    public static final float DEFAULT_SPEED = 3.0f;

    private Stats stats;
    private Occupation occupation;
    protected Location location;
    private Inventory inventory;
    private Nav nav;


    protected float speed;
    protected float xVelocity, yVelocity;
    protected Controller controller;
    protected int width, height;
    protected Rectangle bounds;

    public Entity(Controller controller, float x, float y, int width, int height, Occupation o) {
        this.location = new Location((int)x, (int)y, 0);
        this.controller = controller;
        this.width = width;
        this.height = height;
        this.occupation = o;
        this.bounds = new Rectangle(0, 0, width , height);
    }

    public Entity(Controller controller, float x, float y, int width, int height, int direction, Occupation o) {
        this(controller, x, y, width, height,o);
        location.setDir(direction);
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

    public void useItem(){}

    public void equipItem(){}

    public void uneuquipItem(){}

    public void dropItem(){}

    public void pause(){}

    public void openInventory(){}

    public void openMenu(){}

    public Stats getStats() { return stats; }

}
