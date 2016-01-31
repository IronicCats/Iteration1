package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.KeyManagementException;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class InputManager implements KeyListener{

    private boolean[] keys;
    private boolean N, NE, E, SE, S, SW, W, NW;

    public InputManager() {
        System.out.println(KeyEvent.VK_NUMPAD8);
        keys = new boolean[256];
        System.out.println("Input Manager Started");
    }

    public void tick() {
        N = keys[KeyEvent.VK_NUMPAD8];
        NE = keys[KeyEvent.VK_NUMPAD9];
        E = keys[KeyEvent.VK_NUMPAD6];
        SE = keys[KeyEvent.VK_NUMPAD3];
        S = keys[KeyEvent.VK_NUMPAD2];
        SW = keys[KeyEvent.VK_NUMPAD1];
        W = keys[KeyEvent.VK_NUMPAD4];
        NW = keys[KeyEvent.VK_NUMPAD7];
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;

    }


}
