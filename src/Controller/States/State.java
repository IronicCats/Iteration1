package Controller.States;

import Controller.Controller;

import java.awt.*;
import java.awt.event.KeyListener;
import View.View;
/**
 * Created by jlkegley on 1/31/2016.
 */


public abstract class State implements KeyListener {

    private static State state = null;
    private static States previousState;

    public static void setState(State thisState) {
        View.view.removeKeyListener(state);
        state = thisState;
        View.view.addKeyListener(state);
    }

    public static void setInitialState(State thisState) {
        state = thisState;
        View.view.addKeyListener(state);
    }

    public static State getState() {
        return state;
    }

    public void switchState(States stateNumber){}

    protected Controller controller;

    public State(Controller controller) {
        this.controller = controller;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public static void setPreviousState(States s){ previousState = s;};

    public States getPreviousState(){return previousState;};
}
