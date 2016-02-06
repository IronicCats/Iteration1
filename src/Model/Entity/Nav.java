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
    protected int goalX;
    protected int goalY;
    protected Player player;

    protected boolean isMoving = false;

    public Nav(Location location,Rectangle bounds, Controller controller, Player player){
        goalX = location.getX();
        goalY = location.getY();
        this.location = location;
        this.bounds = bounds;
        this.controller = controller;
        this.player = player;
    }

    public void move(int direction) {
        isMoving = true;
        boolean Obstaclecheck = true;
        if (direction == 0) {
            if (controller.getTiles((location.getX())/Tile.TILEWIDTH, (location.getY() - Tile.TILEHEIGHT) / Tile.TILEWIDTH).isUnWalkable) {
                Obstaclecheck = false;
            }
            else if(location.getY() - Tile.TILEHEIGHT == -Tile.TILEHEIGHT){
                Obstaclecheck = false;
            }
            if (Obstaclecheck) {
                goalY = location.getY() - Tile.TILEHEIGHT;
                controller.getTiles(location.getX(),location.getY()).removePlayer(player);
            }
        }else if (direction == 1) {
                if (controller.getTiles((location.getX() + Tile.TILEWIDTH) / Tile.TILEWIDTH, (location.getY()) / Tile.TILEHEIGHT).isUnWalkable) {
                    Obstaclecheck = false;
                }
                else if(location.getX() + Tile.TILEWIDTH == (controller.getMap().getWidth() * Tile.TILEWIDTH)/2){
                    Obstaclecheck = false;
                }
                if (Obstaclecheck) {
                    goalX = location.getX() + Tile.TILEWIDTH;
                    controller.getTiles(location.getX(),location.getY()).removePlayer(player);
                }
            } else if (direction == 2) {
            if (controller.getTiles((location.getX()) / Tile.TILEWIDTH, (location.getY() + Tile.TILEHEIGHT) / Tile.TILEHEIGHT).isUnWalkable) {
                Obstaclecheck = false;
            }
            else if(location.getY() == (controller.getMap().getHeight() * Tile.TILEHEIGHT)/2 - Tile.TILEHEIGHT){
                Obstaclecheck = false;
            }
            if(Obstaclecheck) {
                goalY = location.getY() + Tile.TILEHEIGHT;
                controller.getTiles(location.getX(),location.getY()).removePlayer(player);
            }
            } else if(direction == 3) {
            if (controller.getTiles((location.getX() - Tile.TILEWIDTH) / Tile.TILEWIDTH, (location.getY()) / Tile.TILEHEIGHT).isUnWalkable) {
                Obstaclecheck = false;
            }
            else if(location.getX() - Tile.TILEWIDTH == -Tile.TILEWIDTH){
                Obstaclecheck = false;
            }
            if (Obstaclecheck) {
                goalX = location.getX() - Tile.TILEWIDTH;
                controller.getTiles(location.getX(),location.getY()).removePlayer(player);
            }
        }
        else if(direction == 4){
            if(controller.getTiles((location.getX() + Tile.TILEWIDTH)/ Tile.TILEWIDTH,(location.getY() - Tile.TILEHEIGHT) / Tile.TILEHEIGHT).isUnWalkable){
                Obstaclecheck = false;
            }
            else if(location.getY() - Tile.TILEHEIGHT == -Tile.TILEHEIGHT || location.getX() + Tile.TILEWIDTH == (controller.getMap().getWidth() * Tile.TILEWIDTH)/2 ){
                Obstaclecheck = false;
            }
            if(Obstaclecheck){
                goalX = location.getX() + Tile.TILEWIDTH;
                goalY = location.getY() - Tile.TILEHEIGHT;
                controller.getTiles(location.getX(),location.getY()).removePlayer(player);
            }
        }
        else if(direction == 5){
            if(controller.getTiles((location.getX() - Tile.TILEWIDTH)/ Tile.TILEWIDTH,(location.getY() - Tile.TILEHEIGHT) / Tile.TILEHEIGHT).isUnWalkable){
                Obstaclecheck = false;
            }
            else if(location.getY() - Tile.TILEHEIGHT == -Tile.TILEHEIGHT || location.getX() - Tile.TILEWIDTH == -Tile.TILEWIDTH){
                Obstaclecheck = false;
            }
            if(Obstaclecheck){
                goalX = location.getX() - Tile.TILEWIDTH;
                goalY = location.getY() - Tile.TILEHEIGHT;
                controller.getTiles(location.getX(),location.getY()).removePlayer(player);
            }
        }
        else if(direction == 6){
            if(controller.getTiles((location.getX() - Tile.TILEWIDTH)/ Tile.TILEWIDTH,(location.getY() + Tile.TILEHEIGHT) / Tile.TILEHEIGHT).isUnWalkable){
                Obstaclecheck = false;
            }
            else if(location.getY() == (controller.getMap().getHeight() * Tile.TILEHEIGHT)/2 - Tile.TILEHEIGHT || location.getX() - Tile.TILEWIDTH == -Tile.TILEWIDTH){
                Obstaclecheck = false;
            }
            if(Obstaclecheck){
                goalX = location.getX() - Tile.TILEWIDTH;
                goalY = location.getY() + Tile.TILEHEIGHT;
                controller.getTiles(location.getX(),location.getY()).removePlayer(player);
            }
        }
        else if(direction == 7){
            if(controller.getTiles((location.getX() + Tile.TILEWIDTH)/ Tile.TILEWIDTH,(location.getY() + Tile.TILEHEIGHT) / Tile.TILEHEIGHT).isUnWalkable){
                Obstaclecheck = false;
            }
            else if(location.getY() == (controller.getMap().getHeight() * Tile.TILEHEIGHT)/2 - Tile.TILEHEIGHT || location.getX() + Tile.TILEWIDTH == (controller.getMap().getWidth() * Tile.TILEWIDTH)/2){
                Obstaclecheck = false;
            }
            if(Obstaclecheck){
                goalX = location.getX() + Tile.TILEWIDTH;
                goalY = location.getY() + Tile.TILEHEIGHT;
                controller.getTiles(location.getX(),location.getY()).removePlayer(player);
            }
        }
        }

    public void move() {
        if(location.getY() == goalY && location.getX() == goalX) {
            isMoving = false;
            controller.getTiles(location.getX(),location.getY()).addPlayer(player);
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
}
