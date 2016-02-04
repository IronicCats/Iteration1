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

    public Nav(Location location,Rectangle bounds, Controller controller){
        this.location = location;
        this.bounds = bounds;
        this.controller = controller;
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

    public static void move(float xVelocity, float yVelocity){
        moveX(xVelocity);
        moveY(yVelocity);
    }

    public static void moveX(float xVelocity){
        if(xVelocity > 0){//Moving right
            int tx = (int) (location.getX() + xVelocity + bounds.x + bounds.width) / Tile.TILEWIDTH;

            if(!collisionWithTile(tx, (int) (location.getY() + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (location.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
                location.setX(location.getX() + (int)xVelocity);
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




}
