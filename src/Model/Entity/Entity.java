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

    public static final float DEFAULT_SPEED = 3.0f;

    protected float speed;
    protected float xVelocity, yVelocity;
    protected Controller controller;
    protected float x,y;
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
        if(xVelocity > 0){//Moving right
            int tx = (int) (getX() + xVelocity + bounds.x + bounds.width) / Tile.TILEWIDTH;

            if(!collisionWithTile(tx, (int) (getY() + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
                setX(getX() + xVelocity);
            }else{
                setX(tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1);
            }

        }else if(xVelocity < 0){//Moving left
            int tx = (int) (getX() + xVelocity + bounds.x) / Tile.TILEWIDTH;

            if(!collisionWithTile(tx, (int) (getY() + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
                setX(getX() + xVelocity);
            }else{
                setX(tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x);
            }

        }
        }


    public void moveY(){
        if(yVelocity < 0){//Up
            int ty = (int) (getY() + yVelocity + bounds.y) / Tile.TILEHEIGHT;
            System.out.println("Position: X" + getX() + bounds.x + " Y" + ty );
            if(!collisionWithTile((int) (getX() + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty) ){
                setY(getY() + yVelocity);
            }else{
                setY(ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y);
            }

        }else if(yVelocity > 0){//Down
            int ty = (int) (getY() + yVelocity + bounds.y + bounds.height) / Tile.TILEHEIGHT;

            if(!collisionWithTile((int) (getX() + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
                setY(getY() + yVelocity);
            }else{
                setY(ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1);
            }

        }
        }

    protected boolean collisionWithTile(int x, int y){
        return controller.getMap().getTile(x, y).isUnWalkable;
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
