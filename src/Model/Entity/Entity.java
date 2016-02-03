package Model.Entity;

import Controller.Controller;
import Model.Entity.Stats.Stats;
import Model.Location;

import java.awt.Graphics;

/**
 * Created by broskj on 1/31/16.
 */



public abstract class Entity {
    public static final float DEFAULT_SPEED = 3.0f;

    private Stats stats;

    protected float speed;
    protected float xVelocity, yVelocity;
    protected Controller controller;
    protected int width, height;
    protected Location location;

    public Entity(Controller controller, float x, float y, int width, int height) {
        location = new Location((int)x, (int)y, 0);
        this.controller = controller;
        this.width = width;
        this.height = height;
    }

    public Entity(Controller controller, float x, float y, int width, int height, int direction) {
        this(controller, x, y, width, height);
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

    public float getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(float yVelocity) {
        this.yVelocity = yVelocity;
    }

    public float getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(float xVelocity) {
        this.xVelocity = xVelocity;
    }


    public void move(){
        moveX();
        moveY();
    }

    public void moveX(){
        location.setX((int) (location.getX() + xVelocity));
    }

    public void moveY(){
        location.setY((int) (location.getY() + yVelocity));
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
