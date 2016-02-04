package Model.Entity;

import Controller.Controller;
import Model.Location;
import Model.Map.Tiles.Tile;

import java.awt.*;

/**
 * Created by Aidan on 2/3/2016.
 */
public class Nav {

    protected float xVelocity, yVelocity;
    protected static Controller controller;
    protected static Location location;
    protected static Rectangle bounds;
    protected int goalX;
    protected int goalY;

    protected boolean isMoving = false;

    public Nav(Location location,Rectangle bounds, Controller controller){
        goalX = location.getX();
        goalY = location.getY();
        this.location = location;
        this.bounds = bounds;
        this.controller = controller;
    }

    public void move(int direction) {
        isMoving = true;
        boolean Obstaclecheck = true;
        if (direction == 0) {
            if (controller.getTiles((location.getX())/64, (location.getY() - 64) / 64).isUnWalkable) {
                Obstaclecheck = false;
            }
            if (Obstaclecheck) {
                goalY = location.getY() - Tile.TILEHEIGHT;
            }
        }else if (direction == 1) {
                if (controller.getTiles((location.getX() + 64) / 64, (location.getY()) / 64).isUnWalkable) {
                    Obstaclecheck = false;
                }
                if (Obstaclecheck) {
                    goalX = location.getX() + Tile.TILEWIDTH;
                }
            } else if (direction == 2) {
            if (controller.getTiles((location.getX()) / 64, (location.getY() + 64) / 64).isUnWalkable) {
                Obstaclecheck = false;
            }
            if(Obstaclecheck) {
                goalY = location.getY() + Tile.TILEHEIGHT;
            }
            } else/*3*/ {
            if (controller.getTiles((location.getX() - 64) / 64, (location.getY()) / 64).isUnWalkable) {
                Obstaclecheck = false;
            }
            if (Obstaclecheck) {
                goalX = location.getX() - Tile.TILEWIDTH;
            }
        }
    }

    public void move() {
        if(location.getY() == goalY && location.getX() == goalX) {
            isMoving = false;
        }else {
            //TWEEN TO LOCATION
            if(location.getX() != goalX) {
                if(location.getX() > goalX) {
                    location.setX(location.getX() - 2);
                }else {
                    location.setX(location.getX() + 2);
                }
            }
            if(location.getY() != goalY) {
                if (location.getY() > goalY) {
                    location.setY(location.getY() - 2);
                } else {
                    location.setY(location.getY() + 2);
                }
            }
        }
    }


/*
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

    public static void move(float xVelocity, float yVelocity){
        moveX(xVelocity);
        moveY(yVelocity);
    }

    public static void moveX(float xVelocity){
        if(xVelocity > 0){//Moving right
            int tx = (int) (location.getX() + xVelocity + bounds.x + bounds.width) / Tile.TILEWIDTH;

            if(!collisionWithTile(tx, (int) (location.getY() + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (location.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
                location.setX((location.getX() + (int)xVelocity));
            }else{
                location.setX(tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1);
            }

        }else if(xVelocity < 0){//Moving left
            int tx = (int) (location.getX() + xVelocity + bounds.x) / Tile.TILEWIDTH;

            if(!collisionWithTile(tx, (int) (location.getY() + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (location.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
                location.setX(location.getX() + (int)xVelocity);
            }else{
                location.setX(tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x);
            }

        }
    }


    public static void moveY(float yVelocity){
        if(yVelocity < 0){//Up
            int ty = (int) (location.getY() + yVelocity + bounds.y) / Tile.TILEHEIGHT;
            if(!collisionWithTile((int) (location.getX() + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (location.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty) ){
                location.setY(location.getY() + (int)yVelocity);
            }else{
                location.setY(ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y);
            }

        }else if(yVelocity > 0){//Down
            int ty = (int) (location.getY() + yVelocity + bounds.y + bounds.height) / Tile.TILEHEIGHT;

            if(!collisionWithTile((int) (location.getX() + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (location.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
                location.setY(location.getY() + (int)yVelocity);
            }else{
                location.setY(ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1);
            }

        }
    }

    protected static boolean collisionWithTile(int x, int y){
        return controller.getMap().getTile(x, y).isUnWalkable;
    }


*/

}
