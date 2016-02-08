package Model.Entity;

import Controller.Controller;
import Model.Entity.Inventory.Inventory;
import Model.Entity.Occupation.Occupation;
import Model.Entity.Occupation.Smasher;
import Model.Entity.Occupation.Sneak;
import Model.Entity.Occupation.Summoner;
import Model.Entity.Inventory.Pack;
import Model.Entity.Stats.Stats;
import Model.Location;
import Model.Map.Tiles.Tile;

import java.awt.*;

/**
 * Created by broskj on 1/31/16.
 */

public abstract class Entity {

    private Stats stats;
    private Occupation occupation;
    protected Location location;
    private Inventory inventory;
    private Nav nav;



    protected float speed;
    protected Controller controller;
    protected int width, height;
    protected Rectangle bounds;

    public Entity(Controller controller, Location location, int width, int height, Occupation o, Stats stats) {
        this.location = location;
        this.controller = controller;
        this.width = width;
        this.height = height;
        this.occupation = o;
        this.stats = stats;
        this.bounds = new Rectangle(0, 0, width , height);
        bounds = new Rectangle(0, 0, width , height);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public float getPixelX() {
        return location.getPixelX();
    }

    public void setX(int x) {
        location.setX(x);
    }

    public float getPixelY() {
        return location.getPixelY();
    }

    public void setY(int y) {
        location.setY(y);
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

    public void setStats(Stats stats){this.stats = stats;}

    public Occupation getOccupation() { return occupation; }

}
