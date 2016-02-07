package Model.Entity;

import Controller.Controller;
import Model.Location;
import Model.Map.Tiles.Tile;

import java.awt.*;

/**
 * Created by Aidan on 2/3/2016.
 */
public class Nav {

    protected static Controller controller;
    protected static Location location;
    protected static Rectangle bounds;
    protected float goalX;
    protected float goalY;
    protected Player player;

    protected boolean isMoving = false;

    public Nav(Location location,Rectangle bounds, Controller controller, Player player){
        goalX = location.getPixelX();
        goalY = location.getPixelY();
        this.location = location;
        this.bounds = bounds;
        this.controller = controller;
        this.player = player;
    }

    public void move(int direction) {
        isMoving = true;
        boolean Obstaclecheck = true;
        if (direction == 0) {
            if (controller.getTiles((location.getX()), (location.getY() - 1)).isUnWalkable) {
                Obstaclecheck = false;
            }
            else if((location.getPixelY() - Tile.TILEHEIGHT) == -Tile.TILEHEIGHT){
                Obstaclecheck = false;
            }
            if (Obstaclecheck) {
                goalY = location.getPixelY() - Tile.TILEHEIGHT;
            }
        }else if (direction == 1) {
                if (controller.getTiles((location.getX() + 1), (location.getY())).isUnWalkable) {
                    Obstaclecheck = false;
                }
                else if(location.getPixelX() + Tile.TILEWIDTH == (controller.getMap().getWidth() * Tile.TILEWIDTH)/2){
                    Obstaclecheck = false;
                }
                if (Obstaclecheck) {
                    goalX = location.getPixelX() + Tile.TILEWIDTH;
                }
            } else if (direction == 2) {
            if (controller.getTiles((location.getX()), (location.getY() + 1)).isUnWalkable) {
                Obstaclecheck = false;
            }
            else if(location.getPixelY() == (controller.getMap().getHeight() * Tile.TILEHEIGHT)/2 - Tile.TILEHEIGHT){
                Obstaclecheck = false;
            }
            if(Obstaclecheck) {
                goalY = location.getPixelY() + Tile.TILEHEIGHT;
            }
            } else if(direction == 3) {
            if (controller.getTiles((location.getX() - 1), (location.getY())).isUnWalkable) {
                Obstaclecheck = false;
            }
            else if(location.getPixelX() - Tile.TILEWIDTH == -Tile.TILEWIDTH){
                Obstaclecheck = false;
            }
            if (Obstaclecheck) {
                goalX = location.getPixelX() - Tile.TILEWIDTH;
            }
        }/*
        else if(direction == 4){
            if(controller.getTiles((location.getX() + 1),(location.getY() - 1)).isUnWalkable){
                Obstaclecheck = false;
            }
            else if(location.getPixelY() - Tile.TILEHEIGHT == -Tile.TILEHEIGHT || location.getPixelX() + Tile.TILEWIDTH == (controller.getMap().getWidth() * Tile.TILEWIDTH)/2 ){
                Obstaclecheck = false;
            }
            if(Obstaclecheck){
                goalX = location.getPixelX() + Tile.TILEWIDTH;
                goalY = location.getPixelY() - Tile.TILEHEIGHT;
            }
        }
        else if(direction == 5){
            if(controller.getTiles((location.getX() + Tile.TILEWIDTH),(location.getY() + Tile.TILEHEIGHT)).isUnWalkable){
                Obstaclecheck = false;
            }
            else if(location.getPixelY() == (controller.getMap().getHeight() * Tile.TILEHEIGHT)/2 - Tile.TILEHEIGHT || location.getPixelX() + Tile.TILEWIDTH == (controller.getMap().getWidth() * Tile.TILEWIDTH)/2){
                Obstaclecheck = false;
            }
            if(Obstaclecheck){
                goalX = location.getPixelX() + Tile.TILEWIDTH;
                goalY = location.getPixelY() + Tile.TILEHEIGHT;
            }
        }
        else if(direction == 6){
            if(controller.getTiles((location.getX() - Tile.TILEWIDTH),(location.getY() + Tile.TILEHEIGHT)).isUnWalkable){
                Obstaclecheck = false;
            }
            else if(location.getPixelY() == (controller.getMap().getHeight() * Tile.TILEHEIGHT)/2 - Tile.TILEHEIGHT || location.getX() - Tile.TILEWIDTH == -Tile.TILEWIDTH){
                Obstaclecheck = false;
            }
            if(Obstaclecheck){
                goalX = location.getPixelX() - Tile.TILEWIDTH;
                goalY = location.getPixelY() + Tile.TILEHEIGHT;
            }
        }
        else if(direction == 7){
            if(controller.getTiles((location.getX() - 1),(location.getY() - 1)).isUnWalkable){
                Obstaclecheck = false;
            }
            else if(location.getY() - Tile.TILEHEIGHT == -Tile.TILEHEIGHT || location.getX() - Tile.TILEWIDTH == -Tile.TILEWIDTH){
                Obstaclecheck = false;
            }
            if(Obstaclecheck){
                goalX = location.getPixelX() - Tile.TILEWIDTH;
                goalY = location.getPixelY() - Tile.TILEHEIGHT;
            }
        }
        */
    }

    public void move() {
        if(location.getPixelY() == goalY && location.getPixelX() == goalX) {
            //System.out.println("Ive got a player");
            if(isMoving) {
                controller.getTiles(location.getX(), location.getY()).addPlayer(player);
            }
            isMoving = false;

        }else {
            isMoving = true;
            controller.getTiles(location.getX(), location.getY()).removePlayer();
            //TWEEN TO LOCATION
            if(location.getPixelX() != goalX) {
                if(location.getPixelX() > goalX) {
                    location.setPixelX(location.getPixelX() - 2);
                }else {
                    location.setPixelX(location.getPixelX() + 2);
                }
            }
            if(location.getPixelY() != goalY) {
                if (location.getPixelY() > goalY) {
                    location.setPixelY(location.getPixelY() - 2);
                } else {
                    location.setPixelY(location.getPixelY() + 2);
                }
            }
        }
    }

    public boolean getIsmoving(){
        return this.isMoving;
    }
    public void setIsmoving(boolean isMoving){
        this.isMoving = isMoving;
    }

    public float getGoalX(){
        return this.goalX;
    }
    public float getGoalY(){
        return this.goalY;
    }

    public void setGoalX(float goalX){
        this.goalX = goalX;

    }

    public void setGoalY(float goalY){
        this.goalY = goalY;
    }
}
