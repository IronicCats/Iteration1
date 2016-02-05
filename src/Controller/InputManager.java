package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.KeyManagementException;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class InputManager implements KeyListener{

    private boolean[] keys;
    public boolean N, NE, E, SE, S, SW, W, NW, drop;

    public InputManager() {
        keys = new boolean[256];
    }

    public void tick() {
        N = keys[KeyEvent.VK_NUMPAD8] || keys[KeyEvent.VK_UP];
        NE = keys[KeyEvent.VK_NUMPAD9];
        E = keys[KeyEvent.VK_NUMPAD6]  || keys[KeyEvent.VK_RIGHT];;
        SE = keys[KeyEvent.VK_NUMPAD3];
        S = keys[KeyEvent.VK_NUMPAD2]  || keys[KeyEvent.VK_DOWN];;
        SW = keys[KeyEvent.VK_NUMPAD1];
        W = keys[KeyEvent.VK_NUMPAD4] || keys[KeyEvent.VK_LEFT];;
        NW = keys[KeyEvent.VK_NUMPAD7];
        drop = keys[KeyEvent.VK_Q];
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        N = false;
        keys[e.getKeyCode()] = false;

    }


}
