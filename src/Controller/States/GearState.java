package Controller.States;

import View.View;
import View.Views.GearView;

import java.awt.*;
import java.awt.event.KeyEvent;
import Controller.Controller;

/**
 * Created by broskj on 2/7/16.
 */
public class GearState extends State {
    GearView gearView;
    public static GearState gear;

    public GearState(Controller controller, int width, int height) {
        super(controller);
        gear = this;
        gearView = new GearView(controller, width, height);
    } // end constructor

    public void switchState() {
        System.out.println("Resume Game from Gear");
        setState(GameState.game);
    } // end switchState

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        controller.getCamera().centerOnPlayer(controller.getPlayer());
        controller.getMap().render(g);
        controller.getPlayer().render(g);
        gearView.render(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
            gearView.shift();
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            gearView.up();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            gearView.down();
            System.out.println("Down P");
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            gearView.left();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            gearView.right();
        }
        if(e.getKeyCode() == KeyEvent.VK_Q) {
            int index=gearView.q();
            controller.getPlayer().getInventory().getEquipment().getArmor().unequipArmor(index);
        }
        if(e.getKeyCode() == KeyEvent.VK_G || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.switchState();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
