package Model.Entity;

import Controller.Controller;
import Model.Game;
import View.Graphics.Assets;

import java.awt.Graphics;
/**
 * Created by Aidan on 1/31/2016.
 */
public class Player extends Entity {
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 32,
            DEFAULT_CREATURE_HEIGHT = 32;

    protected float speed;
    protected float xMove, yMove;

    public Player(Controller controller,float x, float y) {
        super(controller, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
        speed = DEFAULT_SPEED;
    }

    public void move(){
        moveX();
        moveY();
    }

    public void moveX(){
        x += xMove;
    }

    public void moveY(){
        y += yMove;
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    public void getInput(){
        xMove = 0;
        yMove = 0;
        if(controller.getInputManager().N)
            y--;
            //yMove = -speed;
       // if(game.getInputManager().S)
           // yMove = speed;
       // if(game.getInputManager().E)
          //  xMove = speed;
       // if(game.getInputManager().W)
           // xMove = -speed;

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.avatar, (int)getX(),(int)getY(), width, height, null);

    }
    //GETTERS SETTERS

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
