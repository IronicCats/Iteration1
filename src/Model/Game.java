package Model;

import Controller.Controller;
import Controller.States.*;

import Controller.States.GameState;
import Controller.States.MenuState;
import Controller.States.PauseState;
import Controller.States.State;
import Controller.States.KillState;
import Controller.States.InventoryState;
import Controller.States.GearState;
import Model.Item.InventoryList;



/**
 * Created by jlkegley on 1/31/2016.
 */
public class Game implements Runnable {

    private Controller controller;

    private State gameState;
    private State menuState;
    private State pauseState;
    private State killState;
    private State inventoryState;
    private State gearState;
    private State loadState;
    private State saveState;
    private State createState;
    private State mapState;



    private int width, height;

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private boolean running = false;
    private Thread thread;

    public void init() {
        //START STATES HERE
        controller = new Controller(this);
        createState = new CreateState(controller, width, height);
        menuState = new MenuState(controller, width, height);
        gameState = new GameState(controller);
        pauseState = new PauseState(controller, width, height);
        killState = new KillState(controller, width, height);
        inventoryState = new InventoryState(controller, width, height);
        gearState = new GearState(controller, width, height);
        loadState = new LoadState(controller, width, height);
        saveState = new SaveState(controller, width, height);

        // Map state is initialized in the init function for gameState

        State.setInitialState(menuState);
        InventoryList.init();

    }

    public void tick() {
        if(State.getState() != null ) {
            State.getState().tick();
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setMapState(MapState map) {
        this.mapState = map;
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
