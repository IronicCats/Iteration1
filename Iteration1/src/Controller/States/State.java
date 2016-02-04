package Controller.States;

import Controller.Controller;

import java.awt.*;

/**
 * Created by jlkegley on 1/31/2016.
 */


public abstract class State {

    private static State state = null;

    public static void setState(State thisState) {
        state = thisState;
    }

    public static State getState() {
        return state;
    }

    protected Controller controller;

    public State(Controller controller) {
        this.controller = controller;
    }

    public abstract void tick();

    public abstract void render(Graphics g);


}
