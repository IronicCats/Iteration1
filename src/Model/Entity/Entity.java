package Model.Entity;

import Controller.Controller;
import Model.Game;

import java.awt.Graphics;

/**
 * Created by broskj on 1/31/16.
 */



public abstract class Entity {
    public static final float DEFAULT_SPEED = 3.0f;

    protected float speed;
    protected float xVelocity, yVelocity;
    protected Controller controller;
    protected float x,y;
    protected int width, height;

    public Entity(Controller controller, float x, float y, int width, int height){
        this.controller = controller;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
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
        x += xVelocity;
    }

    public void moveY(){
        y += yVelocity;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
