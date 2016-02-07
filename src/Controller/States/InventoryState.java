package Controller.States;

import Controller.Controller;
import View.Views.InventoryView;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Dartyx on 2/6/2016.
 */
public class InventoryState extends State {
    InventoryView inv;


    public InventoryState(Controller controller){
        super(controller);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SHIFT) {

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
