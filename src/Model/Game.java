package Model;

import Controller.Controller;
import Controller.InputManager;
import Controller.States.GameState;
import Controller.States.MenuState;
import Controller.States.State;
import jdk.internal.util.xml.impl.Input;

import javax.naming.ldap.Control;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class Game implements Runnable {

    private Controller controller;

    private State gameState;
    private State menuState;
    private InputManager inputManager;

    public Game(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    private boolean running = false;
    private Thread thread;

    public void init() {
        //START STATES HERE
        controller = new Controller(this, inputManager);
        gameState = new GameState(controller);
        menuState = new MenuState(controller);
        State.setState(gameState);

    }

    public void tick() {
        inputManager.tick();

        if(State.getState() != null ) {
            State.getState().tick();
        }
    }

    public void run() {

        init();
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if( delta >= 1 ) {
                //DO STUFF
                tick();

                //
                ticks++;
                delta--;
            }

            if( timer >= 1000000000 ) {
                //System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public InputManager getInputManager(){
        return inputManager;
    }


    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }


    public synchronized void stop() {
        if( !running ) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
